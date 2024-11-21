/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.charset.Charset;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class utf16
implements Testlet {
    private void testCharset(TestHarness h, String name2, float expected_average, float expected_max) {
        Charset charset = Charset.forName(name2);
        h.check(charset != null, "Charset.forName(\"" + name2 + "\") returned 'null'");
        CharsetEncoder encoder = charset.newEncoder();
        h.check(encoder != null, "Charset.newEncoder() returned 'null'");
        float average = encoder.averageBytesPerChar();
        h.check((double)average, (double)expected_average, "average bytes per char (expected: " + expected_average + ", got: " + average + ")");
        float max2 = encoder.maxBytesPerChar();
        h.check((double)max2, (double)expected_max, "max bytes per char (expected: " + expected_max + ", got: " + max2 + ")");
    }

    @Override
    public void test(TestHarness h) {
        this.testCharset(h, "UTF-16", 2.0f, 4.0f);
        this.testCharset(h, "UTF-16LE", 2.0f, 2.0f);
        this.testCharset(h, "UTF-16BE", 2.0f, 2.0f);
    }
}

