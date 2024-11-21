/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.SimpleTimeZone;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("(int, String)");
        SimpleTimeZone z = new SimpleTimeZone(1234, "Z1");
        harness.check(z.getRawOffset(), 1234);
        harness.check(z.getID(), (Object)"Z1");
        try {
            SimpleTimeZone z2 = new SimpleTimeZone(0, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    private void testConstructor2(TestHarness harness) {
        SimpleTimeZone z2;
        harness.checkPoint("(int, String, int, int, int, int, int, int, int, int)");
        SimpleTimeZone z = new SimpleTimeZone(1234, "Z1", 3, 15, 0, 0x6DDD00, 10, 22, 0, 0x6DDD00);
        harness.check(z.getRawOffset(), 1234);
        harness.check(z.getID(), (Object)"Z1");
        harness.check(z.useDaylightTime());
        harness.check(z.getDSTSavings(), 3600000);
        try {
            z2 = new SimpleTimeZone(0, null, 3, 15, 0, 0x6DDD00, 10, 22, 0, 0x6DDD00);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 12, 15, 0, 0x6DDD00, 10, 22, 0, 0x6DDD00);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 15, 0, 0x6DDD00, 12, 22, 0, 0x6DDD00);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 33, 0, 0x6DDD00, 10, 22, 0, 0x6DDD00);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 15, 0, 0x6DDD00, 10, 33, 0, 0x6DDD00);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 6, 2, 0x6DDD00, 10, 22, 0, 0x6DDD00);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, -6, 2, 0x6DDD00, 10, 22, 0, 0x6DDD00);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 1, 2, 0x6DDD00, 10, 6, 2, 0x6DDD00);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 1, 2, 0x6DDD00, 10, -6, 2, 0x6DDD00);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void testConstructor3(TestHarness harness) {
        SimpleTimeZone z2;
        harness.checkPoint("(int, String, int, int, int, int, int, int, int, int, int)");
        SimpleTimeZone z = new SimpleTimeZone(1234, "Z1", 3, 15, 0, 0x6DDD00, 10, 22, 0, 0x6DDD00, 123456);
        harness.check(z.getRawOffset(), 1234);
        harness.check(z.getID(), (Object)"Z1");
        harness.check(z.useDaylightTime());
        harness.check(z.getDSTSavings(), 123456);
        try {
            z2 = new SimpleTimeZone(0, null, 3, 15, 0, 0x6DDD00, 10, 22, 0, 0x6DDD00, 3600000);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 12, 15, 0, 0x6DDD00, 10, 22, 0, 0x6DDD00, 3600000);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 15, 0, 0x6DDD00, 15, 22, 0, 0x6DDD00, 3600000);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 33, 0, 0x6DDD00, 10, 22, 0, 0x6DDD00, 3600000);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 15, 0, 0x6DDD00, 10, 33, 0, 0x6DDD00, 3600000);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 6, 2, 0x6DDD00, 10, 22, 0, 0x6DDD00, 3600000);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, -6, 2, 0x6DDD00, 10, 22, 0, 0x6DDD00, 3600000);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, 1, 2, 0x6DDD00, 10, 6, 2, 0x6DDD00, 3600000);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(0, "Z", 3, -1, 2, 0x6DDD00, 10, -6, 2, 0x6DDD00, 3600000);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void testConstructor4(TestHarness harness) {
        SimpleTimeZone z2;
        harness.checkPoint("(int, String, int, int, int, int, int, int, int, int, int, int, int)");
        SimpleTimeZone z = new SimpleTimeZone(1234, "Z1", 3, 15, 0, 0x6DDD00, 2, 10, 22, 0, 0x6DDD00, 2, 123456);
        harness.check(z.getRawOffset(), 1234);
        harness.check(z.getID(), (Object)"Z1");
        harness.check(z.useDaylightTime());
        harness.check(z.getDSTSavings(), 123456);
        try {
            z2 = new SimpleTimeZone(0, null, 3, 15, 0, 0x6DDD00, 0, 10, 22, 0, 0x6DDD00, 0, 3600000);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(1234, "Z1", 12, 15, 0, 0x6DDD00, 2, 10, 22, 0, 0x6DDD00, 2, 123456);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(1234, "Z1", 3, 15, 0, 0x6DDD00, 2, 12, 22, 0, 0x6DDD00, 2, 123456);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(1234, "Z1", 3, 33, 0, 0x6DDD00, 2, 10, 22, 0, 0x6DDD00, 2, 123456);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(1234, "Z1", 3, 15, 0, 0x6DDD00, 2, 10, 33, 0, 0x6DDD00, 2, 123456);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(1234, "Z1", 3, 6, 2, 0x6DDD00, 2, 10, 22, 0, 0x6DDD00, 2, 123456);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(1234, "Z1", 3, -6, 2, 0x6DDD00, 2, 10, 22, 0, 0x6DDD00, 2, 123456);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(1234, "Z1", 3, 1, 2, 0x6DDD00, 2, 10, 6, 2, 0x6DDD00, 2, 123456);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            z2 = new SimpleTimeZone(1234, "Z1", 3, 1, 2, 0x6DDD00, 2, 10, -6, 2, 0x6DDD00, 2, 123456);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

