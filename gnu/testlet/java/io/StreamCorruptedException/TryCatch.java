/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.StreamCorruptedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.StreamCorruptedException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new StreamCorruptedException("StreamCorruptedException");
        }
        catch (StreamCorruptedException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

