/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Thread;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class interrupt
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        Thread current2 = Thread.currentThread();
        Thread.interrupted();
        harness.check(!current2.isInterrupted(), "Thread.interrupted() makes isInterrupted() false");
        harness.check(!Thread.interrupted(), "Thread.interrupted() makes interrupted() false");
        current2.interrupt();
        harness.check(current2.isInterrupted(), "interrupt() makes isInterrupted() true");
        harness.check(current2.isInterrupted(), "isInterrupt() doesn't clear interrupt flag");
        harness.check(Thread.interrupted(), "interrupt() makes interrupted() true");
        current2.interrupt();
        boolean interrupted_exception = false;
        try {
            Object o;
            Object object = o = new Object();
            synchronized (object) {
                o.wait(50L);
            }
        }
        catch (InterruptedException ie) {
            interrupted_exception = true;
        }
        harness.check(interrupted_exception, "wait with interrupt flag throws InterruptedException");
        harness.check(interrupted_exception && !Thread.interrupted(), "InterruptedException in wait() clears interrupt flag");
        current2.interrupt();
        interrupted_exception = false;
        try {
            Thread.sleep(50L);
        }
        catch (InterruptedException ie) {
            interrupted_exception = true;
        }
        harness.check(interrupted_exception, "sleep with interrupt flag throws InterruptedException");
        harness.check(interrupted_exception && !Thread.interrupted(), "InterruptedException in sleep() clears interrupt flag");
        current2.interrupt();
        interrupted_exception = false;
        try {
            current2.join(50L, 50);
        }
        catch (InterruptedException ie) {
            interrupted_exception = true;
        }
        harness.check(interrupted_exception, "join with interrupt flag throws InterruptedException");
        harness.check(interrupted_exception && !Thread.interrupted(), "InterruptedException in join() clears interrupt flag");
    }
}

