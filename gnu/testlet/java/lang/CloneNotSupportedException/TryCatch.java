/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.CloneNotSupportedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new CloneNotSupportedException("CloneNotSupportedException");
        }
        catch (CloneNotSupportedException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

