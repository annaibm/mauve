/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InvalidClassException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InvalidClassException;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InvalidClassException o = new InvalidClassException("xyzzy");
        Class<?> c = o.getClass();
        Package p = c.getPackage();
        harness.check(p.getName(), (Object)"java.io");
    }
}

