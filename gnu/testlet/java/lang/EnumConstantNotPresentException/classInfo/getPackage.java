/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.EnumConstantNotPresentException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EnumConstantNotPresentException o = new EnumConstantNotPresentException(X.class, "EnumConstantNotPresentException");
        Class<?> c = o.getClass();
        Package p = c.getPackage();
        harness.check(p.getName(), (Object)"java.lang");
    }

    static enum X {
        ONE,
        TWO,
        THREE;

    }
}

