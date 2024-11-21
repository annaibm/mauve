/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InstantiationException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAnnotation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InstantiationException o = new InstantiationException("java.lang.InstantiationException");
        Class<?> c = o.getClass();
        harness.check(!c.isAnnotation());
    }
}

