/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JInternalFrame;

public class setClosable
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
        harness.check(!f.isClosable());
        f.addPropertyChangeListener(this);
        f.setClosable(true);
        harness.check(f.isClosable());
        harness.check(this.lastEvent.getPropertyName(), (Object)"closable");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getOldValue(), Boolean.FALSE);
        harness.check(this.lastEvent.getNewValue(), Boolean.TRUE);
    }
}

