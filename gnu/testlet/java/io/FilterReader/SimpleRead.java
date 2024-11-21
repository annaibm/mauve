/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FilterReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharArrayReader;
import java.io.FilterReader;
import java.io.IOException;

public class SimpleRead
extends FilterReader
implements Testlet {
    public SimpleRead() {
        this(new CharArrayReader(new char[0]));
    }

    SimpleRead(CharArrayReader car) {
        super(car);
    }

    @Override
    public void test(TestHarness harness) {
        String str = "In junior high, I did a lot writing.  I wrote a science\nfiction novel length story that was called 'The Destruction of\nPlanet Earth'.  All the characters in the story were my friends \nfrom school because I couldn't think up any cool names.\n";
        char[] str_chars = new char[str.length()];
        str.getChars(0, str.length(), str_chars, 0);
        char[] read_buf = new char[12];
        CharArrayReader car = new CharArrayReader(str_chars);
        SimpleRead fr = new SimpleRead(car);
        try {
            int chars_read;
            harness.check(fr.read(), 73, "read()");
            int total_read = 0;
            while ((chars_read = fr.read(read_buf, 0, read_buf.length)) != -1) {
                harness.debug(new String(read_buf, 0, chars_read), false);
                total_read += chars_read;
            }
            harness.check(total_read, str.length() - 1, "read(buf,off,len)");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

