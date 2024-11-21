/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

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
        BasicInternalFrameTitlePane.CloseAction a = new BasicInternalFrameTitlePane.CloseAction(p);
        harness.check(a.getValue("Name"), (Object)"Close");
    }
}

