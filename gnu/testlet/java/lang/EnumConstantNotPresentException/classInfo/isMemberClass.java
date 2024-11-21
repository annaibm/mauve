/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.EnumConstantNotPresentException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isMemberClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EnumConstantNotPresentException o = new EnumConstantNotPresentException(X.class, "EnumConstantNotPresentException");
        Class<?> c = o.getClass();
        harness.check(!c.isMemberClass());
    }

    static enum X {
        ONE,
        TWO,
        THREE;

    }
}

