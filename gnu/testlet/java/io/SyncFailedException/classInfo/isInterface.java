/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.SyncFailedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.SyncFailedException;

public class isInterface
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SyncFailedException o = new SyncFailedException("xyzzy");
        Class<?> c = o.getClass();
        harness.check(!c.isInterface());
    }
}

