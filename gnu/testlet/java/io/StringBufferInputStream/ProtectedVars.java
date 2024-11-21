/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.StringBufferInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.StringBufferInputStream;

public class ProtectedVars
extends StringBufferInputStream
implements Testlet {
    public ProtectedVars(String b) {
        super(b);
    }

    public ProtectedVars() {
        super("");
    }

    @Override
    public void test(TestHarness harness) {
        String str = "Between my freshman and sophomore years of high school\nwe moved into a brand new building.  The old high school was turned\ninto an elementary school.\n";
        ProtectedVars sbis = new ProtectedVars(str);
        byte[] read_buf = new byte[12];
        try {
            sbis.read(read_buf);
            sbis.mark(0);
            sbis.read(read_buf);
            harness.check(sbis.pos, read_buf.length * 2, "pos");
            harness.check(sbis.count, str.length(), "count");
            harness.check(sbis.buffer, str, "buf");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

