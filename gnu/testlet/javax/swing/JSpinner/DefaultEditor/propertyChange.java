/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.DefaultEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSpinner.DefaultEditor.MyDefaultEditor;
import java.beans.PropertyChangeEvent;
import javax.swing.JSpinner;

public class propertyChange
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(PropertyChangeEvent)");
        JSpinner s = new JSpinner();
        MyDefaultEditor e = new MyDefaultEditor(s);
        s.setEditor(e);
        e.propertyChangeEvents.clear();
        e.getTextField().setValue(new Integer(88));
        harness.check(e.propertyChangeEvents.size(), 1);
        PropertyChangeEvent event = (PropertyChangeEvent)e.propertyChangeEvents.get(0);
        harness.check(event.getPropertyName(), (Object)"value");
        harness.check(e.getTextField().getText(), (Object)"88");
    }
}

