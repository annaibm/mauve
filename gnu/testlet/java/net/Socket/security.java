/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.Socket;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
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
            InetAddress inetaddr = InetAddress.getByName(null);
            String hostname = inetaddr.getHostName();
            String hostaddr = inetaddr.getHostAddress();
            harness.check(!hostname.equals(hostaddr));
            ServerSocket socket = new ServerSocket(0, 50, inetaddr);
            int hostport = socket.getLocalPort();
            InetSocketAddress sockaddr = new InetSocketAddress(inetaddr, hostport);
            Permission[] checkConnect = new Permission[]{new SocketPermission(hostaddr + ":" + hostport, "connect")};
            Permission[] checkResolveConnect = new Permission[]{new SocketPermission(hostname, "resolve"), new SocketPermission(hostaddr + ":" + hostport, "connect")};
            Permission[] checkSelectorProvider = new Permission[]{new RuntimePermission("selectorProvider")};
            Permission[] checkSetFactory = new Permission[]{new RuntimePermission("setFactory")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                int i;
                sm.install();
                try {
                    harness.checkPoint("Socket(InetAddress, int)");
                    sm.prepareChecks(checkConnect, checkSelectorProvider);
                    new Socket(inetaddr, hostport).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("Socket(String, int)");
                try {
                    sm.prepareChecks(checkConnect, checkSelectorProvider);
                    new Socket(hostaddr, hostport).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                try {
                    sm.prepareChecks(checkResolveConnect, checkSelectorProvider);
                    new Socket(hostname, hostport).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("Socket(InetAddress, int, boolean)");
                for (i = 0; i < 2; ++i) {
                    try {
                        sm.prepareChecks(checkConnect, checkSelectorProvider);
                        new Socket(inetaddr, hostport, i == 0).close();
                        sm.checkAllChecked();
                        continue;
                    }
                    catch (SecurityException e) {
                        harness.debug(e);
                        harness.check(false, "unexpected check");
                    }
                }
                harness.checkPoint("Socket(String, int, boolean)");
                for (i = 0; i < 2; ++i) {
                    try {
                        sm.prepareChecks(checkConnect, checkSelectorProvider);
                        new Socket(hostaddr, hostport, i == 0).close();
                        sm.checkAllChecked();
                    }
                    catch (SecurityException e) {
                        harness.debug(e);
                        harness.check(false, "unexpected check");
                    }
                    try {
                        sm.prepareChecks(checkResolveConnect, checkSelectorProvider);
                        new Socket(hostname, hostport, i == 0).close();
                        sm.checkAllChecked();
                        continue;
                    }
                    catch (SecurityException e) {
                        harness.debug(e);
                        harness.check(false, "unexpected check");
                    }
                }
                harness.checkPoint("Socket(InetAddress, int, InetAddress, int)");
                try {
                    sm.prepareChecks(checkConnect, checkSelectorProvider);
                    new Socket(inetaddr, hostport, inetaddr, 0).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("Socket(String, int, InetAddress, int)");
                try {
                    sm.prepareChecks(checkConnect, checkSelectorProvider);
                    new Socket(hostaddr, hostport, inetaddr, 0).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                try {
                    sm.prepareChecks(checkResolveConnect, checkSelectorProvider);
                    new Socket(hostname, hostport, inetaddr, 0).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("connect(InetSocketAddress)");
                try {
                    sm.prepareChecks(checkConnect, checkSelectorProvider);
                    Socket sock = new Socket();
                    sock.connect(sockaddr, hostport);
                    sock.close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("setSocketImplFactory");
                try {
                    sm.prepareHaltingChecks(checkSetFactory);
                    Socket.setSocketImplFactory(null);
                    harness.check(false);
                }
                catch (TestSecurityManager.SuccessException ex) {
                    harness.check(true);
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
        catch (Exception e) {
            harness.debug(e);
            harness.check(false, "Unexpected exception");
        }
    }
}

