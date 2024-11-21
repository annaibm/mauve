/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatFlagsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatFlagsException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatFlagsException object1 = new IllegalFormatFlagsException("nothing happens");
        harness.check(object1 != null);
        harness.check(object1.toString().contains("java.util.IllegalFormatFlagsException"));
        harness.check(object1.toString().contains("nothing happens"));
    }
}

