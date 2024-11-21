/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setLoggerName
implements Testlet {
    @Override
    public void test(TestHarness th) {
        LogRecord rec = new LogRecord(Level.CONFIG, "msg");
        th.check(rec.getLoggerName(), null);
        rec.setLoggerName("foo");
        th.check(rec.getLoggerName(), (Object)"foo");
        rec.setLoggerName(null);
        th.check(rec.getLoggerName(), null);
        rec.setLoggerName("");
        th.check(rec.getLoggerName(), (Object)"");
    }
}

