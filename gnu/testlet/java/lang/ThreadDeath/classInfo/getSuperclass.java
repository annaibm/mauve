/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ThreadDeath.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ThreadDeath o = new ThreadDeath();
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.lang.Error");
    }
}

