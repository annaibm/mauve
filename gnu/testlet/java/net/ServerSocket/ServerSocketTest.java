/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.ServerSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.ServerSocket.BasicBacklogSocketServer;
import gnu.testlet.java.net.ServerSocket.BasicSocketServer;
import gnu.testlet.java.net.ServerSocket.MyBasicSocketServer;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerSocketTest
implements Testlet {
    protected static TestHarness harness;
    private static final boolean USE_JOIN = false;

    private boolean completed(Thread thread2) {
        try {
            for (int i = 0; i < 5 && thread2.isAlive(); ++i) {
                Thread.sleep(1000L);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return !thread2.isAlive();
    }

    public void test_BasicBacklogServer() {
        Socket sock;
        BasicBacklogSocketServer srv = new BasicBacklogSocketServer();
        srv.init(harness);
        srv.start();
        Thread.yield();
        try {
            sock = new Socket("127.0.0.1", 21000);
            DataInputStream dis = new DataInputStream(sock.getInputStream());
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_BasicBacklogServer failed - 2 exception was thrown " + e);
        }
        try {
            sock = new Socket("127.0.0.1", 21000);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_BasicBacklogServer failed - 3 exception was thrown " + e);
        }
        try {
            sock = new Socket("127.0.0.1", 21000);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_BasicBacklogServer failed - 4 exception was thrown " + e);
        }
        harness.check(this.completed(srv), "Error : test_BasicBacklogServer failed - 5 server didn't end");
    }

    public void test_BasicServer() {
        String str;
        DataInputStream dis;
        Socket sock;
        harness.checkPoint("BasicServer");
        BasicSocketServer srv = new BasicSocketServer();
        srv.init(harness);
        srv.start();
        Thread.yield();
        try {
            sock = new Socket("127.0.0.1", 12000);
            dis = new DataInputStream(sock.getInputStream());
            str = dis.readLine();
            harness.check(str.equals("hello buddy"), "Error : test_BasicServer failed - 1 string returned is not correct.");
            sock.close();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_BasicServer failed - 2 exception was thrown: " + e.getMessage());
        }
        try {
            sock = new Socket("127.0.0.1", 12000);
            dis = new DataInputStream(sock.getInputStream());
            str = dis.readLine();
            harness.check(str.equals("hello buddy"), "Error : test_BasicServer failed - 3 string returned is not correct.");
            sock.close();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_BasicServer failed - 4 exception was thrown: " + e.getMessage());
        }
        if (!this.completed(srv)) {
            harness.fail("Error : test_BasicServer failed - 5  server didn't end ");
            try {
                srv.srvsock.close();
            }
            catch (Exception e) {
                harness.fail("Error : test_BasicServer failed - 6  exception in close: " + e.getMessage());
            }
            if (!this.completed(srv)) {
                harness.fail("Error : test_BasicServer failed - 7 server didn't end when its socket was closed");
                try {
                    srv.interrupt();
                }
                catch (Exception e) {
                    harness.fail("Error : test_BasicServer failed - 8  exception in interrupt: " + e.getMessage());
                }
                if (!this.completed(srv)) {
                    harness.fail("Error : test_BasicServer failed - 9 server didn't end when interrupted");
                }
            }
        } else {
            harness.check(true);
        }
    }

    public void test_MyBasicServer() {
        MyBasicSocketServer srv = new MyBasicSocketServer();
        srv.init(harness);
        srv.start();
        Thread.yield();
        try {
            Socket socket = new Socket("127.0.0.1", 12000);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void test_params() {
        ServerSocket sock = null;
        try {
            sock = new ServerSocket(30000);
            harness.check(sock.getLocalPort() == 30000, "Error : test_params failed - 1 get port did not return proper values");
            try {
                ServerSocket sock1 = new ServerSocket(30000);
                harness.fail("Error : test_params failed - 3 should have thrown bind exception here.");
            }
            catch (IOException e) {
                harness.check(true);
            }
            String ip = "0.0.0.0";
            harness.check(sock.toString().indexOf(ip) != -1, "toString() should contain IP");
            InetAddress addr = sock.getInetAddress();
            if (addr == null) {
                harness.fail("Error : test_params failed - 4 sock.getInetAddress() -> null");
            } else {
                harness.check(addr.toString().indexOf(ip) != -1, "InetAddress toString() should contain IP");
            }
            ServerSocket.setSocketFactory(null);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_params failed - 10 exception was thrown");
            harness.debug(e);
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

    public void test_close() {
        try {
            harness.checkPoint("test_close");
            ServerSocket s = new ServerSocket(0);
            harness.check(s.isBound());
            harness.check(!s.isClosed());
            int port = s.getLocalPort();
            InetAddress address = s.getInetAddress();
            SocketAddress sockAddress = s.getLocalSocketAddress();
            s.close();
            harness.check(s.isBound());
            harness.check(s.isClosed());
            harness.check(port == s.getLocalPort());
            harness.check(address.equals(s.getInetAddress()));
            harness.check(sockAddress.equals(s.getLocalSocketAddress()));
        }
        catch (Exception e) {
            harness.fail("Unexpected exception");
            harness.debug(e);
        }
    }

    public void testall() {
        this.test_BasicServer();
        this.test_MyBasicServer();
        this.test_BasicBacklogServer();
        this.test_params();
        this.test_close();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

