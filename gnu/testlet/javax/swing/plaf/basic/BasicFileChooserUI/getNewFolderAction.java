/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class getNewFolderAction
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicFileChooserUI ui = new BasicFileChooserUI(new JFileChooser());
        Action a = ui.getNewFolderAction();
        harness.check(a.getValue("Name"), (Object)"New Folder");
        Action a2 = ui.getNewFolderAction();
        harness.check(a == a2);
    }
}

