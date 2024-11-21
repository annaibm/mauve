/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.CharArrayReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharArrayReader;
import java.io.IOException;

public class MarkReset
extends CharArrayReader
implements Testlet {
    public MarkReset(char[] c) {
        super(c);
    }

    public MarkReset() {
        super(new char[1]);
    }

    @Override
    public void test(TestHarness harness) {
        String str = "In junior high, I did a lot writing.  I wrote a science\nfiction novel length story that was called 'The Destruction of\nPlanet Earth'.  All the characters in the story were my friends \nfrom school because I couldn't think up any cool names.";
        char[] str_chars = new char[str.length()];
        str.getChars(0, str.length(), str_chars, 0);
        MarkReset car = new MarkReset(str_chars);
        char[] read_buf = new char[12];
        try {
            car.read(read_buf);
            harness.check(car.ready(), "ready()");
            harness.check(car.skip(5L), 5L, "skip()");
            harness.check(car.markSupported(), "markSupported()");
            car.mark(0);
            int pos_save = car.pos;
            car.read();
            car.reset();
            harness.check(car.pos, pos_save, "reset()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

