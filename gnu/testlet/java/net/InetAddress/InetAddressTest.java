/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        harness.checkPoint("Basics");
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            harness.fail("Error : test_Basics failed - 0  Should not throw UnknownHostException here ");
        }
        harness.check(addr.getHostName() != null, "Error : test_Basics failed - 1 Should not return null as the host name ");
        harness.check(addr.getHostAddress() != null, "Error : test_Basics failed - 2 Should not return null as the host address ");
        harness.check(addr.hashCode() != 0, "Error : test_Basics failed - 3 Should not return 0 as the hashcode ");
        InetAddress addr1 = null;
        try {
            addr1 = InetAddress.getByName(addr.getHostName());
            harness.check(true);
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            harness.fail("Error : test_Basics failed - 4  Should not throw UnknownHostException here ");
        }
        harness.check(addr, addr1, "Error : test_Basics failed - 5 Both the addresses should be the same");
        harness.check(addr1.getHostAddress(), addr.getHostAddress(), "Error : test_Basics failed - 6 Should return the host addresses the same");
        InetAddress[] addr2 = null;
        try {
            addr2 = InetAddress.getAllByName(addr.getHostName());
            harness.check(true);
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            harness.fail("Error : test_Basics failed - 7  Should not throw UnknownHostException here ");
        }
        catch (Exception e) {
            e.printStackTrace();
            harness.fail("Error : test_Basics failed - 7  Should not throw Exception here ");
        }
        if (addr2.length < 1) {
            harness.fail("Error : test_Basics failed - 8 the address array should be of length 1 or larger");
        } else {
            harness.check(true);
        }
        harness.check(addr2[0], addr1, "Error : test_Basics failed - 9 Both the addresses should be the same");
        InetAddress addr3 = null;
        try {
            addr3 = InetAddress.getByName("savannah.gnu.org");
            harness.check(true);
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            harness.fail("Error : test_Basics failed - 10  Should not throw UnknownHostException here ");
        }
        try {
            harness.check(addr3.getHostName().equals("savannah.gnu.org") || addr3.getHostName().equals("savannah"), "test_Basics failed - 11  the hostname returned is not correct.");
        }
        catch (NullPointerException npe) {
            harness.check(false, "test_Basics failed - 11 - NullPointerException");
        }
        try {
            String toStr = addr3.toString();
            String toStr1 = addr3.getHostAddress();
            if (toStr.indexOf(toStr1) == -1) {
                harness.fail("Error : test_Basics failed - 12  the host address returned is not correct.");
            }
        }
        catch (NullPointerException npe) {
            harness.check(false, "test_Basics failed - 12 - NullPointerException");
        }
        InetAddress addr4 = null;
        try {
            addr4 = InetAddress.getByName("176.1.1.1");
        }
        catch (UnknownHostException e) {
            harness.fail("Error : test_Basics failed - 13  Should not throw UnknownHostException here ");
        }
        if (addr4.isMulticastAddress()) {
            harness.fail("Error : test_Basics failed - 14  Should have returned false here ");
        }
        InetAddress addr5 = null;
        try {
            addr5 = InetAddress.getByName("238.255.255.255");
        }
        catch (UnknownHostException e) {
            harness.fail("Error : test_Basics failed - 15  Should not throw UnknownHostException here ");
        }
        if (!addr5.isMulticastAddress()) {
            harness.fail("Error : test_Basics failed - 16  Should have returned true here ");
        }
        InetAddress addr6 = null;
        try {
            addr6 = InetAddress.getByName("224.0.0.1");
        }
        catch (UnknownHostException e) {
            harness.fail("Error : test_Basics failed - 17  Should not throw UnknownHostException here ");
        }
        if (!addr6.isMulticastAddress()) {
            harness.fail("Error : test_Basics failed - 18  Should have returned true here ");
        }
        InetAddress addr7 = null;
        try {
            addr7 = InetAddress.getByName("229.35.35.1");
        }
        catch (UnknownHostException e) {
            harness.fail("Error : test_Basics failed - 19  Should not throw UnknownHostException here ");
        }
        if (!addr7.isMulticastAddress()) {
            harness.fail("Error : test_Basics failed - 20  Should have returned true here ");
        }
        InetAddress addr8 = null;
        try {
            addr8 = InetAddress.getByName("127.0.0.1");
        }
        catch (UnknownHostException e) {
            harness.fail("Error : test_Basics failed - 21  Should not throw UnknownHostException here ");
        }
        if (!(addr8 instanceof Inet4Address)) {
            harness.fail("Error : test_Basics failed - 22  Should have returned true here ");
        }
    }

    public void testall() {
        this.test_Basics();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

