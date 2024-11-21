/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.NotActiveException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.NotActiveException;

public class isInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NotActiveException o = new NotActiveException("xyzzy");
        Class<?> c = o.getClass();
        harness.check(c.isInstance(new NotActiveException("xyzzy")));
    }
}

