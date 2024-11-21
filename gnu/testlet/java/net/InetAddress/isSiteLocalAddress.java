/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class isSiteLocalAddress
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            h.check(InetAddress.getByAddress(new byte[]{10, 0, 0, 0}).isSiteLocalAddress());
            h.check(InetAddress.getByAddress(new byte[]{10, -1, -1, -1}).isSiteLocalAddress());
            h.check(!InetAddress.getByAddress(new byte[]{9, -1, -1, -1}).isSiteLocalAddress());
            h.check(!InetAddress.getByAddress(new byte[]{11, 0, 0, 0}).isSiteLocalAddress());
            h.check(InetAddress.getByAddress(new byte[]{-84, 16, 0, 0}).isSiteLocalAddress());
            h.check(InetAddress.getByAddress(new byte[]{-84, 31, -1, -1}).isSiteLocalAddress());
            h.check(!InetAddress.getByAddress(new byte[]{-84, 15, -1, -1}).isSiteLocalAddress());
            h.check(!InetAddress.getByAddress(new byte[]{-84, 32, 0, 0}).isSiteLocalAddress());
            h.check(InetAddress.getByAddress(new byte[]{-64, -88, 0, 0}).isSiteLocalAddress());
            h.check(InetAddress.getByAddress(new byte[]{-64, -88, -1, -1}).isSiteLocalAddress());
            h.check(!InetAddress.getByAddress(new byte[]{-64, -89, -1, -1}).isSiteLocalAddress());
            h.check(!InetAddress.getByAddress(new byte[]{-64, -87, 0, 0}).isSiteLocalAddress());
        }
        catch (UnknownHostException e) {
            h.debug(e);
            h.check(false, "unexpected exception");
        }
    }
}

