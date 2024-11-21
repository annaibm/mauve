/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Thread;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class priority
implements Testlet,
Runnable {
    private static TestHarness harness;
    static priority p;
    boolean please_stop = false;

    private void test_set_prio(Thread t, String test_name) {
        int prio = t.getPriority();
        harness.check(prio >= 1, test_name + " has at least MIN_PRIORITY");
        harness.check(prio <= 10, test_name + " has at at most MAX_PRIORITY");
        ThreadGroup tg = t.getThreadGroup();
        harness.debug("ThreadGroup: " + tg);
        int thread_group_prio = t.getThreadGroup().getMaxPriority();
        t.getThreadGroup().setMaxPriority(10);
        for (int i = 1; i <= 10; ++i) {
            t.setPriority(i);
            harness.check(t.getPriority() == i, test_name + " can be set to priority " + i);
        }
        t.getThreadGroup().setMaxPriority(5);
        t.setPriority(6);
        harness.check(t.getPriority() == 5, test_name + " has thread group upper bound");
        t.getThreadGroup().setMaxPriority(thread_group_prio);
        boolean illegal_exception = false;
        try {
            t.setPriority(0);
        }
        catch (IllegalArgumentException iae) {
            illegal_exception = true;
        }
        harness.check(illegal_exception, test_name + " cannot set prio to less then MIN_PRIORITY");
        harness.check(t.getPriority() == 5, test_name + " prio doesn't change when set to illegal min");
        illegal_exception = false;
        try {
            t.setPriority(11);
        }
        catch (IllegalArgumentException iae) {
            illegal_exception = true;
        }
        harness.check(illegal_exception, test_name + " cannot set prio to more then MAX_PRIORITY");
        harness.check(t.getPriority() == 5, test_name + " prio doesn't change when set to illegal max");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        harness = h;
        harness.check(10, 10);
        harness.check(1, 1);
        harness.check(5, 5);
        Thread current2 = Thread.currentThread();
        this.test_set_prio(current2, "Every Thread");
        int prio = current2.getPriority();
        Thread t = new Thread(p);
        harness.check(t.getPriority() == prio, "New Thread inherits priority");
        this.test_set_prio(t, "New Thread");
        prio = t.getPriority();
        t.start();
        harness.check(t.getPriority() == prio, "Started Thread does not change priority");
        this.test_set_prio(t, "Started Thread");
        priority priority2 = p;
        synchronized (priority2) {
            priority.p.please_stop = true;
            p.notify();
        }
        try {
            t.join();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        harness.check(t.getPriority() == prio, "Stopped Thread does not change priority");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        priority priority2 = p;
        synchronized (priority2) {
            while (!this.please_stop) {
                try {
                    p.wait();
                }
                catch (InterruptedException interruptedException) {}
            }
        }
    }

    static {
        p = new priority();
    }
}

