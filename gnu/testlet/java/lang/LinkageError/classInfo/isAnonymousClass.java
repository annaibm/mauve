/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.LinkageError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAnonymousClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        LinkageError o = new LinkageError("LinkageError");
        Class<?> c = o.getClass();
        harness.check(!c.isAnonymousClass());
    }
}

