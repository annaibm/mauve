/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.URI;
import java.net.URISyntaxException;

public class ToASCIIStringTest
implements Testlet {
    private static final String TEST_URI_1 = "http://example.com/money/\uffe5/file.html";

    @Override
    public void test(TestHarness h) {
        try {
            h.check(new URI(TEST_URI_1).toString(), (Object)TEST_URI_1);
            h.check(new URI(TEST_URI_1).toASCIIString(), (Object)"http://example.com/money/%EF%BF%A5/file.html");
        }
        catch (URISyntaxException e) {
            h.debug(e);
            h.fail("Unexpected exception");
        }
    }
}

