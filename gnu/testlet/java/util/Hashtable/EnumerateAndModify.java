/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Hashtable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Enumeration;
import java.util.Hashtable;

public class EnumerateAndModify
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Throwable thrown;
        Hashtable<String, String> allKeys2 = new Hashtable<String, String>();
        allKeys2.put("C", "c");
        allKeys2.put("D", "d");
        allKeys2.put("A", "a");
        allKeys2.put("B", "b");
        allKeys2.put("E", "e");
        allKeys2.put("C1", "c");
        allKeys2.put("D1", "d");
        allKeys2.put("A1", "a");
        allKeys2.put("B1", "b");
        allKeys2.put("E1", "e");
        Hashtable<String, String> allElements = new Hashtable<String, String>();
        allElements.put("c", "c");
        allElements.put("d", "d");
        allElements.put("a", "a");
        allElements.put("b", "b");
        allElements.put("e", "e");
        allElements.put("c1", "c1");
        allElements.put("d1", "d1");
        allElements.put("a1", "a1");
        allElements.put("b1", "b1");
        allElements.put("e1", "e1");
        Hashtable<String, String> ht = new Hashtable<String, String>();
        ht.put("A", "a");
        ht.put("B", "b");
        ht.put("C", "c");
        ht.put("D", "d");
        ht.put("E", "e");
        boolean returnedOnlyKeysThatWerePut = true;
        try {
            Enumeration e = ht.keys();
            while (e.hasMoreElements()) {
                String str = (String)e.nextElement();
                if (str != null && !allKeys2.containsKey(str)) {
                    returnedOnlyKeysThatWerePut = false;
                }
                ht.put("C", "c");
                ht.put("D", "d");
                ht.put("A", "a");
                ht.put("B", "b");
                ht.put("E", "e");
                ht.put("C1", "c");
                ht.put("D1", "d");
                ht.put("A1", "a");
                ht.put("B1", "b");
                ht.put("E1", "e");
            }
            thrown = null;
        }
        catch (Throwable t) {
            t.printStackTrace();
            thrown = t;
        }
        harness.check(thrown == null);
        harness.check(returnedOnlyKeysThatWerePut);
        ht = new Hashtable();
        ht.put("A", "a");
        ht.put("B", "b");
        ht.put("C", "c");
        ht.put("D", "d");
        ht.put("E", "e");
        boolean returnedOnlyElementsThatWerePut = true;
        try {
            Enumeration e = ht.elements();
            while (e.hasMoreElements()) {
                String str = (String)e.nextElement();
                if (str != null && !allElements.containsKey(str)) {
                    returnedOnlyElementsThatWerePut = false;
                }
                ht.put("C", "c");
                ht.put("D", "d");
                ht.put("A", "a");
                ht.put("B", "b");
                ht.put("E", "e");
                ht.put("C1", "c1");
                ht.put("D1", "d1");
                ht.put("A1", "a1");
                ht.put("B1", "b1");
                ht.put("E1", "e1");
            }
            thrown = null;
        }
        catch (Throwable t) {
            thrown = t;
        }
        harness.check(thrown == null);
        harness.check(returnedOnlyElementsThatWerePut);
    }
}

