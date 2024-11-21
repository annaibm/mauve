/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToolTip;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JToolTip;

public class setTipText
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.events.add(event);
    }

    @Override
    public void test(TestHarness harness) {
        JToolTip tt = new JToolTip();
        tt.addPropertyChangeListener(this);
        tt.setTipText("XYZ");
        harness.check(tt.getTipText(), (Object)"XYZ");
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getPropertyName(), (Object)"tiptext");
        harness.check(e.getSource(), tt);
        harness.check(e.getOldValue(), null);
        harness.check(e.getNewValue(), (Object)"XYZ");
    }
}

