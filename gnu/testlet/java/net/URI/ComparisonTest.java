/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.TreeSet;

public class ComparisonTest
implements Testlet {
    private static final String REL_URI = "..";
    private static final String HIER_URI = "http://jones@example.com:98?name=Fred#1";
    private static final String OPAQ_URI = "isbn:123456789#34";

    @Override
    public void test(TestHarness h) {
        try {
            h.check(new URI(REL_URI).compareTo(new URI(REL_URI)) == 0);
            URI testURI = new URI(HIER_URI);
            h.check(testURI.compareTo(testURI) == 0);
            h.check(testURI.compareTo(new URI(HIER_URI)) == 0);
            h.check(testURI.compareTo(new URI("ftp://jones@example.com:98?name=Fred#1")) > 0);
            h.check(testURI.compareTo(new URI("http://jones@example.com:98?name=Fred#2")) < 0);
            h.check(testURI.compareTo(new URI("http://alice@example.com:98?name=Fred#1")) > 0);
            h.check(testURI.compareTo(new URI("http://jones@examples.com:98?name=Fred#1")) < 0);
            h.check(testURI.compareTo(new URI("http://jones@example.com:99?name=Fred#1")) < 0);
            h.check(testURI.compareTo(new URI("http://jones@example.com:98?name=Sally#1")) < 0);
            URI opaqURI = new URI(OPAQ_URI);
            h.check(opaqURI.compareTo(opaqURI) == 0);
            h.check(opaqURI.compareTo(new URI(OPAQ_URI)) == 0);
            h.check(opaqURI.compareTo(testURI) > 0);
            h.check(opaqURI.compareTo(new URI("isbn:987654321#34")) < 0);
            TreeSet<URI> s = new TreeSet<URI>();
            s.add(opaqURI);
            s.add(testURI);
            s.add(new URI("ftp://jones@example.com:98?name=Fred#1"));
            s.add(new URI("http://jones@example.com:98?name=Fred#2"));
            s.add(new URI("http://alice@example.com:98?name=Fred#1"));
            s.add(new URI("http://jones@examples.com:98?name=Fred#1"));
            s.add(new URI("http://jones@example.com:99?name=Fred#1"));
            s.add(new URI("http://jones@example.com:98?name=Sally#1"));
            s.add(new URI("isbn:987654321#34"));
            h.debug(((Object)s).toString());
        }
        catch (URISyntaxException e) {
            h.debug(e);
            h.fail("Unexpected exception");
        }
    }
}

