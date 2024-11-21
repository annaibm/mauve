/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.DataInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class readLine
implements Testlet {
    private static void check(TestHarness harness, String input, String[] expected, int separator) {
        DataInputStream din = new DataInputStream(new ByteArrayInputStream(input.getBytes()));
        for (int i = 0; i < expected.length; ++i) {
            try {
                harness.check(din.readLine(), (Object)expected[i]);
                if (separator == -1) continue;
                harness.check(din.read() == separator, "missing separator in: " + input);
                continue;
            }
            catch (Exception x) {
                harness.fail("unexpected exception " + x);
            }
        }
        try {
            harness.check(din.readLine(), null);
        }
        catch (Exception x) {
            harness.fail("unexpected exception " + x);
        }
    }

    @Override
    public void test(TestHarness harness) {
        readLine.check(harness, "", new String[0], -1);
        readLine.check(harness, "\n", new String[]{""}, -1);
        readLine.check(harness, "\r", new String[]{""}, -1);
        readLine.check(harness, "\r\n", new String[]{""}, -1);
        readLine.check(harness, "\n\r", new String[]{"", ""}, -1);
        readLine.check(harness, "\r\nfoo", new String[]{"", "foo"}, -1);
        readLine.check(harness, "foo\r\nbar", new String[]{"foo", "bar"}, -1);
        readLine.check(harness, "foo\rbar", new String[]{"foo", "bar"}, -1);
        readLine.check(harness, "foo\nbar", new String[]{"foo", "bar"}, -1);
        readLine.check(harness, "foo\r\n:bar\n:", new String[]{"foo", "bar"}, 58);
        readLine.check(harness, "foo\r\n:bar\r:", new String[]{"foo", "bar"}, 58);
        readLine.check(harness, "foo\r\n:bar\r\n:", new String[]{"foo", "bar"}, 58);
    }
}

