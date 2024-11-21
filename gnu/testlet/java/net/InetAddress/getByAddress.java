/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.InetAddress;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class getByAddress
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testX(harness);
    }

    private void testX(TestHarness harness) {
        byte[] a1 = new byte[]{1, 2, 3, 4};
        InetAddress ia = null;
        try {
            ia = InetAddress.getByAddress(a1);
        }
        catch (UnknownHostException uhe) {
            harness.check(false);
        }
        byte[] a2 = ia.getAddress();
        harness.check(a2[0], 1);
        harness.check(a2[1], 2);
        harness.check(a2[2], 3);
        harness.check(a2[3], 4);
        harness.check(a2 != a1);
        a1[0] = 5;
        byte[] a3 = ia.getAddress();
        harness.check(a3[0], 1);
        harness.check(a2 != a3);
        byte[] a4 = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        ia = null;
        try {
            ia = InetAddress.getByAddress(a4);
        }
        catch (UnknownHostException uhe) {
            harness.check(false);
        }
        byte[] a5 = ia.getAddress();
        harness.check(a5[0], 1);
        harness.check(a5[1], 2);
        harness.check(a5[2], 3);
        harness.check(a5[15], 16);
        harness.check(a5 != a4);
        a4[0] = 5;
        byte[] a6 = ia.getAddress();
        harness.check(a6[0], 1);
        harness.check(a5 != a6);
    }
}

