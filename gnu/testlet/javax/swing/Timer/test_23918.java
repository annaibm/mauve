/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.Timer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class test_23918
implements Testlet,
ActionListener {
    int fired;

    @Override
    public void test(TestHarness harness) {
        this.fired = 0;
        Timer timer = new Timer(50, this);
        timer.setRepeats(false);
        timer.start();
        try {
            Thread.sleep(400L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        harness.check(this.fired, 1, "Must be fired exactly once.");
        harness.check(timer.isRunning(), false, "Must not be terminated");
    }

    @Override
    public void actionPerformed(ActionEvent parm1) {
        ++this.fired;
    }
}

