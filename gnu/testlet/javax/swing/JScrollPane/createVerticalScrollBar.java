/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JScrollPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class createVerticalScrollBar
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JScrollPane pane = new JScrollPane();
        JScrollBar scrollBar = pane.createVerticalScrollBar();
        harness.check(scrollBar.getClass().getName().endsWith("ScrollBar"));
        harness.check(scrollBar.getOrientation(), 1);
        harness.check(scrollBar.getClientProperty("JScrollBar.isFreeStanding"), null);
    }
}

