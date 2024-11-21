/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ThreadGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.security.Permission;

public class insecurity
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("setup");
            ThreadGroup systemGroup = Thread.currentThread().getThreadGroup();
            while (systemGroup.getParent() != null) {
                systemGroup = systemGroup.getParent();
            }
            ThreadGroup nonSystemGroup = new ThreadGroup(systemGroup, "test group");
            Thread testThread = new Thread(nonSystemGroup, new TestRunner(harness));
            testThread.start();
            testThread.join();
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
    }

    public static class TestRunner
    implements Runnable {
        private TestHarness harness;

        public TestRunner(TestHarness harness) {
            this.harness = harness;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            try {
                ThreadGroup testGroup2 = Thread.currentThread().getThreadGroup();
                this.harness.check(testGroup2.getParent() != null);
                ThreadGroup nonSystemGroup = new ThreadGroup(testGroup2, "test group");
                this.harness.check(nonSystemGroup.getParent() != null);
                Permission[] noChecks = new Permission[]{};
                TestSecurityManager sm = new TestSecurityManager(this.harness);
                try {
                    sm.install();
                    this.harness.checkPoint("ThreadGroup(String)");
                    try {
                        sm.prepareChecks(noChecks);
                        new ThreadGroup("test");
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("ThreadGroup(ThreadGroup, String)");
                    try {
                        sm.prepareChecks(noChecks);
                        new ThreadGroup(testGroup2, "test");
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("checkAccess");
                    try {
                        sm.prepareChecks(noChecks);
                        testGroup2.checkAccess();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("enumerate(Thread[])");
                    try {
                        sm.prepareChecks(noChecks);
                        testGroup2.enumerate(new Thread[0]);
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("enumerate(Thread[], boolean)");
                    for (int i = 0; i <= 1; ++i) {
                        try {
                            sm.prepareChecks(noChecks);
                            testGroup2.enumerate(new Thread[]{}, i == 1);
                            sm.checkAllChecked();
                            continue;
                        }
                        catch (SecurityException ex) {
                            this.harness.debug(ex);
                            this.harness.check(false, "unexpected check");
                        }
                    }
                    this.harness.checkPoint("enumerate(ThreadGroup[])");
                    try {
                        sm.prepareChecks(noChecks);
                        testGroup2.enumerate(new ThreadGroup[0]);
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("enumerate(ThreadGroup[], boolean)");
                    for (int i = 0; i <= 1; ++i) {
                        try {
                            sm.prepareChecks(noChecks);
                            testGroup2.enumerate(new ThreadGroup[]{}, i == 1);
                            sm.checkAllChecked();
                            continue;
                        }
                        catch (SecurityException ex) {
                            this.harness.debug(ex);
                            this.harness.check(false, "unexpected check");
                        }
                    }
                    this.harness.checkPoint("getParent");
                    try {
                        sm.prepareChecks(noChecks);
                        nonSystemGroup.getParent();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("setDaemon");
                    try {
                        sm.prepareChecks(noChecks);
                        testGroup2.setDaemon(false);
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("setMaxPriority");
                    try {
                        int priority2 = testGroup2.getMaxPriority();
                        sm.prepareChecks(noChecks);
                        testGroup2.setMaxPriority(priority2);
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("suspend");
                    try {
                        sm.prepareChecks(noChecks);
                        nonSystemGroup.suspend();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("resume");
                    try {
                        sm.prepareChecks(noChecks);
                        nonSystemGroup.resume();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("interrupt");
                    try {
                        sm.prepareChecks(noChecks);
                        nonSystemGroup.interrupt();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("stop");
                    try {
                        sm.prepareChecks(noChecks);
                        nonSystemGroup.stop();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                }
                finally {
                    sm.uninstall();
                }
            }
            catch (Exception ex) {
                this.harness.debug(ex);
                this.harness.check(false, "Unexpected exception");
            }
        }
    }
}

