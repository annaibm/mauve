/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.charset.Charset;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class forName
implements Testlet {
    private void checkCharset(TestHarness h, String name2) {
        boolean supported = false;
        try {
            Charset cs = Charset.forName(name2);
            if (cs != null) {
                supported = true;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        h.check(supported, "Charset '" + name2 + "' supported");
    }

    @Override
    public void test(TestHarness h) {
        boolean works = false;
        try {
            Charset charset = Charset.forName("foobar");
        }
        catch (UnsupportedCharsetException e) {
            works = true;
        }
        h.check(works, "UnsupportedCharsetException expected");
        this.checkCharset(h, "ISO-8859-1");
        this.checkCharset(h, "US-ASCII");
        this.checkCharset(h, "UTF-8");
        this.checkCharset(h, "UTF-16");
        this.checkCharset(h, "UTF-16BE");
        this.checkCharset(h, "UTF-16LE");
        works = false;
        try {
            Charset.forName(null);
        }
        catch (Exception e) {
            works = e instanceof IllegalArgumentException;
        }
        h.check(works, "IllegalArgumentException thrown");
    }
}

