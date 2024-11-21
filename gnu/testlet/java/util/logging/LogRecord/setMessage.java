/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setMessage
implements Testlet {
    @Override
    public void test(TestHarness th) {
        LogRecord rec = new LogRecord(Level.CONFIG, "msg");
        th.check(rec.getMessage(), (Object)"msg");
        rec.setMessage("foo");
        th.check(rec.getMessage(), (Object)"foo");
        rec.setMessage(null);
        th.check(rec.getMessage(), null);
        rec.setMessage("");
        th.check(rec.getMessage(), (Object)"");
    }
}

