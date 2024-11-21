/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class getApproveSelectionAction
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicFileChooserUI ui = new BasicFileChooserUI(new JFileChooser());
        Action a = ui.getApproveSelectionAction();
        harness.check(a.getValue("Name"), (Object)"approveSelection");
        Action a2 = ui.getApproveSelectionAction();
        harness.check(a == a2);
    }
}

