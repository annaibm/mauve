/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.LinkageError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;

public class getEnclosingConstructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        LinkageError o = new LinkageError("LinkageError");
        Class<?> c = o.getClass();
        Constructor<?> cons = c.getEnclosingConstructor();
        harness.check(cons == null);
    }
}

