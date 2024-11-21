/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.HttpURLConnection;
import java.net.URL;

public class nullPointerException
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            URL url = new URL("http://sources.redhat.com/mauve/testarea/index.html");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            String str = conn.getRequestProperty(null);
            h.check(str == null);
            try {
                conn.setRequestProperty(null, "dddd");
                h.check(false);
            }
            catch (NullPointerException e) {
                h.check(true);
            }
            try {
                conn.addRequestProperty(null, "dddd");
                h.check(false);
            }
            catch (NullPointerException e) {
                h.check(true);
            }
        }
        catch (Exception e) {
            h.debug(e);
            h.fail("Unexpected error: " + e.getMessage());
        }
    }
}

