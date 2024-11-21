/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.StreamCorruptedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.StreamCorruptedException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StreamCorruptedException object1 = new StreamCorruptedException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.StreamCorruptedException");
        StreamCorruptedException object2 = new StreamCorruptedException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.StreamCorruptedException: nothing happens");
        StreamCorruptedException object3 = new StreamCorruptedException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.io.StreamCorruptedException");
    }
}

