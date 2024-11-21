/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSimpleName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<Math> c = Math.class;
        harness.check(c.getSimpleName(), (Object)"Math");
    }
}

