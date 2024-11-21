/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Boolean object1 = new Boolean(true);
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"true");
        Boolean object2 = new Boolean(false);
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"false");
        Boolean object3 = new Boolean(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"false");
    }
}

