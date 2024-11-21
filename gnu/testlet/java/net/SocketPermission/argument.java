/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.SocketPermission;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.SocketPermission;

public class argument
implements Testlet {
    private Test[] hosts = new Test[]{new Test("", true), new Test("local:host", false), new Test("localhost", true), new Test("example.com", true), new Test("*.com", true), new Test("209.132:177.50", false), new Test("209.132.177.50", true), new Test("[", false), new Test("[::192.9.5.5]3", false), new Test("[FEDC:BA98:7654:3210:FEDC:BA98:7654:3210]", true), new Test("[3ffe:2a00:100:7031::1]", true), new Test("[1080::8:800:200C:417A]", true), new Test("[::192.9.5.5]", true), new Test("[::FFFF:129.144.52.38]", true), new Test("FEDC:BA98:7654:3210:FEDC:BA98:7654:3210", true), new Test("3ffe:2a00:100:7031::1", false), new Test("1080::8:800:200C:417A", false), new Test("::192.9.5.5", false), new Test("::FFFF:129.144.52.38", false), new Test("0:0:0:0:0:0:0:1", true)};
    private Test[] ports = new Test[]{new Test("", true), new Test(":", true), new Test(":80", true), new Test(":-80", true), new Test(":80-", true), new Test(":70-90", true), new Test(":8a", false), new Test(":-8a", false), new Test(":8a-", false), new Test(":7a-90", false), new Test(":70-9a", false), new Test(":800000", true), new Test(":-800000", true), new Test(":800000-", true), new Test(":700000-900000", true), new Test(":-", false), new Test(":--80", false), new Test(":-80-", false), new Test(":80--", false), new Test(":70--90", false), new Test(":-70-90", false), new Test(":-70--90", false), new Test(":70-90-", false), new Test(":-70-90-", false)};

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("argument checking");
        for (int i = 0; i < this.hosts.length; ++i) {
            for (int j = 0; j < this.ports.length; ++j) {
                boolean success;
                Test test = new Test(this.hosts[i], this.ports[j]);
                try {
                    new SocketPermission(test.hostport, "connect");
                    success = true;
                }
                catch (IllegalArgumentException e) {
                    success = false;
                }
                harness.check(success == test.expect, test.hostport + " should " + (test.expect ? "be ok" : "fail"));
            }
        }
    }

    private static class Test {
        String hostport;
        boolean expect;

        Test(String hostport, boolean expect) {
            this.hostport = hostport;
            this.expect = expect;
        }

        Test(Test host, Test port) {
            this.hostport = host.hostport + port.hostport;
            this.expect = host.expect && port.expect;
        }
    }
}

