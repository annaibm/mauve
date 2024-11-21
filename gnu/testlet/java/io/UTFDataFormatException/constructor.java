/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.UTFDataFormatException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.UTFDataFormatException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UTFDataFormatException object1 = new UTFDataFormatException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.UTFDataFormatException");
        UTFDataFormatException object2 = new UTFDataFormatException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.UTFDataFormatException: nothing happens");
        UTFDataFormatException object3 = new UTFDataFormatException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.io.UTFDataFormatException");
    }
}

