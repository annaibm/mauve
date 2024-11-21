/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String o = new String();
        harness.check(o instanceof String);
        harness.check(o instanceof Object);
    }
}

