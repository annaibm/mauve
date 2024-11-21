/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

public class setDisplayedMnemonicIndex
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();
    int mnemonicIndexWhenEventFired = -1;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
        if (e.getPropertyName().equals("displayedMnemonicIndex") && e.getSource() instanceof JLabel) {
            JLabel l = (JLabel)e.getSource();
            this.mnemonicIndexWhenEventFired = l.getDisplayedMnemonicIndex();
        }
    }

    @Override
    public void test(TestHarness harness) {
        JLabel label = new JLabel("ABCDEFG");
        harness.check(label.getDisplayedMnemonicIndex(), -1);
        label.addPropertyChangeListener(this);
        label.setDisplayedMnemonicIndex(3);
        harness.check(label.getDisplayedMnemonicIndex(), 3);
        harness.check(label.getDisplayedMnemonic(), 0);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), label);
        harness.check(e.getPropertyName(), (Object)"displayedMnemonicIndex");
        harness.check(e.getOldValue(), new Integer(-1));
        harness.check(e.getNewValue(), new Integer(3));
        harness.check(this.mnemonicIndexWhenEventFired, 3);
        this.events.clear();
        label.setDisplayedMnemonicIndex(3);
        harness.check(this.events.size(), 0);
        this.events.clear();
        label.setDisplayedMnemonicIndex(-1);
        harness.check(label.getDisplayedMnemonicIndex(), -1);
        harness.check(this.events.size(), 1);
        e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), label);
        harness.check(e.getOldValue(), new Integer(3));
        harness.check(e.getNewValue(), new Integer(-1));
        boolean pass = false;
        try {
            label.setDisplayedMnemonicIndex(-2);
        }
        catch (IllegalArgumentException ex) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            label.setDisplayedMnemonicIndex(label.getText().length());
        }
        catch (IllegalArgumentException ex) {
            pass = true;
        }
        harness.check(pass);
        label.setText(null);
        harness.check(label.getDisplayedMnemonicIndex(), -1);
        pass = false;
        try {
            label.setDisplayedMnemonicIndex(0);
        }
        catch (IllegalArgumentException ex) {
            pass = true;
        }
        harness.check(pass);
        label.setText("");
        harness.check(label.getDisplayedMnemonicIndex(), -1);
        pass = false;
        try {
            label.setDisplayedMnemonicIndex(0);
        }
        catch (IllegalArgumentException ex) {
            pass = true;
        }
        harness.check(pass);
    }
}

