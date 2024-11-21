/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatConversionException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatConversionException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new IllegalFormatConversionException('c', Integer.class);
        }
        catch (IllegalFormatConversionException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

