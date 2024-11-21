/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedWriter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.IOException;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            CharArrayWriter caw = new CharArrayWriter(24);
            BufferedWriter bw = new BufferedWriter(caw, 12);
            String str = "I used to live right behind this super-cool bar in\nChicago called Lounge Ax.  They have the best music of pretty\nmuch anyplace in town with a great atmosphere and $1 Huber\non tap.  I go to tons of shows there, even though I moved.\n";
            char[] buf = new char[str.length()];
            str.getChars(0, str.length(), buf, 0);
            bw.write(str.substring(0, 5));
            harness.check(caw.toCharArray().length, 0, "buffering/toCharArray");
            bw.write(buf, 5, 8);
            bw.write(buf, 13, 12);
            bw.write(buf[25]);
            bw.write(buf, 26, buf.length - 27);
            bw.newLine();
            bw.flush();
            bw.close();
            String str2 = new String(caw.toCharArray());
            harness.check(str, str2, "Did all chars make it through?");
            harness.debug(str2, false);
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false, "Caught unexpected exception");
        }
    }
}

