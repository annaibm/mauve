/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalMonitorStateException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalMonitorStateException o = new IllegalMonitorStateException("java.lang.IllegalMonitorStateException");
        Class<?> c = o.getClass();
        harness.check(c.isInstance(new IllegalMonitorStateException("java.lang.IllegalMonitorStateException")));
    }
}

