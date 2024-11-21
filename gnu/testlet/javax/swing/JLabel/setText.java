/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JLabel.TestLabel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

public class setText
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testGeneralWithMnemonic(harness);
        this.testRepaint(harness);
        this.testRevalidate(harness);
    }

    public void testGeneral(TestHarness harness) {
        harness.checkPoint("testGeneral()");
        JLabel label = new JLabel("ABC");
        label.addPropertyChangeListener(this);
        label.setText("XYZ");
        harness.check(label.getText(), (Object)"XYZ");
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"text");
        harness.check(e0.getOldValue(), (Object)"ABC");
        harness.check(e0.getNewValue(), (Object)"XYZ");
        this.events.clear();
        label.setText("XYZ");
        harness.check(this.events.size(), 0);
        this.events.clear();
        label.setText(null);
        harness.check(label.getText(), null);
        harness.check(this.events.size(), 1);
        e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"text");
        harness.check(e0.getOldValue(), (Object)"XYZ");
        harness.check(e0.getNewValue(), null);
        this.events.clear();
        label.setText(null);
        harness.check(this.events.size(), 0);
    }

    public void testGeneralWithMnemonic(TestHarness harness) {
        harness.checkPoint("testGeneralWithMnemonic()");
        JLabel label = new JLabel("ABC");
        label.setDisplayedMnemonic('C');
        harness.check(label.getDisplayedMnemonicIndex(), 2);
        this.events.clear();
        label.addPropertyChangeListener(this);
        label.setText("CAB");
        harness.check(label.getText(), (Object)"CAB");
        harness.check(label.getDisplayedMnemonicIndex(), 0);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"text");
        harness.check(e0.getOldValue(), (Object)"ABC");
        harness.check(e0.getNewValue(), (Object)"CAB");
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(1);
        if (e1.getPropertyName().equals("html")) {
            e1 = (PropertyChangeEvent)this.events.get(2);
        }
        harness.check(e1.getSource(), label);
        harness.check(e1.getPropertyName(), (Object)"displayedMnemonicIndex");
        harness.check(e1.getOldValue(), new Integer(2));
        harness.check(e1.getNewValue(), new Integer(0));
        this.events.clear();
        label.setText("CAB");
        harness.check(this.events.size(), 0);
        this.events.clear();
        label.setText(null);
        harness.check(label.getText(), null);
        harness.check(label.getDisplayedMnemonicIndex(), -1);
        harness.check(this.events.size(), 2);
        e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), label);
        harness.check(e0.getPropertyName(), (Object)"text");
        harness.check(e0.getOldValue(), (Object)"CAB");
        harness.check(e0.getNewValue(), null);
        e1 = (PropertyChangeEvent)this.events.get(1);
        if (e1.getPropertyName().equals("html")) {
            e1 = (PropertyChangeEvent)this.events.get(2);
        }
        harness.check(e1.getSource(), label);
        harness.check(e1.getPropertyName(), (Object)"displayedMnemonicIndex");
        harness.check(e1.getOldValue(), new Integer(0));
        harness.check(e1.getNewValue(), new Integer(-1));
    }

    private void testRepaint(TestHarness harness) {
        TestLabel c = new TestLabel();
        c.setText(null);
        c.repaintCalled = false;
        c.setText("Test1");
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setText("Test1");
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setText("Text2");
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setText("Text2");
        harness.check(c.repaintCalled, false);
    }

    private void testRevalidate(TestHarness harness) {
        TestLabel c = new TestLabel();
        c.setText(null);
        c.revalidateCalled = false;
        c.setText("Test1");
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setText("Test1");
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setText("Test2");
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setText("Test2");
        harness.check(c.revalidateCalled, false);
    }
}

