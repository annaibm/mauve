/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame.AccessibleJInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleValue;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

public class setCurrentAccessibleValue
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
        JInternalFrame.JDesktopIcon icon = f.getDesktopIcon();
        AccessibleContext ac = icon.getAccessibleContext();
        AccessibleValue av = ac.getAccessibleValue();
        harness.check(av.getCurrentAccessibleValue(), JLayeredPane.DEFAULT_LAYER);
        ac.addPropertyChangeListener(this);
        av.setCurrentAccessibleValue(JLayeredPane.PALETTE_LAYER);
        harness.check(f.getLayer(), JLayeredPane.PALETTE_LAYER);
        harness.check(this.lastEvent, null);
        boolean set2 = av.setCurrentAccessibleValue(null);
        harness.check(!set2);
        harness.check(f.getLayer(), JLayeredPane.PALETTE_LAYER);
    }
}

