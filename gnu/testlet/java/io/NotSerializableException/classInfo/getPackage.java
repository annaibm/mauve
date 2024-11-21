/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.NotSerializableException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.NotSerializableException;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NotSerializableException o = new NotSerializableException("xyzzy");
        Class<?> c = o.getClass();
        Package p = c.getPackage();
        harness.check(p.getName(), (Object)"java.io");
    }
}

