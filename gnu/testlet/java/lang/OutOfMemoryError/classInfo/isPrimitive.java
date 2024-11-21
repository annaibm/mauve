/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.OutOfMemoryError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isPrimitive
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        OutOfMemoryError o = new OutOfMemoryError("OutOfMemoryError");
        Class<?> c = o.getClass();
        harness.check(!c.isPrimitive());
    }
}

