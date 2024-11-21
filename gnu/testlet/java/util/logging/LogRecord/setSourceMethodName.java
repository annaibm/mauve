/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setSourceMethodName
implements Testlet {
    @Override
    public void test(TestHarness th) {
        LogRecord rec = new LogRecord(Level.CONFIG, "msg");
        rec.setSourceMethodName("fooBar");
        th.check(rec.getSourceMethodName(), (Object)"fooBar");
        rec.setSourceMethodName(null);
        th.check(rec.getSourceMethodName(), null);
    }
}

