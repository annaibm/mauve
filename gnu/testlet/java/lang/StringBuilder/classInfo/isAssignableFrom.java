/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringBuilder.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringBuilder o = new StringBuilder("xyzzy");
        Class<StringBuilder> c = o.getClass();
        harness.check(c.isAssignableFrom(StringBuilder.class));
    }
}

