/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.GregorianCalendar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

public class internal
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        long expectTime;
        int[][] checkFields = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1970, 0, 1, 1, 1, 1, 5, 1, 0, 0, 0, 0, 0, 0, -18000000, 0}, {1, 1969, 11, 1, 5, 31, 365, 4, 5, 1, 10, 22, 0, 0, 0, -25200000, 0}, {1, 1970, 11, 1, 5, 31, 365, 5, 5, 1, 10, 22, 0, 0, 0, -25200000, 0}, {1, 1969, 0, 5, 5, 31, 31, 6, 5, 1, 10, 22, 0, 0, 0, -25200000, 0}, {1, 1970, 0, 1, 1, 1, 1, 5, 1, 0, 0, 0, 0, 0, 0, -25200000, 0}, {0, 2007, 3, 15, 4, 18, 107, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0}};
        TestCalendar c = TestCalendar.getTestCalendar(TimeZone.getTimeZone("EST"), Locale.US);
        c.checkState(harness, false, 0, checkFields[0], false, 0L);
        harness.check(c.getFirstDayOfWeek() == 1);
        harness.check(c.getMinimalDaysInFirstWeek() == 1);
        c.get(1);
        c.checkState(harness, true, 131071, checkFields[1], true, 18000000L);
        c.setTimeZone(TimeZone.getTimeZone("MST"));
        c.checkState(harness, false, 131071, checkFields[1], true, 18000000L);
        c.get(1);
        c.checkState(harness, true, 131071, checkFields[2], true, 18000000L);
        for (int i = 0; i < 17; ++i) {
            TestCalendar d = (TestCalendar)c.clone();
            int[] expectFields = (int[])checkFields[2].clone();
            expectTime = 18000000L;
            d.checkState(harness, true, 131071, expectFields, true, expectTime);
            d.clear(i);
            expectFields[i] = 0;
            d.checkState(harness, false, ~(1 << i), expectFields, false, expectTime);
            d.get(1);
            if (i == 1) {
                expectFields = checkFields[3];
                expectTime = 31554000000L;
            } else if (i == 2) {
                expectFields = checkFields[4];
                expectTime = -28839600000L;
            } else {
                expectFields = checkFields[2];
                expectTime = 18000000L;
            }
            d.checkState(harness, true, 131071, expectFields, true, expectTime);
        }
        c.clear();
        c.checkState(harness, false, 0, checkFields[0], false, 18000000L);
        c.get(1);
        c.checkState(harness, true, 131071, checkFields[5], true, 25200000L);
        c.setTimeInMillis(18000000L);
        c.checkState(harness, true, 131071, checkFields[2], true, 18000000L);
        Permutator iter2 = new Permutator(8);
        while (iter2.hasNext()) {
            int[] order = (int[])iter2.next();
            int i = 0;
            while (i < order.length) {
                int n = i++;
                order[n] = order[n] + 1;
            }
            c.setTimeInMillis(0L);
            c.clear();
            for (i = 0; i < order.length; ++i) {
                c.set(order[i], checkFields[6][order[i]]);
            }
            c.checkState(harness, false, 510, checkFields[6], false, 0L);
            int[] setOrder = new int[6];
            int i2 = 0;
            int j = setOrder.length - 1;
            while (j >= 0) {
                if (order[i2] >= 3 && order[i2] <= 8) {
                    setOrder[j--] = order[i2];
                }
                ++i2;
            }
            expectTime = -1L;
            if (setOrder[0] == 5) {
                expectTime = 1176879600000L;
            } else if (setOrder[0] == 8) {
                expectTime = 1178175600000L;
            } else if (setOrder[0] == 6) {
                expectTime = 1176793200000L;
            } else if (setOrder[0] == 3) {
                expectTime = 1176361200000L;
            } else if (setOrder[0] == 7) {
                for (int i3 = 1; i3 < setOrder.length; ++i3) {
                    if (setOrder[i3] == 5 || setOrder[i3] == 6) continue;
                    expectTime = setOrder[i3] == 3 ? 1176361200000L : (setOrder[i3] == 4 ? 1177570800000L : 1178175600000L);
                    break;
                }
            } else {
                expectTime = 1177570800000L;
            }
            long actualTime = c.getTimeInMillis();
            harness.check(actualTime == expectTime);
        }
    }

    private static class Permutator
    implements Iterator {
        private int size;
        private int length;
        private int pos;

        public Permutator(int s) {
            this.size = s;
            this.length = 1;
            for (int i = 2; i <= this.size; ++i) {
                this.length *= i;
            }
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return this.pos < this.length;
        }

        public Object next() {
            int[] result = new int[this.size];
            boolean[] used = new boolean[this.size];
            int tmp = this.pos;
            for (int j = this.size; j > 0; --j) {
                int choice = tmp % j;
                for (int k = 0; k < this.size; ++k) {
                    if (used[k]) continue;
                    if (choice == 0) {
                        result[this.size - j] = k;
                        used[k] = true;
                        break;
                    }
                    --choice;
                }
                tmp /= j;
            }
            ++this.pos;
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class TestCalendar
    extends GregorianCalendar {
        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public static TestCalendar getTestCalendar(TimeZone zone, Locale locale) {
            Locale defaultLocale = Locale.getDefault();
            Locale.setDefault(locale);
            try {
                TestCalendar c = new TestCalendar();
                c.setTimeZone(zone);
                TestCalendar testCalendar = c;
                return testCalendar;
            }
            finally {
                Locale.setDefault(defaultLocale);
            }
        }

        private TestCalendar() {
            super(2007, 3, 11);
            this.clear();
        }

        public void checkState(TestHarness harness, boolean areFieldsSet, int isSetBitmask, int[] fields, boolean isTimeSet, long time2) {
            String expected = this.stateString(areFieldsSet, isSetBitmask, isTimeSet, time2);
            harness.debug("expecting " + expected);
            String actual = this.stateString(this.areFieldsSet, this.isSet, this.isTimeSet, this.time);
            boolean success = expected.equals(actual);
            if (!success) {
                harness.debug("      got " + actual);
            }
            harness.check(success);
            expected = this.stateString(fields);
            harness.debug("expecting " + expected);
            actual = this.stateString(this.fields);
            success = expected.equals(actual);
            if (!success) {
                harness.debug("      got " + actual);
            }
            harness.check(success);
        }

        private String stateString(boolean areFieldsSet, int isSetBitmask, boolean isTimeSet, long time2) {
            String result = areFieldsSet + " (";
            for (int i = 0; i < 17; ++i) {
                result = result + ((isSetBitmask & 1 << i) != 0 ? "S" : "-");
            }
            result = result + "), " + isTimeSet + " (" + time2 + ")";
            return result;
        }

        private String stateString(boolean areFieldsSet, boolean[] isSet, boolean isTimeSet, long time2) {
            int isSetBitmask = 0;
            for (int i = 0; i < 17; ++i) {
                if (!isSet[i]) continue;
                isSetBitmask |= 1 << i;
            }
            return this.stateString(areFieldsSet, isSetBitmask, isTimeSet, time2);
        }

        private String stateString(int[] fields) {
            String result = "{";
            for (int i = 0; i < 17; ++i) {
                if (i > 0) {
                    result = result + ", ";
                }
                result = result + fields[i];
            }
            result = result + "}";
            return result;
        }
    }
}

