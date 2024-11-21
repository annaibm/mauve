/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.ServerSocket;

import gnu.testlet.TestHarness;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class BasicSocketServer
extends Thread {
    ServerSocket srvsock = null;
    private TestHarness harness;

    BasicSocketServer() {
    }

    public void init(TestHarness harness) {
        this.harness = harness;
        try {
            this.srvsock = new ServerSocket(12000);
            harness.check(true);
        }
        catch (Exception e) {
            System.out.println("Error : BasicSocketServer::init failed exception in new ServerSocket(...) " + e);
            harness.debug(e);
        }
    }

    @Override
    public void run() {
        this.harness.check(this.srvsock != null, "Error : BasicSocketServer::run failed  - 1 server socket creation was not successful");
        if (this.srvsock == null) {
            return;
        }
        int i = 0;
        while (i++ < 2) {
            try {
                Socket clnt = this.srvsock.accept();
                OutputStream os = clnt.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeBytes("hello buddy");
                dos.close();
                this.harness.check(true);
            }
            catch (Exception e) {
                System.out.println("Error : BasicSocketServer::run failed - 2exception was thrown");
                this.harness.debug(e);
            }
        }
        try {
            this.srvsock.close();
            this.harness.check(true);
        }
        catch (Exception e) {
            System.out.println("Error : BasicSocketServer::run failed - 3exception was thrown");
            this.harness.debug(e);
        }
    }
}

