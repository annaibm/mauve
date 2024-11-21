/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.EmptyStackException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EmptyStackException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new EmptyStackException();
        }
        catch (EmptyStackException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

