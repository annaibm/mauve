/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.management;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.lang.management.BadGuy;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class RuntimeMXBeanTest
implements Testlet {
    private BadGuy bg = new BadGuy();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        try {
            Exception caught = null;
            RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
            this.bg.install();
            caught = null;
            try {
                bean.getVmName();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "vmName");
            caught = null;
            try {
                bean.getVmVendor();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "vmVendor");
            caught = null;
            try {
                bean.getVmVersion();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "vmVersion");
            caught = null;
            try {
                bean.getSpecName();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "specName");
            caught = null;
            try {
                bean.getSpecVendor();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "specVendor");
            caught = null;
            try {
                bean.getSpecVersion();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "specVersion");
            caught = null;
            try {
                bean.getClassPath();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "classPath");
            caught = null;
            try {
                bean.getLibraryPath();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "libraryPath");
            caught = null;
            try {
                bean.getBootClassPath();
            }
            catch (Exception ex) {
                caught = ex;
            }
            if (bean.isBootClassPathSupported()) {
                h.check(caught instanceof SecurityException, "bootClassPath");
            } else {
                h.check(caught instanceof UnsupportedOperationException, "bootClassPath");
            }
            caught = null;
            try {
                bean.getInputArguments();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "inputArguments");
            caught = null;
            try {
                bean.getSystemProperties();
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "systemProperties");
        }
        finally {
            this.bg.uninstall();
        }
    }
}

