/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.DatagramSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.DatagramSocket.DatagramSocketTestEchoServer;
import gnu.testlet.java.net.DatagramSocket.DatagramSocketTestEchoTimeoutServer;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class DatagramSocketTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        harness.checkPoint("Basics");
        try {
            DatagramSocket sock1 = new DatagramSocket(7000);
            harness.check(sock1.getLocalPort(), 7000, "Error : test_Basics failed - 1 returned port value is wrong");
        }
        catch (SocketException e) {
            harness.fail("Error : test_Basics failed - 2 Not able to create a socket ");
        }
        catch (IllegalArgumentException e) {
            harness.fail("Error : test_Basics failed - 3a Port 7000 causes IllegalArgumentException");
        }
        catch (Exception e) {
            harness.fail("Error : test_Basics failed - 3b ");
            harness.debug(e);
        }
        try {
            DatagramSocket sock3 = new DatagramSocket(7001, InetAddress.getLocalHost());
            harness.check(sock3.getLocalAddress().getHostAddress(), InetAddress.getLocalHost().getHostAddress(), "Error : test_Basics failed - 4 ip address returned is not correct ");
        }
        catch (SocketException e) {
            harness.fail("Error : test_Basics failed - 5 Not able to create a socket ");
        }
        catch (UnknownHostException e) {
            harness.fail("Error : test_Basics failed - 6 Should not throw UnknownHostException ");
        }
        catch (IllegalArgumentException e) {
            harness.fail("Error : test_Basics failed - 7 Port 7001 causes IllegalArgumentException");
        }
        catch (Exception e) {
            harness.fail("Error : test_Basics failed - 8 ");
            harness.debug(e);
        }
    }

    public void test_echo() {
        DatagramSocketTestEchoServer srv = new DatagramSocketTestEchoServer();
        srv.setDaemon(true);
        srv.setPriority(10);
        srv.start();
        Thread.yield();
        try {
            Thread.sleep(2000L);
        }
        catch (Exception exception) {
            // empty catch block
        }
        byte[] buff = new byte[]{104, 101, 108, 108, 111, 98, 117, 100, 100, 121};
        DatagramSocket client = null;
        DatagramPacket request = null;
        try {
            client = new DatagramSocket();
            request = new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), 8000);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_echo failed - 0 Should not throw Exception ");
        }
        byte[] resp = new byte[10];
        DatagramPacket reply = new DatagramPacket(resp, resp.length);
        if (client == null) {
            return;
        }
        if (request == null) {
            return;
        }
        try {
            client.send(request);
            try {
                Thread.sleep(1000L);
            }
            catch (Exception exception) {
                // empty catch block
            }
            client.receive(reply);
            client.close();
            try {
                byte[] resp1 = new byte[10];
                DatagramPacket reply1 = new DatagramPacket(resp1, resp1.length);
                client.receive(reply1);
                harness.fail("Error : test_echo failed - 2 IOException should be thrown if try to read after the socket is closed");
            }
            catch (IOException e) {
                harness.check(true);
            }
        }
        catch (Exception e) {
            harness.fail("Error : test_echo failed - 3 Exception occured while sending/receiving ");
        }
        harness.check(reply.getLength(), 10, "Error : test_echo failed - 4 server did not return proper number of bytes ");
        harness.check(new String(reply.getData()), "hellobuddy", "Error : test_echo - 5 failed The echo server did not send the expected data ");
    }

    public void test_echoWithTimeout() {
        DatagramSocketTestEchoTimeoutServer srv = new DatagramSocketTestEchoTimeoutServer();
        srv.setDaemon(true);
        srv.setPriority(10);
        srv.start();
        Thread.yield();
        try {
            Thread.sleep(2000L);
        }
        catch (Exception exception) {
            // empty catch block
        }
        byte[] buff = new byte[]{104, 101, 108, 108, 111, 98, 117, 100, 100, 121};
        DatagramSocket client = null;
        DatagramPacket request = null;
        try {
            client = new DatagramSocket();
            request = new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), 8001);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_echoWithTimeout failed - 0 Should not throw Exception ");
        }
        if (client == null) {
            return;
        }
        if (request == null) {
            return;
        }
        try {
            client.setSoTimeout(500);
            harness.check(true);
        }
        catch (SocketException e) {
            harness.fail("Error : test_echoWithTimeout failed - 1 Should not throw SocketException ");
        }
        try {
            harness.check(client.getSoTimeout(), 500, "Error : test_echoWithTimeout failed - 2 did not return proper timeout value ");
        }
        catch (SocketException e) {
            harness.fail("Error : test_echoWithTimeout failed - 3 Should not throw SocketException ");
        }
        byte[] resp = new byte[10];
        DatagramPacket reply = new DatagramPacket(resp, resp.length);
        try {
            client.send(request);
            client.receive(reply);
            try {
                client.setSoTimeout(1);
                client.receive(reply);
                harness.fail("Error : test_echoWithTimeout failed - 2 Should throw interrupted exception after the specified duration");
            }
            catch (InterruptedIOException e) {
                harness.check(true);
            }
            catch (IOException ioe) {
                harness.debug(ioe);
                harness.check(false);
            }
            client.close();
            try {
                byte[] resp1 = new byte[10];
                DatagramPacket reply1 = new DatagramPacket(resp1, resp1.length);
                client.receive(reply1);
                harness.fail("Error : test_echoWithTimeout failed - 4 IOException should be thrown if try to read after the socket is closed");
            }
            catch (IOException e) {
                harness.check(true);
            }
        }
        catch (Exception e) {
            harness.fail("Error : test_echoWithTimeout failed - 5 Exception occured while sending/receiving ");
            harness.debug(e);
        }
        harness.check(reply.getLength(), 10, "Error : test_echoWithTimeout failed - 6 server did not return proper number of bytes ");
        harness.check(new String(reply.getData()), "hellobuddy", "Error : test_echoWithTimeout - 7 failed The echo server didnot send the expected data ");
    }

    public void testall() {
        this.test_Basics();
        this.test_echo();
        this.test_echoWithTimeout();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

