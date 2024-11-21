/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.management;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.lang.management.BadGuy;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class OperatingSystemMXBeanTest
implements Testlet {
    private BadGuy bg = new BadGuy();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        try {
            Exception caught = null;
            OperatingSystemMXBean bean = ManagementFactory.getOperatingSystemMXBean();
            this.bg.install();
            caught = null;
            try {
                bean.getName();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "name");
            caught = null;
            try {
                bean.getArch();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "arch");
            caught = null;
            try {
                bean.getVersion();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "version");
        }
        finally {
            this.bg.uninstall();
        }
    }
}

