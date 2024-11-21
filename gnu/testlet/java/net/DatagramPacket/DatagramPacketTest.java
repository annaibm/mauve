/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.DatagramPacket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DatagramPacketTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        byte[] b = new byte[]{97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108};
        harness.checkPoint("test_Basics");
        DatagramPacket packet = new DatagramPacket(b, 10);
        harness.check(packet.getAddress(), null, "Error : test_Basics failed - 1 The getAddress should return null since no address is assigned yet");
        harness.check(packet.getLength(), 10, "Error : test_Basics failed - 2 The getLength should return the number of bytes to be sent/received");
        String str = new String(packet.getData());
        harness.check(str, "abcdefghijkl", "Error : test_Basics failed - 3 The getData should return actual bytes to be sent/received");
        packet.setPort(1000);
        harness.check(packet.getPort(), 1000, "Error : test_Basics failed - 4 The getPort should return actual port to which it is set");
        packet.setLength(3);
        harness.check(packet.getLength(), 3, "Error : test_Basics failed - 5 The getLength should return the number of bytes to be sent/received");
        byte[] b1 = new byte[]{104, 104, 105, 106};
        packet.setData(b1);
        String str1 = new String(packet.getData());
        harness.check(str1, "hhij", "Error : test_Basics failed - 6 The getData should return actual bytes to be sent/received");
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
            harness.check(true);
        }
        catch (UnknownHostException e) {
            harness.fail("Error : test_Basics failed - 7 The getLocalHost should not raise UnknownHostException in this case");
        }
        packet.setAddress(addr);
        harness.check(packet.getAddress(), addr, "Error : test_Basics failed - 8 The getAddress should return the value that is assigned to it");
    }

    public void test_Basics1() {
        byte[] b = new byte[]{97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108};
        harness.checkPoint("test_Basics1");
        InetAddress addr0 = null;
        try {
            addr0 = InetAddress.getLocalHost();
            harness.check(true);
        }
        catch (UnknownHostException e) {
            harness.fail("Error : test_Basics1 failed - 0 The getLocalHost should not raise UnknownHostException in this case");
        }
        DatagramPacket packet = new DatagramPacket(b, 10, addr0, 2000);
        harness.check(packet.getAddress() != null, "Error : test_Basics1 failed - 1 The getAddress should return not return null since address is assigned");
        harness.check(packet.getLength() == 10 && packet.getPort() == 2000, "Error : test_Basics1 failed - 2 The getLength and getPort should return the number of bytes to be sent/receive and the port set respectively");
        String str = new String(packet.getData());
        harness.check(str, "abcdefghijkl", "Error : test_Basics1 failed - 3 The getData should return actual bytes to be sent/received");
        packet.setPort(1000);
        harness.check(packet.getPort(), 1000, "Error : test_Basics1 failed - 4 The getPort should return actual port to which it is set");
        packet.setLength(3);
        harness.check(packet.getLength(), 3, "Error : test_Basics1 failed - 5 The getLength should return the number of bytes to be sent/received");
        byte[] b1 = new byte[]{104, 104, 105, 106};
        packet.setData(b1);
        String str1 = new String(packet.getData());
        harness.check(str1, "hhij", "Error : test_Basics1 failed - 6 The getData should return actual bytes to be sent/received");
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
            harness.check(true);
        }
        catch (UnknownHostException e) {
            harness.fail("Error : test_Basics1 failed - 7 The getLocalHost should not raise UnknownHostException in this case");
        }
        packet.setAddress(addr);
        harness.check(packet.getAddress(), addr, "Error : test_Basics1 failed - 8 The getAddress should return the value that is assigned to it");
    }

    public void testall() {
        this.test_Basics();
        this.test_Basics1();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

