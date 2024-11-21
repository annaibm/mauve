/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnsatisfiedLinkError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getComponentType
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsatisfiedLinkError o = new UnsatisfiedLinkError("UnsatisfiedLinkError");
        Class<?> c = o.getClass();
        Class<?> cls = c.getComponentType();
        harness.check(cls == null);
    }
}

