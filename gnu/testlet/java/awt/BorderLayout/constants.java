/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constants
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check("Last".equals("Last"));
        harness.check("After".equals("After"));
        harness.check("First".equals("First"));
        harness.check("Before".equals("Before"));
        harness.check("Center".equals("Center"));
        harness.check("East".equals("East"));
        harness.check("After".equals("After"));
        harness.check("Before".equals("Before"));
        harness.check("North".equals("North"));
        harness.check("Last".equals("Last"));
        harness.check("First".equals("First"));
        harness.check("South".equals("South"));
        harness.check("West".equals("West"));
    }
}

