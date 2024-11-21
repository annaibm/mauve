/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Properties;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class AcuniaPropertiesTest
implements Testlet {
    protected TestHarness th;
    protected Properties defProps;
    protected byte[] buffer;
    protected byte[] bytesout;
    protected ByteArrayInputStream bin;
    protected ByteArrayOutputStream bout;
    protected PrintStream psout;
    protected PrintWriter pwout;

    @Override
    public void test(TestHarness harness) {
        this.th = harness;
        this.setUpTest();
        this.resetStreams();
        this.test_Properties();
        this.resetStreams();
        this.test_getProperty();
        this.resetStreams();
        this.test_list();
        this.resetStreams();
        this.test_load();
        this.resetStreams();
        this.test_propertyNames();
        this.resetStreams();
        this.test_setProperty();
        this.resetStreams();
        this.test_store();
        this.resetStreams();
        this.test_save();
        this.resetStreams();
        this.test_loadextra();
    }

    private void resetStreams() {
        try {
            this.bin.reset();
            this.bout.reset();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void setUpTest() {
        this.buffer = new String("name=yes\nSmart=move\nanimal=dog").getBytes();
        this.bin = new ByteArrayInputStream(this.buffer);
        this.bout = new ByteArrayOutputStream();
        this.psout = new PrintStream(this.bout);
        this.pwout = new PrintWriter(this.bout);
        this.defProps = new Properties();
        try {
            this.defProps.load(this.bin);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.buffer = new String("!comment\n   \nname=no\n#morecomments\ndog=no_cat\ntest\ndate=today\nlongvalue=I'mtryingtogiveavaluelongerthen40characters\n40chars=thisvalueshouldcontainexactly40charcters").getBytes();
        this.bin = new ByteArrayInputStream(this.buffer);
    }

    public void test_Properties() {
        this.th.checkPoint("Properties()");
        Properties p = new Properties();
        this.th.check(p.isEmpty(), "nothing in there");
        this.th.checkPoint("Properties(java.util.Properties)");
        p = new Properties(this.defProps);
        this.th.check(p.isEmpty(), "nothing in there");
        this.th.check(p.getProperty("name").equals("yes"), "default field is not empty");
        try {
            p = new Properties(null);
            this.th.check(true);
        }
        catch (Exception e) {
            this.th.fail("should not throw an Exeption. Got: " + e);
        }
    }

    public void test_getProperty() {
        this.th.checkPoint("getProperty(java.lang.String)java.lang.String");
        Properties p = new Properties();
        try {
            p.getProperty(null);
            this.th.fail("should throw a NullPointerException -- 1");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        p = new Properties(this.defProps);
        try {
            p.getProperty(null);
            this.th.fail("should throw a NullPointerException -- 2");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        try {
            p.load(this.bin);
        }
        catch (Exception ne) {
            // empty catch block
        }
        try {
            p.getProperty(null);
            this.th.fail("should throw a NullPointerException -- 1");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        try {
            this.th.check(p.getProperty("dog").equals("no_cat"), "check returnvalue");
            this.th.check(p.getProperty("name").equals("no"), "return property from main property table");
            this.th.check(p.getProperty("Smart").equals("move"), "check returnvalue from default table");
            this.th.check(p.getProperty("NoEntry") == null, "check for null if not there");
        }
        catch (Exception e) {
            this.th.fail("got unexpected exception: " + e);
        }
        this.th.checkPoint("getProperty(java.lang.String,java.lang.String)java.lang.String");
        try {
            p.getProperty(null, "Noooo...");
            this.th.fail("should throw a NullPointerException -- 1");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        try {
            this.th.check(p.getProperty("Noooo...", null) == null, "defVal may be null");
        }
        catch (NullPointerException ne) {
            this.th.fail("shouldn't throw a NullPointerException -- 1");
        }
        this.th.check(p.getProperty("dog", "not found").equals("no_cat"), "check returnvalue");
        this.th.check(p.getProperty("name", "not found").equals("no"), "return property from main property table");
        this.th.check(p.getProperty("Smart", "not found").equals("move"), "check returnvalue from default table");
        this.th.check(p.getProperty("NoEntry", "not found").equals("not found"), "check for defVal if not there");
    }

    public void test_list() {
        int start;
        int count;
        String s;
        this.th.checkPoint("list(java.io.PrintStream)void");
        Properties p = new Properties();
        try {
            p.list((PrintStream)null);
            this.th.fail("should throw NullPointerException -- 1");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        try {
            p.load(this.bin);
        }
        catch (Exception ne) {
            // empty catch block
        }
        p.list(this.psout);
        byte[] ba = this.bout.toByteArray();
        Vector<String> v = new Vector<String>();
        Enumeration<Object> ek = p.keys();
        while (ek.hasMoreElements()) {
            s = (String)ek.nextElement();
            v.add(s + "=" + p.getProperty(s));
        }
        v.add("Smart=move");
        v.add("animal=dog");
        v.removeElement("longvalue=I'mtryingtogiveavaluelongerthen40characters");
        v.add("longvalue=I'mtryingtogiveavaluelongerthen40char...");
        for (count = 0; count < ba.length; ++count) {
            start = count;
            while (ba[count] != 10 && count < ba.length) {
                ++count;
            }
            s = new String(ba, start, count - start);
            if (!s.startsWith("--")) {
                this.th.check(v.contains(s), "v does not contain:$" + s + "$");
            }
            v.removeElement(s);
        }
        try {
            p.list((PrintStream)null);
            this.th.fail("should throw NullPointerException -- 2");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        this.th.checkPoint("list(java.io.PrintWriter)void");
        this.resetStreams();
        p = new Properties();
        try {
            p.list((PrintWriter)null);
            this.th.fail("should throw NullPointerException -- 1");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        try {
            p.load(this.bin);
        }
        catch (Exception ne) {
            // empty catch block
        }
        p.list(this.pwout);
        ba = this.bout.toByteArray();
        v = new Vector();
        ek = p.keys();
        while (ek.hasMoreElements()) {
            s = (String)ek.nextElement();
            v.add(s + "=" + p.getProperty(s));
        }
        v.add("Smart=move");
        v.add("animal=dog");
        v.removeElement("longvalue=I'mtryingtogiveavaluelongerthen40characters");
        v.add("longvalue=I'mtryingtogiveavaluelongerthen40char...");
        for (count = 0; count < ba.length; ++count) {
            start = count;
            while (ba[count] != 10 && count < ba.length) {
                ++count;
            }
            s = new String(ba, start, count - start);
            if (!s.startsWith("--")) {
                this.th.check(v.contains(s), "v does not contain:$" + s + "$");
            }
            v.removeElement(s);
        }
        try {
            p.list((PrintStream)null);
            this.th.fail("should throw NullPointerException -- 2");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
    }

    public void test_load() {
        this.th.checkPoint("load(java.io.InputStream)void");
        Properties p = new Properties();
        try {
            p.load((InputStream)null);
            this.th.fail("should throw NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        catch (Exception e) {
            this.th.fail("should throw an NullPointerException instead of: " + e);
        }
        try {
            p.load(this.bin);
        }
        catch (Exception e) {
            // empty catch block
        }
        Enumeration<Object> ek1 = p.keys();
        this.resetStreams();
        try {
            p.load(this.bin);
        }
        catch (Exception exception) {
            // empty catch block
        }
        Enumeration<Object> ek2 = p.keys();
        boolean ok = true;
        while (ek1.hasMoreElements() && ek2.hasMoreElements()) {
            if (ek1.nextElement() == ek2.nextElement()) continue;
            ok = false;
        }
        this.th.check(!ek1.hasMoreElements() && !ek2.hasMoreElements(), "no extra elements may be added with same name");
        this.th.check(ok, " all elements are equal ");
        this.bin = new ByteArrayInputStream(new String("name=yes\nSmart=move\nanimal=dog").getBytes());
        try {
            p.load(this.bin);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.th.check(p.getProperty("name").equals("yes"), "load overrides previous values");
        Vector<String> v = new Vector<String>();
        v.add("name");
        v.add("Smart");
        v.add("animal");
        v.add("dog");
        v.add("test");
        v.add("date");
        v.add("longvalue");
        v.add("40chars");
        ek1 = p.keys();
        ok = true;
        while (ek1.hasMoreElements()) {
            Object o = ek1.nextElement();
            if (v.contains(o)) {
                v.removeElement(o);
                continue;
            }
            ok = false;
            this.th.debug("got extra element: " + (String)o);
        }
        this.th.check(ok, "all elements were there");
        this.th.check(v.isEmpty(), "all elements should be gone, got" + v);
        this.setUpTest();
    }

    public void test_propertyNames() {
        this.th.checkPoint("propertyNames()java.util.Enumeration");
        Properties p = new Properties();
        try {
            p.load(this.bin);
        }
        catch (Exception exception) {
            // empty catch block
        }
        Enumeration<?> en = p.propertyNames();
        Enumeration<Object> ek = p.keys();
        boolean ok = true;
        Vector<Object> v = new Vector<Object>();
        Enumeration<Object> ek2 = p.keys();
        while (ek2.hasMoreElements()) {
            v.add(ek2.nextElement());
        }
        while (ek.hasMoreElements() && en.hasMoreElements()) {
            ek.nextElement();
            Object next2 = en.nextElement();
            if (v.contains(next2)) continue;
            ok = false;
            this.th.debug(next2 + " not in " + v);
        }
        this.th.check(ok, "all elements are the same");
        this.th.check(!ek.hasMoreElements() && !en.hasMoreElements(), "make sure both enumerations are empty");
        p = new Properties(this.defProps);
        this.resetStreams();
        try {
            p.load(this.bin);
        }
        catch (Exception next2) {
            // empty catch block
        }
        v.add("Smart");
        v.add("animal");
        en = p.propertyNames();
        ok = true;
        while (en.hasMoreElements()) {
            Object o = en.nextElement();
            if (v.contains(o)) {
                v.removeElement(o);
                continue;
            }
            ok = false;
            this.th.debug("got extra element: " + o);
        }
        this.th.check(ok, "see if no double were generated");
        this.th.check(v.isEmpty(), "check if all names were mentioned -- got:" + v);
    }

    public void test_setProperty() {
        this.th.checkPoint("setProperty(java.lang.String,java.lang.String)java.lang.Object");
        Properties p = new Properties();
        try {
            p.setProperty(null, "Noooo...");
            this.th.fail("should throw NullPointerException -- 1");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        try {
            p.setProperty("Noooo...", null);
            this.th.fail("should throw NullPointerException -- 2");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        p = new Properties(this.defProps);
        try {
            p.load(this.bin);
        }
        catch (Exception ne) {
            // empty catch block
        }
        try {
            p.setProperty(null, "Noooo...");
            this.th.fail("should throw NullPointerException -- 3");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        try {
            p.setProperty("No again...", null);
            this.th.fail("should throw NullPointerException -- 4");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        try {
            this.th.check(((String)p.setProperty("test", "null")).equals(""), "returns \"\" in our case");
        }
        catch (NullPointerException ne) {
            this.th.fail("the value a of property cannot be null, got:" + ne);
        }
        this.th.check(p.getProperty("test").equals("null"), "check new value in our case null");
        this.th.check(p.setProperty("testing", "null") == null, "returns value null, name not in list");
        this.th.check(p.getProperty("test").equals("null"), "check new value in our case null");
        String s = (String)p.setProperty("Smart", "nul");
        this.th.check(s == null, "returnvalue, is null default list not touched, got");
        this.th.check(p.getProperty("Smart").equals("nul"), "check new value in our case null");
        s = (String)p.setProperty("name", "nu");
        this.th.check(s.equals("no"), "return value in our case no, got: " + s);
        this.th.check(p.getProperty("name").equals("nu"), "check new value in our case nu");
    }

    public void test_store() {
        this.th.checkPoint("store(java.io.OutputStream,java.lang.String)void");
        Properties p = new Properties(this.defProps);
        try {
            p.store((OutputStream)null, "no comment");
            this.th.fail("should throw NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        catch (Exception e) {
            this.th.fail("should throw an NullPointerEception instead of: " + e);
        }
        try {
            p.store(this.bout, null);
            this.th.check(true);
        }
        catch (NullPointerException ne) {
            this.th.fail("should not throw NullPointerException");
        }
        catch (Exception e) {
            this.th.fail("shouldn't throw any Exception, but got: " + e);
        }
        this.resetStreams();
        try {
            p.store(this.bout, null);
        }
        catch (Exception e) {
            this.th.fail("shouldn't throw any Exception, but got: " + e);
        }
        byte[] ba = this.bout.toByteArray();
        this.th.check(ba[0] == 35 && ba[1] != 35, "only the date should be written");
        this.th.check(ba.length < 50, "default properties are never printed out");
        this.resetStreams();
        try {
            p.load(this.bin);
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            p.store(this.bout, "no comments");
        }
        catch (Exception e) {
            this.th.fail("shouldn't throw any Exception, but got: " + e);
        }
        ba = this.bout.toByteArray();
        String s = new String(ba, 0, 12);
        this.th.check(s.equals("#no comments"), "got: " + s);
        int i = 0;
        int count = 0;
        while (i < 2 && count < ba.length) {
            if (ba[count++] != 10) continue;
            ++i;
        }
        Vector<String> v = new Vector<String>();
        Enumeration<Object> ek = p.keys();
        while (ek.hasMoreElements()) {
            s = (String)ek.nextElement();
            v.add(s + "=" + p.getProperty(s));
        }
        while (count < ba.length) {
            int start = count;
            while (count < ba.length && ba[count] != 10) {
                ++count;
            }
            s = new String(ba, start, count - start);
            this.th.check(v.contains(s), "v does not contain: " + s);
            v.removeElement(s);
            ++count;
        }
    }

    public void test_save() {
        this.th.checkPoint("save(java.io.OutputStream,java.lang.String)void");
        Properties p = new Properties(this.defProps);
        try {
            p.save(null, "no comment");
            this.th.fail("should throw NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        catch (Exception e) {
            this.th.fail("should throw an NullPointerEception instead of: " + e);
        }
        try {
            p.save(this.bout, null);
            this.th.check(true);
        }
        catch (NullPointerException ne) {
            this.th.fail("should not throw NullPointerException");
        }
        catch (Exception e) {
            this.th.fail("shouldn't throw any Exception, but got: " + e);
        }
        this.resetStreams();
        try {
            p.save(this.bout, null);
        }
        catch (Exception e) {
            this.th.fail("shouldn't throw any Exception, but got: " + e);
        }
        byte[] ba = this.bout.toByteArray();
        this.th.check(ba[0] == 35 && ba[1] != 35, "just date should be written");
        this.th.debug(ba.length + " -- got: " + new String(ba));
        this.th.check(ba.length < 50, "default properties are never printed out");
        this.resetStreams();
        try {
            p.load(this.bin);
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            p.save(this.bout, "no comments");
        }
        catch (Exception e) {
            this.th.fail("shouldn't throw any Exception, but got: " + e);
        }
        ba = this.bout.toByteArray();
        String s = new String(ba, 0, 12);
        this.th.check(s.equals("#no comments"), "got: " + s);
        int i = 0;
        int count = 0;
        while (i < 2 && count < ba.length) {
            if (ba[count++] != 10) continue;
            ++i;
        }
        Vector<String> v = new Vector<String>();
        Enumeration<Object> ek = p.keys();
        while (ek.hasMoreElements()) {
            s = (String)ek.nextElement();
            v.add(s + "=" + p.getProperty(s));
        }
        while (count < ba.length) {
            int start = count;
            while (count < ba.length && ba[count] != 10) {
                ++count;
            }
            s = new String(ba, start, count - start);
            this.th.check(v.contains(s), "v does not contain: " + s);
            v.removeElement(s);
            ++count;
        }
    }

    public void test_loadextra() {
        this.th.checkPoint("load(java.io.InputStream)void");
        Properties p = new Properties();
        this.buffer = new String("   !comment\n \t  \nname = no\r    #morec\tomm\\\nents\r\n  dog=no\\\\cat   \nburps    :\ntest=\ndate today\n\n\nlong\\\n   value=tryin \\\n gto\n4:vier\nvier     :4").getBytes();
        this.bin = new ByteArrayInputStream(this.buffer);
        try {
            p.load(this.bin);
        }
        catch (Exception exception) {
            // empty catch block
        }
        Enumeration<Object> e = p.keys();
        Vector<String> v = new Vector<String>();
        v.add("ents=");
        v.add("name=no");
        v.add("dog=no\\cat   ");
        v.add("burps=");
        v.add("test=");
        v.add("date=today");
        v.add("longvalue=tryin gto");
        v.add("4=vier");
        v.add("vier=4");
        while (e.hasMoreElements()) {
            String s = (String)e.nextElement();
            this.th.debug("checkvalue -- got:$" + s + "=" + p.getProperty(s) + "$");
            this.th.check(v.contains(s + "=" + p.getProperty(s)), "checkvalue -- got:$" + s + "=" + p.getProperty(s) + "$");
            v.removeElement(s + "=" + p.getProperty(s));
        }
        this.th.check(v.isEmpty(), "check if all elements were found -- got: " + v);
    }
}

