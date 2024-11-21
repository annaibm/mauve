/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.EnumConstantNotPresentException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new EnumConstantNotPresentException(X.class, "EnumConstantNotPresentException");
        }
        catch (EnumConstantNotPresentException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }

    static enum X {
        ONE,
        TWO,
        THREE;

    }
}

