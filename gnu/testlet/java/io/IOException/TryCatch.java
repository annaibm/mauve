/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.IOException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new IOException("IOException");
        }
        catch (IOException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

