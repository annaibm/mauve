/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ArrayIndexOutOfBoundsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArrayIndexOutOfBoundsException o = new ArrayIndexOutOfBoundsException("java.lang.ArrayIndexOutOfBoundsException");
        Class<ArrayIndexOutOfBoundsException> c = o.getClass();
        harness.check(c.isAssignableFrom(ArrayIndexOutOfBoundsException.class));
    }
}

