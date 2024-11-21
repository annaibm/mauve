/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchFieldException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchFieldException o = new NoSuchFieldException("java.lang.NoSuchFieldException");
        Class<NoSuchFieldException> c = o.getClass();
        harness.check(c.isAssignableFrom(NoSuchFieldException.class));
    }
}

