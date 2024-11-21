/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Thread;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class daemon
extends Thread
implements Testlet {
    TestHarness harness;
    boolean started = false;
    boolean please_stop = false;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        daemon daemon2 = this;
        synchronized (daemon2) {
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
        this.harness = harness;
        Thread current2 = Thread.currentThread();
        boolean status = current2.isDaemon();
        boolean illegal_exception = false;
        try {
            current2.setDaemon(!status);
        }
        catch (IllegalThreadStateException itse) {
            illegal_exception = true;
        }
        harness.check(illegal_exception, "Cannot change daemon state on current Thread");
        harness.check(current2.isDaemon() == status, "Daemon status not changed when set on current Thread");
        daemon t = new daemon();
        harness.check(t.isDaemon() == status, "Newly created thread gets daemon status of creator");
        t.setDaemon(!status);
        harness.check(t.isDaemon() != status, "Can change daemon status on an unstarted Thread");
        status = t.isDaemon();
        t.start();
        daemon daemon2 = t;
        synchronized (daemon2) {
            while (!t.started) {
                try {
                    t.wait();
                }
                catch (InterruptedException interruptedException) {}
            }
        }
        harness.check(t.isDaemon() == status, "Daemon status does not change when starting a Thread");
        illegal_exception = false;
        try {
            t.setDaemon(!status);
        }
        catch (IllegalThreadStateException itse22) {
            illegal_exception = true;
        }
        harness.check(illegal_exception, "Cannot change daemon state on a running Thread");
        harness.check(t.isDaemon() == status, "Daemon status not changed when set on a running Thread");
        status = t.isDaemon();
        daemon itse22 = t;
        synchronized (itse22) {
            t.please_stop = true;
            t.notify();
        }
        try {
            t.join();
        }
        catch (InterruptedException itse22) {
            // empty catch block
        }
        illegal_exception = false;
        try {
            t.setDaemon(!status);
        }
        catch (IllegalThreadStateException itse) {
            illegal_exception = true;
        }
        harness.check(!illegal_exception, "Can change daemon state on an exitted Thread");
        harness.check(t.isDaemon() != status, "Daemon status changed when set on an exitted Thread");
    }
}

