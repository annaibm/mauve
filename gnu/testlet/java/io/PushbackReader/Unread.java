/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PushbackReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

public class Unread
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str = "I used to idolize my older cousin Kurt.  I wanted to be\njust like him when I was a kid.  (Now we are as different as night\nand day - but still like each other).  One thing he did for a while\nwas set traps for foxes thinking he would make money off selling furs.\nNow I never saw a fox in all my years of Southern Indiana.  That\ndidn't deter us.  One time we went out in the middle of winter to\ncheck our traps.  It was freezing and I stepped onto a frozen over\nstream. The ice broke and I got my foot soaked.  Despite the fact that\nit made me look like a girl, I turned around and went straight home.\nGood thing too since I couldn't even feel my foot by the time I got\nthere.\n";
        try {
            int chars_read;
            PushbackReader prt = new PushbackReader(new StringReader(str), 15);
            char[] read_buf1 = new char[12];
            char[] read_buf2 = new char[12];
            boolean passed = true;
            harness.check(prt.ready(), "ready()");
            harness.check(!prt.markSupported(), "markSupported()");
            prt.read(read_buf1);
            prt.unread(read_buf1);
            prt.read(read_buf2);
            for (int i = 0; i < read_buf1.length; ++i) {
                if (read_buf1[i] == read_buf2[i]) continue;
                throw new IOException("Re-reading bytes gave different results");
            }
            prt.unread(read_buf2, 1, read_buf2.length - 1);
            prt.unread(read_buf2[0]);
            int total_read = 0;
            while ((chars_read = prt.read(read_buf1)) != -1) {
                harness.debug(new String(read_buf1, 0, chars_read), false);
                total_read += chars_read;
            }
            harness.check(total_read, str.length(), "total_read == str.length()");
            prt.close();
            harness.check(true, "close()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

