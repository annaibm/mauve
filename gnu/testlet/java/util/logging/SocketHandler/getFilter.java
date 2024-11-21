/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.SocketHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.ServerSocket;
import java.util.logging.SocketHandler;

public class getFilter
implements Testlet {
    @Override
    public void test(TestHarness th) {
        try {
            ServerSocket socket = new ServerSocket(0);
            SocketHandler handler = new SocketHandler("0.0.0.0", socket.getLocalPort());
            socket.close();
            th.check(handler.getFilter() == null);
        }
        catch (Exception ex) {
            th.check(false);
            th.debug(ex);
        }
    }
}

