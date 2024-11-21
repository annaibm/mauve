/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatCodePointException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatCodePointException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatCodePointException object1 = new IllegalFormatCodePointException(42);
        harness.check(object1 != null);
        harness.check(object1.toString().contains("java.util.IllegalFormatCodePointException"));
        harness.check(object1.toString().contains(Integer.toHexString(42)));
    }
}

