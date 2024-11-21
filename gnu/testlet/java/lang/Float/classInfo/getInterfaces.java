/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.List;

public class getInterfaces
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Float o = new Float(42.0f);
        Class<?> c = o.getClass();
        List<Class<?>> interfaces = Arrays.asList(c.getInterfaces());
        harness.check(interfaces.contains(Comparable.class));
    }
}

