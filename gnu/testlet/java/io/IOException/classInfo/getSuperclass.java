/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.IOException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IOException o = new IOException("xyzzy");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.lang.Exception");
    }
}

