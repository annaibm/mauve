/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.BoxLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTError;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BoxLayout layout2 = new BoxLayout(null, 0);
        harness.check(layout2 != null);
        boolean pass = false;
        try {
            layout2 = new BoxLayout(new JPanel(), 99);
        }
        catch (AWTError e) {
            pass = true;
        }
        harness.check(pass);
    }
}

