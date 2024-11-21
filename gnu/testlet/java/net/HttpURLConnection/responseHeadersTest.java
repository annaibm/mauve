/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.HttpURLConnection.TestHttpServer;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class responseHeadersTest
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        TestHttpServer server = null;
        try {
            try {
                server = new TestHttpServer();
            }
            catch (IOException ioe) {
                harness.debug(ioe);
                harness.fail("Could not start server");
                server.killTestServer();
                return;
            }
            this.test_MultiHeaders(harness, server);
            this.test_LowerUpperCaseHeaders(harness, server);
        }
        finally {
            server.killTestServer();
        }
    }

    public void test_MultiHeaders(TestHarness h, TestHttpServer server) {
        try {
            Factory f = new Factory("HTTP/1.0 200 OK\r\nServer: TestServer\r\nKey1: value, value2\r\nKey1: value3\r\nIntHeader: 1234\r\nIntHeaderMalformed: 1234XY\r\nDateHeader: Thu, 02 Mar 2006 14:34:55 +0000\r\nDateHeaderMalformed: Thu, 02 Mar 2006V 14:13:07 +0000\r\n\r\n");
            server.setConnectionHandlerFactory(f);
            URL url = new URL("http://localhost:" + server.getPort() + "/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            h.checkPoint("getHeaderFields()");
            Map<String, List<String>> fields = conn.getHeaderFields();
            try {
                fields.clear();
                h.check(false);
            }
            catch (UnsupportedOperationException e) {
                h.check(true);
            }
            h.check(fields.size() == 7);
            List<String> obj = fields.get("Key1");
            if (!(obj instanceof List)) {
                h.check(false);
            } else {
                h.check(true);
                List<String> value2 = obj;
                h.check(value2.size() == 2);
                h.check(value2.get(0).equals("value3"));
                h.check(value2.get(1).equals("value, value2"));
                try {
                    value2.remove(0);
                    h.check(false);
                }
                catch (UnsupportedOperationException e) {
                    h.check(true);
                }
            }
            obj = fields.get("key1");
            h.check(obj == null);
            h.checkPoint("getHeaderField(int)");
            String statusline = conn.getHeaderField(0);
            h.check(statusline.equals("HTTP/1.0 200 OK"));
            String aboutIndex = conn.getHeaderField(44);
            h.check(aboutIndex == null);
            String belowIndex = conn.getHeaderField(-1);
            h.check(belowIndex == null);
            String key1_Value = conn.getHeaderField(2);
            h.check(key1_Value.equals("value, value2"));
            h.checkPoint("getHeaderFieldKey(int)");
            String statuslineKey = conn.getHeaderFieldKey(0);
            h.check(statuslineKey == null);
            String aboutIndexKey = conn.getHeaderFieldKey(44);
            h.check(aboutIndexKey == null);
            String belowIndexKey = conn.getHeaderFieldKey(-1);
            h.check(belowIndexKey == null);
            String key1_Key = conn.getHeaderFieldKey(2);
            h.check(key1_Key.equals("Key1"));
            h.checkPoint("getHeaderFieldDate()");
            long dateHeader = conn.getHeaderFieldDate("DateHeader", 5555L);
            h.check(dateHeader == 1141310095000L);
            dateHeader = conn.getHeaderFieldDate("DateHeaderXX", 5555L);
            h.check(dateHeader == 5555L);
            dateHeader = conn.getHeaderFieldDate("DateHeaderMalformed", 5555L);
            h.check(dateHeader == 5555L);
            h.checkPoint("getHeaderFieldInt()");
            int intHeader = conn.getHeaderFieldInt("IntHeader", 5555);
            h.check(intHeader == 1234);
            intHeader = conn.getHeaderFieldInt("IntHeaderXX", 5555);
            h.check(intHeader == 5555);
            intHeader = conn.getHeaderFieldInt("IntHeaderMalformed", 5555);
            h.check(intHeader == 5555);
            h.checkPoint("convenience methods");
            h.check(conn.getLastModified() == 0L);
            h.check(conn.getDate() == 0L);
            h.check(conn.getExpiration() == 0L);
            h.check(conn.getContentEncoding() == null);
            h.check(conn.getContentType() == null);
            h.check(conn.getContentLength() == -1);
            h.checkPoint("getHeaderField(String)");
            String field = conn.getHeaderField("Server");
            String field1 = conn.getHeaderField("server");
            h.check(field.equals("TestServer"));
            h.check(field == field1);
            String none = conn.getHeaderField("NotExistent");
            h.check(none == null);
            String field_key1 = conn.getHeaderField("Key1");
            h.check(field_key1.equals("value3"));
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
        catch (RuntimeException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
    }

    public void test_LowerUpperCaseHeaders(TestHarness h, TestHttpServer server) {
        try {
            Factory f = new Factory("HTTP/1.0 200 OK\r\nServer: TestServer\r\nAnotherKey: value\r\nKey: value\r\nKey: value1\r\nkey: value2\r\nkey: value3\r\n\r\n");
            server.setConnectionHandlerFactory(f);
            URL url = new URL("http://localhost:" + server.getPort() + "/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            h.checkPoint("LowerUpperCase header fields tests");
            Map<String, List<String>> fields = conn.getHeaderFields();
            h.check(fields.size() == 5);
            List<String> value2 = fields.get("Key");
            h.check(value2.size() == 2);
            h.check(value2.get(0).equals("value1"));
            List<String> value22 = fields.get("key");
            h.check(value22.size() == 2);
            h.check(value22.get(0).equals("value3"));
            List<String> value3 = fields.get("AnotherKey");
            h.check(value3.get(0).equals("value"));
            value3 = fields.get("anotherkey");
            h.check(value3 == null);
            String field = conn.getHeaderField("Key");
            String field1 = conn.getHeaderField("key");
            h.check(field.equals("value3"));
            h.check(field == field1);
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
        catch (RuntimeException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
    }

    static class Handler
    extends TestHttpServer.ConnectionHandler {
        private String responseHeaders;
        private Writer sink;

        Handler(Socket socket, String headers) throws IOException {
            super(socket);
            this.responseHeaders = headers;
            this.sink = new OutputStreamWriter(this.output, "US-ASCII");
        }

        @Override
        protected boolean processConnection(List headers, byte[] body) throws IOException {
            this.sink.write(this.responseHeaders);
            this.sink.close();
            return false;
        }
    }

    static class Factory
    implements TestHttpServer.ConnectionHandlerFactory {
        private String headers;

        Factory(String headers) {
            this.headers = headers;
        }

        @Override
        public TestHttpServer.ConnectionHandler newConnectionHandler(Socket s) throws IOException {
            return new Handler(s, this.headers);
        }
    }
}

