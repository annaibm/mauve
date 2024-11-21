/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalMonitorStateException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;

public class getEnclosingConstructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalMonitorStateException o = new IllegalMonitorStateException("java.lang.IllegalMonitorStateException");
        Class<?> c = o.getClass();
        Constructor<?> cons = c.getEnclosingConstructor();
        harness.check(cons == null);
    }
}

