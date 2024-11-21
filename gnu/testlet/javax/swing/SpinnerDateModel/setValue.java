/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerDateModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setValue
implements Testlet,
ChangeListener {
    private ChangeEvent event;

    @Override
    public void stateChanged(ChangeEvent e) {
        this.event = e;
    }

    @Override
    public void test(TestHarness harness) {
        Date now = new Date();
        Date v1 = new Date(now.getTime() - 1L);
        Date start = new Date(now.getTime() - 2L);
        Date preStart = new Date(now.getTime() - 3L);
        Date end2 = new Date(now.getTime() + 2L);
        Date postEnd = new Date(now.getTime() + 3L);
        SpinnerDateModel m = new SpinnerDateModel(now, start, end2, 14);
        m.addChangeListener(this);
        m.setValue(v1);
        harness.check(m.getValue(), v1);
        harness.check(this.event.getSource(), m);
        this.event = null;
        m.setValue(v1);
        harness.check(this.event == null);
        m.setValue(preStart);
        harness.check(m.getValue(), preStart);
        m.setValue(postEnd);
        harness.check(m.getValue(), postEnd);
        boolean pass = false;
        try {
            m.setValue(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setValue("123");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

