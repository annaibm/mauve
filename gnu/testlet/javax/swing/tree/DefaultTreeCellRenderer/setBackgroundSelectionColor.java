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

public class setBackgroundSelectionColor
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
        harness.check(r.getBackgroundSelectionColor(), UIManager.getColor("Tree.selectionBackground"));
        r.setBackgroundSelectionColor(Color.yellow);
        harness.check(r.getBackgroundSelectionColor(), Color.yellow);
        harness.check(this.lastEvent, null);
        r.setBackgroundSelectionColor(null);
        harness.check(r.getBackgroundSelectionColor(), null);
        harness.check(this.lastEvent, null);
    }
}

