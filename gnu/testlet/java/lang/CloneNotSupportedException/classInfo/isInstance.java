/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.CloneNotSupportedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CloneNotSupportedException o = new CloneNotSupportedException("java.lang.CloneNotSupportedException");
        Class<?> c = o.getClass();
        harness.check(c.isInstance(new CloneNotSupportedException("java.lang.CloneNotSupportedException")));
    }
}

