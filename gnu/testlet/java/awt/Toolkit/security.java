/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Toolkit;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.awt.AWTEvent;
import java.awt.AWTPermission;
import java.awt.Frame;
import java.awt.JobAttributes;
import java.awt.PageAttributes;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.security.Permission;
import java.util.Properties;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            toolkit.getSystemEventQueue();
            TestEventListener listener = new TestEventListener();
            Frame frame = new Frame();
            Properties props = new Properties();
            JobAttributes jobattrs = new JobAttributes();
            PageAttributes pageattrs = new PageAttributes();
            Permission[] listenToAllAWTEvents = new Permission[]{new AWTPermission("listenToAllAWTEvents")};
            Permission[] queuePrintJob = new Permission[]{new RuntimePermission("queuePrintJob")};
            Permission[] accessClipboard = new Permission[]{new AWTPermission("accessClipboard")};
            Permission[] accessEventQueue = new Permission[]{new AWTPermission("accessEventQueue")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("addAWTEventListener");
                try {
                    sm.prepareChecks(listenToAllAWTEvents);
                    toolkit.addAWTEventListener(listener, 8L);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("removeAWTEventListener");
                try {
                    sm.prepareChecks(listenToAllAWTEvents);
                    toolkit.removeAWTEventListener(listener);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getPrintJob(3-arg)");
                try {
                    sm.prepareHaltingChecks(queuePrintJob);
                    toolkit.getPrintJob(frame, "Test job", props);
                    harness.check(false);
                }
                catch (TestSecurityManager.SuccessException ex) {
                    harness.check(true);
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getPrintJob(4-arg)");
                try {
                    sm.prepareHaltingChecks(queuePrintJob);
                    toolkit.getPrintJob(frame, "Test job", jobattrs, pageattrs);
                    harness.check(false);
                }
                catch (TestSecurityManager.SuccessException ex) {
                    harness.check(true);
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getSystemClipboard");
                try {
                    sm.prepareChecks(accessClipboard);
                    toolkit.getSystemClipboard();
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getSystemEventQueue");
                try {
                    sm.prepareChecks(accessEventQueue);
                    toolkit.getSystemEventQueue();
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
            }
            finally {
                sm.uninstall();
            }
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
    }

    private static class TestEventListener
    implements AWTEventListener {
        private TestEventListener() {
        }

        @Override
        public void eventDispatched(AWTEvent event) {
        }
    }
}

