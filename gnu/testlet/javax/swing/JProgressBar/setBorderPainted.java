/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JProgressBar;

public class setBorderPainted
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
        harness.check(pb.isBorderPainted(), true);
        pb.addPropertyChangeListener(this);
        pb.setBorderPainted(true);
        harness.check(this.lastEvent, null);
        pb.setBorderPainted(false);
        harness.check(pb.isBorderPainted(), false);
        harness.check(this.lastEvent.getPropertyName(), (Object)"borderPainted");
        harness.check(this.lastEvent.getOldValue(), Boolean.TRUE);
        harness.check(this.lastEvent.getNewValue(), Boolean.FALSE);
    }
}

