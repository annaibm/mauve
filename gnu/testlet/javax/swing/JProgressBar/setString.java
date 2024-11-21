/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JProgressBar;

public class setString
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
        harness.check(pb.getString(), (Object)"0%");
        pb.addPropertyChangeListener(this);
        pb.setString("XYZ");
        harness.check(pb.getString(), (Object)"XYZ");
        harness.check(this.lastEvent.getPropertyName(), (Object)"string");
        harness.check(this.lastEvent.getOldValue(), null);
        harness.check(this.lastEvent.getNewValue(), (Object)"XYZ");
        pb.setString(null);
        harness.check(pb.getString(), (Object)"0%");
        harness.check(this.lastEvent.getPropertyName(), (Object)"string");
        harness.check(this.lastEvent.getOldValue(), (Object)"XYZ");
        harness.check(this.lastEvent.getNewValue(), null);
    }
}

