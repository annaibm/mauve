/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.ConcurrentModificationException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ConcurrentModificationException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ConcurrentModificationException o = new ConcurrentModificationException("ConcurrentModificationException");
        harness.check(o instanceof ConcurrentModificationException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

