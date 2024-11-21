/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setLevel
implements Testlet {
    @Override
    public void test(TestHarness h) {
        LogRecord rec = new LogRecord(Level.INFO, "msg");
        h.check(rec.getLevel() == Level.INFO);
        rec.setLevel(Level.WARNING);
        h.check(rec.getLevel() == Level.WARNING);
    }
}

