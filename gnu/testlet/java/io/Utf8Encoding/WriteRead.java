/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Utf8Encoding;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class WriteRead
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str1 = "This is the first line of text\n";
        String str2 = "This has some \u01ff\ua000\u6666\u0200 weird characters\n";
        try {
            FileOutputStream fos = new FileOutputStream("utf8test.out");
            OutputStreamWriter osr = new OutputStreamWriter((OutputStream)fos, "UTF8");
            osr.write(str1);
            osr.write(str2);
            osr.close();
            harness.check(true, "Write UTF8 test (conditionally)");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false, "Write UTF8 test");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream("utf8test.out");
            InputStreamReader isr = new InputStreamReader((InputStream)fis, "UTF8");
            char[] buf = new char[255];
            int chars_read = isr.read(buf, 0, str1.length());
            String str3 = new String(buf, 0, chars_read);
            chars_read = isr.read(buf, 0, str2.length());
            String str4 = new String(buf, 0, chars_read);
            harness.check(str1, str3, "Read UTF8 file");
            harness.check(str2, str4, "Read UTF8 file");
            isr.close();
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false, "Read UTF8 file");
        }
    }
}

