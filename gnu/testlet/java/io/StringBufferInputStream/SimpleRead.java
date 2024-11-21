/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.StringBufferInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.StringBufferInputStream;

public class SimpleRead
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str = "Between my freshman and sophomore years of high school\nwe moved into a brand new building.  The old high school was turned\ninto an elementary school.\n";
        StringBufferInputStream sbis = new StringBufferInputStream(str);
        try {
            int bytes_read;
            int total_read = 0;
            StringBuffer sb = new StringBuffer("");
            byte[] read_buf = new byte[12];
            while ((bytes_read = sbis.read(read_buf, 0, read_buf.length)) != -1) {
                sb.append(new String(read_buf, 0, bytes_read));
                total_read += bytes_read;
            }
            harness.debug(sb.toString());
            sbis.close();
            harness.check(total_read, str.length(), "Bytes read");
            harness.check(str, sb.toString(), "String contents");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

