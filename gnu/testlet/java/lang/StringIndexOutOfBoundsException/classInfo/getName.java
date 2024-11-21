/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringIndexOutOfBoundsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringIndexOutOfBoundsException o = new StringIndexOutOfBoundsException("java.lang.StringIndexOutOfBoundsException");
        Class<?> c = o.getClass();
        harness.check(c.getName(), (Object)"java.lang.StringIndexOutOfBoundsException");
    }
}

