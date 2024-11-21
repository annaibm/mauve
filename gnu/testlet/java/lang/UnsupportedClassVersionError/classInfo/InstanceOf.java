/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnsupportedClassVersionError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsupportedClassVersionError o = new UnsupportedClassVersionError("UnsupportedClassVersionError");
        harness.check(o instanceof UnsupportedClassVersionError);
        harness.check(o instanceof ClassFormatError);
        harness.check(o instanceof LinkageError);
        harness.check(o instanceof Error);
        harness.check(o instanceof Throwable);
        harness.check(o instanceof Object);
    }
}

