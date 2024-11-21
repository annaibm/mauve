/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatConversionException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatConversionException;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatConversionException o = new IllegalFormatConversionException('a', Character.class);
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.util.IllegalFormatException");
    }
}

