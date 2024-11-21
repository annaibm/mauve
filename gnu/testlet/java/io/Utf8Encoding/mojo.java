/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Utf8Encoding;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class mojo
implements Testlet {
    private static byte[] test0_bytes = new byte[]{65, -30, -119, -94, -50, -111, 46, -19, -107, -100, -22, -75, -83, -20, -106, -76, -26, -105, -91, -26, -100, -84, -24, -86, -98};
    private static char[] test0_chars = new char[]{'A', '\u2262', '\u0391', '.', '\ud55c', '\uad6d', '\uc5b4', '\u65e5', '\u672c', '\u8a9e'};
    private static byte[] test1_bytes = new byte[]{0, 1, 126, 127};
    private static char[] test1_chars = new char[]{'\u0000', '\u0001', '~', '\u007f'};
    private static byte[] test2_bytes = new byte[]{-62, -128, -62, -127, -61, -96, -33, -66, -33, -65};
    private static char[] test2_chars = new char[]{'\u0080', '\u0081', '\u00e0', '\u07fe', '\u07ff'};
    private static byte[] test3_bytes = new byte[]{-32, -96, -128, -32, -96, -127, -17, -65, -66, -17, -65, -65};
    private static char[] test3_chars = new char[]{'\u0800', '\u0801', '\ufffe', '\uffff'};
    private static byte[] test4_bytes = new byte[]{-16, -112, -128, -128, -16, -112, -128, -127, -16, -112, -120, -128, -16, -112, -112, -128, -16, -112, -113, -65, -15, -112, -113, -65, -14, -112, -113, -65, -12, -113, -65, -65};
    private static char[] test4_chars = new char[]{'\ud800', '\udc00', '\ud800', '\udc01', '\ud800', '\ude00', '\ud801', '\udc00', '\ud800', '\udfff', '\ud900', '\udfff', '\uda00', '\udfff', '\udbff', '\udfff'};
    private static byte[] test5_bytes = new byte[]{-9, -113, -65, -65};
    private static byte[] test6_bytes = new byte[]{-9, -113, -65, -65};
    private static byte[] test7_bytes = new byte[]{-8, -128, -128, -128, -128};
    private static byte[] test8_bytes = new byte[]{-8, -65, -128, -128, -128};
    private static byte[] test9_bytes = new byte[]{-4, -128, -128, -128, -128, -128};
    private static byte[] test10_bytes = new byte[]{-4, -128, -128, -128, -128, -127};
    private static byte[] test11_bytes = new byte[]{-128};
    private static byte[] test12_bytes = new byte[]{-87};
    private static byte[] test13_bytes = new byte[]{-9, -128, -128, -128};
    private static byte[] bad0_bytes = new byte[]{-64, -128};
    private static byte[] bad1_bytes = new byte[]{-32, -128, -128};
    private static byte[] bad2_bytes = new byte[]{-16, -128, -128, -128};
    private static byte[] bad3_bytes = new byte[]{-63, -128};
    private static byte[] bad4_bytes = new byte[]{-32, -127, -128};
    private static byte[] bad5_bytes = new byte[]{-32, -112, -128};

    private static void positive(TestHarness harness, byte[] encoded, char[] decoded, String label) {
        boolean flag = true;
        int i = 0;
        harness.checkPoint(label);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter((OutputStream)out, "UTF8");
            writer.write(decoded);
            writer.close();
            byte[] result = out.toByteArray();
            harness.check(result.length, encoded.length);
            flag = true;
            for (i = 0; i < encoded.length && i < result.length; ++i) {
                if (encoded[i] == result[i]) continue;
                harness.debug("failing index = " + i);
                flag = false;
            }
            harness.check(flag);
            ByteArrayInputStream in = new ByteArrayInputStream(encoded);
            InputStreamReader reader = new InputStreamReader((InputStream)in, "UTF8");
            flag = true;
            for (i = 0; i < decoded.length; ++i) {
                int c = reader.read();
                harness.check(c, decoded[i]);
                if (c == decoded[i]) continue;
                harness.debug(label + ": read failed, char " + i);
                flag = false;
                break;
            }
            harness.check(flag);
            harness.check(reader.read(), -1);
        }
        catch (Exception e) {
            harness.debug(label + ": failed (i = " + i + "), " + e.getClass().getName() + ", " + e.getMessage());
        }
    }

    private static void negative(TestHarness harness, byte[] encoded, String label) {
        boolean flag = false;
        harness.checkPoint(label);
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(encoded);
            InputStreamReader reader = new InputStreamReader((InputStream)in, "UTF8");
            int c = reader.read();
            flag = c == 65533;
        }
        catch (Throwable t) {
            harness.debug(label + ": failed, threw " + t.getClass().getName() + ", " + t.getMessage());
        }
        harness.check(flag);
    }

    @Override
    public void test(TestHarness harness) {
        mojo.positive(harness, test0_bytes, test0_chars, "RFC 2279 Examples");
        mojo.positive(harness, test1_bytes, test1_chars, "One Byte Characters");
        mojo.positive(harness, test2_bytes, test2_chars, "Two Byte Characters");
        mojo.positive(harness, test3_bytes, test3_chars, "Three Byte Characters");
        mojo.positive(harness, test4_bytes, test4_chars, "Surrogate Pairs");
        mojo.negative(harness, test5_bytes, "Four Byte Range Error (0)");
        mojo.negative(harness, test6_bytes, "Four Byte Range Error (1)");
        mojo.negative(harness, test7_bytes, "Five Bytes (0)");
        mojo.negative(harness, test8_bytes, "Five Bytes (1)");
        mojo.negative(harness, test9_bytes, "Six Bytes (0)");
        mojo.negative(harness, test10_bytes, "Six Bytes (1)");
        mojo.negative(harness, test11_bytes, "Orphan Continuation (1)");
        mojo.negative(harness, test12_bytes, "Orphan Continuation (2)");
        mojo.negative(harness, test13_bytes, "Four Byte Range Error (2)");
    }
}

