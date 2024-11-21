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

public class setStart
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
        Date start1 = new Date(now.getTime() - 1L);
        Date start2 = new Date(now.getTime() - 2L);
        Date end2 = new Date(now.getTime() + 1L);
        Date postEnd = new Date(now.getTime() + 2L);
        SpinnerDateModel m = new SpinnerDateModel(now, start1, end2, 5);
        m.addChangeListener(this);
        m.setStart(start2);
        harness.check(m.getStart(), start2);
        harness.check(this.event.getSource(), m);
        this.event = null;
        m.setStart(start2);
        harness.check(this.event == null);
        this.event = null;
        m.setStart(null);
        harness.check(m.getStart(), null);
        harness.check(this.event.getSource(), m);
        this.event = null;
        m.setStart(null);
        harness.check(this.event == null);
        m.setStart(postEnd);
        harness.check(m.getStart(), postEnd);
    }
}

