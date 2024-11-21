/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Exception;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Exception object1 = new Exception();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.Exception");
        Exception object2 = new Exception("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.Exception: nothing happens");
        Exception object3 = new Exception((String)null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.Exception");
        Exception object4 = new Exception(new Throwable());
        harness.check(object4 != null);
        harness.check(object4.toString(), (Object)"java.lang.Exception: java.lang.Throwable");
        Exception object5 = new Exception((Throwable)null);
        harness.check(object5 != null);
        harness.check(object5.toString(), (Object)"java.lang.Exception");
    }
}

