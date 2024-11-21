/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;

public class getEnclosingConstructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<Math> c = Math.class;
        Constructor<?> cons = c.getEnclosingConstructor();
        harness.check(cons == null);
    }
}

