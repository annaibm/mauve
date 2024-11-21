/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Dimension;

public class getMaximumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Component c = new Component(){};
        Dimension max2 = c.getMaximumSize();
        harness.check(max2.width, Short.MAX_VALUE);
        harness.check(max2.height, Short.MAX_VALUE);
    }
}

