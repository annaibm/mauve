/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.MulticastSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.MulticastSocket.MulticastClient;
import gnu.testlet.java.net.MulticastSocket.MulticastServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSocketTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        InetAddress address;
        MulticastSocket socket;
        int nPort = 0;
        try {
            socket = new MulticastSocket(4441);
            address = InetAddress.getByName("15.0.0.1");
            socket.joinGroup(address);
            harness.fail("Wrong ipaddress arg. - 1");
        }
        catch (IOException e) {
            harness.check(true);
        }
        try {
            socket = new MulticastSocket(-1);
            harness.fail("Wrong port arg. - 2");
            address = InetAddress.getByName("230.0.0.1");
            socket.joinGroup(address);
        }
        catch (Exception e) {
            harness.check(true);
        }
        try {
            socket = new MulticastSocket(0);
            address = InetAddress.getByName("230.0.0.1");
            socket.joinGroup(address);
            socket.leaveGroup(address);
            socket.close();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Correct args. - 3");
            harness.debug(e);
        }
        try {
            socket = new MulticastSocket();
            address = InetAddress.getByName("230.0.0.1");
            nPort = socket.getLocalPort();
            socket.joinGroup(address);
            socket.leaveGroup(address);
            socket.close();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Correct args. different constructor. - 4");
            harness.debug(e);
        }
        try {
            socket = new MulticastSocket(nPort);
            address = InetAddress.getByName("230.0.0.1");
            socket.joinGroup(address);
            socket.joinGroup(address);
            harness.fail("joinGroup() twice.");
        }
        catch (Exception e) {
            harness.check(true);
        }
        try {
            socket = new MulticastSocket(++nPort);
            address = InetAddress.getByName("230.0.0.1");
            socket.joinGroup(null);
            harness.fail("joinGroup() with incorrect params. - 5");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("joinGroup() with incorrect params. should have thrown a NullPointerException - 5a");
            harness.debug(e);
        }
        try {
            socket = new MulticastSocket(++nPort);
            address = InetAddress.getByName("230.0.0.1");
            socket.joinGroup(address);
            socket.leaveGroup(address);
            harness.check(true);
            socket.leaveGroup(address);
            harness.fail("leaveGroup() twice. - 6");
            socket.close();
        }
        catch (Exception e) {
            harness.check(true);
        }
        try {
            socket = new MulticastSocket(++nPort);
            address = InetAddress.getByName("230.0.0.1");
            socket.joinGroup(address);
            socket.leaveGroup(null);
            harness.fail("leaveGroup() with incorrect params - 7");
            socket.close();
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("leaveGroup() with incorrect params. should have thrown a NullPointerException - 7a");
            harness.debug(e);
        }
        try {
            socket = new MulticastSocket(++nPort);
            address = InetAddress.getByName("230.0.0.1");
            socket.joinGroup(address);
            socket.leaveGroup(address);
            socket.close();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Correct args. - 8");
            harness.debug(e);
        }
        try {
            socket = new MulticastSocket(++nPort);
            address = InetAddress.getByName("230.0.0.1");
            socket.joinGroup(address);
            byte bTTL = socket.getTTL();
            harness.check(bTTL != 0, "getTTL() should never return zero - 9");
            byte newbTTL = 127;
            socket.setTTL(newbTTL);
            bTTL = socket.getTTL();
            harness.check(bTTL, newbTTL, "getTTL() should return same value (127) used for setTTL() - 10");
            bTTL = -56;
            socket.setTTL(bTTL);
            bTTL = socket.getTTL();
            socket.setTTL((byte)1);
            socket.leaveGroup(address);
            socket.close();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Should not have thrown any exception - 11");
            harness.debug(e);
        }
    }

    public void test_MultipleBind() {
        int sharedMcastPort = 1234;
        try {
            MulticastSocket firstMcastSock = new MulticastSocket(1234);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("could not create FIRST multicast socket on shared port 1234");
            harness.debug(e);
        }
        try {
            MulticastSocket secondMcastSock = new MulticastSocket(1234);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("could not create SECOND multicast socket on shared port 1234");
            harness.debug(e);
        }
    }

    public void test_Comm() {
        try {
            MulticastClient client = new MulticastClient();
            client.start();
            MulticastServer server = new MulticastServer(4446);
            server.start();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("test_Comm failed");
            harness.debug(e);
        }
    }

    public void testall() {
        this.test_Basics();
        this.test_MultipleBind();
        this.test_Comm();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

