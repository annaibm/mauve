/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.CharConversionException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharConversionException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CharConversionException object1 = new CharConversionException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.CharConversionException");
        CharConversionException object2 = new CharConversionException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.CharConversionException: nothing happens");
        CharConversionException object3 = new CharConversionException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.io.CharConversionException");
    }
}

