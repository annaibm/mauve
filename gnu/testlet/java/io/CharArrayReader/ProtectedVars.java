/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.CharArrayReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharArrayReader;
import java.io.IOException;

public class ProtectedVars
extends CharArrayReader
implements Testlet {
    public ProtectedVars(char[] b) {
        super(b);
    }

    public ProtectedVars() {
        super(new char[1]);
    }

    @Override
    public void test(TestHarness harness) {
        String str = "In junior high, I did a lot writing.  I wrote a science\nfiction novel length story that was called 'The Destruction of\nPlanet Earth'.  All the characters in the story were my friends \nfrom school because I couldn't think up any cool names.";
        char[] str_chars = new char[str.length()];
        str.getChars(0, str.length(), str_chars, 0);
        ProtectedVars car = new ProtectedVars(str_chars);
        char[] read_buf = new char[12];
        try {
            car.read(read_buf);
            car.mark(0);
            harness.check(car.markedPos, read_buf.length, "markedPos");
            car.read(read_buf);
            harness.check(car.pos, read_buf.length * 2, "pos");
            harness.check(car.count, str_chars.length, "count");
            harness.check(car.buf, str_chars, "buf");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

