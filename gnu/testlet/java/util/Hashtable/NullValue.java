/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Hashtable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.HashMap;
import java.util.Hashtable;

public class NullValue
extends Hashtable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Hashtable h;
        HashMap<String, String> m = new HashMap<String, String>();
        m.put("a", "1");
        m.put("b", null);
        try {
            h = new Hashtable(m);
            harness.fail("Should throw NullPointerException");
        }
        catch (NullPointerException x) {
            harness.check(true);
        }
        m = new HashMap();
        m.put("a", "1");
        m.put(null, "2");
        try {
            h = new Hashtable(m);
            harness.fail("Should throw NullPointerException");
        }
        catch (NullPointerException x) {
            harness.check(true);
        }
    }
}

