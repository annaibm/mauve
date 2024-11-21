/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.OutputStreamWriter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class jdk11
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            String tstr = "ABCDEFGH";
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(baos);
            harness.check(true, "OutputStreamWriter(writer)");
            harness.check(osw.getEncoding() != null, "non-null getEncoding");
            osw.write(tstr.charAt(0));
            harness.check(true, "write(int)");
            osw.write("ABCDE", 1, 3);
            harness.check(true, "write(string, off, len)");
            char[] cbuf = new char[8];
            tstr.getChars(4, 8, cbuf, 0);
            osw.write(cbuf, 0, 4);
            harness.check(true, "write(char[], off, len)");
            osw.flush();
            harness.check(true, "flush()");
            harness.check(baos.toString(), tstr, "Wrote all characters okay");
            osw.close();
            harness.check(osw.getEncoding(), null, "null encoding after close");
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            OutputStreamWriter osw2 = new OutputStreamWriter((OutputStream)baos2, "ISO-8859-1");
            harness.check(osw2.getEncoding(), "ISO8859_1", "OutputStreamWriter(writer, encoding)");
            osw2.close();
            osw2 = new OutputStreamWriter((OutputStream)baos2, "latin1");
            harness.check(osw2.getEncoding(), "ISO8859_1", "OutputStreamWriter(writer, encoding) // alias");
            osw2.close();
        }
        catch (IOException e) {
            harness.check(false, "IOException unexpected");
        }
    }
}

