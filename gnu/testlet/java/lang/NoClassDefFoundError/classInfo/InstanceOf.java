/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoClassDefFoundError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoClassDefFoundError o = new NoClassDefFoundError("NoClassDefFoundError");
        harness.check(o instanceof NoClassDefFoundError);
        harness.check(o instanceof LinkageError);
        harness.check(o instanceof Error);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

