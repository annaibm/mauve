/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.LinkageError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        LinkageError object1 = new LinkageError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.LinkageError");
        LinkageError object2 = new LinkageError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.LinkageError: nothing happens");
        LinkageError object3 = new LinkageError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.LinkageError");
    }
}

