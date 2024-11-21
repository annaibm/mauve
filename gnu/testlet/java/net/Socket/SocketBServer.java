/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.Socket;

import gnu.testlet.TestHarness;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class SocketBServer
extends Thread {
    ServerSocket srvsock = null;
    static TestHarness harness;

    SocketBServer() {
    }

    public void init() {
        try {
            this.srvsock = new ServerSocket(20002);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : BasicSocketServer::init failed Exception should not be thrown here " + e);
        }
    }

    @Override
    public void run() {
        if (this.srvsock == null) {
            harness.fail("Error : BasicSocketServer::run failed  - 1 server socket creation was not successful");
            return;
        }
        int i = 0;
        while (i++ < 1) {
            try {
                Socket clnt = this.srvsock.accept();
                OutputStream os = clnt.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeBytes("hello buddy");
                dos.close();
                harness.check(true);
            }
            catch (Exception e) {
                harness.fail("Error : BasicSocketServer::run failed - 2exception was thrown");
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

