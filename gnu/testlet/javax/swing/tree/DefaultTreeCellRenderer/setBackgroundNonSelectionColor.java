/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultTreeCellRenderer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;

public class setBackgroundNonSelectionColor
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
        harness.check(r.getBackgroundNonSelectionColor(), UIManager.getColor("Tree.textBackground"));
        r.setBackgroundNonSelectionColor(Color.yellow);
        harness.check(r.getBackgroundNonSelectionColor(), Color.yellow);
        harness.check(this.lastEvent, null);
        r.setBackgroundNonSelectionColor(null);
        harness.check(r.getBackgroundNonSelectionColor(), null);
        harness.check(this.lastEvent, null);
    }
}

