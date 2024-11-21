/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setMillis
implements Testlet {
    @Override
    public void test(TestHarness th) {
        LogRecord rec = new LogRecord(Level.CONFIG, "foo");
        rec.setMillis(12345L);
        th.check(rec.getMillis(), 12345L);
        rec.setMillis(-54321L);
        th.check(rec.getMillis(), -54321L);
    }
}

