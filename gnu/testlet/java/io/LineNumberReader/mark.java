/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.LineNumberReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

public class mark
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String s = "1234567890abcdef";
        for (int nr = 0; nr <= 16; ++nr) {
            for (int limit = 1; limit < 16 - nr; ++limit) {
                String test = "nr: " + nr + " limit: " + limit;
                try {
                    StringReader sr = new StringReader(s);
                    LineNumberReader lnr = new LineNumberReader(sr, 2);
                    for (int i = 0; i < nr; ++i) {
                        lnr.read();
                    }
                    lnr.mark(limit);
                    int j = lnr.read();
                    for (int i = 0; i < limit - 1; ++i) {
                        lnr.read();
                    }
                    lnr.reset();
                    int k = lnr.read();
                    harness.check(j, k, test);
                    continue;
                }
                catch (IOException e) {
                    harness.debug(e);
                    harness.check(false, test);
                }
            }
        }
    }
}

