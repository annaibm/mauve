/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.DuplicateFormatFlagsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.DuplicateFormatFlagsException;

public class getMessage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DuplicateFormatFlagsException object1 = new DuplicateFormatFlagsException("");
        harness.check(object1 != null);
        harness.check(object1.getMessage() != null);
        harness.check(object1.getMessage().contains("Flags = ''"));
        DuplicateFormatFlagsException object2 = new DuplicateFormatFlagsException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.getMessage() != null);
        harness.check(object2.getMessage().contains("nothing happens"));
        harness.check(object2.getMessage().contains("Flags = 'nothing happens'"));
    }
}

