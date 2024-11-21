/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.Socket;

import gnu.testlet.TestHarness;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class SocketServer
extends Thread {
    ServerSocket srvsock = null;
    String helloBuddy = "hello buddy";
    static TestHarness harness;

    SocketServer() {
    }

    public void init() {
        try {
            this.srvsock = new ServerSocket(23000);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : BasicSocketServer::init failed Exception should not be thrown here " + e);
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (this.srvsock == null) {
            harness.fail("Error : BasicSocketServer::run failed  - 1 server socket creation was not successful");
            return;
        }
        int i = 0;
        while (i++ < 5) {
            try {
                Socket clnt = this.srvsock.accept();
                OutputStream os = clnt.getOutputStream();
                byte[] data = new byte[this.helloBuddy.length()];
                this.helloBuddy.getBytes(0, this.helloBuddy.length(), data, 0);
                os.write(data);
                os.close();
                harness.check(true);
            }
            catch (Exception e) {
                harness.fail("Error : BasicSocketServer::run failed - 2exception was thrown: " + e);
                e.printStackTrace();
            }
        }
        try {
            this.srvsock.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }
}

