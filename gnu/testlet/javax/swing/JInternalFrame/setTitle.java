/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JInternalFrame;

public class setTitle
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent lastEvent;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.lastEvent = e;
    }

    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("F1");
        f.addPropertyChangeListener(this);
        f.setTitle("F2");
        harness.check(f.getTitle(), (Object)"F2");
        harness.check(this.lastEvent.getPropertyName(), (Object)"title");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getOldValue(), (Object)"F1");
        harness.check(this.lastEvent.getNewValue(), (Object)"F2");
        this.lastEvent = null;
        f.setTitle(null);
        harness.check(f.getTitle(), null);
        harness.check(this.lastEvent.getPropertyName(), (Object)"title");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getOldValue(), (Object)"F2");
        harness.check(this.lastEvent.getNewValue(), null);
        this.lastEvent = null;
        f.setTitle(null);
        harness.check(this.lastEvent.getPropertyName(), (Object)"title");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getOldValue(), null);
        harness.check(this.lastEvent.getNewValue(), null);
        f.setTitle("F3");
        harness.check(f.getTitle(), (Object)"F3");
        harness.check(this.lastEvent.getPropertyName(), (Object)"title");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getOldValue(), null);
        harness.check(this.lastEvent.getNewValue(), (Object)"F3");
    }
}

