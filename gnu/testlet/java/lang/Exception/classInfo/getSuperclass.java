/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Exception.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Exception o = new Exception("java.lang.Exception");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.lang.Throwable");
    }
}

