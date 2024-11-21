/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.BoxLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTError;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class minimumLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JPanel container = new JPanel();
        BoxLayout layout2 = new BoxLayout(container, 0);
        harness.check(layout2.minimumLayoutSize(container), new Dimension(0, 0));
        container.setBorder(BorderFactory.createEmptyBorder(1, 2, 3, 4));
        harness.check(layout2.minimumLayoutSize(container), new Dimension(6, 4));
        boolean pass = false;
        try {
            layout2.minimumLayoutSize(new JPanel());
        }
        catch (AWTError e) {
            pass = true;
        }
        harness.check(pass);
    }
}

