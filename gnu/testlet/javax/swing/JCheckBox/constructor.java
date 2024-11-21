/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JCheckBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JCheckBox;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JCheckBox cb = new JCheckBox();
        harness.check((double)cb.getAlignmentX(), 0.0, "alignmentX");
        harness.check((double)cb.getAlignmentY(), 0.5, "alignmentY");
        harness.check(cb.getHorizontalAlignment(), 10, "horizontalAlignment");
        harness.check(cb.getVerticalAlignment(), 0, "verticalAlignment");
    }
}

