/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnsupportedClassVersionError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new UnsupportedClassVersionError("UnsupportedClassVersionError");
        }
        catch (UnsupportedClassVersionError e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

