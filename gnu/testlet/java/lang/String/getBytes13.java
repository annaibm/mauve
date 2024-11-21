/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.UnsupportedEncodingException;

public class getBytes13
implements Testlet {
    protected static final byte[] ABC1 = new byte[]{97, 98, 99};
    protected static final byte[] ABC2 = new byte[]{-2, -1, 0, 97, 0, 98, 0, 99};
    protected static final byte[] ABC3 = new byte[]{0, 97, 0, 98, 0, 99};
    protected static final byte[] ABC4 = new byte[]{-1, -2, 97, 0, 98, 0, 99, 0};
    protected static final byte[] ABC5 = new byte[]{97, 0, 98, 0, 99, 0};

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getBytes13");
        this.test1Encoding(harness, "ASCII", "abc", ABC1);
        this.test1Encoding(harness, "Cp1252", "abc", ABC1);
        this.test1Encoding(harness, "ISO8859_1", "abc", ABC1);
        this.test1Encoding(harness, "UTF8", "abc", ABC1);
        this.test1Encoding(harness, "UTF-16", "abc", ABC2);
        this.test1Encoding(harness, "UnicodeBig", "abc", ABC2);
        this.test1Encoding(harness, "UnicodeBigUnmarked", "abc", ABC3);
        this.test1Encoding(harness, "UnicodeLittle", "abc", ABC4);
        this.test1Encoding(harness, "UnicodeLittleUnmarked", "abc", ABC5);
    }

    protected void test1Encoding(TestHarness h, String encoding, String s, byte[] ba) {
        String signature = "String.getBytes(\"" + encoding + "\")";
        try {
            byte[] theBytes = s.getBytes(encoding);
            boolean result = getBytes13.areEqual(theBytes, ba);
            h.check(result, signature);
            if (!result) {
                getBytes13.dumpArray(h, "Got     : ", theBytes);
                getBytes13.dumpArray(h, "Expected: ", ba);
            }
        }
        catch (UnsupportedEncodingException x) {
            h.debug(x);
            h.fail(signature);
        }
    }

    static void dumpArray(TestHarness h, String prefix, byte[] a) {
        StringBuffer result = new StringBuffer(prefix);
        for (int i = 0; i < a.length; ++i) {
            if (i > 0) {
                result.append(' ');
            }
            result.append(a[i]);
        }
        h.debug(result.toString());
    }

    static boolean areEqual(byte[] a, byte[] b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == b[i]) continue;
            return false;
        }
        return true;
    }
}

