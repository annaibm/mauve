/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatConversionException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatConversionException;

public class TryCatchNPE
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            IllegalFormatConversionException illegalFormatConversionException = new IllegalFormatConversionException('c', null);
        }
        catch (NullPointerException npe) {
            caught = true;
        }
        harness.check(caught);
    }
}

