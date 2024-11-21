/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.Timer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class basic
implements Testlet,
ActionListener {
    public static int ACCEPTABLE_ACCURACY = 20;
    static int EXPECTED_DELAY = 800;
    static int EXPECTED_INITIAL_DELAY = 2000;
    long[] history = new long[200];
    int p = 1;
    long started;
    Thread main;

    @Override
    public void test(TestHarness harness) {
        this.main = Thread.currentThread();
        Timer t = new Timer(EXPECTED_DELAY, this);
        t.setCoalesce(false);
        t.setInitialDelay(EXPECTED_INITIAL_DELAY);
        t.setDelay(EXPECTED_DELAY);
        System.gc();
        this.history[0] = System.currentTimeMillis();
        t.start();
        try {
            Thread.sleep(5000L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        t.stop();
        double S = 0.0;
        StringBuffer series = new StringBuffer();
        for (int i = 1; i < this.p; ++i) {
            long d = Math.abs(this.history[i] - this.history[i - 1] - (long)(i == 1 ? EXPECTED_INITIAL_DELAY : EXPECTED_DELAY));
            series.append(this.history[i] - this.history[i - 1] + " ");
            S += (double)d;
        }
        int percentError = (int)(100.0 * (S /= (double)(this.p - 1)) / (double)EXPECTED_DELAY);
        if (percentError > ACCEPTABLE_ACCURACY) {
            harness.fail("Inaccurate work, series " + series + ", " + percentError + " % deviation from  2000 800 ..");
        }
    }

    @Override
    public void actionPerformed(ActionEvent parm1) {
        try {
            this.history[this.p] = System.currentTimeMillis();
            ++this.p;
            Thread.sleep((long)Math.random() * (long)EXPECTED_DELAY);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            this.main.interrupt();
        }
        catch (InterruptedException iex) {
            this.main.interrupt();
        }
    }
}

