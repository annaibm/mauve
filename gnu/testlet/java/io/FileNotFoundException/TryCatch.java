/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileNotFoundException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileNotFoundException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new FileNotFoundException("FileNotFoundException");
        }
        catch (FileNotFoundException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

