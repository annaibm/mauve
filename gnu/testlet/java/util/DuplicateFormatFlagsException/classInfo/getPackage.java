/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.DuplicateFormatFlagsException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.DuplicateFormatFlagsException;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DuplicateFormatFlagsException o = new DuplicateFormatFlagsException("DuplicateFormatFlagsException");
        Class<?> c = o.getClass();
        Package p = c.getPackage();
        harness.check(p.getName(), (Object)"java.util");
    }
}

