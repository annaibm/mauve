/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;

public class SimpleRead
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            int bytes_read;
            String str = "One of my 8th grade teachers was Mr. Russell.\nHe used to start each year off by telling the class that the\nearth was flat.  He did it to teach people to question\nthings they are told.  But everybody knew that he did it\nso it lost its effect.\n";
            StringBufferInputStream sbis = new StringBufferInputStream(str);
            BufferedInputStream bis = new BufferedInputStream(sbis, 15);
            byte[] buf = new byte[12];
            int total_read = 0;
            while ((bytes_read = bis.read(buf)) != -1) {
                harness.debug(new String(buf, 0, bytes_read), false);
                total_read += bytes_read;
            }
            bis.close();
            harness.check(total_read, str.length(), "total_read");
            sbis = new StringBufferInputStream(str);
            bis = new BufferedInputStream(sbis);
            harness.check(bis.available(), str.length(), "available()");
            harness.debug(bis.available() + " bytes available; should be " + str.length());
            harness.check(bis.markSupported(), "markSupported()");
            harness.debug("Mark " + (bis.markSupported() ? "is" : "is not") + " supported.");
            int skip = 10;
            long skipped = bis.skip(skip);
            harness.check(skipped, (long)skip, "skip(long)");
            harness.debug("Skipped " + skipped + "(=" + skip + "?) bytes");
            harness.debug("Reading " + bis.read(buf, 0, 3) + "(=3?) bytes");
            String tst = new String(buf, 0, 3);
            harness.check(tst, str.substring(skip, skip + 3), "read(buf[], off, len)");
            harness.debug("Extracted " + tst + "; expected " + str.substring(skip, skip + 3));
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

