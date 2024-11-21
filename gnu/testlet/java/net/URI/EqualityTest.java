/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.URI;
import java.net.URISyntaxException;

public class EqualityTest
implements Testlet {
    private static final String REL_URI = "..";
    private static final String HIER_URI = "http://jones@example.com:98?name=Fred#1";
    private static final String OPAQ_URI = "isbn:123456789#34";

    @Override
    public void test(TestHarness h) {
        try {
            h.check(new URI(REL_URI).equals(new URI(REL_URI)));
            URI testURI = new URI(HIER_URI);
            h.check(testURI.equals(testURI));
            h.check(testURI.equals(new URI(HIER_URI)));
            h.check(!testURI.equals(new URI("ftp://jones@example.com:98?name=Fred#1")));
            h.check(!testURI.equals(new URI("http://jones@example.com:98?name=Fred#2")));
            h.check(!testURI.equals(new URI("http://alice@example.com:98?name=Fred#1")));
            h.check(!testURI.equals(new URI("http://jones@examples.com:98?name=Fred#1")));
            h.check(!testURI.equals(new URI("http://jones@example.com:99?name=Fred#1")));
            h.check(!testURI.equals(new URI("http://jones@example.com:98?name=Sally#1")));
            URI opaqURI = new URI(OPAQ_URI);
            h.check(opaqURI.equals(opaqURI));
            h.check(opaqURI.equals(new URI(OPAQ_URI)));
            h.check(!opaqURI.equals(testURI));
            h.check(!opaqURI.equals(new URI("isbn:987654321#34")));
        }
        catch (URISyntaxException e) {
            h.debug(e);
            h.fail("Unexpected exception");
        }
    }
}

