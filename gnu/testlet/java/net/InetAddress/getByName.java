/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class getByName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            InetAddress addr = InetAddress.getByName(null);
            harness.check(addr != null);
            harness.check(addr.isLoopbackAddress());
        }
        catch (UnknownHostException x) {
            harness.fail(x.toString());
        }
    }
}

