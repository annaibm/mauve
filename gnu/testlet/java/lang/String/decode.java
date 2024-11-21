/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.UnsupportedEncodingException;

public class decode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] cstr = new char[]{'a', 'b', 'c', '\t', 'A', 'B', 'C', ' ', '1', '2', '3'};
        byte[] bstr = new byte[cstr.length];
        for (int i = 0; i < cstr.length; ++i) {
            bstr[i] = (byte)cstr[i];
        }
        String a = new String(bstr);
        String a_utf8 = "";
        String b = new String(bstr, 3, 3);
        String b_utf8 = "";
        String c = "";
        String d = "";
        try {
            a_utf8 = new String(bstr, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        try {
            b_utf8 = new String(bstr, 3, 3, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        try {
            c = new String(bstr, "8859_1");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        try {
            d = new String(bstr, 3, 3, "8859_1");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        harness.check(a, (Object)"abc\tABC 123");
        harness.check(a_utf8, (Object)"abc\tABC 123");
        harness.check(b, (Object)"\tAB");
        harness.check(b_utf8, (Object)"\tAB");
        harness.check(c, (Object)"abc\tABC 123");
        harness.check(d, (Object)"\tAB");
        boolean ok = false;
        try {
            c = new String(bstr, "foobar8859_1");
        }
        catch (UnsupportedEncodingException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            d = new String(bstr, 3, 3, "foobar8859_1");
        }
        catch (UnsupportedEncodingException ex) {
            ok = true;
        }
        harness.check(ok);
        harness.check(String.copyValueOf(cstr), (Object)"abc\tABC 123");
        harness.check(String.copyValueOf(cstr, 3, 3), (Object)"\tAB");
        byte[] leWithBOM = new byte[]{-1, -2, 97, 0};
        byte[] leWithoutBOM = new byte[]{97, 0};
        byte[] beWithBOM = new byte[]{-2, -1, 0, 97};
        byte[] beWithoutBOM = new byte[]{0, 97};
        harness.check(this.decodeTest(leWithBOM, "UTF-16", "a"));
        harness.check(!this.decodeTest(leWithoutBOM, "UTF-16", "a"));
        harness.check(this.decodeTest(beWithBOM, "UTF-16", "a"));
        harness.check(this.decodeTest(beWithoutBOM, "UTF-16", "a"));
        harness.check(!this.decodeTest(leWithBOM, "UTF-16LE", "a"));
        harness.check(this.decodeTest(leWithoutBOM, "UTF-16LE", "a"));
        harness.check(!this.decodeTest(beWithBOM, "UTF-16LE", "a"));
        harness.check(!this.decodeTest(beWithoutBOM, "UTF-16LE", "a"));
        harness.check(!this.decodeTest(leWithBOM, "UTF-16BE", "a"));
        harness.check(!this.decodeTest(leWithoutBOM, "UTF-16BE", "a"));
        harness.check(!this.decodeTest(beWithBOM, "UTF-16BE", "a"));
        harness.check(this.decodeTest(beWithoutBOM, "UTF-16BE", "a"));
        harness.check(this.decodeTest(leWithBOM, "UnicodeLittle", "a"));
        harness.check(this.decodeTest(leWithoutBOM, "UnicodeLittle", "a"));
        harness.check(!this.decodeTest(beWithBOM, "UnicodeLittle", "a"));
        harness.check(!this.decodeTest(beWithoutBOM, "UnicodeLittle", "a"));
    }

    public boolean decodeTest(byte[] bytes, String encoding, String expected) {
        try {
            String s = new String(bytes, encoding);
            return s.equals(expected);
        }
        catch (UnsupportedEncodingException ex) {
            return false;
        }
    }
}

