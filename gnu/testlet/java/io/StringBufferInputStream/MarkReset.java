/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.StringBufferInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.StringBufferInputStream;

public class MarkReset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str = "Between my freshman and sophomore years of high school\nwe moved into a brand new building.  The old high school was turned\ninto an elementary school.\n";
        StringBufferInputStream sbis = new StringBufferInputStream(str);
        try {
            boolean passed = true;
            byte[] read_buf = new byte[12];
            sbis.read(read_buf);
            harness.check(sbis.available(), str.length() - read_buf.length, "available pre skip");
            harness.check(sbis.skip(5L), 5L, "skip");
            harness.check(sbis.available(), str.length() - (read_buf.length + 5), "available post skip");
            harness.check(!sbis.markSupported(), "markSupported");
            sbis.reset();
            harness.check(sbis.available(), str.length(), "reset()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

