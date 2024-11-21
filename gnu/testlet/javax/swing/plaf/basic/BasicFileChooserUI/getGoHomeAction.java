/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class getGoHomeAction
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicFileChooserUI ui = new BasicFileChooserUI(new JFileChooser());
        AbstractAction a = (AbstractAction)ui.getGoHomeAction();
        harness.check(a.getValue("Name"), (Object)"Go Home");
        Object[] keys2 = a.getKeys();
        harness.check(keys2.length, 1);
        Action a2 = ui.getGoHomeAction();
        harness.check(a == a2);
    }
}

