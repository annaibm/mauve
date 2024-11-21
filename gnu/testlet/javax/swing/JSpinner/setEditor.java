/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

public class setEditor
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(JComponent)");
        JSpinner s = new JSpinner();
        s.addPropertyChangeListener(this);
        JComponent e = s.getEditor();
        SpinnerNumberModel m = (SpinnerNumberModel)s.getModel();
        EventListener[] l1 = s.getListeners(ChangeListener.class);
        harness.check(Arrays.asList(l1).contains(e));
        harness.check(!Arrays.asList(l1).contains(m));
        JSpinner.NumberEditor e2 = new JSpinner.NumberEditor(s);
        s.setEditor(e2);
        harness.check(s.getEditor(), e2);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent pce = (PropertyChangeEvent)this.events.get(0);
        harness.check(pce.getPropertyName(), (Object)"editor");
        harness.check(pce.getOldValue(), e);
        harness.check(pce.getNewValue(), e2);
        l1 = s.getListeners(ChangeListener.class);
        harness.check(Arrays.asList(l1).contains(e2));
        harness.check(!Arrays.asList(l1).contains(e));
        boolean pass = false;
        try {
            s.setEditor(null);
        }
        catch (IllegalArgumentException iae) {
            pass = true;
        }
        harness.check(pass);
    }
}

