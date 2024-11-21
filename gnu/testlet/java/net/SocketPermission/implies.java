/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.SocketPermission;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.SocketPermission;
import java.net.UnknownHostException;

public class implies
implements Testlet {
    static String redhat_com_addr = null;
    private Test[] hosts = new Test[]{new Test("", "", false), new Test("localhost", "localhost", true), new Test("127.0.0.1", "localhost", true), new Test("localhost", "127.0.0.1", true), new Test("www.redhat.com", "www.redhat.com", true), new Test("*.redhat.com", "www.redhat.com", true), new Test("www.redhat.com", "*.redhat.com", false), new Test(redhat_com_addr, redhat_com_addr, true), new Test("www.redhat.com", redhat_com_addr, true), new Test(redhat_com_addr, "www.redhat.com", true), new Test("*.redhat.com", redhat_com_addr, true), new Test(redhat_com_addr, "*.redhat.com", false), new Test("209.132.177.50", "209.132.177.51", false), new Test("209.132.177.50", "209.132.178.50", false), new Test("209.132.177.50", "209.130.177.50", false), new Test("209.132.177.50", "208.132.177.50", false), new Test("[FEDC:BA98:7654:3210:FEDC:BA98:7654:3210]", "[FEDC:BA98:7654:3210:FEDC:BA98:7654:3210]", true), new Test("[FEDC:BA98:7654:3210:FEDC:BA98:7654:3210]", "FEDC:BA98:7654:3210:FEDC:BA98:7654:3210", true), new Test("FEDC:BA98:7654:3210:FEDC:BA98:7654:3210", "[FEDC:BA98:7654:3210:FEDC:BA98:7654:3210]", true), new Test("FEDC:BA98:7654:3210:FEDC:BA98:7654:3210", "FEDC:BA98:7654:3210:FEDC:BA98:7654:3210", true), new Test("[FEDC:BA98:7654:3210:FEDC:BA98:7654:3210]", "[fedc:ba98:7654:3210:fedc:ba98:7654:3210]", true), new Test("[FEDC:Bb98:7654:3210:FEDC:BA98:7654:3210]", "[FEDC:BA98:7654:3210:FEDC:BA98:7654:3210]", false), new Test("[1080:0:0:0:8:800:200C:417A]", "[1080:0000:0:0:8:800:200C:417A]", true), new Test("[1080::8:800:200C:417A]", "[1080::8:800:200C:417A]", true), new Test("[1080::8:800:200C:417A]", "[1080::8:800:200C:417a]", true), new Test("[1080::8:800:200C:417A]", "[1080:0:0:0:8:800:200C:417A]", true), new Test("[1080:0:0:0:8:800:200C:417A]", "[1080::8:800:200C:417A]", true), new Test("[1080::8:800:200C:417B]", "[1080:0:0:0:8:800:200C:417A]", false), new Test("[1080:0:0:0:8:800:200C:417A]", "[1080::8:800:200C:417B]", false), new Test("[FF01::101]", "[FF01:0:0:0:0:0:0:101]", true), new Test("[FF01:0:0:0:0:0:0:101]", "[FF01::101]", true), new Test("[::1]", "[0:0:0:0:0:0:0:1]", true), new Test("[0:0:0:0:0:0:0:1]", "[::1]", true), new Test("[::]", "[0:0:0:0:0:0:0:0]", true), new Test("[0:0:0:0:0:0:0:0]", "[::]", true), new Test("[0:0:0:0:0:0:13.1.68.3]", "[0:0:0:0:0:0:13.1.68.3]", true), new Test("[::13.1.68.3]", "[0:0:0:0:0:0:13.1.68.3]", true), new Test("[0:0:0:0:0:0:13.1.68.3]", "[::13.1.68.3]", true), new Test("[::13.1.68.3]", "[::13.1.68.3]", true), new Test("[::13.1.68.3]", "[::D01:4403]", true), new Test("[::D01:4403]", "[::13.1.68.3]", true), new Test("[::D01:4403]", "[::D01:4403]", true), new Test("[::D01:4403]", "[0:0:0:0:0:0:13.1.68.3]", true), new Test("[0:0:0:0:0:0:13.1.68.3]", "[::D01:4403]", true), new Test("[0:0:0:0:0:FFFF:129.144.52.38]", "[0:0:0:0:0:FFFF:129.144.52.38]", true), new Test("[::FFFF:129.144.52.38]", "[0:0:0:0:0:FFFF:129.144.52.38]", true), new Test("[0:0:0:0:0:FFFF:129.144.52.38]", "[::FFFF:129.144.52.38]", true), new Test("[::FFFF:129.144.52.38]", "[::FFFF:129.144.52.38]", true), new Test("[::13.1.68.3]", "[::FFFF:13.1.68.3]", false), new Test("[::FFFF:13.1.68.3]", "[::13.1.68.3]", false), new Test("[::FFFF:13.1.68.3]", "13.1.68.3", true), new Test("13.1.68.3", "[::FFFF:13.1.68.3]", true), new Test("[::FFFF:D01:4403]", "13.1.68.3", true), new Test("13.1.68.3", "[::FFFF:D01:4403]", true), new Test("[::13.1.68.3]", "13.1.68.3", false), new Test("13.1.68.3", "[::13.1.68.3]", false), new Test("[::D01:4403]", "13.1.68.3", false), new Test("13.1.68.3", "[::D01:4403]", false), new Test("13.1.68.3", "13.1.17411", true), new Test("13.1.17411", "13.1.68.3", true), new Test("13.1.68.3", "13.82947", true), new Test("13.82947", "13.1.68.3", true), new Test("13.1.68.3", "13.82947", true), new Test("13.1.68.3", String.valueOf(218186755), true), new Test(String.valueOf(218186755), "13.1.68.3", true)};
    private Test[] ports = new Test[]{new Test("", "", true), new Test("", ":80", true), new Test("", ":-80", true), new Test("", ":80-", true), new Test("", ":70-90", true), new Test(":80", "", false), new Test(":80", ":70", false), new Test(":80", ":80", true), new Test(":80", ":-80", false), new Test(":80", ":80-", false), new Test(":80", ":70-90", false), new Test(":80", ":80-80", true), new Test(":80", ":90-90", false), new Test(":-80", "", false), new Test(":-80", ":70", true), new Test(":-80", ":80", true), new Test(":-80", ":90", false), new Test(":-80", ":-70", true), new Test(":-80", ":-80", true), new Test(":-80", ":-90", false), new Test(":-80", ":70-", false), new Test(":-80", ":80-", false), new Test(":-80", ":90-", false), new Test(":-80", ":60-70", true), new Test(":-80", ":70-90", false), new Test(":-80", ":90-100", false), new Test(":-80", ":70-70", true), new Test(":-80", ":80-80", true), new Test(":-80", ":90-90", false), new Test(":80-", "", false), new Test(":80-", ":70", false), new Test(":80-", ":80", true), new Test(":80-", ":90", true), new Test(":80-", ":-70", false), new Test(":80-", ":-80", false), new Test(":80-", ":-90", false), new Test(":80-", ":70-", false), new Test(":80-", ":80-", true), new Test(":80-", ":90-", true), new Test(":80-", ":60-70", false), new Test(":80-", ":70-90", false), new Test(":80-", ":90-100", true), new Test(":80-", ":70-70", false), new Test(":80-", ":80-80", true), new Test(":80-", ":90-90", true), new Test(":75-85", "", false), new Test(":75-85", ":70", false), new Test(":75-85", ":80", true), new Test(":75-85", ":90", false), new Test(":75-85", ":-70", false), new Test(":75-85", ":-80", false), new Test(":75-85", ":-90", false), new Test(":75-85", ":70-", false), new Test(":75-85", ":80-", false), new Test(":75-85", ":90-", false), new Test(":75-85", ":70-80", false), new Test(":75-85", ":75-85", true), new Test(":75-85", ":80-90", false), new Test(":75-85", ":70-90", false), new Test(":75-85", ":70-70", false), new Test(":75-85", ":80-80", true), new Test(":75-85", ":90-90", false), new Test(":80", ":65616", false), new Test(":80", ":-65456", false)};
    private static String[] actions;

    @Override
    public void test(TestHarness harness) {
        int j;
        int i;
        harness.checkPoint("hostport checking");
        harness.check(redhat_com_addr != null);
        for (i = 0; i < this.hosts.length; ++i) {
            for (j = 0; j < this.ports.length; ++j) {
                Test test = new Test(this.hosts[i], this.ports[j]);
                SocketPermission px = new SocketPermission(test.x, "connect");
                SocketPermission py = new SocketPermission(test.y, "connect");
                try {
                    harness.check(px.implies(py) == test.expect, test.x + " should" + (test.expect ? "" : " not") + " imply " + test.y);
                    continue;
                }
                catch (Exception e) {
                    harness.check(false, test.x + " implies " + test.y + " failed");
                    harness.debug(e);
                }
            }
        }
        harness.checkPoint("actions checking");
        for (i = 1; i < 1 << actions.length; ++i) {
            for (j = 1; j < 1 << actions.length; ++j) {
                SocketPermission pi = new SocketPermission("localhost", implies.makeAction(i));
                SocketPermission pj = new SocketPermission("localhost", implies.makeAction(j));
                harness.check(pi.implies(pj) == ((implies.maybeAddResolve(i) & j) == j));
            }
        }
    }

    private static String makeAction(int mask) {
        String result = "";
        for (int i = 0; i < actions.length; ++i) {
            if ((mask & 1 << i) == 0) continue;
            if (result.length() > 0) {
                result = result + ",";
            }
            result = result + actions[i];
        }
        return result;
    }

    private static int maybeAddResolve(int mask) {
        boolean addit = false;
        int addwhat = 0;
        for (int i = 0; i < actions.length; ++i) {
            if (actions[i].equals("resolve")) {
                addwhat = 1 << i;
                continue;
            }
            if ((mask & 1 << i) == 0) continue;
            addit = true;
        }
        if (addit) {
            mask |= addwhat;
        }
        return mask;
    }

    static {
        try {
            redhat_com_addr = InetAddress.getByName("www.redhat.com").getHostAddress();
        }
        catch (UnknownHostException unknownHostException) {
            // empty catch block
        }
        actions = new String[]{"accept", "connect", "listen", "resolve"};
    }

    private static class Test {
        String x;
        String y;
        boolean expect;

        Test(String x, String y, boolean expect) {
            this.x = x;
            this.y = y;
            this.expect = expect;
        }

        Test(Test host, Test port) {
            this.x = host.x + port.x;
            this.y = host.y + port.y;
            this.expect = this.x.length() == 0 && this.y.length() == 0 ? true : host.expect && port.expect;
        }
    }
}

