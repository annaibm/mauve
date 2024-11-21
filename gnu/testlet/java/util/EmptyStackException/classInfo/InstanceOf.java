/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.EmptyStackException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EmptyStackException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EmptyStackException o = new EmptyStackException();
        harness.check(o instanceof EmptyStackException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

