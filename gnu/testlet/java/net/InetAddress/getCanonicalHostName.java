/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class getCanonicalHostName
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            String host = "sources.redhat.com";
            String canon = "sourceware.org";
            InetAddress addr = InetAddress.getByName(host);
            h.check(addr.getHostName().equals(host));
            h.check(addr.getCanonicalHostName().equals(canon));
        }
        catch (UnknownHostException e) {
            h.fail(e.toString());
        }
    }
}

