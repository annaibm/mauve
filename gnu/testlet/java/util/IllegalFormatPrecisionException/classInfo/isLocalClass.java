/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatPrecisionException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatPrecisionException;

public class isLocalClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatPrecisionException o = new IllegalFormatPrecisionException(42);
        Class<?> c = o.getClass();
        harness.check(!c.isLocalClass());
    }
}

