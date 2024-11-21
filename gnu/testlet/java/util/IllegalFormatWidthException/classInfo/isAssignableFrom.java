/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatWidthException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatWidthException;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatWidthException o = new IllegalFormatWidthException(42);
        Class<IllegalFormatWidthException> c = o.getClass();
        harness.check(c.isAssignableFrom(IllegalFormatWidthException.class));
    }
}

