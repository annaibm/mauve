/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.EmptyStackException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EmptyStackException;

public class isPrimitive
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EmptyStackException o = new EmptyStackException();
        Class<?> c = o.getClass();
        harness.check(!c.isPrimitive());
    }
}

