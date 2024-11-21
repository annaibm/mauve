/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.NetworkInterface;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketPermission;
import java.security.Permission;
import java.util.Enumeration;
import java.util.LinkedList;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("setup");
            LinkedList<InetAddress> list2 = new LinkedList<InetAddress>();
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface nif = e.nextElement();
                Enumeration<InetAddress> f = nif.getInetAddresses();
                while (f.hasMoreElements()) {
                    list2.add(f.nextElement());
                }
            }
            harness.check(!list2.isEmpty());
            Permission[] checks = new Permission[list2.size()];
            for (int i = 0; i < list2.size(); ++i) {
                InetAddress addr = (InetAddress)list2.get(i);
                checks[i] = new SocketPermission(addr.getHostAddress(), "resolve");
            }
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("getInetAddresses");
                try {
                    sm.prepareChecks(checks);
                    Enumeration<NetworkInterface> e2 = NetworkInterface.getNetworkInterfaces();
                    while (e2.hasMoreElements()) {
                        NetworkInterface nif = e2.nextElement();
                        nif.getInetAddresses();
                    }
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

