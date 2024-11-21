/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.RuntimeException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.List;

public class getInterfaces
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RuntimeException o = new RuntimeException("java.lang.RuntimeException");
        Class<?> c = o.getClass();
        List<Class<?>> interfaces = Arrays.asList(c.getInterfaces());
    }
}

