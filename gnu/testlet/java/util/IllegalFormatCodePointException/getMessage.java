/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatCodePointException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatCodePointException;

public class getMessage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatCodePointException object1 = new IllegalFormatCodePointException(0);
        harness.check(object1 != null);
        harness.check(object1.getMessage() != null);
        harness.check(object1.getMessage().contains("Code point = "));
        harness.check(object1.getMessage().contains("0x0"));
        IllegalFormatCodePointException object2 = new IllegalFormatCodePointException(42);
        harness.check(object2 != null);
        harness.check(object2.getMessage() != null);
        harness.check(object2.getMessage().contains("Code point = "));
        harness.check(object2.getMessage().contains("0x2a"));
        IllegalFormatCodePointException object3 = new IllegalFormatCodePointException(Integer.MAX_VALUE);
        harness.check(object3 != null);
        harness.check(object3.getMessage() != null);
        harness.check(object3.getMessage().contains("Code point = "));
        harness.check(object3.getMessage().contains("0x7fffffff"));
        IllegalFormatCodePointException object4 = new IllegalFormatCodePointException(Integer.MIN_VALUE);
        harness.check(object4 != null);
        harness.check(object4.getMessage() != null);
        harness.check(object4.getMessage().contains("Code point = "));
        harness.check(object4.getMessage().contains("0x80000000"));
    }
}

