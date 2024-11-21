/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String object1 = new String();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"");
        String object2 = new String("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"nothing happens");
        String object3 = new String(new char[]{'x', 'y', 'z', 'z', 'y'});
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"xyzzy");
    }
}

