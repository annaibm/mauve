/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.NotActiveException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.NotActiveException;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NotActiveException o = new NotActiveException("xyzzy");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.io.ObjectStreamException");
    }
}

