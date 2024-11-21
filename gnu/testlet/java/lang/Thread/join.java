/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Thread;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class join
extends Thread
implements Testlet {
    static TestHarness harness;
    boolean please_wait = false;
    boolean waiting = false;
    boolean please_stop = false;
    int sleep = 0;
    int work = 0;
    Thread please_join = null;
    boolean done = false;
    long counter = 0L;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        if (this.please_wait) {
            join join2 = this;
            synchronized (join2) {
                this.waiting = true;
                this.notify();
                while (!this.please_stop) {
                    try {
                        this.wait();
                    }
                    catch (InterruptedException ie) {
                        harness.fail("Interrupted wait in run()");
                    }
                }
            }
        }
        if (this.sleep > 0) {
            try {
                Thread.sleep(this.sleep);
            }
            catch (InterruptedException ignore) {
                harness.fail("Interrupted sleep in run()");
            }
        }
        if (this.work > 0) {
            for (int i = 0; i < this.work; ++i) {
                this.counter += (long)(this.sleep < 0 ? this.work - 1 : this.work + 1);
            }
        }
        if (this.please_join != null) {
            try {
                this.please_join.join();
            }
            catch (InterruptedException ignore) {
                harness.fail("Interrupted join in run()");
            }
        }
        this.done = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        harness = h;
        try {
            Thread current2 = Thread.currentThread();
            current2.join(10L, 10);
            harness.check(current2.isAlive(), "Can join current Thread");
            join t = new join();
            t.join(10L, 10);
            harness.check(!t.isAlive(), "Can join a non-started Thread");
            t.start();
            t.join();
            harness.check(!t.isAlive(), "Can join a started Thread");
            harness.check(t.done, "join() returns after Thread is done");
            t.join();
            harness.check(!t.isAlive(), "Can join a stopped Thread");
            t = new join();
            t.please_wait = true;
            t.start();
            join join2 = t;
            synchronized (join2) {
                while (!t.waiting) {
                    t.wait();
                }
            }
            t.join(10L, 10);
            harness.check(t.waiting && !t.done, "Can join waiting Thread");
            join2 = t;
            synchronized (join2) {
                t.please_stop = true;
                t.notify();
            }
            t.join();
            harness.check(!t.isAlive(), "Can join wait/notify Thread");
            harness.check(t.done, "join() returns after wait/notify Thread done");
            t = new join();
            t.work = 100000;
            t.start();
            t.join();
            harness.check(t.done, "join() returns after Thread has worked");
            t = new join();
            t.sleep = 750;
            t.start();
            t.join();
            harness.check(t.done, "join() returns after Thread has slept");
            join t1 = new join();
            t1.sleep = 750;
            t1.work = 100000;
            join t2 = new join();
            t2.please_join = t1;
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            harness.check(t1.done && t2.done, "Multiple Threads can join()");
        }
        catch (InterruptedException ie) {
            harness.fail("Unexpected interrupt");
        }
    }
}

