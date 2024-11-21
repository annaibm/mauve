/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Robot;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.awt.AWTPermission;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.security.Permission;
import java.util.PropertyPermission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            Permission[] createRobot = new Permission[]{new AWTPermission("createRobot")};
            Permission[] readProperty = new Permission[]{new PropertyPermission("*", "read")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("0-arg constructor");
                try {
                    sm.prepareChecks(createRobot, readProperty);
                    new Robot();
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("1-arg constructor");
                try {
                    sm.prepareChecks(createRobot, readProperty);
                    new Robot(gd);
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

