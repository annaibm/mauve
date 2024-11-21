/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.SocketPermission;
import java.security.Permission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("setup");
            InetAddress localhost = InetAddress.getLocalHost();
            String hostname = localhost.getHostName();
            harness.check(!hostname.equals(localhost.getHostAddress()));
            byte[] hostaddr = localhost.getAddress();
            Permission[] checkConnect = new Permission[]{new SocketPermission(hostname, "resolve")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("getHostName");
                try {
                    sm.prepareChecks(checkConnect);
                    InetAddress.getByAddress(hostaddr).getHostName();
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getCanonicalHostName");
                try {
                    sm.prepareChecks(checkConnect);
                    InetAddress.getByAddress(hostaddr).getCanonicalHostName();
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getByName");
                try {
                    sm.prepareChecks(checkConnect);
                    InetAddress.getByName(hostname);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getAllByName");
                try {
                    sm.prepareChecks(checkConnect);
                    InetAddress.getAllByName(hostname);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getLocalHost");
                try {
                    sm.prepareChecks(checkConnect);
                    InetAddress.getLocalHost();
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

