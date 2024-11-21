/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Hashtable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Hashtable;

public class ContainsHash
extends Hashtable
implements Testlet {
    private static Object a = new Object();
    private static Object b = new Object();

    @Override
    public void test(TestHarness harness) {
        harness.check(!this.contains(a));
        harness.check(this.contains(b));
        harness.check(!this.containsValue(a));
        harness.check(this.containsValue(b));
    }

    @Override
    public boolean contains(Object value2) {
        return value2 == b;
    }
}

