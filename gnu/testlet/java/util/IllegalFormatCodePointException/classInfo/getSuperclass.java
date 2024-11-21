/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatCodePointException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatCodePointException;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatCodePointException o = new IllegalFormatCodePointException(42);
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.util.IllegalFormatException");
    }
}

