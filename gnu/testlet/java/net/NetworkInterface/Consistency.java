/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.NetworkInterface;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashSet;

public class Consistency
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Enumeration<NetworkInterface> ifs = null;
        harness.checkPoint("getNetworkInterfaces");
        try {
            ifs = NetworkInterface.getNetworkInterfaces();
            harness.check(ifs != null);
        }
        catch (Exception x) {
            harness.fail("getNetworkInterfaces");
            harness.debug(x);
            return;
        }
        harness.check(ifs.hasMoreElements(), "getNetworkInterfaces returns something");
        HashSet<String> names = new HashSet<String>();
        while (ifs.hasMoreElements()) {
            NetworkInterface netif = ifs.nextElement();
            harness.checkPoint("consistency - " + netif.getName());
            harness.check(!names.contains(netif.getName()), "duplicate entries");
            names.add(netif.getName());
            try {
                NetworkInterface netif2 = NetworkInterface.getByName(netif.getName());
                harness.check(netif2 != null);
                harness.check(netif.equals(netif2));
            }
            catch (Exception x) {
                harness.fail("getByName unexpected exception");
                harness.debug(x);
            }
            Enumeration<InetAddress> addrs = netif.getInetAddresses();
            harness.check(addrs.hasMoreElements());
            while (addrs.hasMoreElements()) {
                try {
                    InetAddress addr = addrs.nextElement();
                    NetworkInterface netif2 = NetworkInterface.getByInetAddress(addr);
                    harness.check(netif2 != null);
                    harness.check(netif.equals(netif2));
                }
                catch (Exception x) {
                    harness.fail("getByAddress unexpected exception");
                    harness.debug(x);
                }
            }
        }
    }
}

