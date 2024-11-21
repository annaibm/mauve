/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Error.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isLocalClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Error o = new Error("Error");
        Class<?> c = o.getClass();
        harness.check(!c.isLocalClass());
    }
}

