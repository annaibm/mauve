/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Integer object1 = new Integer(42);
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"42");
        Integer object2 = new Integer("42");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"42");
        Integer object3 = new Integer("0");
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"0");
        Integer object4 = new Integer(Integer.MAX_VALUE);
        harness.check(object4 != null);
        harness.check(object4.toString(), (Object)"2147483647");
        Integer object5 = new Integer(Integer.MIN_VALUE);
        harness.check(object5 != null);
        harness.check(object5.toString(), (Object)"-2147483648");
    }
}

