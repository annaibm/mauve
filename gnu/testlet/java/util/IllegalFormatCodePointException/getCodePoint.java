/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatCodePointException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatCodePointException;

public class getCodePoint
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatCodePointException object1 = new IllegalFormatCodePointException(0);
        harness.check(object1 != null);
        harness.check(object1.getCodePoint() == 0);
        IllegalFormatCodePointException object2 = new IllegalFormatCodePointException(42);
        harness.check(object2 != null);
        harness.check(object2.getCodePoint() == 42);
        IllegalFormatCodePointException object3 = new IllegalFormatCodePointException(Integer.MAX_VALUE);
        harness.check(object3 != null);
        harness.check(object3.getCodePoint() == Integer.MAX_VALUE);
        IllegalFormatCodePointException object4 = new IllegalFormatCodePointException(Integer.MIN_VALUE);
        harness.check(object4 != null);
        harness.check(object4.getCodePoint() == Integer.MIN_VALUE);
    }
}

