/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.HttpURLConnection.TestHttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.List;

public class reuseConnection
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
            this.test_GET(h, server);
            server.closeAllConnections();
            this.test_HEAD(h, server);
            server.closeAllConnections();
            this.test_POST(h, server);
            server.closeAllConnections();
        }
        finally {
            if (server != null) {
                server.killTestServer();
            }
        }
    }

    public void test_HEAD(TestHarness h, TestHttpServer server) {
        try {
            h.checkPoint("HEAD-1");
            server.setConnectionHandlerFactory(new FactoryH1());
            URL url = new URL("http://localhost:" + server.getPort() + "/file1");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("HEAD");
            int code = conn.getResponseCode();
            h.check(code, 200);
            int contentLength = conn.getContentLength();
            h.check(contentLength, 100000);
            InputStream s = conn.getInputStream();
            int v = s.read();
            h.check(v, -1);
            InputStream error = conn.getErrorStream();
            h.check(error, null);
            h.checkPoint("HEAD-2");
            url = new URL("http://localhost:" + server.getPort() + "/file2");
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("HEAD");
            code = conn.getResponseCode();
            h.check(code, 200);
            contentLength = conn.getContentLength();
            h.check(contentLength, 200000);
            s = conn.getInputStream();
            v = s.read();
            h.check(v, -1);
            error = conn.getErrorStream();
            h.check(error, null);
            server.setConnectionHandlerFactory(new FactoryH2());
            h.checkPoint("HEAD-3");
            url = new URL("http://localhost:" + server.getPort() + "/fileA");
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("HEAD");
            code = conn.getResponseCode();
            h.check(code, 200);
            String contentType = conn.getContentType();
            h.check(contentType, (Object)"text/html");
            s = conn.getInputStream();
            v = s.read();
            h.check(v, -1);
            error = conn.getErrorStream();
            h.check(error, null);
            h.checkPoint("HEAD-4");
            url = new URL("http://localhost:" + server.getPort() + "/fileB");
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("HEAD");
            code = conn.getResponseCode();
            h.check(code, 200);
            contentType = conn.getContentType();
            h.check(contentType, (Object)"text/plain");
            s = conn.getInputStream();
            v = s.read();
            h.check(v, -1);
            error = conn.getErrorStream();
            h.check(error, null);
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
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

    public void test_GET(TestHarness h, TestHttpServer server) {
        try {
            byte[] data = new byte[100];
            h.checkPoint("GET-1");
            server.setConnectionHandlerFactory(new FactoryG1());
            URL url = new URL("http://localhost:" + server.getPort() + "/file1");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            int code = conn.getResponseCode();
            h.check(code, 200);
            int contentLength = conn.getContentLength();
            h.check(contentLength, 5);
            InputStream s = conn.getInputStream();
            int v = reuseConnection.readFully(s, data);
            h.check(v, 5);
            InputStream error = conn.getErrorStream();
            h.check(error, null);
            h.checkPoint("GET-2");
            url = new URL("http://localhost:" + server.getPort() + "/file2");
            conn = (HttpURLConnection)url.openConnection();
            code = conn.getResponseCode();
            h.check(code, 200);
            contentLength = conn.getContentLength();
            h.check(contentLength, 8);
            s = conn.getInputStream();
            v = reuseConnection.readFully(s, data);
            h.check(v, 8);
            error = conn.getErrorStream();
            h.check(error, null);
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
    }

    public void test_POST(TestHarness h, TestHttpServer server) {
        try {
            byte[] data = new byte[]{77, 101, 115, 115, 97, 103, 101};
            h.checkPoint("POST-1");
            server.setConnectionHandlerFactory(new FactoryP1());
            URL url = new URL("http://localhost:" + server.getPort() + "/file1");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(data);
            os.close();
            int code = conn.getResponseCode();
            h.check(code, 204);
            String serverName = conn.getHeaderField("Server");
            h.check(serverName, (Object)"TestServer1");
            InputStream error = conn.getErrorStream();
            h.check(error, null);
            h.checkPoint("POST-2");
            url = new URL("http://localhost:" + server.getPort() + "/file2");
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            os = conn.getOutputStream();
            os.write(data);
            os.close();
            code = conn.getResponseCode();
            h.check(code, 204);
            serverName = conn.getHeaderField("Server");
            h.check(serverName, (Object)"TestServer2");
            error = conn.getErrorStream();
            h.check(error, null);
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
    }

    static class HandlerH2
    extends TestHttpServer.ConnectionHandler {
        private Writer sink;
        private int requestNumber;

        HandlerH2(Socket socket) throws IOException {
            super(socket);
            this.sink = new OutputStreamWriter(this.output, "US-ASCII");
        }

        @Override
        protected boolean processConnection(List headers, byte[] body) throws IOException {
            ++this.requestNumber;
            String request = (String)headers.get(0);
            if (!request.startsWith("HEAD ")) {
                this.sink.write("HTTP/1.1 400 Bad Request\r\n");
                this.sink.write("Server: TestServer\r\n");
                this.sink.write("Connection: close\r\n");
                this.sink.write("\r\n");
                this.sink.flush();
                return false;
            }
            this.sink.write("HTTP/1.1 200 OK\r\n");
            this.sink.write("Server: TestServer\r\n");
            this.sink.write("Transfer-Encoding: chunked\r\n");
            if (request.indexOf("fileA") != -1) {
                this.sink.write("Content-Type: text/html\r\n");
            } else if (this.requestNumber == 2) {
                this.sink.write("Content-Type: text/plain\r\n");
                this.sink.write("Connection: close\r\n");
            } else {
                this.sink.write("Content-Type: application/octet-stream\r\n");
            }
            this.sink.write("\r\n");
            this.sink.flush();
            return this.requestNumber < 2;
        }
    }

    static class FactoryH2
    implements TestHttpServer.ConnectionHandlerFactory {
        FactoryH2() {
        }

        @Override
        public TestHttpServer.ConnectionHandler newConnectionHandler(Socket s) throws IOException {
            return new HandlerH2(s);
        }
    }

    static class HandlerH1
    extends TestHttpServer.ConnectionHandler {
        private Writer sink;
        private int requestNumber;

        HandlerH1(Socket socket) throws IOException {
            super(socket);
            this.sink = new OutputStreamWriter(this.output, "US-ASCII");
        }

        @Override
        protected boolean processConnection(List headers, byte[] body) throws IOException {
            ++this.requestNumber;
            String request = (String)headers.get(0);
            if (!request.startsWith("HEAD ")) {
                this.sink.write("HTTP/1.1 400 Bad Request\r\n");
                this.sink.write("Server: TestServer\r\n");
                this.sink.write("Connection: close\r\n");
                this.sink.write("\r\n");
                this.sink.flush();
                return false;
            }
            this.sink.write("HTTP/1.1 200 OK\r\n");
            this.sink.write("Server: TestServer\r\n");
            if (request.indexOf("file1") != -1) {
                this.sink.write("Content-Length: 100000\r\n");
            } else if (this.requestNumber == 2) {
                this.sink.write("Content-Length: 200000\r\n");
                this.sink.write("Connection: close\r\n");
            } else {
                this.sink.write("Content-Length: 300000\r\n");
            }
            this.sink.write("\r\n");
            this.sink.flush();
            return this.requestNumber < 2;
        }
    }

    static class FactoryH1
    implements TestHttpServer.ConnectionHandlerFactory {
        FactoryH1() {
        }

        @Override
        public TestHttpServer.ConnectionHandler newConnectionHandler(Socket s) throws IOException {
            return new HandlerH1(s);
        }
    }

    static class HandlerG1
    extends TestHttpServer.ConnectionHandler {
        private Writer sink;
        private int requestNumber;

        HandlerG1(Socket socket) throws IOException {
            super(socket);
            this.sink = new OutputStreamWriter(this.output, "US-ASCII");
        }

        @Override
        protected boolean processConnection(List headers, byte[] body) throws IOException {
            boolean hello = false;
            boolean goodBye = false;
            boolean err = false;
            ++this.requestNumber;
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
            if (request.indexOf("file1") != -1) {
                this.sink.write("Content-Length: 5\r\n");
                hello = true;
            } else if (this.requestNumber == 2) {
                this.sink.write("Content-Length: 8\r\n");
                this.sink.write("Connection: close\r\n");
                goodBye = true;
            } else {
                this.sink.write("Content-Length: 3\r\n");
                err = true;
            }
            this.sink.write("\r\n");
            if (hello) {
                this.sink.write("Hello");
            } else if (goodBye) {
                this.sink.write("Good Bye");
            } else if (err) {
                this.sink.write("Err");
            }
            this.sink.flush();
            return this.requestNumber < 2;
        }
    }

    static class FactoryG1
    implements TestHttpServer.ConnectionHandlerFactory {
        FactoryG1() {
        }

        @Override
        public TestHttpServer.ConnectionHandler newConnectionHandler(Socket s) throws IOException {
            return new HandlerG1(s);
        }
    }

    static class HandlerP1
    extends TestHttpServer.ConnectionHandler {
        private Writer sink;
        private int requestNumber;

        HandlerP1(Socket socket) throws IOException {
            super(socket);
            this.sink = new OutputStreamWriter(this.output, "US-ASCII");
        }

        @Override
        protected boolean processConnection(List headers, byte[] body) throws IOException {
            ++this.requestNumber;
            String request = (String)headers.get(0);
            if (!request.startsWith("POST ")) {
                this.sink.write("HTTP/1.1 400 Bad Request\r\n");
                this.sink.write("Server: TestServer\r\n");
                this.sink.write("Connection: close\r\n");
                this.sink.write("\r\n");
                this.sink.flush();
                return false;
            }
            this.sink.write("HTTP/1.1 204 No Content\r\n");
            if (request.indexOf("file1") != -1) {
                this.sink.write("Server: TestServer1\r\n");
            } else if (this.requestNumber == 2) {
                this.sink.write("Server: TestServer2\r\n");
            } else {
                this.sink.write("Server: TestServer3\r\n");
            }
            this.sink.write("\r\n");
            this.sink.flush();
            return this.requestNumber < 2;
        }
    }

    static class FactoryP1
    implements TestHttpServer.ConnectionHandlerFactory {
        FactoryP1() {
        }

        @Override
        public TestHttpServer.ConnectionHandler newConnectionHandler(Socket s) throws IOException {
            return new HandlerP1(s);
        }
    }
}

