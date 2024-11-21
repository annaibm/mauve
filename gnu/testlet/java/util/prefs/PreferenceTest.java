/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.prefs;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.NodeChangeEvent;
import java.util.prefs.NodeChangeListener;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

public class PreferenceTest
implements Testlet {
    private static final String FULL_PATH = "/gnu/testlet/java/util/prefs";
    private static final String KEY = "AppName";
    private static final String VALUE = "GNU Classpath - Preference API Test Case";
    private static final boolean DEBUG = false;
    protected TestHarness harness = null;
    private Preferences prefs = null;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.setup();
        this.testAbsolutePath();
        this.testClear();
        this.testPut();
        this.testByte();
        this.testBoolean();
        this.testSpecialCharacters();
        this.testListener();
        this.testChildren();
    }

    private void setup() {
        this.prefs = Preferences.userNodeForPackage(PreferenceTest.class);
    }

    private void testAbsolutePath() {
        this.harness.checkPoint("absolutePath()");
        String absolutePath = this.prefs.absolutePath();
        this.print("Absolute path: " + absolutePath);
        this.harness.check(FULL_PATH.compareTo(absolutePath) == 0);
    }

    private void testClear() {
        this.harness.checkPoint("testClear()");
        try {
            this.prefs.clear();
        }
        catch (BackingStoreException e) {
            this.print(e.getLocalizedMessage());
            this.harness.fail("testClear()");
        }
        this.harness.check(true);
    }

    private void testPut() {
        this.harness.checkPoint("testPut()");
        this.prefs.put(KEY, VALUE);
        try {
            this.prefs.sync();
        }
        catch (BackingStoreException e) {
            this.print(e.getLocalizedMessage());
            this.harness.fail("testPut(), call to sync");
        }
        String value2 = this.prefs.get(KEY, "Wrong value for key: AppName, expected: GNU Classpath - Preference API Test Case");
        this.print("Key (AppName): " + value2);
        this.harness.check(VALUE.compareTo(value2) == 0);
    }

    private void testChildren() {
        this.harness.checkPoint("testChildren()");
        String absolutePath = null;
        Preferences pref1 = this.prefs.node("children_1");
        this.harness.check("children_1".compareTo(pref1.name()) == 0);
        absolutePath = pref1.absolutePath();
        this.harness.check("/gnu/testlet/java/util/prefs/children_1".compareTo(absolutePath) == 0);
        Preferences pref2 = this.prefs.node("children_2");
        this.harness.check("children_2".compareTo(pref2.name()) == 0);
        absolutePath = pref2.absolutePath();
        this.harness.check("/gnu/testlet/java/util/prefs/children_2".compareTo(absolutePath) == 0);
        Preferences pref3 = this.prefs.node("children_3");
        this.harness.check("children_3".compareTo(pref3.name()) == 0);
        absolutePath = pref3.absolutePath();
        this.harness.check("/gnu/testlet/java/util/prefs/children_3".compareTo(absolutePath) == 0);
        pref1.put("key1", "value1");
        pref2.put("key2", "value2");
        pref3.put("key3", "value3");
        Preferences child1 = pref1.node("subPreference1");
        this.harness.check("subPreference1".compareTo(child1.name()) == 0);
        absolutePath = child1.absolutePath();
        this.harness.check("/gnu/testlet/java/util/prefs/children_1/subPreference1".compareTo(absolutePath) == 0);
        child1.put("key1-child1", "some value");
        this.harness.checkPoint("testAddChildren() - check new children");
        String[] expResult = new String[]{"children_1", "children_2", "children_3"};
        if (!this.listChildren(this.prefs, expResult)) {
            this.harness.fail("testAddChildren(), children listing error");
        }
        this.harness.checkPoint("testAddChildren() - check subnodes");
        expResult = new String[]{"subPreference1"};
        if (!this.listChildren(pref1, expResult)) {
            this.harness.fail("testAddChildren(), children listing error");
        }
        try {
            this.prefs.removeNode();
            this.prefs.flush();
        }
        catch (BackingStoreException e) {
            this.print(e.getLocalizedMessage());
            this.harness.fail("testAddChildren(), call to clear()");
        }
        this.harness.checkPoint("testAddChildren() - checking emptyness");
        try {
            this.prefs.childrenNames();
            this.harness.fail("The node should not exist anymore!");
        }
        catch (IllegalStateException e) {
            this.harness.check(true);
        }
        catch (BackingStoreException e) {
            this.print(e.getLocalizedMessage());
            this.harness.fail("The node should not exist anymore!");
        }
    }

    private boolean listChildren(Preferences pref, String[] expResult) {
        boolean _res = false;
        try {
            String[] result = pref.childrenNames();
            this.print("Resuls length: " + result.length + ", expected: " + expResult.length);
            this.harness.check(result.length == expResult.length);
            for (int i = 0; i < expResult.length; ++i) {
                this.print("result[" + i + "] = " + result[i] + ", expected = " + expResult[i]);
                this.harness.check(result[i], (Object)expResult[i]);
            }
            _res = true;
        }
        catch (BackingStoreException e) {
            this.print(e.getLocalizedMessage());
            this.harness.fail("call to childrenNames()");
        }
        return _res;
    }

    private void testByte() {
        this.harness.checkPoint("testByte()");
        String string = "an array of bytes value";
        byte[] bytes = null;
        byte[] result = null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oStream = new ObjectOutputStream(stream);
            oStream.writeObject(string);
            bytes = stream.toByteArray();
            this.harness.checkPoint("testByte() - put byte array");
            this.prefs.putByteArray(KEY, bytes);
            this.harness.checkPoint("testByte() - get byte array");
            result = this.prefs.getByteArray(KEY, null);
            ByteArrayInputStream iStream = new ByteArrayInputStream(result);
            ObjectInputStream oiStream = new ObjectInputStream(iStream);
            String rString = (String)oiStream.readObject();
            this.print("Result: " + rString + ", expected: " + string);
            this.harness.check(rString, (Object)string);
        }
        catch (IOException e) {
            this.print(e.getLocalizedMessage());
            this.harness.fail("call to testByte() - IO Exception");
        }
        catch (ClassNotFoundException e) {
            this.print(e.getLocalizedMessage());
            this.harness.fail("call to testByte() - ClassNotFoundException");
        }
    }

    private void testBoolean() {
        this.harness.checkPoint("testBoolean()");
        String key = "boolean_key";
        String _true = "TrUe";
        this.prefs.putBoolean(key, true);
        boolean result = this.prefs.getBoolean(key, false);
        this.harness.check(result, true);
        this.prefs.remove(key);
        try {
            this.prefs.flush();
        }
        catch (BackingStoreException e) {
            this.print(e.getLocalizedMessage());
            this.harness.fail("call to testBoolean() - fail to flush");
        }
        this.prefs.put(key, _true);
        result = this.prefs.getBoolean(key, false);
        this.harness.check(result, true);
    }

    private void testSpecialCharacters() {
        this.harness.checkPoint("testSpecialCharacters()");
        Preferences _prefs = this.prefs.node("invalid children node");
        _prefs.put("Invalid Key", "An invalid key, on an invalid subnode");
        _prefs.put("Valid_Key", "A valid key, on an invalid subnode");
        String one = _prefs.get("Invalid Key", "unable to get the invalid key");
        String two = _prefs.get("Valid_Key", "unable to get the invalid key");
        this.harness.check(one, (Object)"An invalid key, on an invalid subnode");
        this.harness.check(two, (Object)"A valid key, on an invalid subnode");
        try {
            _prefs.flush();
            _prefs.removeNode();
        }
        catch (BackingStoreException e) {
            this.print(e.getLocalizedMessage());
            this.harness.fail("call to testSpecialCharacters() fail to removeNode");
        }
    }

    private void testListener() {
        this.harness.checkPoint("testListener()");
        PreferenceListener listener = new PreferenceListener();
        this.harness.checkPoint("testListener() - adding listeners");
        this.prefs.addNodeChangeListener(listener);
        this.prefs.addPreferenceChangeListener(listener);
        this.harness.checkPoint("testListener() - inserting key");
        this.prefs.put("new_key", "some value");
        String key = this.prefs.get("new_key", "Wrong! Wrong! Wrong!");
        this.harness.check(key, (Object)"some value");
        this.harness.checkPoint("testListener() - updating key");
        this.prefs.put("new_key", "some other value");
        key = this.prefs.get("new_key", "Wrong! Wrong! Wrong!");
        this.harness.check(key, (Object)"some other value");
        this.harness.checkPoint("testListener() - removing listeners");
        this.prefs.removeNodeChangeListener(listener);
        this.prefs.removePreferenceChangeListener(listener);
        this.harness.checkPoint("testListener() - removing key");
        this.prefs.remove("new_key");
    }

    private void printInfo() {
        String backendName = System.getProperty("java.util.prefs.PreferencesFactory", "No backend registered, using default backend");
        String vendor = System.getProperty("java.vendor");
        this.harness.debug(vendor);
        this.harness.debug(backendName);
    }

    private void print(String message) {
    }

    private class PreferenceListener
    implements NodeChangeListener,
    PreferenceChangeListener {
        private PreferenceListener() {
        }

        @Override
        public void childAdded(NodeChangeEvent event) {
            PreferenceTest.this.harness.check(true);
            PreferenceTest.this.print("Child added!");
            String name2 = event.getChild().name();
            PreferenceTest.this.print("name: " + name2);
        }

        @Override
        public void childRemoved(NodeChangeEvent event) {
            PreferenceTest.this.harness.check(true);
            PreferenceTest.this.print("Child removed!");
            String name2 = event.getChild().name();
            PreferenceTest.this.print("name: " + name2);
        }

        @Override
        public void preferenceChange(PreferenceChangeEvent event) {
            PreferenceTest.this.harness.check(true);
            PreferenceTest.this.print("Preference changed!");
            String name2 = event.getNode().name();
            String value2 = event.getNewValue();
            PreferenceTest.this.print("name: " + name2);
            PreferenceTest.this.print("value: " + value2);
        }
    }
}

