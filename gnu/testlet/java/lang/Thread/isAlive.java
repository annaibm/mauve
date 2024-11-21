/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Thread;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAlive
extends Thread
implements Testlet {
    boolean started = false;
    boolean please_stop = false;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        isAlive isAlive2 = this;
        synchronized (isAlive2) {
            this.started = true;
            this.notify();
            while (!this.please_stop) {
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {}
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        Thread current2 = Thread.currentThread();
        boolean alive = current2.isAlive();
        harness.check(alive, "Current running thread is always alive");
        isAlive t = new isAlive();
        harness.check(!t.isAlive(), "Newly created threads are not alive");
        t.start();
        isAlive isAlive2 = t;
        synchronized (isAlive2) {
            while (!t.started) {
                try {
                    t.wait();
                }
                catch (InterruptedException interruptedException) {}
            }
            harness.check(t.isAlive(), "Running threads are alive");
            t.please_stop = true;
            t.notify();
        }
        try {
            t.join();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        harness.check(!t.isAlive(), "Stopped threads are not alive");
    }
}

