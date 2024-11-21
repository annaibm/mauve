/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatFlagsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatFlagsException;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatFlagsException o = new IllegalFormatFlagsException("IllegalFormatFlagsException");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.util.IllegalFormatException");
    }
}

