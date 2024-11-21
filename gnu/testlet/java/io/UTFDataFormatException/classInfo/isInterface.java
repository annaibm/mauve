/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.UTFDataFormatException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.UTFDataFormatException;

public class isInterface
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UTFDataFormatException o = new UTFDataFormatException("xyzzy");
        Class<?> c = o.getClass();
        harness.check(!c.isInterface());
    }
}

