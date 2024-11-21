/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.WriteAbortedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.WriteAbortedException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        WriteAbortedException object1 = new WriteAbortedException(null, null);
        harness.check(object1 != null);
        harness.check(object1.toString().contains("java.io.WriteAbortedException"));
        WriteAbortedException object2 = new WriteAbortedException("nothing happens", null);
        harness.check(object2 != null);
        harness.check(object2.toString().contains("java.io.WriteAbortedException: nothing happens"));
        WriteAbortedException object3 = new WriteAbortedException(null, new Exception("e"));
        harness.check(object3 != null);
        harness.check(object3.toString().contains("java.io.WriteAbortedException"));
        harness.check(object3.toString().contains("Exception"));
        WriteAbortedException object4 = new WriteAbortedException("nothing happens", new Exception("e"));
        harness.check(object4 != null);
        harness.check(object4.toString().contains("java.io.WriteAbortedException"));
        harness.check(object4.toString().contains("Exception"));
        harness.check(object4.toString().contains("nothing happens"));
    }
}

