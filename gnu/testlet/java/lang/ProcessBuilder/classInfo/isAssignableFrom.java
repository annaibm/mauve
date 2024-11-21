/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ProcessBuilder.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ProcessBuilder o = new ProcessBuilder("");
        Class<ProcessBuilder> c = o.getClass();
        harness.check(c.isAssignableFrom(ProcessBuilder.class));
    }
}

