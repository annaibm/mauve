/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setThreadID
implements Testlet {
    @Override
    public void test(TestHarness th) {
        LogRecord rec = new LogRecord(Level.CONFIG, "foo");
        rec.setThreadID(1234);
        th.check(rec.getThreadID(), 1234);
        rec.setThreadID(-4321);
        th.check(rec.getThreadID(), -4321);
    }
}

