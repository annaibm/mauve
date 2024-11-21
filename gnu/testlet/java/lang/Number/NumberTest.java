/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Number;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.lang.Number.NewNumber;

public class NumberTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        NewNumber _newnum = new NewNumber();
        NewNumber newnum = new NewNumber(300);
        NewNumber newnum1 = new NewNumber(Integer.MAX_VALUE);
        if (newnum.byteValue() != 44) {
            harness.fail("Error : test_Basics failed -1 ");
        }
        if (newnum1.shortValue() != -1) {
            harness.fail("Error : test_Basics failed -2 ");
        }
    }

    public void testall() {
        this.test_Basics();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

