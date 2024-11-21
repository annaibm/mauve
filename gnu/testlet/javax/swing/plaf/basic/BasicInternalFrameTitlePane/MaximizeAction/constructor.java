/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame();
        BasicInternalFrameTitlePane p = new BasicInternalFrameTitlePane(f);
        BasicInternalFrameTitlePane.MaximizeAction a = new BasicInternalFrameTitlePane.MaximizeAction(p);
        harness.check(a.getValue("Name"), (Object)"Maximize");
    }
}

