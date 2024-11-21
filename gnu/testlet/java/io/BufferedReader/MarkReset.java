/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class MarkReset
extends CharArrayReader
implements Testlet {
    @Override
    public boolean markSupported() {
        return false;
    }

    public MarkReset(char[] buf) {
        super(buf);
    }

    public MarkReset() {
        super(new char[1]);
    }

    public static int marktest(Reader ins, TestHarness harness) throws IOException {
        BufferedReader br = new BufferedReader(ins, 15);
        int total_read = 0;
        char[] buf = new char[12];
        int chars_read = br.read(buf);
        total_read += chars_read;
        harness.debug(new String(buf, 0, chars_read), false);
        chars_read = br.read(buf);
        total_read += chars_read;
        harness.debug(new String(buf, 0, chars_read), false);
        br.mark(75);
        br.read();
        br.read(buf);
        br.read(buf);
        br.read(buf);
        br.reset();
        chars_read = br.read(buf);
        total_read += chars_read;
        harness.debug(new String(buf, 0, chars_read), false);
        br.mark(555);
        chars_read = br.read(buf);
        total_read += chars_read;
        harness.debug(new String(buf, 0, chars_read), false);
        br.reset();
        br.read(buf);
        chars_read = br.read(buf);
        total_read += chars_read;
        harness.debug(new String(buf, 0, chars_read), false);
        chars_read = br.read(buf);
        total_read += chars_read;
        harness.debug(new String(buf, 0, chars_read), false);
        br.mark(14);
        br.read(buf);
        br.reset();
        chars_read = br.read(buf);
        total_read += chars_read;
        harness.debug(new String(buf, 0, chars_read), false);
        while ((chars_read = br.read(buf)) != -1) {
            harness.debug(new String(buf, 0, chars_read), false);
            total_read += chars_read;
        }
        return total_read;
    }

    @Override
    public void test(TestHarness harness) {
        String str;
        try {
            harness.debug("First mark/reset test series");
            harness.debug("Underlying reader supports mark/reset");
            str = "Growing up in a rural area brings such delights.  One\ntime my uncle called me up and asked me to come over and help him\nout with something.  Since he lived right across the field, I\nwalked right over.  Turned out he wanted me to come down to the\nbarn and help him castrate a calf.  Oh, that was fun.  Not.\n";
            StringReader sr = new StringReader(str);
            BufferedReader br = new BufferedReader(sr);
            int total_read = MarkReset.marktest(br, harness);
            harness.check(total_read, str.length(), "total_read");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            harness.debug("Second mark/reset test series");
            harness.debug("Underlying reader does not support mark/reset");
            str = "Growing up we heated our house with a wood stove.  That\nthing could pump out some BTU's, let me tell you.  No matter how\ncold it got outside, it was always warm inside.  Of course the\ndownside is that somebody had to chop the wood for the stove. That\nsomebody was me.  I was slave labor.  My uncle would go back and\nchain saw up dead trees and I would load the wood in wagons and\nsplit it with a maul. Somehow my no account brother always seemed\nto get out of having to work.\n";
            char[] buf = new char[str.length()];
            str.getChars(0, str.length(), buf, 0);
            MarkReset mr = new MarkReset(buf);
            BufferedReader br = new BufferedReader(mr);
            int total_read = MarkReset.marktest(br, harness);
            harness.check(total_read, str.length(), "total_read");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

