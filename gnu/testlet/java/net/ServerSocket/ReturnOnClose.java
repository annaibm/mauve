/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.ServerSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

public class ReturnOnClose
implements Testlet {
    ServerSocket socket;
    Throwable exception;

    @Override
    public synchronized void test(TestHarness harness) {
        Thread t = new Thread(){

            @Override
            public void run() {
                boolean opened = false;
                for (int i = 1; i < 100 && !opened; ++i) {
                    int port = 1000 + (int)(Math.random() * 2000.0);
                    try {
                        ReturnOnClose.this.socket = new ServerSocket(port);
                        opened = true;
                        continue;
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                try {
                    ReturnOnClose.this.socket.accept();
                }
                catch (IOException ex) {
                    ReturnOnClose.this.exception = ex;
                }
                ReturnOnClose.this.socket = null;
            }
        };
        t.start();
        long s = System.currentTimeMillis();
        while (this.socket == null && System.currentTimeMillis() - s < 10000L) {
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {}
        }
        harness.check(this.socket != null, " Socket must be opened");
        try {
            this.socket.close();
            t.interrupt();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        s = System.currentTimeMillis();
        while (this.socket != null && System.currentTimeMillis() - s < 3000L) {
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {}
        }
        harness.check(this.socket == null, " Socket thread must be resumed. POA.testForwarding will also fail.");
        harness.check(this.exception instanceof SocketException, "Must be SocketException");
    }
}

