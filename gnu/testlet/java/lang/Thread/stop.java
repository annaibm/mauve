/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Thread;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class stop
extends Thread
implements Testlet {
    static TestHarness harness;
    static volatile boolean death;
    static Object lock;
    static boolean running;

    @Override
    public void run() {
        try {
            Object object = lock;
            synchronized (object) {
                running = true;
                lock.notifyAll();
                while (true) {
                    lock.wait();
                }
            }
        }
        catch (Exception e) {
            harness.fail("Unexpected exception during run()");
        }
        catch (ThreadDeath d) {
            death = true;
            Thread thread2 = Thread.currentThread();
            ThreadGroup group = thread2.getThreadGroup();
            harness.check(group != null, "Stop should not remove thread from ThreadGroup");
            throw d;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        harness = h;
        int initial_thread_count = 0;
        int running_thread_count = 0;
        int stopped_thread_count = 0;
        Thread[] thread_list = null;
        try {
            int x = 0;
            Thread current2 = Thread.currentThread();
            ThreadGroup group = current2.getThreadGroup();
            x = group.activeCount() + 10;
            thread_list = new Thread[x];
            initial_thread_count = group.enumerate(thread_list, true);
            stop t = new stop();
            ThreadGroup tgroup = t.getThreadGroup();
            harness.check(tgroup != null, "Unstarted thread has non-null thread group");
            t.start();
            Object object = lock;
            synchronized (object) {
                while (!running) {
                    lock.wait();
                }
                x = group.activeCount() + 10;
                thread_list = new Thread[x];
                running_thread_count = group.enumerate(thread_list, true);
                tgroup = t.getThreadGroup();
                harness.check(tgroup != null, "Running thread has non-null thread group");
            }
            t.stop();
            t.join(2000L, 0);
            x = group.activeCount() + 10;
            thread_list = new Thread[x];
            stopped_thread_count = group.enumerate(thread_list, true);
            harness.check(death, "ThreadDeath properly thrown and caught");
            harness.check(initial_thread_count == stopped_thread_count, "Initial thread count matches stopped thread count");
            harness.check(running_thread_count - 1 == initial_thread_count, "Running thread properly increased thread count");
            tgroup = t.getThreadGroup();
            harness.check(tgroup == null, "Stopped thread has null thread group");
        }
        catch (InterruptedException e) {
            harness.fail("Thread not joined - Thread.stop() unimplemented?");
        }
        catch (Exception e) {
            harness.debug(e);
            harness.fail("Unexpected exception during test()");
        }
    }

    static {
        death = false;
        lock = new Object();
        running = false;
    }
}

