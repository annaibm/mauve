/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Thread;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class contextClassLoader
implements Testlet,
Runnable {
    ClassLoader checkClassLoader;
    String check_msg;
    TestHarness h;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        this.h = harness;
        Thread current2 = Thread.currentThread();
        ClassLoader current_cl = current2.getContextClassLoader();
        try {
            ClassLoader system_cl = ClassLoader.getSystemClassLoader();
            harness.check(current_cl, system_cl, "Default contextClassLoader is System ClassLoader");
            Thread t = new Thread((Runnable)this, "CL-Test-Thread");
            ClassLoader t_cl = t.getContextClassLoader();
            harness.check(t_cl, current_cl, "New thread inherits classloader");
            this.checkClassLoader = t_cl;
            this.check_msg = "Run with default contextClassLoader";
            t.start();
            try {
                t.join();
            }
            catch (InterruptedException e) {
                throw new Error(e);
            }
            current2.setContextClassLoader(null);
            harness.check(current2.getContextClassLoader() == null, "null is a valid contextClassLoader");
            t = new Thread((Runnable)this, "CL-Test-Thread-2");
            harness.check(t.getContextClassLoader(), null, "New thread inherits null classloader");
            this.checkClassLoader = null;
            this.check_msg = "run with null classloader";
            t.start();
            try {
                t.join();
            }
            catch (InterruptedException e) {
                throw new Error(e);
            }
        }
        finally {
            current2.setContextClassLoader(current_cl);
            harness.check(current2.getContextClassLoader(), current_cl, "Reset context classloader");
        }
    }

    @Override
    public void run() {
        Thread current2 = Thread.currentThread();
        ClassLoader cl = current2.getContextClassLoader();
        this.h.debug("checkClassLoader: " + this.checkClassLoader);
        this.h.debug(current2 + ": " + cl);
        this.h.check(cl, this.checkClassLoader, this.check_msg);
    }
}

