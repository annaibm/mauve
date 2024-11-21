/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.DuplicateFormatFlagsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.DuplicateFormatFlagsException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DuplicateFormatFlagsException object1 = new DuplicateFormatFlagsException("nothing happens");
        harness.check(object1 != null);
        harness.check(object1.toString().contains("java.util.DuplicateFormatFlagsException"));
        harness.check(object1.toString().contains("nothing happens"));
    }
}

