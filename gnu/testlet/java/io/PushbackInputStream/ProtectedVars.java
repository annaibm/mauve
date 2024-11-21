/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PushbackInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.StringBufferInputStream;

public class ProtectedVars
extends PushbackInputStream
implements Testlet {
    public ProtectedVars(InputStream is, int size2) {
        super(is, size2);
    }

    public ProtectedVars() {
        super(null);
    }

    @Override
    public void test(TestHarness harness) {
        String str = "Once when I was in fourth grade, my friend Lloyd\nSaltsgaver and I got in trouble for kicking a bunch of\nKindergartners off the horse swings so we could play a game\nof 'road hog'\n";
        ProtectedVars pv = new ProtectedVars(new StringBufferInputStream(str), 15);
        harness.check(pv.pos, pv.buf.length, "pst == buf.length");
        harness.check(pv.buf.length, 15, "buf.length");
    }
}

