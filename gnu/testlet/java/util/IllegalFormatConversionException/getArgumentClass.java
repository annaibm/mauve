/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatConversionException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatConversionException;

public class getArgumentClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatConversionException object1 = new IllegalFormatConversionException('c', Integer.class);
        harness.check(object1 != null);
        harness.check(object1.getArgumentClass() != null);
        harness.check(object1.getArgumentClass() == Integer.class);
        IllegalFormatConversionException object2 = new IllegalFormatConversionException(' ', Number.class);
        harness.check(object2 != null);
        harness.check(object2.getArgumentClass() != null);
        harness.check(object2.getArgumentClass() == Number.class);
        IllegalFormatConversionException object3 = new IllegalFormatConversionException('@', Object.class);
        harness.check(object3 != null);
        harness.check(object3.getArgumentClass() != null);
        harness.check(object3.getArgumentClass() == Object.class);
        IllegalFormatConversionException object4 = new IllegalFormatConversionException('\u1234', "xyzzy".getClass());
        harness.check(object4 != null);
        harness.check(object4.getArgumentClass() != null);
        harness.check(object4.getArgumentClass() == String.class);
    }
}

