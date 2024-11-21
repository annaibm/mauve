/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NegativeArraySizeException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NegativeArraySizeException o = new NegativeArraySizeException("java.lang.NegativeArraySizeException");
        Class<NegativeArraySizeException> c = o.getClass();
        harness.check(c.isAssignableFrom(NegativeArraySizeException.class));
    }
}

