/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Object;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object object1 = new Object();
        harness.check(object1 != null);
        harness.check(object1.toString().startsWith("java.lang.Object"));
    }
}

