/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class setRolloverEnabled
implements Testlet,
PropertyChangeListener {
    private PropertyChangeEvent event;

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.event = event;
    }

    @Override
    public void test(TestHarness harness) {
        try {
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            // empty catch block
        }
        JButton b = new JButton("Test");
        harness.check(b.isRolloverEnabled(), false);
        b.addPropertyChangeListener(this);
        b.setRolloverEnabled(true);
        harness.check(b.isRolloverEnabled(), true);
        harness.check(this.event.getPropertyName(), (Object)"rolloverEnabled");
        harness.check(this.event.getSource(), b);
        harness.check(this.event.getOldValue(), Boolean.FALSE);
        harness.check(this.event.getNewValue(), Boolean.TRUE);
    }
}

