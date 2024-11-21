/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.Modifier;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Modifier;

public class toString12
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Modifier.toString(2048), (Object)"strictfp");
        harness.check(Modifier.toString(2064), (Object)"final strictfp");
        int allFlags = 4095;
        harness.check(Modifier.toString(allFlags), "public protected private abstract static final transient volatile synchronized native strictfp interface", "check order of all flags");
    }
}

