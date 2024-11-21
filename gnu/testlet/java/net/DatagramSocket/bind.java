/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.DatagramSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.DatagramSocket;

public class bind
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            DatagramSocket ds = new DatagramSocket(null);
            ds.bind(null);
            h.check(true, "bound to null address");
        }
        catch (NullPointerException npe) {
            h.fail("NPE binding to null address");
        }
        catch (Exception e) {
            h.fail(e.toString() + " binding to null address");
        }
    }
}

