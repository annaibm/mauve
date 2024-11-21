/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.ServerSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptGetLocalPort
implements Testlet,
Runnable {
    private static int port = 5678;

    @Override
    public void test(TestHarness harness) {
        new Thread(this).start();
        try {
            ServerSocket ss = new ServerSocket(port);
            harness.check(ss.getLocalPort(), port);
            Socket s = ss.accept();
            harness.check(s.getLocalPort(), port);
            s.close();
            ss.close();
        }
        catch (IOException ioe) {
            harness.debug(ioe);
            harness.check(false, ioe.toString());
        }
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            try {
                Socket s = new Socket("localhost", port);
                break;
            }
            catch (IOException iOException) {
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException interruptedException) {}
            }
        }
    }
}

