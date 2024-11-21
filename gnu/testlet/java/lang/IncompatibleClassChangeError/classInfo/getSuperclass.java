/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IncompatibleClassChangeError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IncompatibleClassChangeError o = new IncompatibleClassChangeError("IncompatibleClassChangeError");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.lang.LinkageError");
    }
}

