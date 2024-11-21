/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringBuffer.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringBuffer o = new StringBuffer("xyzzy");
        harness.check(o instanceof StringBuffer);
        harness.check(o instanceof Object);
    }
}

