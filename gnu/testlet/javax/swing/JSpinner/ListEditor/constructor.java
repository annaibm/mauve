/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.ListEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.EventListener;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeListener;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(JSpinner)");
        SpinnerListModel m = new SpinnerListModel(new String[]{"A", "B", "C"});
        JSpinner s = new JSpinner(m);
        JSpinner.DefaultEditor e = new JSpinner.DefaultEditor(s);
        harness.check(e.getLayout(), e);
        harness.check(e.getTextField().getValue(), (Object)"A");
        EventListener[] sl = s.getListeners(ChangeListener.class);
        harness.check(Arrays.asList(sl).contains(e));
        EventListener[] tfl = e.getTextField().getListeners(PropertyChangeListener.class);
        harness.check(Arrays.asList(tfl).contains(e));
    }
}

