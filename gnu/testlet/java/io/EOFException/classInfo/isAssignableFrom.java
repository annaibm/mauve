/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.EOFException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.EOFException;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EOFException o = new EOFException("xyzzy");
        Class<EOFException> c = o.getClass();
        harness.check(c.isAssignableFrom(EOFException.class));
    }
}

