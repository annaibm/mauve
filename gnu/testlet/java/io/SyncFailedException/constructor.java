/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.SyncFailedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.SyncFailedException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SyncFailedException object1 = new SyncFailedException("nothing happens");
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.SyncFailedException: nothing happens");
        SyncFailedException object3 = new SyncFailedException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.io.SyncFailedException");
    }
}

