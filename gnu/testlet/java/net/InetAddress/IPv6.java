/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPv6
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            String name2 = "1010:0:0:0:0:2020:0:1";
            byte[] ipaddr = new byte[]{16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 0, 0, 0, 1};
            InetAddress addr = InetAddress.getByAddress(ipaddr);
            h.check(addr.getHostAddress(), name2, "wrong ip string");
            h.check(addr.getHostName(), name2, "wrong hostname");
            h.check(addr.getCanonicalHostName(), name2, "wrong canonical hostname");
            h.check(addr.toString(), name2 + "/" + name2, "wrong string representation");
        }
        catch (UnknownHostException e) {
            h.check(false);
        }
    }
}

