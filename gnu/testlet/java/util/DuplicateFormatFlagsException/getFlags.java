/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.DuplicateFormatFlagsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.DuplicateFormatFlagsException;

public class getFlags
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DuplicateFormatFlagsException object1 = new DuplicateFormatFlagsException("");
        harness.check(object1 != null);
        harness.check(object1.getFlags() != null);
        harness.check(object1.getFlags().isEmpty());
        DuplicateFormatFlagsException object2 = new DuplicateFormatFlagsException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.getFlags() != null);
        harness.check(object2.getFlags().contains("nothing happens"));
    }
}

