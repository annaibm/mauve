/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class setNormalBounds
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent lastEvent;

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.lastEvent = event;
    }

    @Override
    public void test(TestHarness harness) {
        JDesktopPane desktop = new JDesktopPane();
        JInternalFrame f = new JInternalFrame("Title");
        desktop.add(f);
        f.addPropertyChangeListener(this);
        harness.check(f.getNormalBounds(), new Rectangle());
        f.setBounds(4, 3, 2, 1);
        harness.check(f.getNormalBounds(), new Rectangle(4, 3, 2, 1));
        Rectangle normalBounds = new Rectangle(1, 2, 3, 4);
        f.setNormalBounds(normalBounds);
        harness.check(f.getNormalBounds(), new Rectangle(1, 2, 3, 4));
        harness.check(f.getNormalBounds() == normalBounds);
        harness.check(f.getBounds(), new Rectangle(4, 3, 2, 1));
        harness.check(this.lastEvent, null);
        f.setNormalBounds(null);
        harness.check(f.getNormalBounds(), new Rectangle(4, 3, 2, 1));
    }
}

