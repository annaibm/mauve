/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.UTFDataFormatException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.UTFDataFormatException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new UTFDataFormatException("UTFDataFormatException");
        }
        catch (UTFDataFormatException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

