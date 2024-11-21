/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToggleButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JToggleButton;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness h) {
        JToggleButton t1 = new JToggleButton();
        h.check(t1.getText(), "", "Button label should default to \"\"");
        t1 = new JToggleButton((String)null);
        h.check(t1.getText(), "", "Button label should default to \"\"");
    }
}

