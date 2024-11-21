/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI.MyBasicFileChooserUI;
import java.util.Locale;
import javax.swing.JFileChooser;

public class uninstallStrings
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Locale.setDefault(Locale.UK);
        JFileChooser fc1 = new JFileChooser();
        MyBasicFileChooserUI ui = new MyBasicFileChooserUI(fc1);
        ui.installStrings(fc1);
        harness.check(ui.getCancelButtonText(), (Object)"Cancel");
        harness.check(ui.getCancelButtonToolTipText(), (Object)"Abort file chooser dialog");
        harness.check(ui.getCancelButtonMnemonic(), 67);
        harness.check(ui.getDirectoryOpenButtonText(), (Object)"Open");
        harness.check(ui.getDirectoryOpenButtonToolTipText(), (Object)"Open selected directory");
        harness.check(ui.getDirectoryOpenButtonMnemonic(), 79);
        harness.check(ui.getHelpButtonText(), (Object)"Help");
        harness.check(ui.getHelpButtonToolTipText(), (Object)"FileChooser help");
        harness.check(ui.getHelpButtonMnemonic(), 72);
        harness.check(ui.getOpenButtonText(), (Object)"Open");
        harness.check(ui.getOpenButtonToolTipText(), (Object)"Open selected file");
        harness.check(ui.getOpenButtonMnemonic(), 79);
        harness.check(ui.getSaveButtonText(), (Object)"Save");
        harness.check(ui.getSaveButtonToolTipText(), (Object)"Save selected file");
        harness.check(ui.getSaveButtonMnemonic(), 83);
        harness.check(ui.getUpdateButtonText(), (Object)"Update");
        harness.check(ui.getUpdateButtonToolTipText(), (Object)"Update directory listing");
        harness.check(ui.getUpdateButtonMnemonic(), 85);
        ui.uninstallStrings(fc1);
        harness.check(ui.getCancelButtonText(), null);
        harness.check(ui.getCancelButtonToolTipText(), null);
        harness.check(ui.getCancelButtonMnemonic(), 67);
        harness.check(ui.getDirectoryOpenButtonText(), null);
        harness.check(ui.getDirectoryOpenButtonToolTipText(), null);
        harness.check(ui.getDirectoryOpenButtonMnemonic(), 79);
        harness.check(ui.getHelpButtonText(), null);
        harness.check(ui.getHelpButtonToolTipText(), null);
        harness.check(ui.getHelpButtonMnemonic(), 72);
        harness.check(ui.getOpenButtonText(), null);
        harness.check(ui.getOpenButtonToolTipText(), null);
        harness.check(ui.getOpenButtonMnemonic(), 79);
        harness.check(ui.getSaveButtonText(), null);
        harness.check(ui.getSaveButtonToolTipText(), null);
        harness.check(ui.getSaveButtonMnemonic(), 83);
        harness.check(ui.getUpdateButtonText(), null);
        harness.check(ui.getUpdateButtonToolTipText(), null);
        harness.check(ui.getUpdateButtonMnemonic(), 85);
    }
}

