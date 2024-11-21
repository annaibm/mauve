/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Hashtable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Hashtable;

public class basic
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Hashtable<Integer, String> hash2 = new Hashtable<Integer, String>(13, 0.25f);
        harness.check(hash2.toString(), (Object)"{}");
        harness.check(hash2.isEmpty());
        hash2.put(new Integer(1), "one");
        hash2.put(new Integer(2), "two");
        hash2.put(new Integer(3), "three");
        hash2.put(new Integer(4), "four");
        hash2.put(new Integer(5), "five");
        hash2.put(new Integer(6), "six");
        hash2.put(new Integer(7), "seven");
        hash2.put(new Integer(8), "eight");
        hash2.put(new Integer(9), "nine");
        hash2.put(new Integer(10), "ten");
        hash2.put(new Integer(11), "eleven");
        hash2.put(new Integer(12), "twelve");
        hash2.put(new Integer(13), "thirteen");
        hash2.put(new Integer(14), "fourteen");
        hash2.put(new Integer(15), "fifteen");
        harness.check(!hash2.isEmpty());
        harness.check(hash2.size(), 15);
        Integer key = new Integer(13);
        String val = (String)hash2.get(key);
        hash2.put(key, val.toUpperCase());
        harness.check(hash2.size(), 15);
        harness.check(hash2.containsKey(key));
        harness.check(!hash2.contains("thirteen"));
        harness.check(hash2.contains("THIRTEEN"));
        hash2.remove(key);
        harness.check(hash2.size(), 14);
        Hashtable copy2 = (Hashtable)hash2.clone();
        hash2.clear();
        harness.check(hash2.toString(), (Object)"{}");
        harness.check(hash2.size(), 0);
        harness.check(copy2.size(), 14);
    }
}

