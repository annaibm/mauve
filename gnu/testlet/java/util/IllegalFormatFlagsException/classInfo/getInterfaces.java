/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatFlagsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.IllegalFormatFlagsException;
import java.util.List;

public class getInterfaces
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatFlagsException o = new IllegalFormatFlagsException("IllegalFormatFlagsException");
        Class<?> c = o.getClass();
        List<Class<?>> interfaces = Arrays.asList(c.getInterfaces());
    }
}

