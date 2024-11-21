/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

public class MarkReset
implements Testlet {
    public static int marktest(InputStream ins, TestHarness harness) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(ins, 15);
        int total_read = 0;
        byte[] buf = new byte[12];
        int bytes_read = bis.read(buf);
        total_read += bytes_read;
        harness.debug(new String(buf, 0, bytes_read), false);
        bytes_read = bis.read(buf);
        total_read += bytes_read;
        harness.debug(new String(buf, 0, bytes_read), false);
        bis.mark(75);
        bis.read();
        bis.read(buf);
        bis.read(buf);
        bis.read(buf);
        bis.reset();
        bytes_read = bis.read(buf);
        total_read += bytes_read;
        harness.debug(new String(buf, 0, bytes_read), false);
        bis.mark(555);
        bytes_read = bis.read(buf);
        total_read += bytes_read;
        harness.debug(new String(buf, 0, bytes_read), false);
        bis.reset();
        bis.read(buf);
        bytes_read = bis.read(buf);
        total_read += bytes_read;
        harness.debug(new String(buf, 0, bytes_read), false);
        bytes_read = bis.read(buf);
        total_read += bytes_read;
        harness.debug(new String(buf, 0, bytes_read), false);
        bis.mark(14);
        bis.read(buf);
        bis.reset();
        bytes_read = bis.read(buf);
        total_read += bytes_read;
        harness.debug(new String(buf, 0, bytes_read), false);
        while ((bytes_read = bis.read(buf)) != -1) {
            harness.debug(new String(buf, 0, bytes_read), false);
            total_read += bytes_read;
        }
        return total_read;
    }

    private static void readFully(InputStream in, int len) throws IOException {
        byte[] buf = new byte[len];
        while (len > 0) {
            int nr = in.read(buf, 0, len);
            if (nr <= 0) {
                throw new IOException("Unexpected EOF");
            }
            len -= nr;
        }
    }

    @Override
    public void test(TestHarness harness) {
        BufferedInputStream bis;
        ByteArrayInputStream bais;
        int total_read;
        InputStream sbis;
        String str;
        try {
            harness.debug("First BufferedInputStream mark/reset series");
            harness.debug("Underlying InputStream does not support mark/reset");
            str = "My 6th grade teacher was named Mrs. Hostetler.\nShe had a whole list of rules that you were supposed to follow\nin class and if you broke a rule she would make you write the\nrules out several times.  The number varied depending on what\nrule you broke.  Since I knew I would get in trouble, I would\njust go ahead and write out a few sets on the long school bus\nride home so that if had to stay in during recess and write\nrules, five minutes later I could just tell the teacher I was\ndone so I could go outside and play kickball.\n";
            sbis = new StringBufferInputStream(str);
            total_read = MarkReset.marktest(sbis, harness);
            harness.check(total_read, str.length(), "total_read");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            harness.debug("Second BufferedInputStream mark/reset series");
            harness.debug("Underlying InputStream supports mark/reset");
            str = "My first day of college was fun.  A bunch of us\ngot pretty drunk, then this guy named Rick Flake (I'm not\nmaking that name up) took a piss in the bed of a Physical\nPlant dept pickup truck.  Later on we were walking across\ncampus, saw a cop, and took off running for no reason.\nWhen we got back to the dorm we found an even drunker guy\npassed out in a shopping cart outside.\n";
            sbis = new ByteArrayInputStream(str.getBytes());
            total_read = MarkReset.marktest(sbis, harness);
            harness.check(total_read, str.length(), "total_read");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            harness.checkPoint("Third BufferedInputStream mark/reset series");
            bais = new ByteArrayInputStream(new byte[100000]);
            bis = new BufferedInputStream(bais, 2048);
            bis.mark(2048);
            MarkReset.readFully(bis, 2049);
            harness.check(true);
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            harness.checkPoint("Forth BufferedInputStream mark/reset series");
            bais = new ByteArrayInputStream(new byte[100000]);
            bis = new BufferedInputStream(bais, 2048);
            bis.mark(2050);
            MarkReset.readFully(bis, 2050);
            bis.mark(2052);
            MarkReset.readFully(bis, 2052);
            harness.check(true);
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

