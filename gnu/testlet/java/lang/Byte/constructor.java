/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Byte object1 = new Byte("42");
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"42");
        Byte object2 = new Byte(42);
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"42");
        boolean caught = false;
        try {
            Byte by = new Byte(null);
        }
        catch (NumberFormatException e) {
            caught = true;
        }
        harness.check(caught);
        caught = false;
        try {
            Byte e = new Byte("not byte!");
        }
        catch (NumberFormatException e) {
            caught = true;
        }
        harness.check(caught);
    }
}

