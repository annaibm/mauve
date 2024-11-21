/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ArrayIndexOutOfBoundsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isEnum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArrayIndexOutOfBoundsException o = new ArrayIndexOutOfBoundsException("java.lang.ArrayIndexOutOfBoundsException");
        Class<?> c = o.getClass();
        harness.check(!c.isEnum());
    }
}

