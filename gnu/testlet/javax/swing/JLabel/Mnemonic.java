/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JLabel;

public class Mnemonic
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JLabel l = new JLabel("lskdjnvmdsklzedfsdmnWK");
        harness.check(l.getDisplayedMnemonic(), 0);
        harness.check(l.getDisplayedMnemonicIndex(), -1);
        l.setDisplayedMnemonic(75);
        harness.check(l.getDisplayedMnemonic(), 75);
        harness.check(l.getDisplayedMnemonicIndex(), 2);
        l.setDisplayedMnemonic(81);
        harness.check(l.getDisplayedMnemonicIndex(), -1);
        l.setDisplayedMnemonic(87);
        harness.check(l.getDisplayedMnemonicIndex(), 20);
        l.setText("new text");
        harness.check(l.getDisplayedMnemonicIndex(), 2);
        l.setDisplayedMnemonicIndex(5);
        harness.check(l.getDisplayedMnemonic(), 87);
        harness.check(l.getDisplayedMnemonicIndex(), 5);
        l = new JLabel("new text");
        l.setDisplayedMnemonicIndex(5);
        harness.check(l.getDisplayedMnemonic(), 0);
        harness.check(l.getDisplayedMnemonicIndex(), 5);
    }
}

