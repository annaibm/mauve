/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.NotSerializableException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.NotSerializableException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new NotSerializableException("NotSerializableException");
        }
        catch (NotSerializableException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

