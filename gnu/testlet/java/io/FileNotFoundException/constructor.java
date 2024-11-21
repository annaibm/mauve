/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileNotFoundException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileNotFoundException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FileNotFoundException object1 = new FileNotFoundException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.FileNotFoundException");
        FileNotFoundException object2 = new FileNotFoundException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.FileNotFoundException: nothing happens");
        FileNotFoundException object3 = new FileNotFoundException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.io.FileNotFoundException");
    }
}

