/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class post
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            URL url = new URL("http://sources.redhat.com/mauve/testarea/index.html");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            h.check(conn.getRequestMethod(), "GET", "request method is 'GET'");
            conn.getOutputStream();
            h.check(conn.getRequestMethod(), "POST", "request method is 'POST'");
        }
        catch (MalformedURLException e) {
            h.fail("Error in test header - Exception " + e);
        }
        catch (IOException e) {
            h.fail("IO error caught - " + e);
        }
    }
}

