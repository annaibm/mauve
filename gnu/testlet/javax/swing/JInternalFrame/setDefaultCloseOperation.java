/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JInternalFrame;

public class setDefaultCloseOperation
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent lastEvent;

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.lastEvent = event;
    }

    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("F1");
        f.addPropertyChangeListener(this);
        harness.check(f.getDefaultCloseOperation(), 2);
        f.setDefaultCloseOperation(0);
        harness.check(f.getDefaultCloseOperation(), 0);
        harness.check(this.lastEvent, null);
        f.setDefaultCloseOperation(-999);
        harness.check(f.getDefaultCloseOperation(), -999);
    }
}

