/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.SocketHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class SocketHandler
implements Testlet {
    @Override
    public void test(TestHarness th) {
        try {
            new java.util.logging.SocketHandler("0.0.0.0", -1);
            th.check(false);
        }
        catch (Exception ex) {
            th.check(ex instanceof IllegalArgumentException);
        }
        try {
            new java.util.logging.SocketHandler(null, 8080);
            th.check(false);
        }
        catch (Exception ex) {
            th.check(ex instanceof IllegalArgumentException);
        }
    }
}

