/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI.MyBasicFileChooserUI;
import java.util.Locale;
import javax.swing.JFileChooser;

public class installStrings
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Locale.setDefault(Locale.UK);
        JFileChooser fc1 = new JFileChooser();
        MyBasicFileChooserUI ui = new MyBasicFileChooserUI(fc1);
        harness.check(ui.getCancelButtonText(), null);
        harness.check(ui.getCancelButtonToolTipText(), null);
        harness.check(ui.getCancelButtonMnemonic(), 0);
        harness.check(ui.getDirectoryOpenButtonText(), null);
        harness.check(ui.getDirectoryOpenButtonToolTipText(), null);
        harness.check(ui.getDirectoryOpenButtonMnemonic(), 0);
        harness.check(ui.getHelpButtonText(), null);
        harness.check(ui.getHelpButtonToolTipText(), null);
        harness.check(ui.getHelpButtonMnemonic(), 0);
        harness.check(ui.getOpenButtonText(), null);
        harness.check(ui.getOpenButtonToolTipText(), null);
        harness.check(ui.getOpenButtonMnemonic(), 0);
        harness.check(ui.getSaveButtonText(), null);
        harness.check(ui.getSaveButtonToolTipText(), null);
        harness.check(ui.getSaveButtonMnemonic(), 0);
        harness.check(ui.getUpdateButtonText(), null);
        harness.check(ui.getUpdateButtonToolTipText(), null);
        harness.check(ui.getUpdateButtonMnemonic(), 0);
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
        Locale.setDefault(Locale.FRANCE);
        JFileChooser fc2 = new JFileChooser();
        MyBasicFileChooserUI ui2 = new MyBasicFileChooserUI(fc2);
        ui2.installStrings(fc2);
        harness.check(ui2.getCancelButtonText(), (Object)"Cancel");
        harness.check(ui2.getCancelButtonToolTipText(), (Object)"Abort file chooser dialog");
        harness.check(ui2.getDirectoryOpenButtonText(), (Object)"Open");
        harness.check(ui2.getDirectoryOpenButtonToolTipText(), (Object)"Open selected directory");
        harness.check(ui2.getDirectoryOpenButtonMnemonic(), 79);
        harness.check(ui2.getHelpButtonText(), (Object)"Help");
        harness.check(ui2.getHelpButtonToolTipText(), (Object)"FileChooser help");
        harness.check(ui2.getHelpButtonMnemonic(), 72);
        harness.check(ui2.getOpenButtonText(), (Object)"Open");
        harness.check(ui2.getOpenButtonToolTipText(), (Object)"Open selected file");
        harness.check(ui2.getOpenButtonMnemonic(), 79);
        harness.check(ui2.getSaveButtonText(), (Object)"Save");
        harness.check(ui2.getSaveButtonToolTipText(), (Object)"Save selected file");
        harness.check(ui2.getSaveButtonMnemonic(), 83);
        harness.check(ui2.getUpdateButtonText(), (Object)"Update");
        harness.check(ui2.getUpdateButtonToolTipText(), (Object)"Update directory listing");
        harness.check(ui2.getUpdateButtonMnemonic(), 85);
    }
}

