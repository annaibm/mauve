/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;

public class getControlButtonsAreShown
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.getControlButtonsAreShown(), true);
        jfc.setControlButtonsAreShown(false);
        harness.check(jfc.getControlButtonsAreShown(), false);
        jfc.setControlButtonsAreShown(true);
        harness.check(jfc.getControlButtonsAreShown(), true);
    }
}

