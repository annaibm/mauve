/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.EOFException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.EOFException;
import java.util.Arrays;
import java.util.List;

public class getInterfaces
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EOFException o = new EOFException("xyzzy");
        Class<?> c = o.getClass();
        List<Class<?>> interfaces = Arrays.asList(c.getInterfaces());
    }
}

