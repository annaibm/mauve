/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Icon;
import javax.swing.JInternalFrame;
import javax.swing.plaf.metal.MetalIconFactory;

public class setFrameIcon
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent lastEvent;

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.lastEvent = event;
    }

    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("Title");
        f.addPropertyChangeListener(this);
        Icon icon = MetalIconFactory.getHorizontalSliderThumbIcon();
        f.setFrameIcon(icon);
        harness.check(f.getFrameIcon(), icon);
        harness.check(this.lastEvent.getPropertyName(), (Object)"frameIcon");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getNewValue(), icon);
        harness.check(this.lastEvent.getOldValue() != null);
        this.lastEvent = null;
        f.setFrameIcon(null);
        harness.check(f.getFrameIcon(), null);
        harness.check(this.lastEvent.getPropertyName(), (Object)"frameIcon");
        harness.check(this.lastEvent.getSource(), f);
        harness.check(this.lastEvent.getNewValue(), null);
        harness.check(this.lastEvent.getOldValue(), icon);
    }
}

