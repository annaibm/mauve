/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToolBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class buttonInsets
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("JMenu");
        JToolBar tb = new JToolBar();
        JButton button = new JButton("test");
        Insets insets = button.getInsets();
        h.check(insets.top, 5, "insets.top: " + insets.top);
        h.check(insets.bottom, 5, "insets.bottom: " + insets.bottom);
        h.check(insets.left, 17, "insets.left: " + insets.left);
        h.check(insets.right, 17, "insets.right: " + insets.right);
        Insets margin = button.getMargin();
        h.check(margin.top, 2, "insets.top: " + margin.top);
        h.check(margin.bottom, 2, "insets.bottom: " + margin.bottom);
        h.check(margin.left, 14, "insets.left: " + margin.left);
        h.check(margin.right, 14, "insets.right: " + margin.right);
        tb.add(button);
        insets = button.getInsets();
        h.check(insets.top, 6, "insets.top: " + insets.top);
        h.check(insets.bottom, 6, "insets.bottom: " + insets.bottom);
        h.check(insets.left, 6, "insets.left: " + insets.left);
        h.check(insets.right, 6, "insets.right: " + insets.right);
        margin = button.getMargin();
        h.check(margin.top, 2, "insets.top: " + margin.top);
        h.check(margin.bottom, 2, "insets.bottom: " + margin.bottom);
        h.check(margin.left, 14, "insets.left: " + margin.left);
        h.check(margin.right, 14, "insets.right: " + margin.right);
    }
}

