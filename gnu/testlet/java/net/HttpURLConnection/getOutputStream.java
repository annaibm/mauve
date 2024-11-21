/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class getOutputStream
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            URL url = new URL("http://sources.redhat.com/mauve/testarea/index.html");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(false);
            try {
                conn.getOutputStream();
                h.check(false);
            }
            catch (ProtocolException e1) {
                h.check(true);
            }
            conn.setDoOutput(true);
            OutputStream stream = conn.getOutputStream();
            try {
                conn.getRequestProperties();
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            OutputStream stream2 = conn.getOutputStream();
            h.check(stream == stream2);
        }
        catch (Exception e) {
            h.debug(e);
            h.fail("Unexpected error: " + e.getMessage());
        }
    }
}

