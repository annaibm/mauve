/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setParameters
implements Testlet {
    @Override
    public void test(TestHarness th) {
        LogRecord rec = new LogRecord(Level.CONFIG, "msg");
        Object[] params = new Object[]{"foo", "bar", "baz"};
        th.check(rec.getParameters(), null);
        rec.setParameters(params);
        th.check(rec.getParameters() == params);
        rec.setParameters(null);
        th.check(rec.getParameters(), null);
    }
}

