/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLConnection;

import gnu.testlet.ResourceNotFoundException;
import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class getHeaderFields
implements Testlet {
    private void check(TestHarness h, String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            conn.connect();
            Map<String, List<String>> headers = conn.getHeaderFields();
            h.check(headers != null);
            if (!headers.isEmpty()) {
                Map.Entry entry = (Map.Entry)headers.entrySet().toArray()[1];
                h.check(entry.getKey() instanceof String);
                h.check(entry.getValue() instanceof List);
            }
        }
        catch (MalformedURLException url) {
        }
        catch (IOException e) {
            h.fail("Test failed for " + urlString);
        }
    }

    @Override
    public void test(TestHarness h) {
        h.checkPoint("Test HTTP");
        this.check(h, "http://www.gnu.org/");
        h.checkPoint("Test FTP");
        this.check(h, "ftp://ftp.gnu.org");
        h.checkPoint("Test HTTPS");
        this.check(h, "https://www.gmx.net/");
        try {
            h.checkPoint("Test JAR");
            File jarfile = h.getResourceFile("gnu#testlet#java#util#jar#JarFile#jartest.jar");
            this.check(h, "jar:file:" + jarfile.toString() + "!/");
            h.checkPoint("Test File");
            this.check(h, "file://" + jarfile.toString());
        }
        catch (ResourceNotFoundException e) {
            h.debug("Unexpected exception");
            h.debug(e);
        }
    }
}

