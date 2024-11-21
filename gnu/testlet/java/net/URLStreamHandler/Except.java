/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLStreamHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Except
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean ok = false;
        try {
            URL uRL = new URL(null, "blah://", new Handler());
        }
        catch (MalformedURLException ignore) {
            ok = true;
        }
        catch (Exception ex) {
            harness.debug(ex);
        }
        harness.check(ok);
    }

    public static class Handler
    extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL u) {
            return null;
        }

        @Override
        protected void parseURL(URL url, String spec, int start, int end2) {
            throw new RuntimeException();
        }
    }
}

