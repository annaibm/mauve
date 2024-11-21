/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Cloneable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class CloneableTest
implements Testlet,
Cloneable {
    int a = 20;
    char b = (char)98;
    Float c = new Float(10.0f);
    protected static TestHarness harness;

    public void test_clone() {
        CloneableTest tst = null;
        try {
            tst = (CloneableTest)this.clone();
        }
        catch (CloneNotSupportedException e) {
            harness.fail("Error: CloneNotSupportedException should not be thrown here");
        }
        if (tst == null) {
            harness.fail("Error: Clone method on Object did not work properly");
        } else if (tst.a != this.a || tst.b != this.b || tst.c.floatValue() != this.c.floatValue()) {
            harness.fail("Error: Clone method on Object did not clone data properly");
        }
    }

    public void test_array() {
        Class<?> clb;
        int i;
        int[] ia = new int[5];
        for (i = 0; i < ia.length; ++i) {
            ia[i] = i;
        }
        int[] o = ia;
        if (!(ia instanceof Cloneable)) {
            harness.fail("Error: arrays should implement Cloneable");
        }
        int[] ib = (int[])ia.clone();
        Class<?> cla = ia.getClass();
        if (cla != (clb = ib.getClass())) {
            harness.fail("Error: array classes should be equal");
        }
        for (i = 0; i < ia.length; ++i) {
            if (ib[i] == ia[i]) continue;
            harness.fail("Error: mismatch on cloned array at " + i);
        }
    }

    public void testall() {
        this.test_clone();
        this.test_array();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

