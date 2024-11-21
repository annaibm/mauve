/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalAccessError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.List;

public class getInterfaces
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalAccessError o = new IllegalAccessError("IllegalAccessError");
        Class<?> c = o.getClass();
        List<Class<?>> interfaces = Arrays.asList(c.getInterfaces());
    }
}

