/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.TypeNotPresentException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TypeNotPresentException o = new TypeNotPresentException("TypeNotPresentException", new Throwable());
        Class<?> c = o.getClass();
        harness.check(c.getName(), (Object)"java.lang.TypeNotPresentException");
    }
}

