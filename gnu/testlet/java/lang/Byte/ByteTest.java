/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class ByteTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        harness.check(true, "test_Basics - 1");
        harness.check(true, "test_Basics - 2");
        Byte ch = new Byte(98);
        harness.check(ch == 98, "test_Basics - 3");
        Byte ch1 = new Byte("122");
        harness.check(ch1 == 122, "test_Basics - 4");
        harness.check(Byte.valueOf("120") == 120, "test_Basics - 5");
        harness.check(Byte.valueOf("120") == 120, "test_Basics - 6");
    }

    public void test_toString() {
        Byte ch = new Byte(97);
        String str = ch.toString();
        harness.check(str.length() == 2 && str.equals("97"), "test_toString");
    }

    public void test_equals() {
        Byte ch1 = new Byte(43);
        Byte ch2 = new Byte(43);
        Byte ch3 = new Byte(45);
        harness.check(ch1.equals(ch2) && !ch1.equals(ch3) && !ch1.equals(null), "test_equals - 1");
    }

    public void test_hashCode() {
        Byte ch1 = new Byte(97);
        harness.check(ch1.hashCode() == 97, "test_hashCode");
    }

    public void test_decode() {
        try {
            Byte.decode("1234");
            harness.fail("test_decode - 1");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(Byte.decode("34").intValue() == 34, "test_decode - 2");
        try {
            Byte.decode("123.34");
            harness.fail("test_decode - 3");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            Byte.decode("ff");
            harness.fail("test_decode - 4");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public void test_values() {
        Byte b = new Byte(100);
        Byte b1 = new Byte(-123);
        harness.check(b.intValue() == 100, "test_values - 1");
        harness.check(b1.intValue() == -123, "test_values - 2");
        harness.check(b.longValue() == 100L, "test_values - 3");
        harness.check(b1.longValue() == -123L, "test_values - 4");
        harness.check(b.floatValue() == 100.0f, "test_values - 5");
        harness.check(b1.floatValue() == -123.0f, "test_values - 6");
        harness.check(b.doubleValue() == 100.0, "test_values - 7");
        harness.check(b1.doubleValue() == -123.0, "test_values - 8");
        harness.check(b.shortValue() == 100, "test_values - 9");
        harness.check(b1.shortValue() == -123, "test_values - 10");
        harness.check(b == 100, "test_values - 11");
        harness.check(b1 == -123, "test_values - 12");
    }

    public void testall() {
        this.test_Basics();
        this.test_equals();
        this.test_toString();
        this.test_hashCode();
        this.test_decode();
        this.test_values();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

