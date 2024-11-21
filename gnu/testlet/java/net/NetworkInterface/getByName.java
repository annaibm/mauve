/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.NetworkInterface;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.NetworkInterface;

public class getByName
implements Testlet {
    @Override
    public void test(TestHarness h) {
        NetworkInterface netif;
        try {
            netif = NetworkInterface.getByName(null);
            h.fail("- 1 - NullPointerException expected");
        }
        catch (NullPointerException e) {
            h.check(true);
        }
        catch (Exception e) {
            h.fail("- 1 - NullPointerException expected");
        }
        try {
            netif = NetworkInterface.getByName("abcde");
            h.check(netif == null, "- 2 - return value expected to be null");
        }
        catch (Exception e) {
            h.fail("- 2 - no exeption expected");
        }
    }
}

