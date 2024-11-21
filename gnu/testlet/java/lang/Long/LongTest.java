/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Properties;

public class LongTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        long min1 = Long.MIN_VALUE;
        long min2 = Long.MIN_VALUE;
        long max1 = Long.MAX_VALUE;
        long max2 = Long.MAX_VALUE;
        harness.check(min1 == min2 && max1 == max2, "test_Basics - 1");
        Long i1 = new Long(100L);
        harness.check(i1 == 100L, "test_Basics - 2");
        try {
            harness.check(new Long("234") == 234L, "test_Basics - 3");
        }
        catch (NumberFormatException e) {
            harness.fail("test_Basics - 3");
        }
        try {
            harness.check(new Long("-FF") == -255L, "test_Basics - 4");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            new Long("babu");
            harness.fail("test_Basics - 5");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public void test_toString() {
        harness.check(new Long(123L).toString().equals("123"), "test_toString - 1");
        harness.check(new Long(-44L).toString().equals("-44"), "test_toString - 2");
        harness.check(Long.toString(234L).equals("234"), "test_toString - 3");
        harness.check(Long.toString(-34L).equals("-34"), "test_toString - 4");
        harness.check(Long.toString(-34L).equals("-34"), "test_toString - 5");
        harness.check(Long.toString(99L, 1).equals("99"), "test_toString - 6");
        harness.check(Long.toString(99L, 37).equals("99"), "test_toString - 7");
        harness.check(Long.toString(15L, 2).equals("1111"), "test_toString - 8");
        harness.check(Long.toString(37L, 36).equals("11"), "test_toString - 9");
        harness.check(Long.toString(31L, 16).equals("1f"), "test_toString - 10");
        harness.check(Long.toString(-99L, 1).equals("-99"), "test_toString - 11");
        harness.check(Long.toString(-99L, 37).equals("-99"), "test_toString - 12");
        harness.check(Long.toString(-15L, 2).equals("-1111"), "test_toString - 13");
        harness.check(Long.toString(-37L, 36).equals("-11"), "test_toString - 14");
        harness.check(Long.toString(-31L, 16).equals("-1f"), "test_toString - 15");
    }

    public void test_equals() {
        Long i1 = new Long(23L);
        Long i2 = new Long(-23L);
        harness.check(i1.equals(new Long(23L)), "test_equals - 1");
        harness.check(i2.equals(new Long(-23L)), "test_equals - 2");
        harness.check(!i1.equals(i2), "test_equals - 3");
        harness.check(!i1.equals(null), "test_equals - 4");
    }

    public void test_hashCode() {
        Long b1 = new Long(34395555L);
        Long b2 = new Long(-34395555L);
        harness.check(b1.hashCode() == (int)(b1 ^ b1 >>> 32) && b2.hashCode() == (int)(b2 ^ b2 >>> 32), "test_hashCode");
    }

    public void test_intValue() {
        Long b1 = new Long(32767L);
        Long b2 = new Long(-32767L);
        harness.check(b1.intValue() == Short.MAX_VALUE, "test_intValue - 1");
        harness.check(b2.intValue() == -32767, "test_intValue - 2");
    }

    public void test_shortbyteValue() {
        Long b1 = new Long(32767L);
        Long b2 = new Long(-32767L);
        harness.check(b1.byteValue() == -1, "test_shortbyteValue - 1");
        harness.check(b2.byteValue() == 1, "test_shortbyteValue - 2");
        harness.check(b1.shortValue() == Short.MAX_VALUE, "test_shortbyteValue - 3");
        harness.check(b2.shortValue() == -32767, "test_shortbyteValue - 4");
    }

    public void test_longValue() {
        Long b1 = new Long(-9223372036854775807L);
        Long b2 = new Long(Long.MAX_VALUE);
        harness.check(b1 == -9223372036854775807L, "test_longValue - 1");
        harness.check(b2 == Long.MAX_VALUE, "test_longValue - 2");
    }

    public void test_floatValue() {
        Long b1 = new Long(3276L);
        Long b2 = new Long(-3276L);
        harness.check(b1.floatValue() == 3276.0f, "test_floatValue - 1");
        harness.check(b2.floatValue() == -3276.0f, "test_floatValue - 2");
    }

    public void test_doubleValue() {
        Long b1 = new Long(0L);
        Long b2 = new Long(30L);
        harness.check(b1.doubleValue() == 0.0, "test_doubleValue - 1");
        harness.check(b2.doubleValue() == 30.0, "test_doubleValue - 2");
    }

    public void test_toHexString() {
        String str = Long.toHexString(8375L);
        String str1 = Long.toHexString(-5361L);
        harness.check(str.equalsIgnoreCase("20B7"), "test_toHexString - 1");
        harness.check(str1.equalsIgnoreCase("ffffffffffffeb0f"), "test_toHexString - 2");
    }

    public void test_toOctalString() {
        String str = Long.toOctalString(5847L);
        String str1 = Long.toOctalString(-9863L);
        harness.check(str.equals("13327"), "test_toOctalString - 1");
        harness.check(str1.equals("1777777777777777754571"), "test_toOctalString - 2");
    }

    public void test_toBinaryString() {
        String str1 = Long.toBinaryString(-5478L);
        harness.check(Long.toBinaryString(358L).equals("101100110"), "test_toBinaryString - 1");
        harness.check(str1.equals("1111111111111111111111111111111111111111111111111110101010011010"), "test_toBinaryString - 2");
    }

    public void test_parseLong() {
        harness.check(Long.parseLong("473") == Long.parseLong("473", 10), "test_parseLong - 1");
        harness.check(Long.parseLong("0", 10) == 0L, "test_parseLong - 2");
        harness.check(Long.parseLong("473", 10) == 473L, "test_parseLong - 3");
        harness.check(Long.parseLong("-0", 10) == 0L, "test_parseLong - 4");
        harness.check(Long.parseLong("-FF", 16) == -255L, "test_parseLong - 5");
        harness.check(Long.parseLong("1100110", 2) == 102L, "test_parseLong - 6");
        harness.check(Long.parseLong("2147483647", 10) == Integer.MAX_VALUE, "test_parseLong - 7");
        harness.check(Long.parseLong("-2147483647", 10) == -2147483647L, "test_parseLong - 8");
        try {
            Long.parseLong("99", 8);
            harness.fail("test_parseLong - 10");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            Long.parseLong("Hazelnut", 10);
            harness.fail("test_parseLong - 11");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(Long.parseLong("Hazelnut", 36) == 1356099454469L, "test_parseLong - 12");
        LongTest.long_hex_ok("-8000000000000000", Long.MIN_VALUE);
        LongTest.long_hex_ok("7fffffffffffffff", Long.MAX_VALUE);
        LongTest.long_hex_ok("7ffffffffffffff3", 0x7FFFFFFFFFFFFFF3L);
        LongTest.long_hex_ok("7ffffffffffffffe", 0x7FFFFFFFFFFFFFFEL);
        LongTest.long_hex_ok("7ffffffffffffff0", 0x7FFFFFFFFFFFFFF0L);
        LongTest.long_hex_bad("80000000000000010");
        LongTest.long_hex_bad("7ffffffffffffffff");
        LongTest.long_hex_bad("8000000000000001");
        LongTest.long_hex_bad("8000000000000002");
        LongTest.long_hex_bad("ffffffffffffffff");
        LongTest.long_hex_bad("-8000000000000001");
        LongTest.long_hex_bad("-8000000000000002");
        LongTest.long_dec_ok("-9223372036854775808", Long.MIN_VALUE);
        LongTest.long_dec_ok("-9223372036854775807", -9223372036854775807L);
        LongTest.long_dec_ok("-9223372036854775806", -9223372036854775806L);
        LongTest.long_dec_ok("9223372036854775807", Long.MAX_VALUE);
        LongTest.long_dec_ok("9223372036854775806", 0x7FFFFFFFFFFFFFFEL);
        LongTest.long_dec_bad("-9223372036854775809");
        LongTest.long_dec_bad("-9223372036854775810");
        LongTest.long_dec_bad("-9223372036854775811");
        LongTest.long_dec_bad("9223372036854775808");
    }

    static void long_hex_ok(String s, long ref) {
        try {
            long l = Long.parseLong(s, 16);
            if (ref != l) {
                System.out.println(" Error : long_hex_ok failed - 1  expected " + ref + " actual " + l);
            }
        }
        catch (NumberFormatException e) {
            System.out.println(" Error : long_hex_ok failed - 2  should not have thrown exception in parsing" + s);
        }
    }

    static void long_hex_bad(String s) {
        try {
            Long.parseLong(s, 16);
            harness.fail("long_hex_bad " + s + " should not be valid!");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    static void long_dec_ok(String s, long ref) {
        try {
            long l = Long.parseLong(s, 10);
            if (ref != l) {
                System.out.println(" Error : long_dec_ok failed - 1  expected " + ref + " actual " + l);
            }
        }
        catch (NumberFormatException e) {
            System.out.println(" Error : long_dec_ok failed - 2  should not have thrown exception in parsing" + s);
        }
    }

    static void long_dec_bad(String s) {
        try {
            Long.parseLong(s, 10);
            System.out.println(" Error long_dec_bad failed for" + s);
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public void test_valueOf() {
        harness.check(Long.valueOf("21234") == Long.parseLong("21234"), "test_valueOf - 1");
        harness.check(Long.valueOf("Kona", 27) == Long.parseLong("Kona", 27), "test_valueOf - 2");
    }

    public void test_getLong() {
        Properties prop = System.getProperties();
        prop.put("longkey1", "2345");
        prop.put("longkey2", "-984");
        prop.put("longkey3", "-0");
        prop.put("longkey4", "#1f");
        prop.put("longkey5", "0x1f");
        prop.put("longkey6", "017");
        prop.put("longkey7", "babu");
        System.setProperties(prop);
        harness.checkPoint("getLong");
        try {
            harness.check(Long.getLong("longkey1") == 2345L);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("longkey2") == -984L);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("longkey3") == 0L);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("longkey4", new Long(0L)) == 31L);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("longkey5", new Long(0L)) == 31L);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("longkey6", new Long(0L)) == 15L);
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("longkey7", new Long(0L)) == 0L, "test_getLong - 3");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
        try {
            harness.check(Long.getLong("longkey7", 0L) == 0L, "test_getLong - 4");
        }
        catch (NullPointerException npe) {
            harness.check(false);
        }
    }

    public void testall() {
        this.test_Basics();
        this.test_toString();
        this.test_equals();
        this.test_hashCode();
        this.test_intValue();
        this.test_longValue();
        this.test_floatValue();
        this.test_doubleValue();
        this.test_shortbyteValue();
        this.test_toHexString();
        this.test_toOctalString();
        this.test_toBinaryString();
        this.test_parseLong();
        this.test_valueOf();
        this.test_getLong();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

