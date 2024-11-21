/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Utf8Encoding;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadReference
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str1 = "This is the first line of text\n";
        String str2 = "This has some \u01ff\ua000\u6666\u0200 weird characters\n";
        try {
            InputStream is = harness.getResourceStream("gnu#testlet#java#io#Utf8Encoding#utf8test.bin");
            InputStreamReader isr = new InputStreamReader(is, "UTF8");
            char[] buf = new char[255];
            int chars_read = isr.read(buf, 0, str1.length());
            String str3 = new String(buf, 0, chars_read);
            chars_read = isr.read(buf, 0, str2.length());
            String str4 = new String(buf, 0, chars_read);
            harness.check(str1, str3, "Read UTF8 reference file");
            harness.check(str2, str4, "Read UTF8 reference file");
            isr.close();
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false, "Read UTF8 reference file");
        }
    }
}

