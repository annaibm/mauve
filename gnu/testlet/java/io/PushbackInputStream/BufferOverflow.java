/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PushbackInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.io.StringBufferInputStream;

public class BufferOverflow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str = "Once when I was in fourth grade, my friend Lloyd\nSaltsgaver and I got in trouble for kicking a bunch of\nKindergartners off the horse swings so we could play a game\nof 'road hog'\n";
        try {
            PushbackInputStream pist = new PushbackInputStream(new StringBufferInputStream(str), 10);
            byte[] read_buf = new byte[12];
            pist.read(read_buf);
            pist.unread(read_buf);
            harness.debug("Failed overflow test");
            harness.check(false);
        }
        catch (IOException e) {
            harness.debug("Got expected exception: " + e);
            harness.check(true);
        }
    }
}

