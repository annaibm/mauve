/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.URI;
import java.net.URISyntaxException;

public class RelativizationTest
implements Testlet {
    private static final String BASE_URI_1 = "http://example.com/hotcakes/";
    private static final String BASE_URI_2 = "http://example.com/hotcakes/?name=unknown#6";
    private static final String ERROR_URI_1 = "ftp://example.com/hotcakes/bun5.html";
    private static final String ERROR_URI_2 = "http://examples.com/hotcakes/bun6.html";
    private static final String ERROR_URI_3 = "http://examples.com/hotrolls/sausage2.html";
    private static final String RELATIVE_URI_1 = "http://example.com/hotcakes/bun5.html?name=Fred#2";
    private static final String OPAQUE_1 = "urn:890#1";
    private static final String OPAQUE_2 = "urn:891#2";

    @Override
    public void test(TestHarness h) {
        try {
            h.check(new URI(OPAQUE_1).relativize(new URI(OPAQUE_2)), new URI(OPAQUE_2));
            h.check(new URI(BASE_URI_1).relativize(new URI(OPAQUE_2)), new URI(OPAQUE_2));
            h.check(new URI(OPAQUE_1).relativize(new URI(BASE_URI_1)), new URI(BASE_URI_1));
            h.check(new URI(BASE_URI_1).relativize(new URI(ERROR_URI_1)), new URI(ERROR_URI_1));
            h.check(new URI(BASE_URI_1).relativize(new URI(ERROR_URI_2)), new URI(ERROR_URI_2));
            h.check(new URI(BASE_URI_1).relativize(new URI(ERROR_URI_3)), new URI(ERROR_URI_3));
            h.check(new URI(BASE_URI_1).relativize(new URI(RELATIVE_URI_1)), new URI("bun5.html?name=Fred#2"));
            h.check(new URI(BASE_URI_2).relativize(new URI(RELATIVE_URI_1)), new URI("bun5.html?name=Fred#2"));
        }
        catch (URISyntaxException e) {
            h.debug(e);
            h.fail("Unexpected exception");
        }
    }
}

