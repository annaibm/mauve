/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.ServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class MyServerSocket
extends ServerSocket {
    public MyServerSocket(int port) throws IOException {
        super(port);
    }

    public void invoke_implAccept(Socket s) throws IOException {
        super.implAccept(s);
    }

    public void finalize() {
        try {
            super.finalize();
        }
        catch (Throwable t) {
            System.out.println(t);
        }
    }
}

