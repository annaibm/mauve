/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setSourceClassName
implements Testlet {
    @Override
    public void test(TestHarness th) {
        LogRecord rec = new LogRecord(Level.CONFIG, "msg");
        rec.setSourceClassName(Testlet.class.getName());
        th.check(rec.getSourceClassName(), (Object)Testlet.class.getName());
        rec.setSourceClassName(null);
        th.check(rec.getSourceClassName(), null);
    }
}

