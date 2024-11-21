/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.HashMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class AcuniaHashMapTest
implements Testlet {
    protected TestHarness th;
    private final String st = "a";
    private final Byte b = new Byte(97);
    private final Short sh = new Short(97);
    private final Integer i = new Integer(97);
    private final Long l = new Long(97L);
    private int sqnce = 1;

    @Override
    public void test(TestHarness harness) {
        this.th = harness;
        this.test_HashMap();
        this.test_get();
        this.test_containsKey();
        this.test_containsValue();
        this.test_isEmpty();
        this.test_size();
        this.test_clear();
        this.test_put();
        this.test_putAll();
        this.test_remove();
        this.test_entrySet();
        this.test_keySet();
        this.test_values();
        this.test_clone();
        this.test_behaviour();
    }

    protected HashMap buildHM() {
        HashMap<String, String> hm = new HashMap<String, String>();
        for (int i = 0; i < 15; ++i) {
            String s = "a" + i;
            hm.put(s, s + " value");
        }
        hm.put(null, null);
        return hm;
    }

    public void test_HashMap() {
        Field lf = null;
        try {
            lf = HashMap.class.getDeclaredField("loadFactor");
            lf.setAccessible(true);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.th.checkPoint("HashMap()");
        HashMap hm = new HashMap();
        try {
            this.th.check(lf.getFloat(hm), 0.75);
        }
        catch (Exception e) {
            this.th.fail("no exception wanted !!!, got " + e);
        }
        this.th.checkPoint("HashMap(java.util.Map)");
        HashMap hm1 = this.buildHM();
        hm = new HashMap(hm1);
        try {
            this.th.check(lf.getFloat(hm), 0.75);
        }
        catch (Exception e) {
            this.th.fail("no exception wanted !!!, got " + e);
        }
        this.th.check(hm.size() == 16, "all elements are put, got " + hm.size());
        this.th.check(hm.get(null) == null, "test key and value pairs -- 1");
        this.th.check("a1 value".equals(hm.get("a1")), "test key and value pairs -- 2");
        this.th.check("a10 value".equals(hm.get("a10")), "test key and value pairs -- 3");
        this.th.check("a0 value".equals(hm.get("a0")), "test key and value pairs -- 4");
        hm = new HashMap(new Hashtable());
        this.th.check(hm.size() == 0, "no elements are put, got " + hm.size());
        try {
            new HashMap(null);
            this.th.fail("should throw a NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        this.th.checkPoint("HashMap(int)");
        hm = new HashMap(1);
        try {
            this.th.check(lf.getFloat(hm), 0.75);
        }
        catch (Exception e) {
            this.th.fail("no exception wanted !!!, got " + e);
        }
        try {
            new HashMap(-1);
            this.th.fail("should throw an IllegalArgumentException");
        }
        catch (IllegalArgumentException iae) {
            this.th.check(true);
        }
        this.th.checkPoint("HashMap(int,int)");
        hm = new HashMap(10, 0.5f);
        try {
            this.th.check(lf.getFloat(hm), 0.5);
        }
        catch (Exception e) {
            this.th.fail("no exception wanted !!!, got " + e);
        }
        hm = new HashMap(10, 1.5f);
        try {
            this.th.check(lf.getFloat(hm), 1.5);
        }
        catch (Exception e) {
            this.th.fail("no exception wanted !!!, got " + e);
        }
        try {
            new HashMap(-1, 0.1f);
            this.th.fail("should throw an IllegalArgumentException -- 1");
        }
        catch (IllegalArgumentException iae) {
            this.th.check(true);
        }
        try {
            new HashMap(1, -0.1f);
            this.th.fail("should throw an IllegalArgumentException -- 2");
        }
        catch (IllegalArgumentException iae) {
            this.th.check(true);
        }
        try {
            new HashMap(1, 0.0f);
            this.th.fail("should throw an IllegalArgumentException -- 2");
        }
        catch (IllegalArgumentException iae) {
            this.th.check(true);
        }
    }

    public void test_get() {
        this.th.checkPoint("get(java.lang.Object)java.lang.Object");
        HashMap hm = this.buildHM();
        this.th.check(hm.get(null) == null, "checking get -- 1");
        this.th.check(hm.get(this) == null, "checking get -- 2");
        hm.put("a", this);
        this.th.check("a1 value".equals(hm.get("a1")), "checking get -- 3");
        this.th.check("a11 value".equals(hm.get("a11")), "checking get -- 4");
        this.th.check(hm.get(new Integer(97)) == null, "checking get -- 5");
    }

    public void test_containsKey() {
        this.th.checkPoint("containsKey(java.lang.Object)boolean");
        HashMap hm = new HashMap();
        hm.clear();
        this.th.check(!hm.containsKey(null), "Map is empty");
        hm.put("a", this);
        this.th.check(!hm.containsKey(null), "Map does not containsthe key -- 1");
        this.th.check(hm.containsKey("a"), "Map does contain the key -- 2");
        hm = this.buildHM();
        this.th.check(hm.containsKey(null), "Map does contain the key -- 3");
        this.th.check(!hm.containsKey(this), "Map does not contain the key -- 4");
    }

    public void test_containsValue() {
        this.th.checkPoint("containsValue(java.lang.Object)boolean");
        HashMap hm = new HashMap();
        hm.clear();
        this.th.check(!hm.containsValue(null), "Map is empty");
        hm.put("a", this);
        this.th.check(!hm.containsValue(null), "Map does not containsthe value -- 1");
        this.th.check(!hm.containsValue("a"), "Map does  not contain the value -- 2");
        this.th.check(hm.containsValue(this), "Map does contain the value -- 3");
        hm = this.buildHM();
        this.th.check(hm.containsValue(null), "Map does contain the value -- 4");
        this.th.check(!hm.containsValue(this), "Map does not contain the value -- 5");
        this.th.check(!hm.containsValue("a1value"), "Map does  not contain the value -- 6");
    }

    public void test_isEmpty() {
        this.th.checkPoint("isEmpty()boolean");
        HashMap<String, AcuniaHashMapTest> hm = new HashMap<String, AcuniaHashMapTest>();
        this.th.check(hm.isEmpty(), "Map is empty");
        hm.put("a", this);
        this.th.check(!hm.isEmpty(), "Map is not empty");
    }

    public void test_size() {
        this.th.checkPoint("size()int");
        HashMap hm = new HashMap();
        this.th.check(hm.size() == 0, "Map is empty");
        hm.put("a", this);
        this.th.check(hm.size() == 1, "Map has 1 element");
        hm = this.buildHM();
        this.th.check(hm.size() == 16, "Map has 16 elements");
    }

    public void test_clear() {
        this.th.checkPoint("clear()void");
        HashMap hm = this.buildHM();
        hm.clear();
        this.th.check(hm.size() == 0, "Map is cleared -- 1");
        this.th.check(hm.isEmpty(), "Map is cleared -- 2");
    }

    public void test_put() {
        this.th.checkPoint("put(java.lang.Object,java.lang.Object)java.lang.Object");
        HashMap<String, Object> hm = new HashMap<String, Object>();
        this.th.check(hm.put(null, this) == null, "check on return value -- 1");
        this.th.check(hm.get(null) == this, "check on value -- 1");
        this.th.check(hm.put(null, "a") == this, "check on return value -- 2");
        this.th.check("a".equals(hm.get(null)), "check on value -- 2");
        this.th.check("a".equals(hm.put(null, "a")), "check on return value -- 3");
        this.th.check("a".equals(hm.get(null)), "check on value -- 3");
        this.th.check(hm.size() == 1, "only one key added");
        this.th.check(hm.put("a", null) == null, "check on return value -- 4");
        this.th.check(hm.get("a") == null, "check on value -- 4");
        this.th.check(hm.put("a", this) == null, "check on return value -- 5");
        this.th.check(hm.get("a") == this, "check on value -- 5");
        this.th.check(hm.size() == 2, "two keys added");
    }

    public void test_putAll() {
        this.th.checkPoint("putAll(java.util.Map)void");
        HashMap<Object, Object> hm = new HashMap<Object, Object>();
        hm.putAll(new Hashtable());
        this.th.check(hm.isEmpty(), "nothing addad");
        hm.putAll(this.buildHM());
        this.th.check(hm.size() == 16, "checking if all enough elements are added -- 1");
        this.th.check(hm.equals(this.buildHM()), "check on all elements -- 1");
        hm.put(null, this);
        hm.putAll(this.buildHM());
        this.th.check(hm.size() == 16, "checking if all enough elements are added -- 2");
        this.th.check(hm.equals(this.buildHM()), "check on all elements -- 2");
        try {
            hm.putAll(null);
            this.th.fail("should throw a NullPointerException");
        }
        catch (NullPointerException npe) {
            this.th.check(true);
        }
    }

    public void test_remove() {
        this.th.checkPoint("remove(java.lang.Object)java.lang.Object");
        HashMap hm = this.buildHM();
        this.th.check(hm.remove(null) == null, "checking return value -- 1");
        this.th.check(hm.remove(null) == null, "checking return value -- 2");
        this.th.check(!hm.containsKey(null), "checking removed key -- 1");
        this.th.check(!hm.containsValue(null), "checking removed value -- 1");
        for (int i = 0; i < 15; ++i) {
            this.th.check(("a" + i + " value").equals(hm.remove("a" + i)), " removing a" + i);
        }
        this.th.check(hm.isEmpty(), "checking if al is gone");
    }

    public void test_entrySet() {
        this.th.checkPoint("entrySet()java.util.Set");
        HashMap hm = this.buildHM();
        Set s = hm.entrySet();
        Iterator it = s.iterator();
        Map.Entry me = null;
        it.next();
        try {
            s.add("ADDING");
            this.th.fail("add should throw an UnsupportedOperationException");
        }
        catch (UnsupportedOperationException uoe) {
            this.th.check(true);
        }
        this.th.check(s.size() == 16);
        hm.remove("a12");
        this.th.check(s.size() == 15);
        try {
            this.th.check(it.hasNext());
            this.th.check(true);
        }
        catch (ConcurrentModificationException cme) {
            this.th.fail("it.hasNext should not throw ConcurrentModificationException");
        }
        try {
            it.next();
            this.th.fail("should throw a ConcurrentModificationException -- 1");
        }
        catch (ConcurrentModificationException cme) {
            this.th.check(true);
        }
        try {
            it.remove();
            this.th.fail("should throw a ConcurrentModificationException -- 2");
        }
        catch (ConcurrentModificationException cme) {
            this.th.check(true);
        }
        it = s.iterator();
        try {
            me = it.next();
            if (me.getKey() == null) {
                me = it.next();
            }
            this.th.check(me.hashCode(), me.getValue().hashCode() ^ me.getKey().hashCode(), "verifying hashCode");
            this.th.check(!me.equals(it.next()));
        }
        catch (Exception e) {
            this.th.fail("got unwanted exception ,got " + e);
            this.th.debug("got ME key = " + me + " and value = " + me.getKey());
        }
        try {
            me.setValue("alpha");
            this.th.check(hm.get(me.getKey()), "alpha", "setValue through iterator of entrySet");
        }
        catch (UnsupportedOperationException uoe) {
            this.th.fail("setValue should be supported");
        }
        it = s.iterator();
        Vector v = new Vector();
        v.addAll(s);
        while (it.hasNext()) {
            Map.Entry ob = it.next();
            it.remove();
            if (v.remove(ob)) continue;
            this.th.debug("Object " + ob + " not in the Vector");
        }
        this.th.check(v.isEmpty(), "all elements gone from the vector");
        this.th.check(hm.isEmpty(), "all elements removed from the HashMap");
        it = s.iterator();
        hm.put(null, "sdf");
        try {
            it.next();
            this.th.fail("should throw a ConcurrentModificationException -- 3");
        }
        catch (ConcurrentModificationException cme) {
            this.th.check(true);
        }
        it = s.iterator();
        hm.clear();
        try {
            it.next();
            this.th.fail("should throw a ConcurrentModificationException -- 4");
        }
        catch (ConcurrentModificationException cme) {
            this.th.check(true);
        }
    }

    public void test_keySet() {
        this.th.checkPoint("keySet()java.util.Set");
        HashMap hm = this.buildHM();
        this.th.check(hm.size() == 16, "checking map size(), got " + hm.size());
        Set s = null;
        try {
            s = hm.keySet();
            this.th.check(s != null, "s != null");
            this.th.check(s.size() == 16, "checking size keyset, got " + s.size());
            Object[] o = s.toArray();
            this.th.check(o != null, "o != null");
            this.th.check(o.length == 16, "checking length, got " + o.length);
            Iterator it = s.iterator();
            Vector v = new Vector();
            v.addAll(s);
            while (it.hasNext()) {
                Object ob = it.next();
                it.remove();
                if (v.remove(ob)) continue;
                this.th.debug("Object " + ob + " not in the Vector");
            }
            this.th.check(v.isEmpty(), "all elements gone from the vector");
            this.th.check(hm.isEmpty(), "all elements removed from the HashMap");
        }
        catch (Exception e) {
            this.th.fail("got bad Exception -- got " + e);
        }
        try {
            s.add("ADDING");
            this.th.fail("add should throw an UnsupportedOperationException");
        }
        catch (UnsupportedOperationException uoe) {
            this.th.check(true);
        }
    }

    public void test_values() {
        this.th.checkPoint("values()java.util.Collection");
        HashMap hm = this.buildHM();
        this.th.check(hm.size() == 16, "checking map size(), got " + hm.size());
        Collection s = null;
        try {
            s = hm.values();
            this.th.check(s != null, "s != null");
            this.th.check(s.size() == 16, "checking size keyset, got " + s.size());
            Object[] o = s.toArray();
            this.th.check(o != null, "o != null");
            this.th.check(o.length == 16, "checking length, got " + o.length);
            Iterator it = s.iterator();
            Vector v = new Vector();
            v.addAll(s);
            while (it.hasNext()) {
                Object ob = it.next();
                it.remove();
                if (v.remove(ob)) continue;
                this.th.debug("Object " + ob + " not in the Vector");
            }
            this.th.check(v.isEmpty(), "all elements gone from the vector");
            this.th.check(hm.isEmpty(), "all elements removed from the HashMap");
        }
        catch (Exception e) {
            this.th.fail("got bad Exception -- got " + e);
        }
        try {
            s.add("ADDING");
            this.th.fail("add should throw an UnsupportedOperationException");
        }
        catch (UnsupportedOperationException uoe) {
            this.th.check(true);
        }
    }

    public void test_clone() {
        this.th.checkPoint("clone()java.lang.Object");
        HashMap hm = this.buildHM();
        Object o = hm.clone();
        this.th.check(o != hm, "clone is not the same object");
        this.th.check(hm.equals(o), "clone is equal to Map");
        hm.put("a", "b");
        this.th.check(!hm.equals(o), "clone doesn't change if Map changes");
    }

    public void test_behaviour() {
        this.th.checkPoint("behaviour testing");
        this.do_behaviourtest(0.7f);
        this.do_behaviourtest(0.75f);
        this.do_behaviourtest(0.95f);
        this.do_behaviourtest(1.0f);
    }

    protected void sleep(int time2) {
        try {
            Thread.sleep(time2);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    protected void check_presence(HashMap h) {
        this.th.check(h.get("a") != null, "checking presence st -- sequence " + this.sqnce);
        this.th.check(h.get(this.sh) != null, "checking presence sh -- sequence " + this.sqnce);
        this.th.check(h.get(this.i) != null, "checking presence i -- sequence " + this.sqnce);
        this.th.check(h.get(this.b) != null, "checking presence b -- sequence " + this.sqnce);
        this.th.check(h.get(this.l) != null, "checking presence l -- sequence " + this.sqnce);
        ++this.sqnce;
    }

    protected void do_behaviourtest(float loadFactor) {
        Float f;
        int j;
        this.th.checkPoint("behaviour testing with loadFactor " + loadFactor);
        HashMap<Object, Object> h = new HashMap<Object, Object>(11, loadFactor);
        h.put("a", "a");
        h.put(this.b, "byte");
        h.put(this.sh, "short");
        h.put(this.i, "int");
        h.put(this.l, "long");
        this.check_presence(h);
        this.sqnce = 1;
        for (j = 0; j < 100; ++j) {
            f = new Float(j);
            h.put(f, f);
        }
        this.th.check(h.size() == 105, "size checking -- 1 got: " + h.size());
        this.check_presence(h);
        while (j < 200) {
            f = new Float(j);
            h.put(f, f);
            ++j;
        }
        this.th.check(h.size() == 205, "size checking -- 2 got: " + h.size());
        this.check_presence(h);
        while (j < 300) {
            f = new Float(j);
            h.put(f, f);
            ++j;
        }
        this.th.check(h.size() == 305, "size checking -- 3 got: " + h.size());
        this.check_presence(h);
        this.th.check("a".equals(h.put("a", "na")), "replacing values -- 1 - st");
        this.th.check("byte".equals(h.put(this.b, "nbyte")), "replacing values -- 2 - b");
        this.th.check("short".equals(h.put(this.sh, "nshort")), "replacing values -- 3 -sh");
        this.th.check("int".equals(h.put(this.i, "nint")), "replacing values -- 4 -i");
        this.th.check("long".equals(h.put(this.l, "nlong")), "replacing values -- 5 -l");
        while (j > 199) {
            f = new Float(j);
            h.remove(f);
            --j;
        }
        this.th.check(h.size() == 205, "size checking -- 4 got: " + h.size());
        this.check_presence(h);
        while (j > 99) {
            f = new Float(j);
            h.remove(f);
            --j;
        }
        this.th.check(h.size() == 105, "size checking -- 5 got: " + h.size());
        this.check_presence(h);
        while (j > -1) {
            f = new Float(j);
            h.remove(f);
            --j;
        }
        this.th.check(h.size() == 5, "size checking -- 6 got: " + h.size());
        this.th.debug(h.toString());
        this.check_presence(h);
    }
}

