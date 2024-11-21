/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.HttpURLConnection.TestHttpServer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.List;

public class responseCodeTest
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        TestHttpServer server = null;
        try {
            int i;
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
            for (i = 400; i < 418; ++i) {
                this.test_ResponseCode(i, h, server);
            }
            for (i = 500; i < 506; ++i) {
                this.test_ResponseCode(i, h, server);
            }
        }
        finally {
            if (server != null) {
                server.killTestServer();
            }
        }
    }

    public void test_ResponseCode(int responseCode, TestHarness h, TestHttpServer server) {
        try {
            server.setConnectionHandlerFactory(new Factory(responseCode));
            URL url = new URL("http://localhost:" + server.getPort() + "/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            h.checkPoint("Test " + responseCode + " response");
            int code = conn.getResponseCode();
            h.check(code == responseCode);
            try {
                conn.getInputStream();
                h.check(false);
            }
            catch (IOException e) {
                if (responseCode == 404 || responseCode == 410) {
                    if (e instanceof FileNotFoundException) {
                        h.check(true);
                    } else {
                        h.check(false);
                    }
                }
                h.check(true);
            }
            InputStream error = conn.getErrorStream();
            h.check(error != null);
            conn.disconnect();
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
    }

    static class Handler
    extends TestHttpServer.ConnectionHandler {
        private int responseCode;
        private Writer sink;

        Handler(Socket socket, int responseCode) throws IOException {
            super(socket);
            this.responseCode = responseCode;
            this.sink = new OutputStreamWriter(this.output, "US-ASCII");
        }

        @Override
        protected boolean processConnection(List headers, byte[] body) throws IOException {
            this.sink.write("HTTP/1.0 " + this.responseCode + " OK\r\n");
            this.sink.write("Server: TestServer\r\n\r\n");
            this.sink.close();
            return false;
        }
    }

    static class Factory
    implements TestHttpServer.ConnectionHandlerFactory {
        private int responseCode;

        Factory(int responseCode) {
            this.responseCode = responseCode;
        }

        @Override
        public TestHttpServer.ConnectionHandler newConnectionHandler(Socket s) throws IOException {
            return new Handler(s, this.responseCode);
        }
    }
}

