/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ArrayStoreException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArrayStoreException o = new ArrayStoreException("java.lang.ArrayStoreException");
        Class<ArrayStoreException> c = o.getClass();
        harness.check(c.isAssignableFrom(ArrayStoreException.class));
    }
}

