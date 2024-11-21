/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringBuilder.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringBuilder o = new StringBuilder("xyzzy");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName(), (Object)"java.lang.AbstractStringBuilder");
    }
}

