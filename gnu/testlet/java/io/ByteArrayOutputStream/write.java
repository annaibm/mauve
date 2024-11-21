/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ByteArrayOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class write
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String encodedstr;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        byte[] ba = new byte[]{66, 67, 68};
        String tststr = "ABCD";
        baos.write(65);
        harness.check(true, "write(int)");
        baos.write(ba, 0, 3);
        harness.check(true, "write(buf, off, len)");
        harness.check(baos.size(), 4, "size()");
        String finalstr1 = baos.toString();
        harness.check(finalstr1.equals(tststr), "toString()");
        byte[] finalba = baos.toByteArray();
        String finalstr2 = new String(finalba);
        harness.check(finalstr2.equals(tststr), "toByteArray()");
        try {
            encodedstr = baos.toString("English");
        }
        catch (UnsupportedEncodingException ue) {
            harness.check(true, "UnsupportedEncodingException");
        }
        try {
            encodedstr = baos.toString("8859_1");
            harness.check(encodedstr.equals(tststr), "toString(String)");
        }
        catch (UnsupportedEncodingException ue) {
            harness.check(false, "Encoding error");
        }
        try {
            baos.writeTo(baos2);
            harness.check(baos2.toString().equals(tststr), "writeTo(OutputStream)");
        }
        catch (IOException e) {
            harness.check(false, "writeTo(OutputStream)");
        }
        baos.reset();
        harness.check(baos.size(), 0, "reset()");
    }
}

