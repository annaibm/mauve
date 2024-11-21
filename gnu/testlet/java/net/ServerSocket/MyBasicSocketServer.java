/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.ServerSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.java.net.ServerSocket.MyServerSocket;
import java.io.IOException;
import java.net.Socket;

class MyBasicSocketServer
extends Thread {
    MyServerSocket srvsock = null;
    private TestHarness harness;

    MyBasicSocketServer() {
    }

    public void init(TestHarness harness) {
        this.harness = harness;
        try {
            this.srvsock = new MyServerSocket(10000);
            this.srvsock.close();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error - 1 : MyBasicSocketServer::init failed exception in new MyServerSocket(10000): " + e);
        }
        try {
            this.srvsock = new MyServerSocket(20000);
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("Error - 2 : MyBasicSocketServer::init failed exception in new MyServerSocket(20000): " + e);
        }
    }

    @Override
    public void run() {
        try {
            Socket clnt = new Socket("localhost", 20000);
            this.srvsock.invoke_implAccept(clnt);
        }
        catch (IOException iOException) {
            // empty catch block
        }
        try {
            this.srvsock.finalize();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

