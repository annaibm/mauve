/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.Socket;

import gnu.testlet.TestHarness;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread
extends Thread {
    ServerSocket sock;
    TestHarness harness;

    public ServerThread(TestHarness harness) {
        this(harness, 14610);
    }

    public ServerThread(TestHarness harness, int port) {
        this.harness = harness;
        try {
            this.sock = new ServerSocket(port);
            this.start();
        }
        catch (IOException x) {
            harness.fail(x.toString());
        }
    }

    public void close() {
        try {
            this.sock.close();
        }
        catch (IOException x) {
            this.harness.fail(x.toString());
        }
    }

    @Override
    public void run() {
        try {
            block2: while (true) {
                Socket s = this.sock.accept();
                InputStream is = s.getInputStream();
                byte[] data = new byte[512];
                boolean done = false;
                while (true) {
                    if (done) continue block2;
                    if (is.read(data, 0, data.length) >= 0) continue;
                    done = true;
                }
                break;
            }
        }
        catch (IOException iOException) {
            return;
        }
    }
}

