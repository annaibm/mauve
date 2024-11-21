/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.EmptyStackException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EmptyStackException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EmptyStackException object1 = new EmptyStackException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.util.EmptyStackException");
    }
}

