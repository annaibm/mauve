/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatWidthException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.IllegalFormatWidthException;
import java.util.List;

public class getInterfaces
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatWidthException o = new IllegalFormatWidthException(42);
        Class<?> c = o.getClass();
        List<Class<?>> interfaces = Arrays.asList(c.getInterfaces());
    }
}

