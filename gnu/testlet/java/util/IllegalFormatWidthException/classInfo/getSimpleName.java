/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatWidthException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatWidthException;

public class getSimpleName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatWidthException o = new IllegalFormatWidthException(42);
        Class<?> c = o.getClass();
        harness.check(c.getSimpleName(), (Object)"IllegalFormatWidthException");
    }
}

