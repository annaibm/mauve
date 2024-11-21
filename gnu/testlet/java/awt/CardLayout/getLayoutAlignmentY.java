/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.CardLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.CardLayout;
import javax.swing.JComponent;

public class getLayoutAlignmentY
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComponent component2 = new JComponent(){};
        CardLayout cardLayout = new CardLayout();
        harness.check(cardLayout.getLayoutAlignmentY(component2), 0.5);
        component2.setAlignmentY(0.0f);
        harness.check(cardLayout.getLayoutAlignmentY(component2), 0.5);
        component2.setAlignmentY(1.0f);
        harness.check(cardLayout.getLayoutAlignmentY(component2), 0.5);
    }
}

