/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class getChangeListeners
implements Testlet,
ChangeListener {
    List events = new ArrayList();

    @Override
    public void stateChanged(ChangeEvent event) {
        this.events.add(event);
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        JSpinner s = new JSpinner();
        ChangeListener[] cl = s.getChangeListeners();
        harness.check(cl.length, 1);
        harness.check(cl[0], s.getEditor());
        s.addChangeListener(this);
        cl = s.getChangeListeners();
        harness.check(cl.length, 2);
        harness.check(Arrays.asList(cl).contains(this));
        s.removeChangeListener(this);
        cl = s.getChangeListeners();
        harness.check(cl.length, 1);
        harness.check(!Arrays.asList(cl).contains(this));
    }
}

