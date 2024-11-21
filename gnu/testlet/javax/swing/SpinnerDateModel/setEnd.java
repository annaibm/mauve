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

public class setEnd
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
        Date start = new Date(now.getTime() - 1L);
        Date preStart = new Date(now.getTime() - 2L);
        Date end1 = new Date(now.getTime() + 1L);
        Date end2 = new Date(now.getTime() + 2L);
        SpinnerDateModel m = new SpinnerDateModel(now, start, end1, 5);
        m.addChangeListener(this);
        m.setEnd(end2);
        harness.check(m.getEnd(), end2);
        harness.check(this.event.getSource(), m);
        this.event = null;
        m.setEnd(end2);
        harness.check(this.event == null);
        this.event = null;
        m.setEnd(null);
        harness.check(m.getEnd(), null);
        harness.check(this.event.getSource(), m);
        this.event = null;
        m.setEnd(null);
        harness.check(this.event == null);
        m.setEnd(preStart);
        harness.check(m.getEnd(), preStart);
    }
}

