/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.NotSerializableException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.NotSerializableException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NotSerializableException object1 = new NotSerializableException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.NotSerializableException");
        NotSerializableException object2 = new NotSerializableException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.NotSerializableException: nothing happens");
        NotSerializableException object3 = new NotSerializableException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.io.NotSerializableException");
    }
}

