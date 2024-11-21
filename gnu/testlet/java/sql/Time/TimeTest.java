/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.sql.Time;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.sql.Time;

public class TimeTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Time t = new Time(0L);
        try {
            t.getDate();
            harness.check(false, "getDate");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "getDate");
        }
        try {
            t.getDay();
            harness.check(false, "getDay");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "getDay");
        }
        try {
            t.getMonth();
            harness.check(false, "getMonth");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "getMonth");
        }
        try {
            t.getYear();
            harness.check(false, "getYear");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "getYear");
        }
        try {
            t.setDate(0);
            harness.check(false, "setDate");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "setDate");
        }
        try {
            t.setMonth(0);
            harness.check(false, "setMonth");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "setMonth");
        }
        try {
            t.setYear(0);
            harness.check(false, "setYear");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "setYear");
        }
        try {
            Time.valueOf("NoSuchTime");
            harness.check(false, "valueOf");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "valueOf");
        }
    }
}

