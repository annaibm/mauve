/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogRecord;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class setSequenceNumber
implements Testlet {
    @Override
    public void test(TestHarness th) {
        long s2;
        LogRecord rec1 = new LogRecord(Level.CONFIG, "msg");
        LogRecord rec2 = new LogRecord(Level.CONFIG, "msg2");
        long s1 = rec1.getSequenceNumber();
        if (s1 >= 0L == (s2 = rec2.getSequenceNumber()) >= 0L) {
            th.check(s2 > s1);
        } else {
            th.check(true);
        }
        rec2.setSequenceNumber(42L);
        th.check(rec2.getSequenceNumber() == 42L);
        rec2.setSequenceNumber(s2);
        th.check(rec2.getSequenceNumber() == s2);
    }
}

