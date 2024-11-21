/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatWidthException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatWidthException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatWidthException object1 = new IllegalFormatWidthException(42);
        harness.check(object1 != null);
        harness.check(object1.toString().contains("java.util.IllegalFormatWidthException"));
        harness.check(object1.toString().contains("42"));
    }
}

