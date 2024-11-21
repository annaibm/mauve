/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringIndexOutOfBoundsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringIndexOutOfBoundsException o = new StringIndexOutOfBoundsException("java.lang.StringIndexOutOfBoundsException");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.lang.IndexOutOfBoundsException");
    }
}

