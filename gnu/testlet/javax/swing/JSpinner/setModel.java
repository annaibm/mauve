/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

public class setModel
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(SpinnerModel)");
        JSpinner s = new JSpinner();
        harness.check(s.getEditor() instanceof JSpinner.NumberEditor);
        s.addPropertyChangeListener(this);
        SpinnerDateModel m = new SpinnerDateModel();
        s.setModel(m);
        harness.check(s.getModel(), m);
        harness.check(this.events.size(), 2);
        PropertyChangeEvent e1 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e1.getPropertyName(), (Object)"model");
        harness.check(e1.getSource(), s);
        harness.check(e1.getNewValue(), m);
        harness.check(e1.getOldValue() instanceof SpinnerNumberModel);
        PropertyChangeEvent e2 = (PropertyChangeEvent)this.events.get(1);
        harness.check(e2.getPropertyName(), (Object)"editor");
        harness.check(e2.getSource(), s);
        harness.check(e2.getNewValue() instanceof JSpinner.DateEditor);
        harness.check(e2.getOldValue() instanceof JSpinner.NumberEditor);
        this.events.clear();
        s.setModel(m);
        harness.check(this.events.size(), 0);
        boolean pass = false;
        try {
            s.setModel(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

