/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JProgressBar;

public class setOrientation
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent lastEvent;

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.lastEvent = event;
    }

    @Override
    public void test(TestHarness harness) {
        JProgressBar pb = new JProgressBar();
        harness.check(pb.getOrientation(), 0);
        pb.addPropertyChangeListener(this);
        pb.setOrientation(1);
        harness.check(pb.getOrientation(), 1);
        harness.check(this.lastEvent.getPropertyName(), (Object)"orientation");
        harness.check(this.lastEvent.getOldValue(), new Integer(0));
        harness.check(this.lastEvent.getNewValue(), new Integer(1));
        boolean pass = false;
        try {
            pb.setOrientation(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

