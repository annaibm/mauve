/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<Math> c = Math.class;
        Class superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.lang.Object");
    }
}

