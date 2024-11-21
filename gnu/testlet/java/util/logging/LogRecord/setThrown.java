/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setThrown
implements Testlet {
    @Override
    public void test(TestHarness th) {
        LogRecord rec = new LogRecord(Level.CONFIG, "foo");
        IllegalStateException ex = new IllegalStateException();
        th.check(rec.getThrown(), null);
        rec.setThrown(ex);
        th.check(rec.getThrown(), ex);
        rec.setThrown(null);
        th.check(rec.getThrown(), null);
    }
}

