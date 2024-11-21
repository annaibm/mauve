/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.DatagramSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
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
            DatagramSocket socket1 = new DatagramSocket(0, inetaddr);
            DatagramSocket socket2 = new DatagramSocket(0, inetaddr);
            DatagramSocket socket3 = new DatagramSocket(0, inetaddr);
            DatagramSocket socket4 = new DatagramSocket(0, inetaddr);
            SocketAddress sock1addr = socket1.getLocalSocketAddress();
            InetAddress sock2addr = socket2.getLocalAddress();
            byte[] sendbuf = new byte[16];
            DatagramPacket sendpack = new DatagramPacket(sendbuf, sendbuf.length, socket3.getLocalSocketAddress());
            byte[] recvbuf = new byte[sendbuf.length];
            DatagramPacket recvpack = new DatagramPacket(recvbuf, recvbuf.length);
            Permission[] checkResolve = new Permission[]{new SocketPermission(hostaddr, "resolve")};
            Permission[] checkListen80 = new Permission[]{new SocketPermission("localhost:80", "listen")};
            Permission[] checkListen1024plus = new Permission[]{new SocketPermission("localhost:1024-", "listen")};
            Permission[] checkConnect1 = new Permission[]{new SocketPermission(hostaddr + ":" + socket1.getLocalPort(), "connect")};
            Permission[] checkAccept1 = new Permission[]{new SocketPermission(hostaddr + ":" + socket1.getLocalPort(), "accept")};
            Permission[] checkConnect2 = new Permission[]{new SocketPermission(hostaddr + ":" + socket2.getLocalPort(), "connect")};
            Permission[] checkAccept2 = new Permission[]{new SocketPermission(hostaddr + ":" + socket2.getLocalPort(), "accept")};
            Permission[] checkConnect3 = new Permission[]{new SocketPermission(hostaddr + ":" + socket3.getLocalPort(), "connect")};
            Permission[] checkAccept4 = new Permission[]{new SocketPermission(hostaddr + ":" + socket4.getLocalPort(), "accept")};
            Permission[] checkSetFactory = new Permission[]{new RuntimePermission("setFactory")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("DatagramSocket()");
                try {
                    sm.prepareChecks(checkListen1024plus);
                    new DatagramSocket().close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("DatagramSocket(SocketAddress)");
                try {
                    sm.prepareChecks(checkListen80);
                    try {
                        new DatagramSocket(new InetSocketAddress(inetaddr, 80)).close();
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
                    sm.prepareChecks(checkListen1024plus);
                    new DatagramSocket(new InetSocketAddress(inetaddr, 0)).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("DatagramSocket(int)");
                try {
                    sm.prepareChecks(checkListen80);
                    try {
                        new DatagramSocket(80).close();
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
                    sm.prepareChecks(checkListen1024plus);
                    new DatagramSocket(0).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("DatagramSocket(int, InetAddress)");
                try {
                    sm.prepareChecks(checkListen80);
                    try {
                        new DatagramSocket(80, inetaddr).close();
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
                    sm.prepareChecks(checkListen1024plus);
                    new DatagramSocket(0, inetaddr).close();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("connect");
                try {
                    sm.prepareChecks(checkConnect1, checkAccept1);
                    socket2.connect(sock1addr);
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                try {
                    sm.prepareChecks(checkConnect2, checkAccept2);
                    socket1.connect(sock2addr, socket2.getLocalPort());
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("send");
                try {
                    sm.prepareChecks(checkConnect3);
                    socket4.send(sendpack);
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("receive");
                try {
                    sm.prepareChecks(checkAccept4);
                    socket3.receive(recvpack);
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getLocalAddress");
                try {
                    sm.prepareChecks(checkResolve);
                    socket1.getLocalAddress();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getLocalSocketAddress");
                try {
                    sm.prepareChecks(checkResolve);
                    socket1.getLocalSocketAddress();
                    sm.checkAllChecked();
                }
                catch (SecurityException e) {
                    harness.debug(e);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("setDatagramSocketImplFactory");
                try {
                    sm.prepareHaltingChecks(checkSetFactory);
                    DatagramSocket.setDatagramSocketImplFactory(null);
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

