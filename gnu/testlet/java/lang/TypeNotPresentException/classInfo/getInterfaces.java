/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.TypeNotPresentException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.List;

public class getInterfaces
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TypeNotPresentException o = new TypeNotPresentException("TypeNotPresentException", new Throwable());
        Class<?> c = o.getClass();
        List<Class<?>> interfaces = Arrays.asList(c.getInterfaces());
    }
}

