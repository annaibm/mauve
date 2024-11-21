/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FilterReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharArrayReader;
import java.io.FilterReader;
import java.io.IOException;

public class MarkReset
extends FilterReader
implements Testlet {
    public MarkReset(char[] ca) {
        super(new CharArrayReader(ca));
    }

    public MarkReset() {
        super(new CharArrayReader(new char[1]));
    }

    @Override
    public void test(TestHarness harness) {
        String str = "In junior high, I did a lot writing.  I wrote a science\nfiction novel length story that was called 'The Destruction of\nPlanet Earth'.  All the characters in the story were my friends \nfrom school because I couldn't think up any cool names.";
        char[] str_chars = new char[str.length()];
        str.getChars(0, str.length(), str_chars, 0);
        MarkReset fr = new MarkReset(str_chars);
        char[] read_buf = new char[12];
        try {
            fr.read(read_buf);
            harness.check(fr.ready(), "ready()");
            harness.check(fr.skip(5L), 5L, "skip()");
            harness.check(fr.markSupported(), "markSupported()");
            fr.mark(0);
            fr.read();
            fr.reset();
            fr.close();
            harness.check(true, "close()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

