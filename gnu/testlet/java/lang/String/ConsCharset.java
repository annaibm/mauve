/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class ConsCharset
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            byte[] cp437Bytes = this.asByteArray(new int[]{224, 226, 227, 228, 156});
            this.checkString(h, new String(cp437Bytes, Charset.forName("CP437")), "\u03b1\u0393\u03c0\u03a3\u00a3");
        }
        catch (UnsupportedCharsetException cp437Bytes) {
            // empty catch block
        }
        byte[] utf8Bytes = this.asByteArray(new int[]{195, 159, 226, 133, 147, 226, 130, 175, 240, 144, 133, 128});
        this.checkString(h, new String(utf8Bytes, Charset.forName("UTF8")), "\u00df\u2153\u20af\ud800\udd40");
        byte[] isoBytes = this.asByteArray(new int[]{72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33});
        this.checkString(h, new String(isoBytes, Charset.forName("ISO-8859-1")), "Hello World!");
    }

    private void checkString(TestHarness h, String result, String expected) {
        for (int a = 0; a < result.length(); ++a) {
            h.check(result.charAt(a), expected.charAt(a));
        }
        h.check(result, (Object)expected);
    }

    private byte[] asByteArray(int[] ints) {
        byte[] bytes = new byte[ints.length];
        for (int a = 0; a < ints.length; ++a) {
            bytes[a] = Integer.valueOf(ints[a]).byteValue();
        }
        return bytes;
    }
}

