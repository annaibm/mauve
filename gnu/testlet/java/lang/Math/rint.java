/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class rint
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new Double(Math.rint(-3.5)).toString(), (Object)"-4.0");
        harness.check(new Double(Math.rint(4.5)).toString(), (Object)"4.0");
    }
}

