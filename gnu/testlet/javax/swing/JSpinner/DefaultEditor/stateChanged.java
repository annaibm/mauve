/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.DefaultEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSpinner.DefaultEditor.MyDefaultEditor;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;

public class stateChanged
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(ChangeEvent)");
        JSpinner s = new JSpinner();
        MyDefaultEditor e = new MyDefaultEditor(s);
        s.setEditor(e);
        s.getModel().setValue(new Integer(99));
        harness.check(e.stateChangeEvents.size(), 1);
        ChangeEvent event = (ChangeEvent)e.stateChangeEvents.get(0);
        harness.check(event.getSource(), s);
        harness.check(e.getTextField().getText(), (Object)"99");
    }
}

