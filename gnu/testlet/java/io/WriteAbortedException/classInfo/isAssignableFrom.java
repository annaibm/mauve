/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.WriteAbortedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.WriteAbortedException;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        WriteAbortedException o = new WriteAbortedException("xyzzy", new Exception("e"));
        Class<WriteAbortedException> c = o.getClass();
        harness.check(c.isAssignableFrom(WriteAbortedException.class));
    }
}

