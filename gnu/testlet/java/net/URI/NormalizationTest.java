/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.URI;
import java.net.URISyntaxException;

public class NormalizationTest
implements Testlet {
    private static final String BASE_URI = "http://www.dcs.shef.ac.uk/com4280/";
    private static final String RELATIVE_URI = "special/../special/../artistdac1.html?id=32";
    private static final String CORRECT_URI = "http://www.dcs.shef.ac.uk/com4280/artistdac1.html?id=32";

    @Override
    public void test(TestHarness h) {
        try {
            h.check(new URI("/a/b/c/./../../g").normalize().toString(), (Object)"/a/g");
            h.check(new URI("mid/content=5/../6").normalize().toString(), (Object)"mid/6");
            h.check(new URI("http://www.dcs.shef.ac.uk/com4280/special/../special/../artistdac1.html?id=32").normalize().toString(), (Object)CORRECT_URI);
            h.check(new URI(BASE_URI).resolve(RELATIVE_URI).toString(), (Object)CORRECT_URI);
        }
        catch (URISyntaxException e) {
            h.debug(e);
            h.fail("Unexpected exception");
        }
    }
}

