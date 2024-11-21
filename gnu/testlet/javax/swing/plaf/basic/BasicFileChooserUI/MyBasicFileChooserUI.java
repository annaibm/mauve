/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class MyBasicFileChooserUI
extends BasicFileChooserUI {
    public MyBasicFileChooserUI(JFileChooser fc) {
        super(fc);
    }

    @Override
    public JButton getApproveButton(JFileChooser fc) {
        return super.getApproveButton(fc);
    }

    public int getCancelButtonMnemonic() {
        return this.cancelButtonMnemonic;
    }

    public String getCancelButtonText() {
        return this.cancelButtonText;
    }

    public String getCancelButtonToolTipText() {
        return this.cancelButtonToolTipText;
    }

    public int getDirectoryOpenButtonMnemonic() {
        return this.directoryOpenButtonMnemonic;
    }

    public String getDirectoryOpenButtonText() {
        return this.directoryOpenButtonText;
    }

    public String getDirectoryOpenButtonToolTipText() {
        return this.directoryOpenButtonToolTipText;
    }

    public int getHelpButtonMnemonic() {
        return this.helpButtonMnemonic;
    }

    public String getHelpButtonText() {
        return this.helpButtonText;
    }

    public String getHelpButtonToolTipText() {
        return this.helpButtonToolTipText;
    }

    public int getOpenButtonMnemonic() {
        return this.openButtonMnemonic;
    }

    public String getOpenButtonText() {
        return this.openButtonText;
    }

    public String getOpenButtonToolTipText() {
        return this.openButtonToolTipText;
    }

    public int getSaveButtonMnemonic() {
        return this.saveButtonMnemonic;
    }

    public String getSaveButtonText() {
        return this.saveButtonText;
    }

    public String getSaveButtonToolTipText() {
        return this.saveButtonToolTipText;
    }

    public int getUpdateButtonMnemonic() {
        return this.updateButtonMnemonic;
    }

    public String getUpdateButtonText() {
        return this.updateButtonText;
    }

    public String getUpdateButtonToolTipText() {
        return this.updateButtonToolTipText;
    }

    @Override
    public void installStrings(JFileChooser fc) {
        super.installStrings(fc);
    }

    @Override
    public void uninstallStrings(JFileChooser fc) {
        super.uninstallStrings(fc);
    }

    @Override
    public void installIcons(JFileChooser fc) {
        super.installIcons(fc);
    }

    @Override
    public void uninstallIcons(JFileChooser fc) {
        super.uninstallIcons(fc);
    }

    public Icon getComputerIcon() {
        return this.computerIcon;
    }

    public Icon getDetailsViewIcon() {
        return this.detailsViewIcon;
    }

    public Icon getDirectoryIcon() {
        return this.directoryIcon;
    }

    public Icon getFileIcon() {
        return this.fileIcon;
    }

    public Icon getFloppyDriveIcon() {
        return this.floppyDriveIcon;
    }

    public Icon getHardDriveIcon() {
        return this.hardDriveIcon;
    }

    public Icon getHomeFolderIcon() {
        return this.homeFolderIcon;
    }

    public Icon getListViewIcon() {
        return this.listViewIcon;
    }

    public Icon getNewFolderIcon() {
        return this.newFolderIcon;
    }

    public Icon getUpFolderIcon() {
        return this.upFolderIcon;
    }
}

