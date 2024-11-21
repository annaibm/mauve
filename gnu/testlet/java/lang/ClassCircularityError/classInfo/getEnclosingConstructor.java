/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassCircularityError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;

public class getEnclosingConstructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ClassCircularityError o = new ClassCircularityError("ClassCircularityError");
        Class<?> c = o.getClass();
        Constructor<?> cons = c.getEnclosingConstructor();
        harness.check(cons == null);
    }
}

