/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchMethodError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isPrimitive
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchMethodError o = new NoSuchMethodError("NoSuchMethodError");
        Class<?> c = o.getClass();
        harness.check(!c.isPrimitive());
    }
}

