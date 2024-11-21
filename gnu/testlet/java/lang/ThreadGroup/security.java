/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ThreadGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.security.Permission;

public class security
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("setup");
            ThreadGroup systemGroup = Thread.currentThread().getThreadGroup();
            while (systemGroup.getParent() != null) {
                systemGroup = systemGroup.getParent();
            }
            Thread testThread = new Thread(systemGroup, new TestRunner(harness));
            testThread.start();
            testThread.join();
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
    }

    public static class SpecialSecurityManager
    extends TestSecurityManager {
        public SpecialSecurityManager(TestHarness harness) {
            super(harness);
        }

        @Override
        public void checkAccess(ThreadGroup g) {
            this.checkPermission(new RuntimePermission("modifyThreadGroup"));
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
                this.harness.check(testGroup2.getParent() == null);
                ThreadGroup nonSystemGroup = new ThreadGroup(testGroup2, "test group");
                this.harness.check(nonSystemGroup.getParent() != null);
                Permission[] modifyThreadGroup = new Permission[]{new RuntimePermission("modifyThreadGroup")};
                Permission[] modifyThread = new Permission[]{new RuntimePermission("modifyThread")};
                Permission[] stopThread = new Permission[]{new RuntimePermission("modifyThread"), new RuntimePermission("stopThread")};
                TestSecurityManager sm = new TestSecurityManager(this.harness);
                try {
                    sm.install();
                    this.harness.checkPoint("ThreadGroup(String)");
                    try {
                        sm.prepareChecks(modifyThreadGroup);
                        new ThreadGroup("test");
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("ThreadGroup(ThreadGroup, String)");
                    try {
                        sm.prepareChecks(modifyThreadGroup);
                        new ThreadGroup(testGroup2, "test");
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("checkAccess");
                    try {
                        sm.prepareChecks(modifyThreadGroup);
                        testGroup2.checkAccess();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("enumerate(Thread[])");
                    try {
                        sm.prepareChecks(modifyThreadGroup);
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
                            sm.prepareChecks(modifyThreadGroup);
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
                        sm.prepareChecks(modifyThreadGroup);
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
                            sm.prepareChecks(modifyThreadGroup);
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
                        sm.prepareChecks(modifyThreadGroup);
                        nonSystemGroup.getParent();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("setDaemon");
                    try {
                        sm.prepareChecks(modifyThreadGroup);
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
                        sm.prepareChecks(modifyThreadGroup);
                        testGroup2.setMaxPriority(priority2);
                        sm.checkAllChecked();
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("suspend");
                    try {
                        sm.prepareHaltingChecks(modifyThreadGroup, modifyThread);
                        testGroup2.suspend();
                        this.harness.check(false);
                    }
                    catch (TestSecurityManager.SuccessException ex) {
                        this.harness.check(true);
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("resume");
                    try {
                        sm.prepareHaltingChecks(modifyThreadGroup, modifyThread);
                        testGroup2.resume();
                        this.harness.check(false);
                    }
                    catch (TestSecurityManager.SuccessException ex) {
                        this.harness.check(true);
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("interrupt");
                    try {
                        sm.prepareHaltingChecks(modifyThreadGroup, modifyThread);
                        testGroup2.interrupt();
                        this.harness.check(false);
                    }
                    catch (TestSecurityManager.SuccessException ex) {
                        this.harness.check(true);
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                    this.harness.checkPoint("stop");
                    try {
                        sm.prepareHaltingChecks(modifyThreadGroup, stopThread);
                        testGroup2.stop();
                        this.harness.check(false);
                    }
                    catch (TestSecurityManager.SuccessException ex) {
                        this.harness.check(true);
                    }
                    catch (SecurityException ex) {
                        this.harness.debug(ex);
                        this.harness.check(false, "unexpected check");
                    }
                }
                finally {
                    sm.uninstall();
                }
                sm = new SpecialSecurityManager(this.harness);
                try {
                    sm.install();
                    this.harness.checkPoint("destroy");
                    try {
                        sm.prepareChecks(modifyThreadGroup);
                        nonSystemGroup.destroy();
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

