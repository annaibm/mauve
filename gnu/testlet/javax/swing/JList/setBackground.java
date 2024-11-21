/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class setBackground
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent event;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }

    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JList list2 = new JList();
        list2.addPropertyChangeListener(this);
        harness.check(list2.getBackground(), MetalLookAndFeel.getWindowBackground());
        list2.setBackground(Color.yellow);
        harness.check(list2.getBackground(), Color.yellow);
        harness.check(this.event.getPropertyName(), (Object)"background");
        harness.check(this.event.getOldValue(), MetalLookAndFeel.getWindowBackground());
        harness.check(this.event.getNewValue(), Color.yellow);
        list2.setBackground(null);
        harness.check(list2.getBackground(), null);
        harness.check(this.event.getPropertyName(), (Object)"background");
        harness.check(this.event.getOldValue(), Color.yellow);
        harness.check(this.event.getNewValue(), null);
    }
}

