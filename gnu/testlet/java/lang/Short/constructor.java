/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Short;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Short object1 = new Short(42);
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"42");
        Short object2 = new Short("42");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"42");
    }
}

