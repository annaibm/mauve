/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetSocketAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetSocketAddress;

public class createUnresolved
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean ok = false;
        try {
            InetSocketAddress.createUnresolved(null, 2000);
        }
        catch (IllegalArgumentException e) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            InetSocketAddress.createUnresolved("www.classpath.org", -1);
        }
        catch (IllegalArgumentException e) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            InetSocketAddress.createUnresolved("www.classpath.org", 65536);
        }
        catch (IllegalArgumentException e) {
            ok = true;
        }
        harness.check(ok);
        InetSocketAddress sa = InetSocketAddress.createUnresolved("www.classpath.org", 80);
        harness.check(sa.isUnresolved());
    }
}

