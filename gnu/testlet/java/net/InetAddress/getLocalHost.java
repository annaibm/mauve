/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class getLocalHost
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            harness.check(addr != null);
            InetAddress addr2 = InetAddress.getByName(addr.getHostName());
            harness.check(addr2 != null);
            harness.check(addr.equals(addr2));
        }
        catch (UnknownHostException x) {
            harness.fail(x.toString());
        }
    }
}

