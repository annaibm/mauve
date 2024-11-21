/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.AbstractMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.AbstractMap.ESet;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Vector;

public class AcuniaAbstractMapTest
extends AbstractMap
implements Testlet {
    protected TestHarness th;
    Vector keys = new Vector();
    Vector values = new Vector();
    private boolean edit = true;

    @Override
    public void test(TestHarness harness) {
        this.th = harness;
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
        this.test_equals();
        this.test_hashCode();
        this.test_toString();
    }

    protected AcuniaAbstractMapTest buildHT() {
        AcuniaAbstractMapTest t = new AcuniaAbstractMapTest();
        for (int i = 0; i < 15; ++i) {
            String s = "a" + i;
            t.put(s, s + " value");
        }
        return t;
    }

    public void test_get() {
        this.th.checkPoint("get(java.lang.Object)java.lang.Object");
        AcuniaAbstractMapTest ehm = this.buildHT();
        String s = "a1";
        Object o = ehm.get(s);
        this.th.check((s + " value").equals(o), "checking return value");
        o = ehm.get(null);
        this.th.check(o == null);
        o = ehm.get(s + " value");
        this.th.check(o == null);
        ehm.put((Object)null, s);
        o = ehm.get(null);
        this.th.check(s.equals(o));
    }

    public void test_containsKey() {
        this.th.checkPoint("containsKey(java.lang.Object)boolean");
        AcuniaAbstractMapTest ehm = this.buildHT();
        this.th.check(!ehm.containsKey(null), "null not there");
        ehm.put((Object)null, "test");
        this.th.check(ehm.containsKey(null), "null is in there");
        this.th.check(ehm.containsKey("a1"), "object is in there");
        this.th.check(!ehm.containsKey("a1 value"), "object is not in there -- 1");
        this.th.check(!ehm.containsKey(new Object()), "object is not in there -- 2");
    }

    public void test_containsValue() {
        this.th.checkPoint("containsValue(java.lang.Object)boolean");
        AcuniaAbstractMapTest ehm = this.buildHT();
        this.th.check(!ehm.containsValue(null), "null not there");
        ehm.put((Object)null, (Object)null);
        this.th.check(ehm.containsValue(null), "null is in there");
        this.th.check(!ehm.containsValue("a1"), "object is not in there -- 1");
        this.th.check(ehm.containsValue("a1 value"), "object is in there -- 1");
        this.th.check(!ehm.containsValue(new Object()), "object is not in there -- 2");
    }

    public void test_isEmpty() {
        this.th.checkPoint("isEmpty()boolean");
        AcuniaAbstractMapTest ehm = new AcuniaAbstractMapTest();
        this.th.check(ehm.isEmpty(), "true");
        ehm = this.buildHT();
        this.th.check(!ehm.isEmpty(), "false");
    }

    public void test_size() {
        this.th.checkPoint("()");
    }

    public void test_clear() {
        this.th.checkPoint("clear()void");
        AcuniaAbstractMapTest ehm = this.buildHT();
        ehm.clear();
        this.th.check(ehm.isEmpty(), "true");
    }

    public void test_put() {
        this.th.checkPoint("put(java.lang.Object,java.lang.Object)java.lang.Object");
        AcuniaAbstractMapTest ehm = this.buildHT();
        ehm.set_edit(false);
        try {
            ehm.put("a", "b");
            this.th.fail("should throw an UnsupportedOperationException");
        }
        catch (UnsupportedOperationException uoe) {
            this.th.check(true);
        }
    }

    public void test_putAll() {
        this.th.checkPoint("putAll(java.util.Map)void");
        Hashtable<String, String> ht = new Hashtable<String, String>();
        AcuniaAbstractMapTest ehm = new AcuniaAbstractMapTest();
        this.th.check(ehm.equals(ht), "true -- both empty");
        ht.put("a", "b");
        ht.put("c", "d");
        ht.put("e", "f");
        ehm.putAll(ht);
        this.th.check(ehm.equals(ht), "true -- 1");
        ht.put("a1", "f");
        ht.put("e", "b");
        ehm.putAll(ht);
        this.th.check(ehm.equals(ht), "true -- 2");
        ehm = this.buildHT();
        try {
            ehm.putAll(ht);
            this.th.check(true, "putAll: " + ht);
        }
        catch (NoSuchElementException nse) {
            this.th.check(false, "putAll: " + ht);
        }
        this.th.check(ehm.size() == 18, "added three elements");
        this.th.check("f".equals(ehm.get("a1")), "overwritten old value");
    }

    public void test_remove() {
        this.th.checkPoint("remove(java.lang.Object)java.lang.Object");
        AcuniaAbstractMapTest ehm = this.buildHT();
        ehm.remove("a1");
        this.th.check(!ehm.containsKey("a1"), "key removed -- 1");
        this.th.check(!ehm.containsValue("a1 value"), "value removed -- 1");
        ehm.remove("a0");
        this.th.check(!ehm.containsKey("a0"), "key removed -- 2");
        this.th.check(!ehm.containsValue("a0 value"), "value removed -- 2");
        for (int i = 2; i < 15; ++i) {
            ehm.remove("a" + i);
        }
        this.th.check(ehm.isEmpty());
    }

    public void test_entrySet() {
        this.th.checkPoint("()");
    }

    public void test_keySet() {
        this.th.checkPoint("keySet()java.util.Set");
        AcuniaAbstractMapTest ehm = this.buildHT();
        Set s = ehm.keySet();
        this.th.check(s.size() == 15);
        ehm.put((Object)null, "test");
        this.th.check(s.size() == 16);
        this.th.check(s.contains("a1"), "does contain a1");
        this.th.check(s.contains(null), "does contain null");
        this.th.check(!s.contains(new Object()), "does contain new Object");
        this.th.check(!s.contains("test"), "does contain test");
        this.th.check(s == ehm.keySet(), "same Set is returned");
        Iterator it = s.iterator();
        Vector v = ehm.getKeyV();
        for (int i = 0; i < 16; ++i) {
            Object o = it.next();
            this.th.check(v.indexOf(o) == 0, "order is not respected");
            if (v.remove(o)) continue;
            this.th.debug("didn't find " + o);
        }
        it = s.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        this.th.check(s.isEmpty(), "everything is removed");
        s = ehm.keySet();
        this.th.check(s.isEmpty(), "new Set is also empty");
        ehm.put("a", "B");
        this.th.check(!s.isEmpty(), "Set is updated by underlying actions");
    }

    public void test_values() {
        this.th.checkPoint("values()java.util.Collection");
        AcuniaAbstractMapTest ehm = this.buildHT();
        Collection s = ehm.values();
        this.th.check(s.size() == 15);
        ehm.put((Object)null, "test");
        ehm.put("a10", (Object)null);
        this.th.check(s.size() == 16);
        this.th.check(s.contains("a1 value"), "does contain a1 value");
        this.th.check(s.contains(null), "does contain null");
        this.th.check(!s.contains(new Object()), "does contain new Object");
        this.th.check(s.contains("test"), "does contain test");
        this.th.check(!s.contains("a1"), "does not contain a1");
        this.th.check(s == ehm.values(), "same Set is returned");
        Iterator it = s.iterator();
        Vector v = ehm.getValuesV();
        for (int i = 0; i < 16; ++i) {
            Object o = it.next();
            this.th.check(v.indexOf(o) == 0, "order is not respected");
            if (v.remove(o)) continue;
            this.th.debug("didn't find " + o);
        }
        it = s.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        this.th.check(s.isEmpty(), "everything is removed");
        s = ehm.values();
        this.th.check(s.isEmpty(), "new Set is also empty");
        ehm.put("a", "B");
        this.th.check(!s.isEmpty(), "Set is updated by underlying actions");
    }

    public void test_equals() {
        this.th.checkPoint("equals(java.lang.Object)boolean");
        Hashtable<String, String> ht = new Hashtable<String, String>();
        AcuniaAbstractMapTest ehm = new AcuniaAbstractMapTest();
        this.th.check(ehm.equals(ht), "true -- both empty");
        ht.put("a", "b");
        ht.put("c", "d");
        ht.put("e", "f");
        ehm.put("a", "b");
        ehm.put("c", "d");
        ehm.put("e", "f");
        this.th.check(ehm.equals(ht), "true -- same key && values");
        ht.put("a", "f");
        this.th.check(!ehm.equals(ht), "false -- same key && diff values");
        ht.put("e", "b");
        this.th.check(!ehm.equals(ht), "false --  key with diff values");
        this.th.check(!ehm.equals(ht.entrySet()), "false --  no Map");
        this.th.check(!ehm.equals(new Object()), "false -- Object is no Map");
        this.th.check(!ehm.equals(null), "false -- Object is null");
    }

    public void test_hashCode() {
        this.th.checkPoint("hashCode()int");
        AcuniaAbstractMapTest ehm = new AcuniaAbstractMapTest();
        this.th.check(ehm.hashCode() == 0, "hashCode of Empty Map is 0, got " + ehm.hashCode());
        int hash2 = 0;
        Iterator s = ehm.entrySet().iterator();
        while (s.hasNext()) {
            hash2 += s.next().hashCode();
        }
        this.th.check(ehm.hashCode(), hash2, "hashCode of Empty Map -- checking Algorithm");
    }

    public void test_toString() {
        this.th.checkPoint("toString()java.lang.String");
        AcuniaAbstractMapTest ehm = new AcuniaAbstractMapTest();
        this.th.check("{}".equals(ehm.toString()), "checking empty Map");
        ehm.put("a", "b");
        this.th.debug(ehm.toString());
        this.th.check("{a=b}".equals(ehm.toString()), "checking Map with one element");
        ehm.put("c", "d");
        ehm.put("e", "f");
        this.th.debug(ehm.toString());
        this.th.check("{a=b, c=d, e=f}".equals(ehm.toString()), "checking Map with three elements");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    boolean deleteInAM(Object e) {
        if (!this.keys.contains(e)) {
            return false;
        }
        this.values.remove(this.keys.indexOf(e));
        return this.keys.remove(e);
    }

    public Vector getKeyV() {
        return (Vector)this.keys.clone();
    }

    public Vector getValuesV() {
        return (Vector)this.values.clone();
    }

    @Override
    public Set entrySet() {
        return new ESet(this);
    }

    @Override
    public Object put(Object key, Object value2) {
        if (this.edit) {
            if (this.keys.contains(key)) {
                return this.values.set(this.keys.indexOf(key), value2);
            }
            this.values.add(value2);
            this.keys.add(key);
            return null;
        }
        return super.put(key, value2);
    }

    public void set_edit(boolean b) {
        this.edit = b;
    }
}

