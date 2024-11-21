/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PrintStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class encodings
implements Testlet {
    private void test1(TestHarness harness, String encoding, String input, byte[] expected) {
        boolean result;
        byte[] output = null;
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            PrintStream ps = null;
            ps = encoding == null ? new PrintStream(b, false) : new PrintStream((OutputStream)b, false, encoding);
            ps.print(input);
            ps.flush();
            output = b.toByteArray();
        }
        catch (UnsupportedEncodingException b) {
            // empty catch block
        }
        if (output == null && expected == null) {
            harness.check(true);
            return;
        }
        boolean bl = result = output != null && output.length == expected.length;
        if (result) {
            for (int i = 0; i < output.length; ++i) {
                if (output[i] == expected[i]) continue;
                result = false;
                break;
            }
        }
        harness.check(result);
    }

    @Override
    public void test(TestHarness harness) {
        String input = "abc";
        byte[] expected = new byte[]{97, 98, 99};
        this.test1(harness, "ISO-8859-1", input, expected);
        this.test1(harness, "??UNSUPPORTED??", input, null);
    }
}

