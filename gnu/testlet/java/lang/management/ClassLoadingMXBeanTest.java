/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.management;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.lang.management.BadGuy;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

public class ClassLoadingMXBeanTest
implements Testlet {
    private BadGuy bg = new BadGuy();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        try {
            Exception caught = null;
            ClassLoadingMXBean bean = ManagementFactory.getClassLoadingMXBean();
            this.bg.install();
            caught = null;
            try {
                bean.setVerbose(true);
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "verbose");
        }
        finally {
            this.bg.uninstall();
        }
    }
}

