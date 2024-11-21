/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringBuffer.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class getInterfaces
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringBuffer o = new StringBuffer("xyzzy");
        Class<?> c = o.getClass();
        List<Class<?>> interfaces = Arrays.asList(c.getInterfaces());
        harness.check(interfaces.contains(Serializable.class));
        harness.check(interfaces.contains(CharSequence.class));
    }
}

