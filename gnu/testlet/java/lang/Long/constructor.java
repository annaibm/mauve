/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Long object1 = new Long(42L);
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"42");
        Long object2 = new Long("42");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"42");
        Long object3 = new Long("0");
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"0");
    }
}

