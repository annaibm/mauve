/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class fileNotFound
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            URL url = new URL("http://www.redhat.com/mauve/testarea/edeltraut.html");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            try {
                conn.connect();
                int code = conn.getResponseCode();
                h.check(code == 404);
            }
            catch (FileNotFoundException e) {
                h.check(false);
            }
            try {
                conn.getInputStream();
                h.check(false);
            }
            catch (FileNotFoundException e) {
                h.check(true);
            }
            InputStream error = conn.getErrorStream();
            h.check(error != null);
            conn.disconnect();
        }
        catch (Exception e) {
            h.debug(e);
            h.fail("Unexpected error: " + e.getMessage());
        }
    }
}

