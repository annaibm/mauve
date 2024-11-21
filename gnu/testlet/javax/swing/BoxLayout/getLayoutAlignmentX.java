/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.BoxLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTError;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class getLayoutAlignmentX
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JPanel container = new JPanel();
        BoxLayout layout2 = new BoxLayout(container, 0);
        boolean pass = false;
        try {
            layout2.getLayoutAlignmentX(new JPanel());
        }
        catch (AWTError e) {
            pass = true;
        }
        harness.check(pass);
    }
}

