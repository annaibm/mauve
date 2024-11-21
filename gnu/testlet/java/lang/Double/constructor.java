/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Double object2 = new Double("1");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"1.0");
        Double object3 = new Double("1.0");
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"1.0");
    }
}

