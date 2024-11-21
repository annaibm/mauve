/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassCircularityError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ClassCircularityError object1 = new ClassCircularityError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.ClassCircularityError");
        ClassCircularityError object2 = new ClassCircularityError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.ClassCircularityError: nothing happens");
        ClassCircularityError object3 = new ClassCircularityError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.ClassCircularityError");
    }
}

