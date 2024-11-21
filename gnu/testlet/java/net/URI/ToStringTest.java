/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.URI;
import java.net.URISyntaxException;

public class ToStringTest
implements Testlet {
    private static final String TEST_URI_1 = "http://example.com/examples?name=Fred#";
    private static final String TEST_URI_2 = "http://example.com/examples?name=Fred";
    private static final String TEST_URI_3 = "http://example.com/examples?";
    private static final String TEST_URI_4 = "http://example.com/examples";
    private static final String TEST_URI_5 = "://example.com/examples";
    private static final String TEST_URI_6 = "//example.com/examples";
    private static final String TEST_URI_7 = "http:///examples";
    private static final String TEST_URI_8 = "http:/examples";

    @Override
    public void test(TestHarness h) {
        try {
            URI test12 = new URI(TEST_URI_1);
            h.check(test12.toString(), (Object)TEST_URI_1);
            h.check(test12.getRawFragment(), (Object)"");
            URI test22 = new URI(TEST_URI_2);
            h.check(test22.toString(), (Object)TEST_URI_2);
            h.check(test22.getRawFragment(), null);
            URI test32 = new URI(TEST_URI_3);
            h.check(test32.toString(), (Object)TEST_URI_3);
            h.check(test32.getRawQuery(), (Object)"");
            URI test42 = new URI(TEST_URI_4);
            h.check(test42.toString(), (Object)TEST_URI_4);
            h.check(test42.getRawQuery(), null);
            URI test52 = new URI(TEST_URI_5);
            h.check(test52.toString(), (Object)TEST_URI_5);
            h.check(test52.getScheme(), null);
            URI test62 = new URI(TEST_URI_6);
            h.check(test62.toString(), (Object)TEST_URI_6);
            h.check(test62.getScheme(), null);
            URI test7 = new URI(TEST_URI_7);
            h.check(test7.toString(), (Object)TEST_URI_7);
            h.check(test7.getRawAuthority(), (Object)"");
            URI test8 = new URI(TEST_URI_8);
            h.check(test8.toString(), (Object)TEST_URI_8);
            h.check(test8.getRawAuthority(), null);
        }
        catch (URISyntaxException e) {
            h.debug(e);
            h.fail("Unexpected exception");
        }
    }
}

