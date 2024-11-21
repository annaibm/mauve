/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.CharArrayReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharArrayReader;

public class OutOfBounds
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str = "In junior high, I did a lot writing.  I wrote a science\nfiction novel length story that was called 'The Destruction of\nPlanet Earth'.  All the characters in the story were my friends \nfrom school because I couldn't think up any cool names.\n";
        char[] str_chars = new char[str.length()];
        str.getChars(0, str.length(), str_chars, 0);
        char[] read_buf = new char[12];
        CharArrayReader car = new CharArrayReader(str_chars);
        harness.checkPoint("read(X) should throw IndexOutOfBoundsException");
        try {
            car.read(read_buf, 0, read_buf.length + 1);
            harness.check(false);
        }
        catch (IndexOutOfBoundsException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
        try {
            car.read(read_buf, read_buf.length, 1);
            harness.check(false);
        }
        catch (IndexOutOfBoundsException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

