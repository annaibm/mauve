/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatterClosedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatterClosedException;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FormatterClosedException o = new FormatterClosedException();
        harness.check(o instanceof FormatterClosedException);
        harness.check(o instanceof IllegalStateException);
        harness.check(o instanceof RuntimeException);
        harness.check(o instanceof Exception);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

