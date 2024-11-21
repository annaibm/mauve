/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.UIManager.MyLookAndFeel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class setLookAndFeel
implements Testlet,
PropertyChangeListener {
    public PropertyChangeEvent lastEvent = null;

    @Override
    public void test(TestHarness harness) {
        MyLookAndFeel laf1 = new MyLookAndFeel();
        try {
            UIManager.addPropertyChangeListener(this);
            UIManager.setLookAndFeel(laf1);
            harness.check(UIManager.getLookAndFeel(), laf1);
            harness.check(this.lastEvent.getPropertyName(), (Object)"lookAndFeel");
            harness.check(this.lastEvent.getSource(), UIManager.class);
            harness.check(this.lastEvent.getNewValue(), laf1);
        }
        catch (UnsupportedLookAndFeelException e) {
            harness.fail(e.toString());
        }
        try {
            UIManager.setLookAndFeel((LookAndFeel)null);
            harness.check(UIManager.getLookAndFeel(), null);
            harness.check(this.lastEvent.getPropertyName(), (Object)"lookAndFeel");
            harness.check(this.lastEvent.getSource(), UIManager.class);
            harness.check(this.lastEvent.getOldValue(), laf1);
            harness.check(this.lastEvent.getNewValue(), null);
        }
        catch (UnsupportedLookAndFeelException e) {
            harness.fail(e.toString());
        }
        UIManager.removePropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.lastEvent = e;
    }
}

