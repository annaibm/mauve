/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.IOException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IOException object1 = new IOException("nothing happens");
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.IOException: nothing happens");
        IOException object2 = new IOException((String)null);
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.IOException");
    }
}

