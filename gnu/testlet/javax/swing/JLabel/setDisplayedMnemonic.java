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
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class setDisplayedMnemonic
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();
    int displayedMnemonicWhenEventFired;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
        if (e.getPropertyName().equals("displayedMnemonic") && e.getSource() instanceof JLabel) {
            JLabel label = (JLabel)e.getSource();
            this.displayedMnemonicWhenEventFired = label.getDisplayedMnemonic();
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
        this.testKeyMap(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(char)");
        JLabel label = new JLabel("Abc Def");
        label.addPropertyChangeListener(this);
        label.setDisplayedMnemonic('d');
        harness.check(label.getDisplayedMnemonic(), 68);
        harness.check(label.getDisplayedMnemonicIndex(), 4);
        harness.check(this.events.size(), 2);
        harness.check(this.displayedMnemonicWhenEventFired, 68);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"displayedMnemonic");
        harness.check(e0.getOldValue(), new Integer(0));
        harness.check(e0.getNewValue(), new Integer(68));
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e1.getSource(), label);
        harness.check(e1.getPropertyName(), (Object)"displayedMnemonicIndex");
        harness.check(e1.getOldValue(), new Integer(-1));
        harness.check(e1.getNewValue(), new Integer(4));
        this.events.clear();
        label.setDisplayedMnemonic('z');
        harness.check(label.getDisplayedMnemonic(), 90);
        harness.check(label.getDisplayedMnemonicIndex(), -1);
        harness.check(this.events.size(), 2);
        e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"displayedMnemonic");
        harness.check(e0.getOldValue(), new Integer(68));
        harness.check(e0.getNewValue(), new Integer(90));
        e1 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e1.getSource(), label);
        harness.check(e1.getPropertyName(), (Object)"displayedMnemonicIndex");
        harness.check(e1.getOldValue(), new Integer(4));
        harness.check(e1.getNewValue(), new Integer(-1));
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        this.events.clear();
        JLabel label = new JLabel("Abc Def");
        label.addPropertyChangeListener(this);
        label.setDisplayedMnemonic(68);
        harness.check(label.getDisplayedMnemonic(), 68);
        harness.check(label.getDisplayedMnemonicIndex(), 4);
        harness.check(this.events.size(), 2);
        harness.check(this.displayedMnemonicWhenEventFired, 68);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"displayedMnemonic");
        harness.check(e0.getOldValue(), new Integer(0));
        harness.check(e0.getNewValue(), new Integer(68));
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e1.getSource(), label);
        harness.check(e1.getPropertyName(), (Object)"displayedMnemonicIndex");
        harness.check(e1.getOldValue(), new Integer(-1));
        harness.check(e1.getNewValue(), new Integer(4));
        this.events.clear();
        label.setDisplayedMnemonic(90);
        harness.check(label.getDisplayedMnemonic(), 90);
        harness.check(label.getDisplayedMnemonicIndex(), -1);
        harness.check(this.events.size(), 2);
        e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"displayedMnemonic");
        harness.check(e0.getOldValue(), new Integer(68));
        harness.check(e0.getNewValue(), new Integer(90));
        e1 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e1.getSource(), label);
        harness.check(e1.getPropertyName(), (Object)"displayedMnemonicIndex");
        harness.check(e1.getOldValue(), new Integer(4));
        harness.check(e1.getNewValue(), new Integer(-1));
    }

    public void testKeyMap(TestHarness harness) {
        JLabel label = new JLabel("ABC");
        label.setDisplayedMnemonic('B');
        InputMap m = label.getInputMap(2);
        harness.check(m.get(KeyStroke.getKeyStroke(66, 512)), null);
        label.setLabelFor(new JButton());
        m = label.getInputMap(2);
        harness.check(m.get(KeyStroke.getKeyStroke(66, 512)), (Object)"press");
    }
}

