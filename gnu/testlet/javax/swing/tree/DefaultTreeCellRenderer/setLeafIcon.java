/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultTreeCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.plaf.metal.MetalIconFactory;
import javax.swing.tree.DefaultTreeCellRenderer;

public class setLeafIcon
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent lastEvent;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.lastEvent = e;
    }

    @Override
    public void test(TestHarness harness) {
        DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();
        r.addPropertyChangeListener(this);
        harness.check(r.getLeafIcon(), r.getDefaultLeafIcon());
        r.setLeafIcon(MetalIconFactory.getRadioButtonIcon());
        harness.check(r.getLeafIcon(), MetalIconFactory.getRadioButtonIcon());
        harness.check(this.lastEvent, null);
        r.setLeafIcon(null);
        harness.check(r.getLeafIcon(), null);
        harness.check(this.lastEvent, null);
    }
}

