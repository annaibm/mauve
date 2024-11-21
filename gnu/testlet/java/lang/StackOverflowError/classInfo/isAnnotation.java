/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StackOverflowError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAnnotation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StackOverflowError o = new StackOverflowError("StackOverflowError");
        Class<?> c = o.getClass();
        harness.check(!c.isAnnotation());
    }
}

