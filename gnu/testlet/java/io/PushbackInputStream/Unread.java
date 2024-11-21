/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PushbackInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.io.StringBufferInputStream;

public class Unread
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str = "Once when I was in fourth grade, my friend Lloyd\nSaltsgaver and I got in trouble for kicking a bunch of\nKindergartners off the horse swings so we could play a game\nof 'road hog'\n";
        try {
            int bytes_read;
            PushbackInputStream pist = new PushbackInputStream(new StringBufferInputStream(str), 15);
            harness.check(pist.available(), str.length(), "available()");
            harness.check(!pist.markSupported(), "markSupported()");
            byte[] read_buf1 = new byte[12];
            byte[] read_buf2 = new byte[12];
            pist.read(read_buf1);
            pist.unread(read_buf1);
            pist.read(read_buf2);
            for (int i = 0; i < read_buf1.length; ++i) {
                if (read_buf1[i] == read_buf2[i]) continue;
                throw new IOException("Re-reading bytes gave different results");
            }
            pist.unread(read_buf2, 1, read_buf2.length - 1);
            pist.unread(read_buf2[0]);
            int total_read = 0;
            while ((bytes_read = pist.read(read_buf1)) != -1) {
                harness.debug(new String(read_buf1, 0, bytes_read), false);
                total_read += bytes_read;
            }
            harness.debug(str);
            harness.check(total_read, str.length(), "total_read == str.length()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

