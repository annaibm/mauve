/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.ServerSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.net.BindException;
import java.net.InetAddress;
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
            String hostaddr = inetaddr.getHostAddress();
            ServerSocket ssocket = new ServerSocket(0, 50, inetaddr);
            int sport = ssocket.getLocalPort();
            Socket csocket = new Socket(inetaddr, sport, inetaddr, 0);
            int cport = csocket.getLocalPort();
            Permission[] checkListen80 = new Permission[]{new SocketPermission("localhost:80", "listen")};
            Permission[] checkListen1024plus = new Permission[]{new SocketPermission("localhost:1024-", "listen")};
            Permission[] checkAccept = new Permission[]{new SocketPermission(hostaddr + ":" + cport, "accept")};
            Permission[] checkSelectorProvider = new Permission[]{new RuntimePermission("selectorProvider")};
            Permission[] checkSetFactory = new Permission[]{new RuntimePermission("setFactory")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("ServerSocket(int)");
                try {
                    sm.prepareChecks(checkListen80, checkSelectorProvider);
                    try {
                        new ServerSocket(80).close();
                    }
                    catch (BindException bindException) {
                        // empty catch block
                    }
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                try {
                    sm.prepareChecks(checkListen1024plus, checkSelectorProvider);
                    new ServerSocket(0).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("ServerSocket(int, int)");
                try {
                    sm.prepareChecks(checkListen80, checkSelectorProvider);
                    try {
                        new ServerSocket(80, 50).close();
                    }
                    catch (BindException e) {
                        // empty catch block
                    }
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                try {
                    sm.prepareChecks(checkListen1024plus, checkSelectorProvider);
                    new ServerSocket(0, 50).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("ServerSocket(int, int, InetAddress)");
                try {
                    sm.prepareChecks(checkListen80, checkSelectorProvider);
                    try {
                        new ServerSocket(80, 50, inetaddr).close();
                    }
                    catch (BindException e) {
                        // empty catch block
                    }
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                try {
                    sm.prepareChecks(checkListen1024plus, checkSelectorProvider);
                    new ServerSocket(0, 50, inetaddr).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("accept");
                try {
                    sm.prepareChecks(checkAccept, checkSelectorProvider);
                    ssocket.accept().close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("setSocketFactory");
                try {
                    sm.prepareHaltingChecks(checkSetFactory);
                    ServerSocket.setSocketFactory(null);
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
                csocket.close();
                ssocket.close();
            }
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false, "Unexpected exception");
        }
    }
}

