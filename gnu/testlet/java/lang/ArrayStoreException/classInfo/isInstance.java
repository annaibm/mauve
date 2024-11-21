/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ArrayStoreException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArrayStoreException o = new ArrayStoreException("java.lang.ArrayStoreException");
        Class<?> c = o.getClass();
        harness.check(c.isInstance(new ArrayStoreException("java.lang.ArrayStoreException")));
    }
}

