/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassNotFoundException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getCause
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new ClassNotFoundException("ClassNotFoundException");
        }
        catch (ClassNotFoundException e) {
            harness.check(e.getCause(), null);
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

