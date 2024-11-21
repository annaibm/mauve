/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.Timer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.Timer;

public class preparatory
implements Testlet,
ActionListener {
    static int DELAY = 7777;
    static int OTHER_DELAY = 5555;
    Timer object = new Timer(DELAY, null);

    public void test_InitialDelay(TestHarness harness) {
        Timer t = new Timer(DELAY, null);
        harness.check(t.getInitialDelay(), DELAY, "Initial delay must be be a default value from constructor, " + DELAY + ", not " + this.object.getInitialDelay());
        t.setInitialDelay(1);
        harness.check(t.getInitialDelay(), 1, "Initial delay must be set to 1 by setInitialDelay(1)");
        t.setDelay(DELAY);
        harness.check(t.getInitialDelay(), 1, "If the initial delay is explicitly set, setDelay() must not alter it.");
    }

    public void test_Delay(TestHarness harness) {
        harness.check(this.object.getDelay(), DELAY, "getDelay()");
        this.object.setDelay(5);
        harness.check(this.object.getDelay(), 5);
    }

    public void test_Listeners(TestHarness harness) {
        this.object.addActionListener(this);
        harness.checkPoint("getListeners");
        EventListener[] result = this.object.getListeners(ActionListener.class);
        harness.check(result.length == 1);
        harness.check(result[0] == this);
        result = this.object.getListeners(otherListener.class);
        harness.check(result.length == 0);
        this.object.removeActionListener(this);
        harness.check(((ActionListener[])this.object.getListeners(ActionListener.class)).length, 0, "Removing listener");
    }

    public void test_Coalesce(TestHarness harness) {
        harness.checkPoint("isCoalesce");
        this.object.setCoalesce(true);
        harness.check(this.object.isCoalesce());
        this.object.setCoalesce(false);
        harness.check(!this.object.isCoalesce());
    }

    public void test_Repeats(TestHarness harness) {
        harness.checkPoint("Repeats");
        harness.check(this.object.isRepeats(), true, "isRepeats default value is true");
        this.object.setRepeats(true);
        harness.check(this.object.isRepeats());
        this.object.setRepeats(false);
        harness.check(!this.object.isRepeats());
    }

    public void test_isRunning(TestHarness harness) {
        harness.check(!this.object.isRunning(), " should not be running ");
    }

    public void test_add_removeActionListener(TestHarness harness) {
        harness.checkPoint("Adding/removing listeners");
        Timer t = new Timer(1, this);
        otherListener other = new otherListener();
        t.addActionListener(other);
        harness.check(t.getActionListeners().length, 2, "must be 2 listeners");
        t.removeActionListener(this);
        harness.check(t.getActionListeners().length, 1, "must be 1 listener");
        t.removeActionListener(new otherListener());
        harness.check(t.getActionListeners().length, 1, "must still be 1 listener");
        t.removeActionListener(other);
        harness.check(t.getActionListeners().length, 0, "must be no listeners");
    }

    public void test_LogTimers(TestHarness harness) {
        Timer.setLogTimers(true);
        preparatory preparatory2 = this;
        harness.check(preparatory2.object.getLogTimers(), "log timers");
        Timer.setLogTimers(false);
        preparatory preparatory3 = this;
        harness.check(!preparatory3.object.getLogTimers());
    }

    @Override
    public void test(TestHarness harness) {
        this.test_InitialDelay(harness);
        this.test_Delay(harness);
        this.test_Listeners(harness);
        this.test_Coalesce(harness);
        this.test_Repeats(harness);
        this.test_isRunning(harness);
        this.test_add_removeActionListener(harness);
        this.test_LogTimers(harness);
    }

    @Override
    public void actionPerformed(ActionEvent parm1) {
    }

    public static class otherListener
    implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent parm1) {
        }
    }
}

