/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.TypeNotPresentException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getEnclosingClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TypeNotPresentException o = new TypeNotPresentException("java.lang.TypeNotPresentException", new Throwable());
        Class<?> c = o.getClass();
        Class<?> cls = c.getEnclosingClass();
        harness.check(cls == null);
    }
}

