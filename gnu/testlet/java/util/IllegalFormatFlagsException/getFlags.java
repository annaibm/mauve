/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatFlagsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatFlagsException;

public class getFlags
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatFlagsException object1 = new IllegalFormatFlagsException("");
        harness.check(object1 != null);
        harness.check(object1.getFlags() != null);
        harness.check(object1.getFlags().isEmpty());
        IllegalFormatFlagsException object2 = new IllegalFormatFlagsException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.getFlags() != null);
        harness.check(object2.getFlags().contains("nothing happens"));
    }
}

