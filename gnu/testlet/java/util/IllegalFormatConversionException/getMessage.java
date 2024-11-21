/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatConversionException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatConversionException;

public class getMessage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatConversionException object1 = new IllegalFormatConversionException('c', Integer.class);
        harness.check(object1 != null);
        harness.check(object1.getMessage() != null);
        harness.check(object1.getMessage().contains("Integer"));
        IllegalFormatConversionException object2 = new IllegalFormatConversionException(' ', Number.class);
        harness.check(object2 != null);
        harness.check(object2.getMessage() != null);
        harness.check(object2.getMessage().contains("Number"));
        IllegalFormatConversionException object3 = new IllegalFormatConversionException('@', Object.class);
        harness.check(object3 != null);
        harness.check(object3.getMessage() != null);
        harness.check(object3.getMessage().contains("Object"));
        harness.check(object3.getMessage().contains("@"));
        IllegalFormatConversionException object4 = new IllegalFormatConversionException('\u1234', Object.class);
        harness.check(object4 != null);
        harness.check(object4.getMessage() != null);
        harness.check(object4.getMessage().contains("Object"));
        harness.check(object4.getMessage().contains("\u1234"));
    }
}

