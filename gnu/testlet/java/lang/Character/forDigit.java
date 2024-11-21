/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class forDigit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Character.forDigit(-1, 5), 0);
        harness.check(Character.forDigit(7, 5), 0);
        harness.check(Character.forDigit(0, 1), 0);
        harness.check(Character.forDigit(5, 37), 0);
        harness.check(Character.forDigit(8, 10), 56);
        harness.check(Character.forDigit(12, 16), 99);
        harness.check(Character.forDigit(34, 36), 121);
    }
}

