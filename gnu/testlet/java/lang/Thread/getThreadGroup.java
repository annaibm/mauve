/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Thread;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getThreadGroup
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Thread current2 = Thread.currentThread();
        harness.check(current2.getThreadGroup() != null, "Every Thread has a ThreadGroup");
        Thread t = new Thread();
        harness.check(t.getThreadGroup(), current2.getThreadGroup());
        t.start();
        try {
            t.join();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        harness.check(t.getThreadGroup(), null);
        ThreadGroup g = new ThreadGroup("Test-Group");
        t = new Thread(g, "Test-Thread");
        harness.check(t.getThreadGroup(), g);
        t = new Thread((ThreadGroup)null, "Test-Thread-2");
        harness.check(t.getThreadGroup(), current2.getThreadGroup());
    }
}

