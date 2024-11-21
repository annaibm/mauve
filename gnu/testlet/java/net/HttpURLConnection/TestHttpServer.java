/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class TestHttpServer
implements Runnable {
    boolean kill = false;
    ServerSocket serverSocket;
    ConnectionHandlerFactory connectionHandlerFactory;
    private List activeConnections = new LinkedList();

    public TestHttpServer() throws IOException {
        this.serverSocket = new ServerSocket(0);
        Thread t = new Thread((Runnable)this, "TestHttpServer");
        t.start();
    }

    public int getPort() {
        return this.serverSocket.getLocalPort();
    }

    public synchronized void setConnectionHandlerFactory(ConnectionHandlerFactory f) {
        this.connectionHandlerFactory = f;
    }

    public void killTestServer() {
        this.kill = true;
        this.closeAllConnections();
        try {
            this.serverSocket.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        block10: while (true) {
            try {
                while (!this.kill) {
                    Socket socket = this.serverSocket.accept();
                    try {
                        ConnectionHandlerFactory f;
                        TestHttpServer testHttpServer = this;
                        synchronized (testHttpServer) {
                            f = this.connectionHandlerFactory;
                        }
                        ConnectionHandler request = f.newConnectionHandler(socket);
                        Thread thread2 = new Thread(request);
                        thread2.start();
                        List list2 = this.activeConnections;
                        synchronized (list2) {
                            this.activeConnections.add(request);
                            continue block10;
                        }
                    }
                    catch (Exception exception) {
                    }
                }
                break;
            }
            catch (IOException iOException) {
                // empty catch block
                break;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void closeAllConnections() {
        List list2 = this.activeConnections;
        synchronized (list2) {
            Iterator it = this.activeConnections.iterator();
            while (it.hasNext()) {
                ConnectionHandler request = (ConnectionHandler)it.next();
                request.forceClosed();
                it.remove();
            }
        }
    }

    public static abstract class ConnectionHandler
    implements Runnable {
        protected Socket socket;
        protected OutputStream output;
        protected InputStream input;

        ConnectionHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.output = socket.getOutputStream();
            this.input = socket.getInputStream();
        }

        protected abstract boolean processConnection(List var1, byte[] var2) throws IOException;

        protected String getHeaderFromList(List headers, String h) {
            String search = (h + ":").toLowerCase();
            for (String v : headers) {
                String k = v.toLowerCase();
                if (!k.startsWith(search)) continue;
                return v.substring(search.length()).trim();
            }
            return null;
        }

        @Override
        public void run() {
            try {
                byte[] body;
                ArrayList<String> headerList;
                int contentLength = -1;
                do {
                    int ch;
                    headerList = new ArrayList<String>();
                    ByteArrayOutputStream line = new ByteArrayOutputStream();
                    while (-1 != (ch = this.input.read())) {
                        if (ch != 10) {
                            line.write(ch);
                            continue;
                        }
                        byte[] array = line.toByteArray();
                        if (array.length == 1) break;
                        String headerLine = new String(array);
                        if (headerLine.length() > 15 && "Content-Length:".equalsIgnoreCase(headerLine.substring(0, 15))) {
                            contentLength = Integer.parseInt(headerLine.substring(15).trim());
                        }
                        headerList.add(headerLine);
                        line = new ByteArrayOutputStream();
                    }
                    if (contentLength > 0) {
                        int nr;
                        body = new byte[contentLength];
                        for (int pos = 0; pos < contentLength && -1 != (nr = this.input.read(body, pos, body.length - pos)); pos += nr) {
                        }
                    } else {
                        body = null;
                    }
                    contentLength = -1;
                } while (this.processConnection(headerList, body));
                this.output.close();
                this.input.close();
                this.socket.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }

        protected void forceClosed() {
            try {
                this.socket.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    public static interface ConnectionHandlerFactory {
        public ConnectionHandler newConnectionHandler(Socket var1) throws IOException;
    }
}

