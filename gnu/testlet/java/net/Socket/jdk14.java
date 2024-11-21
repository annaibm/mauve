/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.Socket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.Socket.ServerThread;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class jdk14
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        String host = "localhost";
        int port = 14610;
        Socket sock = null;
        ServerThread server = new ServerThread(harness, port);
        try {
            sock = new Socket();
            harness.check(sock.getPort(), 0, "unconnected socket getPort() should return 0");
            harness.check(sock.getLocalPort(), -1, "unbound socket getLocalPort() should return -1");
            harness.debug(host);
            sock = new Socket(host, port);
            harness.checkPoint("connect()");
            harness.checkPoint("bind()");
            harness.checkPoint("getRemoteSocketAddress()");
            harness.checkPoint("getLocalSocketAddress()");
            harness.checkPoint("getChannel");
            harness.checkPoint("sendUrgentData");
            harness.checkPoint("setOOBInline");
            harness.checkPoint("getOOBInline");
            harness.checkPoint("setTrafficClass()");
            harness.checkPoint("getTrafficClass()");
            harness.checkPoint("setReuseAddress()");
            harness.checkPoint("getReuseAddress()");
            harness.checkPoint("isConnected()");
            harness.checkPoint("isBound()");
            harness.checkPoint("isClosed()");
            harness.checkPoint("isInputShutdown()");
            harness.checkPoint("isOutputShutdown()");
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.fail("unexpected error: " + t.getMessage());
        }
        finally {
            try {
                if (sock != null) {
                    sock.close();
                }
                server.close();
            }
            catch (IOException iOException) {}
        }
        try {
            harness.checkPoint("bind to any local address");
            sock = new Socket();
            InetAddress ia = null;
            InetSocketAddress sa = new InetSocketAddress(ia, 30006);
            sock.bind(sa);
            harness.check(true);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.fail("unexpected error: bind() threw an exception");
        }
        finally {
            try {
                if (sock != null) {
                    sock.close();
                }
            }
            catch (IOException iOException) {}
        }
    }
}

