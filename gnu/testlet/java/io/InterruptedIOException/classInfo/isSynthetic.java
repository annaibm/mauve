/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InterruptedIOException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InterruptedIOException;

public class isSynthetic
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InterruptedIOException o = new InterruptedIOException("xyzzy");
        Class<?> c = o.getClass();
        harness.check(!c.isSynthetic());
    }
}

