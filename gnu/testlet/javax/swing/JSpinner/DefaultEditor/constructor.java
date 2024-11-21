/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.DefaultEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.EventListener;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(JSpinner)");
        JSpinner s = new JSpinner();
        JSpinner.DefaultEditor e = new JSpinner.DefaultEditor(s);
        harness.check(e.getLayout(), e);
        harness.check(e.getTextField().getValue(), new Integer(0));
        EventListener[] sl = s.getListeners(ChangeListener.class);
        harness.check(Arrays.asList(sl).contains(e));
        EventListener[] tfl = e.getTextField().getListeners(PropertyChangeListener.class);
        harness.check(Arrays.asList(tfl).contains(e));
    }
}

