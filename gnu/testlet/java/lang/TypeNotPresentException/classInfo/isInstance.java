/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.TypeNotPresentException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TypeNotPresentException o = new TypeNotPresentException("TypeNotPresentException", new Throwable());
        Class<?> c = o.getClass();
        harness.check(c.isInstance(new TypeNotPresentException("TypeNotPresentException", new Throwable())));
    }
}

