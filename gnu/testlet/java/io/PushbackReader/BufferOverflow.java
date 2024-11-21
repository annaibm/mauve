/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PushbackReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

public class BufferOverflow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str = "I used to idolize my older cousin Kurt.  I wanted to be\njust like him when I was a kid.  (Now we are as different as night\nand day - but still like each other).  One thing he did for a while\nwas set traps for foxes thinking he would make money off sellnig furs.\nNow I never saw a fox in all my years of Southern Indiana.  That\ndidn't deter us.  One time we went out in the middle of winter to\ncheck our traps.  It was freezing and I stepped onto a frozen over\nstream. The ice broke and I got my foot soak.  Despite the fact that\nit made me look like a girl, I turned around and went straight home.\nGood thing too since I couldn't even feel my foot by the time I got\nthere.\n";
        try {
            PushbackReader prt = new PushbackReader(new StringReader(str), 10);
            char[] read_buf = new char[12];
            prt.read(read_buf);
            prt.unread(read_buf);
            harness.debug("Did not throw expected buffer overflow exception");
            harness.check(false);
        }
        catch (IOException e) {
            harness.check(true);
        }
    }
}

