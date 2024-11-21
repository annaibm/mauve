/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchFieldError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchFieldError o = new NoSuchFieldError("NoSuchFieldError");
        harness.check(o instanceof NoSuchFieldError);
        harness.check(o instanceof IncompatibleClassChangeError);
        harness.check(o instanceof LinkageError);
        harness.check(o instanceof Error);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

