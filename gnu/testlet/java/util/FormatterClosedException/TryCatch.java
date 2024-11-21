/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatterClosedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatterClosedException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new FormatterClosedException();
        }
        catch (FormatterClosedException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

