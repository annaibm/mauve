/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class addChangeListener
implements Testlet,
ChangeListener {
    List events = new ArrayList();

    @Override
    public void stateChanged(ChangeEvent event) {
        this.events.add(event);
    }

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("addChangeListener()");
        JSpinner s = new JSpinner();
        s.addChangeListener(this);
        s.getModel().setValue(new Integer(11));
        harness.check(this.events.size(), 1);
        ChangeEvent e = (ChangeEvent)this.events.get(0);
        harness.check(e.getSource(), s);
        boolean pass = true;
        try {
            s.addChangeListener(null);
        }
        catch (NullPointerException npe) {
            pass = false;
        }
        harness.check(pass);
    }
}

