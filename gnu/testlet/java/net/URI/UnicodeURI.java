/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.URI;
import java.net.URISyntaxException;

public class UnicodeURI
implements Testlet {
    private static final String LATIN_SMALL_LETTER_C_WITH_ACUTE = "\u0107";

    @Override
    public void test(TestHarness harness) {
        try {
            URI uri = new URI(null, LATIN_SMALL_LETTER_C_WITH_ACUTE, null);
            String uri_string = uri.toString();
            harness.check(LATIN_SMALL_LETTER_C_WITH_ACUTE.equals(uri_string));
        }
        catch (URISyntaxException e) {
            harness.debug(e);
            harness.fail("unexpected exception" + e.toString());
        }
    }
}

