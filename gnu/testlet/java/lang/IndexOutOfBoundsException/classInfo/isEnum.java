/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IndexOutOfBoundsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isEnum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IndexOutOfBoundsException o = new IndexOutOfBoundsException("java.lang.IndexOutOfBoundsException");
        Class<?> c = o.getClass();
        harness.check(!c.isEnum());
    }
}

