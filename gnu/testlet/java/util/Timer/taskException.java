/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Timer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Timer;
import java.util.TimerTask;

public class taskException
implements Testlet {
    private volatile boolean ran;

    @Override
    public void test(TestHarness harness) {
        this.ran = false;
        harness.checkPoint("Timer.schedule");
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                taskException.this.ran = true;
                throw new RuntimeException("eat it!!!");
            }
        }, 10L);
        try {
            Thread.sleep(50L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        harness.check(this.ran, "task was not run");
        try {
            timer.schedule(new TimerTask(){

                @Override
                public void run() {
                    taskException.this.ran = false;
                }
            }, 10L);
            harness.check(false, "still able to schedule tasks");
        }
        catch (IllegalStateException ise) {
            harness.check(true);
        }
        harness.check(this.ran, "unschedulable task was run");
    }
}

