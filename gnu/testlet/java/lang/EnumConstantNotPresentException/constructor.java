/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.EnumConstantNotPresentException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EnumConstantNotPresentException object1 = new EnumConstantNotPresentException(X.class, "nothing happens");
        harness.check(object1 != null);
        harness.check(object1.toString().startsWith("java.lang.EnumConstantNotPresentException"));
        EnumConstantNotPresentException object2 = new EnumConstantNotPresentException(X.class, null);
        harness.check(object2 != null);
        harness.check(object2.toString().startsWith("java.lang.EnumConstantNotPresentException"));
    }

    static enum X {
        ONE,
        TWO,
        THREE;

    }
}

