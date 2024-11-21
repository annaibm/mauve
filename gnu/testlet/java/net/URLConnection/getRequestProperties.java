/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class getRequestProperties
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("getRequestProperties");
            URL url = new URL("http://foo.bar/blah/blah");
            URLConnection c = url.openConnection();
            c.addRequestProperty("mauve", "p1");
            c.addRequestProperty("mauve", "p2");
            Map<String, List<String>> m = c.getRequestProperties();
            List<String> l = m.get("mauve");
            harness.check(l.contains("p1"));
            harness.check(l.contains("p2"));
        }
        catch (ClassCastException cce) {
            harness.debug(cce);
            harness.fail("ClassCastException");
        }
        catch (IOException ioe) {
            harness.debug(ioe);
            harness.fail("IOException");
        }
        catch (Exception e) {
            harness.debug(e);
            harness.fail("Unexpected Exception");
        }
    }
}

