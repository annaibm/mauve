/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetSocketAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetSocketAddressTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Constructors() {
        harness.checkPoint("Constructors");
        InetSocketAddress sa = null;
        try {
            sa = new InetSocketAddress(InetAddress.getLocalHost(), 1234);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_Constructors failed - 0 Should not throw Exception here");
        }
        try {
            sa = new InetSocketAddress((InetAddress)null, 80);
            harness.check(sa.getAddress().toString().equals("0.0.0.0/0.0.0.0"), "Error : test_Constructors failed - 1 No wildcard address returned");
        }
        catch (Exception e) {
            harness.fail("Error : test_Constructors failed - 1 Unexpected Exception here");
        }
        try {
            sa = new InetSocketAddress(InetAddress.getLocalHost(), -1);
            harness.fail("Error: test_Contructors failed - 2 IllegalArgumentException expected here");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_Constructors failed - 2 Unexpected Exception here");
        }
        try {
            sa = new InetSocketAddress(InetAddress.getLocalHost(), 65536);
            harness.fail("Error: test_Contructors failed - 3 IllegalArgumentException expected here");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_Constructors failed - 3 Unexpected Exception here");
        }
        try {
            sa = new InetSocketAddress(-1);
            harness.fail("Error: test_Contructors failed - 4 IllegalArgumentException expected here");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_Constructors failed - 4 Unexpected Exception here");
        }
        try {
            sa = new InetSocketAddress(65536);
            harness.fail("Error: test_Contructors failed - 5 IllegalArgumentException expected here");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_Constructors failed - 5 Unexpected Exception here");
        }
        try {
            sa = new InetSocketAddress((String)null, 80);
            harness.fail("Error: test_Contructors failed - 7 IllegalArgumentException expected here");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_Constructors failed - 7 Unexpected Exception here");
        }
        try {
            sa = new InetSocketAddress("localhost", -1);
            harness.fail("Error: test_Contructors failed - 8 IllegalArgumentException expected here");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_Constructors failed - 8 Unexpected Exception here");
        }
        try {
            sa = new InetSocketAddress("localhost", 65536);
            harness.fail("Error: test_Contructors failed - 9 IllegalArgumentException expected here");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : test_Constructors failed - 9 Unexpected Exception here");
        }
    }

    public void test_Basics() {
        byte[] ipaddr;
        harness.checkPoint("Basics");
        InetSocketAddress sa = null;
        sa = new InetSocketAddress("localhost", 80);
        harness.check(sa.getPort() == 80, "Error : test_Basics failed - 1 Returned wrong port number");
        harness.check(sa.getHostName().equals("localhost"), "Error : test_Basics failed - 2 Returned wrong host name");
        try {
            ipaddr = new byte[]{127, 0, 0, 1};
            harness.check(sa.getAddress().equals(InetAddress.getByAddress("localhost", ipaddr)), "Error : test_Basics failed - 3 Returned wrong InetAdress object");
        }
        catch (UnknownHostException e) {
            harness.fail("Error : test_Basics failed - 3 Unexpected UnknownHostException");
        }
        try {
            ipaddr = new byte[]{1, 2, 3, 4};
            sa = new InetSocketAddress(InetAddress.getByAddress("foo.bar", ipaddr), 80);
            harness.check(!sa.isUnresolved(), "Error : test_Basics failed - 4 Unresolveable hostname got resolved");
        }
        catch (Exception e) {
            harness.fail("Error : test_Basics failed - 4 Unexpected UnknownHostException");
        }
        try {
            sa = new InetSocketAddress("gcc.gnu.org", 80);
            harness.check(!sa.isUnresolved(), "Error : test_Basics failed - 5 Resolveable hostname got not resolved");
        }
        catch (Exception e) {
            harness.fail("Error : test_Basics failed - 5 Unexpected UnknownHostException");
        }
    }

    public void testall() {
        this.test_Constructors();
        this.test_Basics();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

