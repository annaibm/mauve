/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class getAllByName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InetAddress loopback;
        InetAddress[] addr;
        try {
            addr = InetAddress.getAllByName(null);
            harness.check(addr != null);
            loopback = addr[0];
            harness.check(loopback != null);
            harness.check(loopback.isLoopbackAddress());
        }
        catch (UnknownHostException x) {
            harness.fail(x.toString());
        }
        try {
            addr = InetAddress.getAllByName("");
            harness.check(addr != null);
            loopback = addr[0];
            harness.check(loopback != null);
            harness.check(loopback.isLoopbackAddress());
        }
        catch (UnknownHostException x) {
            harness.fail(x.toString());
        }
    }
}

