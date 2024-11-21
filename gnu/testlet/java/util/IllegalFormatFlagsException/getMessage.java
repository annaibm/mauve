/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatFlagsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatFlagsException;

public class getMessage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatFlagsException object1 = new IllegalFormatFlagsException("");
        harness.check(object1 != null);
        harness.check(object1.getMessage() != null);
        harness.check(object1.getMessage().contains("Flags ="));
        IllegalFormatFlagsException object2 = new IllegalFormatFlagsException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.getMessage() != null);
        harness.check(object2.getMessage().contains("nothing happens"));
        harness.check(object2.getMessage().contains("Flags ="));
    }
}

