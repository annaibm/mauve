/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class compareToBoolean
implements Testlet {
    public static final int LESS = -1;
    public static final int EQUAL = 0;
    public static final int GREATER = 1;
    TestHarness harness;

    void compare(Boolean b1, Boolean b2, int expected) {
        int result = b1.compareTo(b2);
        switch (expected) {
            case -1: {
                this.harness.check(result < 0);
                break;
            }
            case 0: {
                this.harness.check(result == 0);
                break;
            }
            case 1: {
                this.harness.check(result > 0);
                break;
            }
            default: {
                throw new Error();
            }
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        harness.checkPoint("compareTo");
        this.compare(Boolean.TRUE, Boolean.TRUE, 0);
        this.compare(Boolean.TRUE, Boolean.FALSE, 1);
        this.compare(Boolean.FALSE, Boolean.TRUE, -1);
        this.compare(Boolean.FALSE, Boolean.FALSE, 0);
    }
}

