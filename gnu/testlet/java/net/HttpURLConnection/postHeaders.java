/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.HttpURLConnection.TestHttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.List;

public class postHeaders
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
            this.test_POST(h, server);
            server.closeAllConnections();
        }
        finally {
            if (server != null) {
                server.killTestServer();
            }
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
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
    }

    static class HandlerP1
    extends TestHttpServer.ConnectionHandler {
        private Writer sink;

        HandlerP1(Socket socket) throws IOException {
            super(socket);
            this.sink = new OutputStreamWriter(this.output, "US-ASCII");
        }

        @Override
        protected boolean processConnection(List headers, byte[] body) throws IOException {
            String request = (String)headers.get(0);
            String contentType = this.getHeaderFromList(headers, "content-type");
            if (!request.startsWith("POST ") || contentType == null || !contentType.equals("application/x-www-form-urlencoded")) {
                this.sink.write("HTTP/1.1 400 Bad Request\r\n");
                this.sink.write("Server: TestServer\r\n");
                this.sink.write("Connection: close\r\n");
                this.sink.write("\r\n");
                this.sink.flush();
                return false;
            }
            this.sink.write("HTTP/1.1 204 No Content\r\n");
            this.sink.write("Server: TestServer\r\n");
            this.sink.write("\r\n");
            this.sink.flush();
            return true;
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

