/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Http
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Good HTTP header ordering");
        try {
            URL url = new URL("http://sources.redhat.com/mauve/testarea/index.html");
            URLConnection conn = url.openConnection();
            harness.check(conn.getHeaderFieldKey(0), null);
            harness.check(conn.getHeaderField(0), (Object)"HTTP/1.1 200 OK");
            harness.check(conn.getHeaderFieldKey(2), (Object)"Server");
            harness.check(conn.getHeaderField(2).indexOf("Apache"), 0);
        }
        catch (MalformedURLException e) {
            harness.fail("Error in test header - Exception " + e);
        }
        catch (IOException e) {
            harness.fail("IO error caught - " + e);
        }
    }
}

