/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.EmptyStackException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EmptyStackException;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EmptyStackException o = new EmptyStackException();
        Class<EmptyStackException> c = o.getClass();
        harness.check(c.isAssignableFrom(EmptyStackException.class));
    }
}

