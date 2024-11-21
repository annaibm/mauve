/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Skip
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            byte[] ba = new byte[]{68, 85};
            ByteArrayInputStream bais = new ByteArrayInputStream(ba);
            BufferedInputStream bis = new BufferedInputStream(bais);
            long s = bis.skip(2L);
            harness.check(s, 2L, "skip(2)");
            harness.debug(s + " bytes skipped; should be 2");
            s = bis.skip(2L);
            harness.check(s >= 0L, true, "skip(2) >= 0");
            harness.debug(s + " bytes skipped; should be >= 0");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

