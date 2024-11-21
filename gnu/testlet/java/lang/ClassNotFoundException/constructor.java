/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassNotFoundException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ClassNotFoundException object1 = new ClassNotFoundException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.ClassNotFoundException");
        ClassNotFoundException object2 = new ClassNotFoundException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.ClassNotFoundException: nothing happens");
        ClassNotFoundException object3 = new ClassNotFoundException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.ClassNotFoundException");
        ClassNotFoundException object4 = new ClassNotFoundException("nothing", new Throwable());
        harness.check(object4 != null);
        harness.check(object4.toString(), (Object)"java.lang.ClassNotFoundException: nothing");
    }
}

