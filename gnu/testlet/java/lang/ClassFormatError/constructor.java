/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassFormatError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ClassFormatError object1 = new ClassFormatError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.ClassFormatError");
        ClassFormatError object2 = new ClassFormatError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.ClassFormatError: nothing happens");
        ClassFormatError object3 = new ClassFormatError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.ClassFormatError");
    }
}

