/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.Socket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.Socket.ServerThread;
import java.io.IOException;
import java.net.Socket;

public class jdk12
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        String host = "localhost";
        int port = 14610;
        Socket sock = null;
        ServerThread server = new ServerThread(harness, port);
        try {
            sock = new Socket(host, port);
            harness.checkPoint("setSendBufferSize()");
            harness.checkPoint("getSendBufferSize()");
            harness.checkPoint("setReceiveBufferSize()");
            harness.checkPoint("getReceiveBufferSize()");
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.fail("unexpected error: " + t.getMessage());
        }
        finally {
            try {
                if (sock != null) {
                    sock.close();
                }
                server.close();
            }
            catch (IOException iOException) {}
        }
    }
}

