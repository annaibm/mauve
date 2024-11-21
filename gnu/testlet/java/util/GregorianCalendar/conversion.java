/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.GregorianCalendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class conversion
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.testTimeZero();
        this.testMonotonic1();
        this.testMonotonic2();
    }

    private void testTimeZero() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.setTimeInMillis(0L);
        this.harness.checkPoint("Testing setTimeInMillis(0L)");
        this.harness.check(cal.getTimeInMillis(), 0L);
        this.harness.check(cal.get(0), 1);
        this.harness.check(cal.get(1), 1970);
        this.harness.check(cal.get(2), 0);
        this.harness.check(cal.get(5), 1);
        this.harness.check(cal.get(11), 0);
        this.harness.check(cal.get(12), 0);
        this.harness.check(cal.get(13), 0);
        this.harness.check(cal.get(14), 0);
    }

    private void testMonotonic1() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        long[] times = new long[64];
        times[0] = 0L;
        for (int i = 1; i < 63; ++i) {
            times[i] = 1L << i;
        }
        times[63] = Long.MAX_VALUE;
        cal.setTimeInMillis(times[0]);
        long[] prevFields = this.getCalFields(cal);
        for (int i = 1; i < times.length; ++i) {
            cal.setTimeInMillis(times[i]);
            long[] fields = this.getCalFields(cal);
            this.harness.checkPoint("Testing setTimeInMillis(" + times[i] + ") i = " + i);
            this.harness.check(fields[0], times[i]);
            for (int j = 1; j < fields.length; ++j) {
                if (fields[j] == prevFields[j]) continue;
                this.harness.check(fields[j] > prevFields[j]);
                if (fields[j] >= prevFields[j]) break;
                this.harness.debug("cal field " + j + " " + this.dumpCalFields(fields) + " < " + this.dumpCalFields(prevFields));
                break;
            }
            prevFields = fields;
        }
    }

    private void testMonotonic2() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        long[] times = new long[63];
        for (int i = 0; i < 63; ++i) {
            times[62 - i] = -1L << i;
        }
        cal.setTimeInMillis(times[0]);
        long[] prevFields = this.getCalFields(cal);
        for (int i = 1; i < times.length; ++i) {
            cal.setTimeInMillis(times[i]);
            long[] fields = this.getCalFields(cal);
            this.harness.checkPoint("Testing setTimeInMillis(" + times[i] + ") i = " + i);
            this.harness.check(fields[0], times[i]);
            if (fields[1] == prevFields[1]) {
                for (int j = 2; j < fields.length; ++j) {
                    if (fields[j] == prevFields[j]) continue;
                    boolean ok = fields[j] > prevFields[j] == (j > 2 || fields[1] == 1L);
                    this.harness.check(ok);
                    if (ok) break;
                    this.harness.debug("cal field " + j + " " + this.dumpCalFields(fields) + " < " + this.dumpCalFields(prevFields));
                    break;
                }
            }
            prevFields = fields;
        }
    }

    private long[] getCalFields(GregorianCalendar cal) {
        return new long[]{cal.getTimeInMillis(), cal.get(0), cal.get(1), cal.get(2), cal.get(5), cal.get(11), cal.get(12), cal.get(13), cal.get(14)};
    }

    private String dumpCalFields(long[] fields) {
        StringBuffer sb = new StringBuffer();
        sb.append(fields[0]);
        for (int i = 1; i < fields.length; ++i) {
            sb.append(i == 1 ? " {" : ", ");
            sb.append(fields[i]);
        }
        sb.append("}");
        return sb.toString();
    }
}

