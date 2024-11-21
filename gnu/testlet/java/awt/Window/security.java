/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Window;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.awt.AWTPermission;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.security.Permission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            Frame frame = new Frame();
            Window window = new Window(frame);
            GraphicsConfiguration gc = window.getGraphicsConfiguration();
            Permission[] showWindowWithoutWarningBanner = new Permission[]{new AWTPermission("showWindowWithoutWarningBanner")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("Window(Frame)");
                try {
                    sm.prepareChecks(showWindowWithoutWarningBanner);
                    new Window(frame);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("Window(Window)");
                try {
                    sm.prepareChecks(showWindowWithoutWarningBanner);
                    new Window(window);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("Window(Window, GraphicsConfiguration)");
                try {
                    sm.prepareChecks(showWindowWithoutWarningBanner);
                    new Window(window, gc);
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
}

