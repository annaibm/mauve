/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InvalidObjectException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InvalidObjectException;

public class isInterface
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InvalidObjectException o = new InvalidObjectException("xyzzy");
        Class<?> c = o.getClass();
        harness.check(!c.isInterface());
    }
}

