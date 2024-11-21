/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Hashtable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AcuniaHashtableTest
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
        this.test_Hashtable();
        this.test_elements();
        this.test_get();
        this.test_keys();
        this.test_contains();
        this.test_containsKey();
        this.test_containsValue();
        this.test_isEmpty();
        this.test_size();
        this.test_put();
        this.test_putAll();
        this.test_remove();
        this.test_entrySet();
        this.test_keySet();
        this.test_values();
        this.test_clone();
        this.test_equals();
        this.test_hashCode();
        this.test_toString();
        this.test_rehash();
        this.test_behaviour();
    }

    public Hashtable buildknownHt() {
        Hashtable<Float, Float> ht = new Hashtable<Float, Float>(19);
        for (int i = 0; i < 11; ++i) {
            Float f = new Float(i);
            ht.put(f, f);
        }
        return ht;
    }

    public void test_Hashtable() {
        this.th.checkPoint("Hashtable()");
        Hashtable h = new Hashtable();
        h = new Hashtable(233, 0.5f);
        try {
            h = new Hashtable(0);
            this.th.check(true, "test 1");
            h = new Hashtable(25);
            this.th.check(true, "test 2");
        }
        catch (Exception e) {
            this.th.fail("shouldn't throw an exception -- " + e);
        }
        try {
            h = new Hashtable(-233);
            this.th.fail("should throw an IllegalArgumentException");
        }
        catch (IllegalArgumentException ie) {
            this.th.check(true, "test 3");
        }
        try {
            h = new Hashtable(233, 23.0f);
            this.th.check(true, "test 4");
        }
        catch (Exception e) {
            this.th.fail("shouldn't throw an exception -- " + e);
        }
        try {
            h = new Hashtable(233, 0.0f);
            this.th.fail("should throw an IllegalArgumentException");
        }
        catch (IllegalArgumentException ie) {
            this.th.check(true, "test 5");
        }
        try {
            h = new Hashtable(233, -1.0f);
            this.th.fail("should throw an IllegalArgumentException");
        }
        catch (IllegalArgumentException ie) {
            this.th.check(true, "test 6");
        }
        h = new Hashtable(this.buildknownHt());
        this.th.check(h.size() == 11, "the map had 11 enries");
        try {
            h = new Hashtable(null);
            this.th.fail("should throw a NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
    }

    public void test_elements() {
        this.th.checkPoint("elements()java.util.Enumeration");
        Hashtable ht = this.buildknownHt();
        Enumeration e = ht.elements();
        int i = 0;
        while (e.hasMoreElements()) {
            Float f = (Float)e.nextElement();
            Object o = ht.get(f);
            this.th.check(o != null, "each element is unique -- nr " + ++i);
            ht.remove(f);
        }
        this.th.check(i == 11, "we should have 11 elements");
        this.th.check(ht.size() == 0);
        e = new Hashtable().elements();
        this.th.check(e != null, "elements should return a non-null value");
        this.th.check(!e.hasMoreElements(), "e should not have elements");
    }

    public void test_get() {
        this.th.checkPoint("get(java.lang.Object)java.lang.Object");
        Hashtable<Float, Float> hte = new Hashtable<Float, Float>();
        Hashtable ht = this.buildknownHt();
        try {
            ht.get(null);
            this.th.fail("should throw NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        this.th.check(ht.get(new Object()) == null, "gives back null if not in -- 1");
        Float f = (Float)ht.elements().nextElement();
        Float g = new Float((double)f.floatValue() + 1.0E-5);
        this.th.check(ht.get(g) == null, "gives back null if not in -- 2");
        this.th.check(ht.get(f) == f, "key and element are same so get(f)==f -- 1");
        ht.put(hte, hte);
        hte.put(f, f);
        hte.put(g, g);
        this.th.check(ht.get(hte) == hte, "changing the hashcode of a key --> key must be found");
    }

    public void test_keys() {
        this.th.checkPoint("keys()java.util.Enumeration");
        Hashtable<String, String> ht = this.buildknownHt();
        Enumeration e = ht.keys();
        int i = 0;
        while (e.hasMoreElements()) {
            Float f = (Float)e.nextElement();
            Object o = ht.get(f);
            this.th.check(o != null, "each key is unique -- nr " + ++i);
            ht.remove(f);
        }
        this.th.check(i == 11, "we should have 11 key");
        this.th.check(ht.size() == 0);
        e = new Hashtable().keys();
        this.th.check(e != null, "keys should return a non-null value");
        this.th.check(!e.hasMoreElements(), "e should not have keys");
        ht = new Hashtable<String, String>();
        e = ht.keys();
        this.th.check(!e.hasMoreElements(), "empty HT Enum has no elements");
        ht.put("abcd", "value");
        e = ht.keys();
        this.th.check(e.hasMoreElements(), "HT Enum stil has elements");
        this.th.check("abcd".equals(e.nextElement()), "checking returned value");
        this.th.check(!e.hasMoreElements(), "HT Enum enumerated all elements");
    }

    public void test_contains() {
        this.th.checkPoint("contains(java.lang.Object)boolean");
        Hashtable ht = this.buildknownHt();
        Float f = new Float(10.0);
        this.th.check(ht.contains(f), "contains uses equals -- 1");
        f = new Float(11.0);
        this.th.check(!ht.contains(f), "contains uses equals -- 2");
        Double d = new Double(5.0);
        this.th.check(!ht.contains(d), "contains uses equals -- 3");
        ht.put(f, d);
        this.th.check(ht.contains(d), "contains uses equals -- 4");
        try {
            ht.contains(null);
            this.th.fail("should throw NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
    }

    public void test_containsKey() {
        this.th.checkPoint("containsKey(java.lang.Object)boolean");
        Hashtable ht = this.buildknownHt();
        Float f = new Float(10.0);
        this.th.check(ht.containsKey(f), "containsKey uses equals -- 1");
        f = new Float(11.0);
        this.th.check(!ht.containsKey(f), "containsKey uses equals -- 2");
        Double d = new Double(5.0);
        this.th.check(!ht.containsKey(d), "containsKey uses equals -- 3");
        ht.put(d, f);
        this.th.check(ht.containsKey(d), "containsKey uses equals -- 4");
        try {
            ht.containsKey(null);
            this.th.fail("should throw NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
    }

    public void test_containsValue() {
        this.th.checkPoint("containsValue(java.lang.Object)boolean");
        Hashtable ht = this.buildknownHt();
        Float f = new Float(10.0);
        this.th.check(ht.containsValue(f), "containsValue uses equals -- 1");
        f = new Float(11.0);
        this.th.check(!ht.containsValue(f), "containsValue uses equals -- 2");
        Double d = new Double(5.0);
        this.th.check(!ht.containsValue(d), "containsValue uses equals -- 3");
        ht.put(d, f);
        this.th.check(!ht.containsValue(d), "containsValue uses equals -- 4");
        d = new Double(89.0);
        ht.put(f, d);
        this.th.check(ht.containsValue(d), "containsValue uses equals -- 5");
        try {
            ht.containsValue(null);
            this.th.fail("should throw NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
    }

    public void test_isEmpty() {
        this.th.checkPoint("isEmpty()boolean");
        Hashtable ht = this.buildknownHt();
        this.th.check(!ht.isEmpty(), "ht is not empty -- 1");
        ht.clear();
        this.th.check(ht.isEmpty(), "hashtable should be empty --> after clear");
        ht.put(new Object(), ht);
        this.th.check(!ht.isEmpty(), "ht is not empty -- 2");
    }

    public void test_size() {
        this.th.checkPoint("size()int");
        Hashtable ht = this.buildknownHt();
        this.th.check(ht.size() == 11);
    }

    public void test_clear() {
        this.th.checkPoint("clear()void");
        Hashtable ht = new Hashtable();
        ht.clear();
        ht = this.buildknownHt();
        if (!ht.isEmpty()) {
            ht.clear();
            this.th.check(ht.isEmpty(), "hashtable should be empty --> after clear");
            try {
                ht.clear();
                this.th.check(ht.isEmpty(), "hashtable should be empty --> after 2nd clear");
            }
            catch (Exception e) {
                this.th.fail("clear should not throw " + e);
            }
        }
    }

    public void test_put() {
        this.th.checkPoint("put(java.lang.Object,java.lang.Object)java.lang.Object");
        Hashtable h = this.buildknownHt();
        Float f = new Float(33.0f);
        Double d = new Double(343.0);
        this.th.check(h.put(f, f) == null, "key f in not used");
        this.th.check(h.get(f) == f, "make sure element is put there -- 1");
        this.th.check(h.put(f, d) == f, "key f in used --> return old element");
        this.th.check(h.get(f) == d, "make sure element is put there -- 2");
        try {
            h.put(null, d);
            this.th.fail("should throw NullPointerException -- 1");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        try {
            h.put(d, null);
            this.th.fail("should throw NullPointerException -- 2");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        try {
            h.put(null, null);
            this.th.fail("should throw NullPointerException -- 3");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
    }

    public void test_putAll() {
        this.th.checkPoint("putAll(java.lang.Map)void");
        Hashtable<Number, Double> h = new Hashtable<Number, Double>();
        h.putAll(this.buildknownHt());
        this.th.check(h.size() == 11 && h.equals(this.buildknownHt()));
        Double d = new Double(34.0);
        Float f = new Float(2.0);
        h.put(f, d);
        h.putAll(this.buildknownHt());
        this.th.check(h.size() == 11 && h.equals(this.buildknownHt()));
        h.put(d, d);
        h.putAll(this.buildknownHt());
        this.th.check(h.size() == 12 && !h.equals(this.buildknownHt()));
        try {
            h.putAll(null);
            this.th.fail("should throw NullPointerException");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
    }

    public void test_remove() {
        this.th.checkPoint("remove(java.lang.Object)java.lang.Object");
        Hashtable h = this.buildknownHt();
        Float f = new Float(33.0f);
        int i = h.size();
        try {
            h.remove(null);
            this.th.fail("should throw NullPointerException -- 1");
        }
        catch (NullPointerException ne) {
            this.th.check(true);
        }
        this.th.check(h.remove(f) == null, "key not there so return null");
        this.th.check(h.size() == i, "check on size -- 1");
        for (int j = 0; j < 11; ++j) {
            f = new Float(j);
            this.th.check(h.remove(f).equals(f), "key is there so return element -- " + j);
            this.th.check(h.size() == --i, "check on size after removing -- " + j);
        }
    }

    public void test_entrySet() {
        this.th.checkPoint("entrySet()java.util.Set");
        Hashtable h = this.buildknownHt();
        Set s = h.entrySet();
        this.th.check(s.size() == 11);
        Object[] ao = s.toArray();
        Iterator i = s.iterator();
        int j = 0;
        while (i.hasNext()) {
            Map.Entry m = i.next();
            if (j == 50) break;
            ++j;
        }
        this.th.check(j == 11, "Iterator of Set must not do an Inf Loop, got j" + j);
    }

    public void test_keySet() {
        this.th.checkPoint("keySet()java.util.Set");
        Hashtable h = this.buildknownHt();
        Set s = h.keySet();
        this.th.check(s.size() == 11);
        for (int i = 0; i < 11; ++i) {
            this.th.check(s.contains(new Float(i)), "check if all keys are given -- " + i);
        }
    }

    public void test_values() {
        this.th.checkPoint("values()java.util.Collection");
        Hashtable h = this.buildknownHt();
        Collection c = h.values();
        this.th.check(c.size() == 11);
        for (int i = 0; i < 11; ++i) {
            this.th.check(c.contains(new Float(i)), "check if all values are given -- " + i);
        }
    }

    public void test_clone() {
        Float f;
        this.th.checkPoint("clone()java.lang.Object");
        Hashtable ht1 = this.buildknownHt();
        Hashtable ht2 = (Hashtable)ht1.clone();
        this.th.check(ht2.size() == 11, "checking size -- got: " + ht2.size());
        this.th.check(ht2.equals(ht1), "clone gives back equal hashtables");
        Enumeration e = ht1.elements();
        for (int i = 0; i < 11; ++i) {
            Object o;
            f = (Float)e.nextElement();
            this.th.check(f == (Float)(o = ht2.get(f)), "key and element are the same");
        }
        f = (Float)ht1.elements().nextElement();
        ht2.remove(f);
        this.th.check(ht1.size() == 11, "changes in clone do not affect original");
        ht1.put(ht2, ht1);
        this.th.check(ht2.size() == 10, "changes in original do not affect clone");
        ht1 = new Hashtable();
        ht2 = (Hashtable)ht1.clone();
        this.th.check(ht2.size() == 0, "cloning an empty hashtable must work");
    }

    public void test_equals() {
        this.th.checkPoint("equals(java.lang.Object)boolean");
        Hashtable h2 = this.buildknownHt();
        Hashtable h1 = this.buildknownHt();
        this.th.check(h2.equals(h1), "hashtables are equal -- 1");
        h2.remove(new Float(2.0f));
        this.th.check(!h2.equals(h1), "hashtables are not equal");
        h1.remove(new Float(2.0f));
        this.th.check(h2.equals(h1), "hashtables are equal -- 2");
        this.th.check(!h2.equals(new Float(3.0)), "hashtables is not equal to Float");
    }

    public void test_hashCode() {
        this.th.checkPoint("hashCode()int");
        Hashtable<Number, Object> h = new Hashtable<Number, Object>(13);
        this.th.check(this.buildknownHt().hashCode() == this.buildknownHt().hashCode());
        Integer i = new Integer(4545);
        String s = new String("string");
        Double d = new Double(23245.6);
        Object o = new Object();
        h.put(i, s);
        this.th.check(h.hashCode() == (i.hashCode() ^ s.hashCode()));
        h.put(d, o);
        this.th.check(h.hashCode() == (i.hashCode() ^ s.hashCode()) + (d.hashCode() ^ o.hashCode()));
    }

    public void test_toString() {
        this.th.checkPoint("toString()java.lang.String");
        Hashtable<String, Object> h = new Hashtable<String, Object>(13, 0.75f);
        this.th.check(h.toString().equals("{}"), "got: " + h);
        h.put("SmartMove", "Fantastic");
        this.th.check(h.toString().equals("{SmartMove=Fantastic}"), "got: " + h);
        h.put("nr 1", new Float(23.0));
        this.th.check(h.toString().equals("{SmartMove=Fantastic, nr 1=23.0}") || h.toString().equals("{nr 1=23.0, SmartMove=Fantastic}"), "got: " + h);
        h.remove("SmartMove");
        this.th.check(h.toString().equals("{nr 1=23.0}"), "got: " + h);
    }

    public void test_rehash() {
        this.th.checkPoint("rehash()void");
        Hashtable<String, String> h = new Hashtable<String, String>(3, 0.5f);
        try {
            h.put("Smart", "Move");
            h.put("rehash", "now");
            this.th.check(h.size() == 2);
        }
        catch (Exception e) {
            this.th.fail("caught exception " + e);
        }
    }

    public void test_behaviour() {
        this.th.checkPoint("behaviour testing");
        this.do_behaviourtest(0.2f);
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

    protected void check_presence(Hashtable h) {
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
        Hashtable<Object, Object> h = new Hashtable<Object, Object>(11, loadFactor);
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

