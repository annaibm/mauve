/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatConversionException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatConversionException;

public class getConversion
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatConversionException object1 = new IllegalFormatConversionException('c', Integer.class);
        harness.check(object1 != null);
        harness.check(object1.getConversion() == 'c');
        IllegalFormatConversionException object2 = new IllegalFormatConversionException(' ', Number.class);
        harness.check(object2 != null);
        harness.check(object2.getConversion() == ' ');
        IllegalFormatConversionException object3 = new IllegalFormatConversionException('@', Object.class);
        harness.check(object3 != null);
        harness.check(object3.getConversion() == '@');
        IllegalFormatConversionException object4 = new IllegalFormatConversionException('\u1234', Object.class);
        harness.check(object4 != null);
        harness.check(object4.getConversion() == '\u1234');
    }
}

