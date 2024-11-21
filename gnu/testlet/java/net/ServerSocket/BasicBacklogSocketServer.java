/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.ServerSocket;

import gnu.testlet.TestHarness;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class BasicBacklogSocketServer
extends Thread {
    ServerSocket srvsock = null;
    private TestHarness harness;

    BasicBacklogSocketServer() {
    }

    public void init(TestHarness harness) {
        this.harness = harness;
        try {
            this.srvsock = new ServerSocket(21000, 1);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error : BasicBacklogSocketServer::init failed exception was thrown: " + e);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        if (this.srvsock == null) {
            this.harness.fail("Error : BasicBacklogSocketServer::run failed  - 1 server socket creation was not successful");
            return;
        }
        try {
            Socket clnt = this.srvsock.accept();
            Socket clnt1 = this.srvsock.accept();
            Socket clnt2 = this.srvsock.accept();
            OutputStream os = clnt.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeBytes("hello buddy");
            dos.close();
            this.harness.check(true);
        }
        catch (Exception e) {
            this.harness.fail("Error : BasicBacklogSocketServer::run failed - 2exception was thrown: " + e);
        }
        finally {
            try {
                this.srvsock.close();
            }
            catch (IOException iOException) {}
        }
    }
}

