/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.CharConversionException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharConversionException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new CharConversionException("CharConversionException");
        }
        catch (CharConversionException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

