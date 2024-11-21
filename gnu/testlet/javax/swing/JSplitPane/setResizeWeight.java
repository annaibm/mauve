/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSplitPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JSplitPane;

public class setResizeWeight
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.events.add(event);
    }

    @Override
    public void test(TestHarness harness) {
        JSplitPane s = new JSplitPane();
        s.addPropertyChangeListener(this);
        s.setResizeWeight(0.33);
        harness.check(s.getResizeWeight(), 0.33);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent pce = (PropertyChangeEvent)this.events.get(0);
        harness.check(pce.getPropertyName(), (Object)"resizeWeight");
        harness.check(pce.getSource(), s);
        harness.check(pce.getOldValue(), new Double(0.0));
        harness.check(pce.getNewValue(), new Double(0.33));
        this.events.clear();
        s.setResizeWeight(0.33);
        harness.check(this.events.size(), 0);
        boolean pass = false;
        try {
            s.setResizeWeight(-0.33);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

