/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class getUpdateAction
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicFileChooserUI ui = new BasicFileChooserUI(new JFileChooser());
        Action a = ui.getUpdateAction();
        harness.check(a.getValue("Name"), null);
        Action a2 = ui.getUpdateAction();
        harness.check(a == a2);
    }
}

