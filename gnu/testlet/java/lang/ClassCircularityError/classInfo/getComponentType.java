/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassCircularityError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getComponentType
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ClassCircularityError o = new ClassCircularityError("ClassCircularityError");
        Class<?> c = o.getClass();
        Class<?> cls = c.getComponentType();
        harness.check(cls == null);
    }
}

