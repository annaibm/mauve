/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerDateModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;
import javax.swing.SpinnerDateModel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        Date before2 = new Date();
        SpinnerDateModel m = new SpinnerDateModel();
        Date after2 = new Date();
        Date date = (Date)m.getValue();
        harness.check(date.getTime() >= before2.getTime());
        harness.check(date.getTime() <= after2.getTime());
        harness.check(m.getStart(), null);
        harness.check(m.getEnd(), null);
        harness.check(m.getCalendarField(), 5);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Date, Comparable, Comparable, int)");
        Date now = new Date();
        Date start = new Date(now.getTime() - 1L);
        Date end2 = new Date(now.getTime() + 1L);
        Date preStart = new Date(now.getTime() - 2L);
        Date postEnd = new Date(now.getTime() + 2L);
        SpinnerDateModel m = new SpinnerDateModel(now, start, end2, 1);
        harness.check(m.getValue(), now);
        harness.check(m.getStart(), start);
        harness.check(m.getEnd(), end2);
        harness.check(m.getCalendarField(), 1);
        m = new SpinnerDateModel(start, start, end2, 1);
        harness.check(m.getValue(), start);
        harness.check(m.getStart(), start);
        harness.check(m.getEnd(), end2);
        harness.check(m.getCalendarField(), 1);
        boolean pass = false;
        try {
            m = new SpinnerDateModel(preStart, start, end2, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        m = new SpinnerDateModel(end2, start, end2, 1);
        harness.check(m.getValue(), end2);
        harness.check(m.getStart(), start);
        harness.check(m.getEnd(), end2);
        harness.check(m.getCalendarField(), 1);
        pass = false;
        try {
            m = new SpinnerDateModel(postEnd, start, end2, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new SpinnerDateModel(null, start, end2, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        m = new SpinnerDateModel(now, start, end2, 0);
        harness.check(m.getCalendarField(), 0);
        m = new SpinnerDateModel(now, start, end2, 1);
        harness.check(m.getCalendarField(), 1);
        m = new SpinnerDateModel(now, start, end2, 2);
        harness.check(m.getCalendarField(), 2);
        m = new SpinnerDateModel(now, start, end2, 3);
        harness.check(m.getCalendarField(), 3);
        m = new SpinnerDateModel(now, start, end2, 4);
        harness.check(m.getCalendarField(), 4);
        m = new SpinnerDateModel(now, start, end2, 5);
        harness.check(m.getCalendarField(), 5);
        m = new SpinnerDateModel(now, start, end2, 6);
        harness.check(m.getCalendarField(), 6);
        m = new SpinnerDateModel(now, start, end2, 7);
        harness.check(m.getCalendarField(), 7);
        m = new SpinnerDateModel(now, start, end2, 8);
        harness.check(m.getCalendarField(), 8);
        m = new SpinnerDateModel(now, start, end2, 9);
        harness.check(m.getCalendarField(), 9);
        m = new SpinnerDateModel(now, start, end2, 10);
        harness.check(m.getCalendarField(), 10);
        m = new SpinnerDateModel(now, start, end2, 11);
        harness.check(m.getCalendarField(), 11);
        m = new SpinnerDateModel(now, start, end2, 12);
        harness.check(m.getCalendarField(), 12);
        m = new SpinnerDateModel(now, start, end2, 13);
        harness.check(m.getCalendarField(), 13);
        m = new SpinnerDateModel(now, start, end2, 14);
        harness.check(m.getCalendarField(), 14);
        m = new SpinnerDateModel(now, start, end2, 5);
        harness.check(m.getCalendarField(), 5);
        pass = false;
        try {
            m = new SpinnerDateModel(now, start, end2, 16);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m = new SpinnerDateModel(now, start, end2, 15);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

