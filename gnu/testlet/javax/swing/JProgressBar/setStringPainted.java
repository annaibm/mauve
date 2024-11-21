/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JProgressBar;

public class setStringPainted
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
        harness.check(pb.isStringPainted(), false);
        pb.addPropertyChangeListener(this);
        pb.setStringPainted(false);
        harness.check(this.lastEvent, null);
        pb.setStringPainted(true);
        harness.check(pb.isStringPainted(), true);
        harness.check(this.lastEvent.getPropertyName(), (Object)"stringPainted");
        harness.check(this.lastEvent.getOldValue(), Boolean.FALSE);
        harness.check(this.lastEvent.getNewValue(), Boolean.TRUE);
    }
}

