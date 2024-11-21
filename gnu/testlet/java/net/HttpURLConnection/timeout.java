/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.HttpURLConnection.TestHttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.List;

public class timeout
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        TestHttpServer server = null;
        try {
            try {
                server = new TestHttpServer();
            }
            catch (IOException ioe) {
                h.debug(ioe);
                h.fail("Could not start server");
                if (server != null) {
                    server.killTestServer();
                }
                return;
            }
            this.testReadTimeout(h, server);
            server.closeAllConnections();
            this.testConnectTimeout(h);
        }
        finally {
            if (server != null) {
                server.killTestServer();
            }
        }
    }

    private static int readFully(InputStream is, byte[] d) throws IOException {
        int pos;
        int c;
        for (pos = 0; pos < d.length; pos += c) {
            c = is.read(d, pos, d.length - pos);
            if (c != -1) continue;
            if (pos != 0) break;
            return -1;
        }
        return pos;
    }

    private void testReadTimeout(TestHarness h, TestHttpServer server) {
        try {
            int v;
            InputStream s;
            int code;
            byte[] data = new byte[100];
            h.checkPoint("read-1");
            server.setConnectionHandlerFactory(new Factory());
            URL url = new URL("http://127.0.0.1:" + server.getPort() + "/closeme");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setReadTimeout(5000);
            try {
                code = conn.getResponseCode();
                s = conn.getInputStream();
                v = timeout.readFully(s, data);
                h.check(false);
            }
            catch (IOException ioe) {
                h.check(true);
            }
            h.checkPoint("read-2");
            url = new URL("http://127.0.0.1:" + server.getPort() + "/foo");
            conn = (HttpURLConnection)url.openConnection();
            code = conn.getResponseCode();
            h.check(code, 200);
            s = conn.getInputStream();
            v = timeout.readFully(s, data);
            s.close();
            h.check(v, 7);
            h.checkPoint("read-3");
            url = new URL("http://127.0.0.1:" + server.getPort() + "/bar");
            conn = (HttpURLConnection)url.openConnection();
            conn.setReadTimeout(5000);
            try {
                code = conn.getResponseCode();
                s = conn.getInputStream();
                v = timeout.readFully(s, data);
                h.check(false);
            }
            catch (IOException ioe) {
                h.check(true);
            }
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
    }

    private void testConnectTimeout(TestHarness h) {
        try {
            byte[] data = new byte[100];
            h.checkPoint("connect-1");
            URL url = new URL("http://10.20.30.40:/foo");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            long start = System.currentTimeMillis();
            conn.setConnectTimeout(3000);
            try {
                int code = conn.getResponseCode();
                InputStream s = conn.getInputStream();
                int v = timeout.readFully(s, data);
                h.check(false);
            }
            catch (IOException ioe) {
                long end2 = System.currentTimeMillis();
                long delta = end2 - start;
                h.check(delta > 0L && delta < 5000L);
            }
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
    }

    static class Handler
    extends TestHttpServer.ConnectionHandler {
        private Writer sink;

        Handler(Socket socket) throws IOException {
            super(socket);
            this.sink = new OutputStreamWriter(this.output, "US-ASCII");
        }

        @Override
        protected boolean processConnection(List headers, byte[] body) throws IOException {
            boolean closeme = false;
            String request = (String)headers.get(0);
            if (!request.startsWith("GET ")) {
                this.sink.write("HTTP/1.1 400 Bad Request\r\n");
                this.sink.write("Server: TestServer\r\n");
                this.sink.write("Connection: close\r\n");
                this.sink.write("\r\n");
                this.sink.flush();
                return false;
            }
            this.sink.write("HTTP/1.1 200 OK\r\n");
            this.sink.write("Server: TestServer\r\n");
            if (request.indexOf("closeme") != -1) {
                this.sink.write("Connection: close\r\n");
                closeme = true;
            }
            this.sink.write("Content-Length: 7\r\n");
            this.sink.write("\r\n");
            this.sink.flush();
            try {
                Thread.sleep(10000L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            this.sink.write("Hello\r\n");
            this.sink.flush();
            return !closeme;
        }
    }

    static class Factory
    implements TestHttpServer.ConnectionHandlerFactory {
        Factory() {
        }

        @Override
        public TestHttpServer.ConnectionHandler newConnectionHandler(Socket s) throws IOException {
            return new Handler(s);
        }
    }
}

