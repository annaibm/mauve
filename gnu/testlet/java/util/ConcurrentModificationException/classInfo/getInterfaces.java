/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.ConcurrentModificationException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

public class getInterfaces
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ConcurrentModificationException o = new ConcurrentModificationException("ConcurrentModificationException");
        Class<?> c = o.getClass();
        List<Class<?>> interfaces = Arrays.asList(c.getInterfaces());
    }
}

