/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class getChangeToParentDirectoryAction
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicFileChooserUI ui = new BasicFileChooserUI(new JFileChooser());
        Action a = ui.getChangeToParentDirectoryAction();
        harness.check(a.getValue("Name"), (Object)"Go Up");
        Action a2 = ui.getChangeToParentDirectoryAction();
        harness.check(a == a2);
    }
}

