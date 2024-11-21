/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Hashtable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Hashtable;

public class HashContains
extends Hashtable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object a = new Object();
        Object b = new Object();
        Object c = this.put(a, b);
        harness.check(null, c);
        harness.check(!this.contains(a));
        harness.check(this.contains(b));
        harness.check(!this.containsValue(a));
        harness.check(this.containsValue(b));
    }

    @Override
    public boolean contains(Object value2) {
        return super.contains(value2);
    }

    @Override
    public boolean containsValue(Object value2) {
        return this.contains(value2);
    }
}

