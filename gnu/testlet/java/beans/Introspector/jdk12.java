/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.Introspector;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class jdk12
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("USE_ALL_BEANINFO");
        harness.debug("USE_ALL_BEANINFO value: 1");
        harness.check(1, 1);
        harness.checkPoint("IGNORE_IMMEDIATE_BEANINFO");
        harness.debug("IGNORE_IMMEDIATE_BEANINFO value: 2");
        harness.check(2, 2);
        harness.checkPoint("IGNORE_ALL_BEANINFO");
        harness.debug("IGNORE_ALL_BEANINFO value: 3");
        harness.check(3, 3);
    }
}

