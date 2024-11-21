/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI.MyBasicFileChooserUI;
import javax.swing.JFileChooser;
import javax.swing.plaf.metal.MetalIconFactory;

public class installIcons
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        MyBasicFileChooserUI ui = new MyBasicFileChooserUI(fc);
        harness.check(ui.getComputerIcon(), null);
        harness.check(ui.getDetailsViewIcon(), null);
        harness.check(ui.getDirectoryIcon(), null);
        harness.check(ui.getFileIcon(), null);
        harness.check(ui.getFloppyDriveIcon(), null);
        harness.check(ui.getHardDriveIcon(), null);
        harness.check(ui.getHomeFolderIcon(), null);
        harness.check(ui.getListViewIcon(), null);
        harness.check(ui.getNewFolderIcon(), null);
        harness.check(ui.getUpFolderIcon(), null);
        ui.installIcons(fc);
        harness.check(ui.getComputerIcon(), MetalIconFactory.getTreeComputerIcon());
        harness.check(ui.getDetailsViewIcon(), MetalIconFactory.getFileChooserDetailViewIcon());
        harness.check(ui.getDirectoryIcon() instanceof MetalIconFactory.TreeFolderIcon);
        harness.check(ui.getDirectoryIcon().getIconWidth(), 16);
        harness.check(ui.getDirectoryIcon().getIconHeight(), 18);
        harness.check(ui.getFileIcon() instanceof MetalIconFactory.TreeLeafIcon);
        harness.check(ui.getFileIcon().getIconWidth(), 16);
        harness.check(ui.getFileIcon().getIconHeight(), 20);
        harness.check(ui.getFloppyDriveIcon(), MetalIconFactory.getTreeFloppyDriveIcon());
        harness.check(ui.getHardDriveIcon(), MetalIconFactory.getTreeHardDriveIcon());
        harness.check(ui.getHomeFolderIcon(), MetalIconFactory.getFileChooserHomeFolderIcon());
        harness.check(ui.getListViewIcon(), MetalIconFactory.getFileChooserListViewIcon());
        harness.check(ui.getNewFolderIcon(), MetalIconFactory.getFileChooserNewFolderIcon());
        harness.check(ui.getUpFolderIcon(), MetalIconFactory.getFileChooserUpFolderIcon());
    }
}

