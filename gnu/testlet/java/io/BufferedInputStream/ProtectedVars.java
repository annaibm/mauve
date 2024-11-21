/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

public class ProtectedVars
extends BufferedInputStream
implements Testlet {
    public ProtectedVars(InputStream in, int size2) {
        super(in, size2);
    }

    public ProtectedVars() {
        super(System.in);
    }

    @Override
    public void test(TestHarness harness) {
        try {
            String str = "This is a test line of text for this pass";
            StringBufferInputStream sbis = new StringBufferInputStream(str);
            ProtectedVars bist = new ProtectedVars(sbis, 12);
            bist.read();
            bist.mark(5);
            harness.check(bist.buf.length, 12, "buf.length");
            harness.check(bist.count, 12, "count");
            harness.check(bist.marklimit, 5, "marklimit");
            harness.check(bist.markpos, 1, "markpos");
            harness.check(bist.pos, 1, "pos");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

