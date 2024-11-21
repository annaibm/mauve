/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.ResourceNotFoundException;
import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.lang.Character.UnicodeBase;
import java.io.IOException;

public class unicode
extends UnicodeBase
implements Testlet {
    public unicode() {
    }

    public unicode(TestHarness aHarness, String filename) throws IOException, ResourceNotFoundException {
        super(aHarness, filename);
    }

    @Override
    public void test(TestHarness harness) {
        String fileName = "UnicodeData-4.0.0.txt";
        long start = System.currentTimeMillis();
        try {
            unicode t = new unicode(harness, fileName);
            long midtime = System.currentTimeMillis();
            t.performTests();
            harness.debug("Benchmark : load:" + (midtime - start) + "ms   tests:" + (System.currentTimeMillis() - midtime) + "ms");
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

