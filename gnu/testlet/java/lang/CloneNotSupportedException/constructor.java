/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.CloneNotSupportedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CloneNotSupportedException object1 = new CloneNotSupportedException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.CloneNotSupportedException");
        CloneNotSupportedException object2 = new CloneNotSupportedException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.CloneNotSupportedException: nothing happens");
        CloneNotSupportedException object3 = new CloneNotSupportedException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.CloneNotSupportedException");
    }
}

