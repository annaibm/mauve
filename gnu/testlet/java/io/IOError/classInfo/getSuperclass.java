/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.IOError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOError;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IOError o = new IOError(null);
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.lang.Error");
    }
}

