/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.zip.ZipEntry;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.zip.ZipEntry;

public class time
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ZipEntry entry = new ZipEntry("test");
        long t = 1086325228000L;
        entry.setTime(t);
        long t1 = entry.getTime();
        harness.check(t, t1, "setTime or getTime broken");
    }
}

