/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringIndexOutOfBoundsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringIndexOutOfBoundsException o = new StringIndexOutOfBoundsException("java.lang.StringIndexOutOfBoundsException");
        Class<?> c = o.getClass();
        Package p = c.getPackage();
        harness.check(p.getName(), (Object)"java.lang");
    }
}

