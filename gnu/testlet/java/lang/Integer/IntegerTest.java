/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Properties;

public class IntegerTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        harness.check(true, "test_Basics - 1");
        harness.check(Integer.TYPE == new int[0].getClass().getComponentType(), "test_Basics - 1a");
        Integer i1 = new Integer(100);
        harness.check(i1 == 100, "test_Basics - 2");
        try {
            harness.check(new Integer("234") == 234, "test_Basics - 3");
        }
        catch (NumberFormatException e) {
            harness.fail("test_Basics - 3");
        }
        try {
            harness.check(new Integer("-FF") == -255, "test_Basics - 4");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            new Integer("babu");
            harness.fail("test_Basics - 5");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(Integer.decode("123") == 123, "test_Basics - 6");
        harness.check(Integer.decode("32767") == Short.MAX_VALUE, "test_Basics - 7");
    }

    public void test_toString() {
        harness.check(new Integer(123).toString().equals("123"), "test_toString - 1");
        harness.check(new Integer(-44).toString().equals("-44"), "test_toString - 2");
        harness.check(Integer.toString(234).equals("234"), "test_toString - 3");
        harness.check(Integer.toString(-34).equals("-34"), "test_toString - 4");
        harness.check(Integer.toString(-34).equals("-34"), "test_toString - 5");
        harness.check(Integer.toString(99, 1).equals("99"), "test_toString - 6");
        harness.check(Integer.toString(99, 37).equals("99"), "test_toString - 7");
        harness.check(Integer.toString(15, 2).equals("1111"), "test_toString - 8");
        harness.check(Integer.toString(37, 36).equals("11"), "test_toString - 9");
        harness.check(Integer.toString(31, 16).equals("1f"), "test_toString - 10");
        harness.check(Integer.toString(-99, 1).equals("-99"), "test_toString - 11");
        harness.check(Integer.toString(-99, 37).equals("-99"), "test_toString - 12");
        harness.check(Integer.toString(-15, 2).equals("-1111"), "test_toString - 13");
        harness.check(Integer.toString(-37, 36).equals("-11"), "test_toString - 14");
        harness.check(Integer.toString(-31, 16).equals("-1f"), "test_toString - 15");
    }

    public void test_equals() {
        Integer i1 = new Integer(23);
        Integer i2 = new Integer(-23);
        harness.check(i1.equals(new Integer(23)), "test_equals - 1");
        harness.check(i2.equals(new Integer(-23)), "test_equals - 2");
        harness.check(!i1.equals(i2), "test_equals - 3");
        harness.check(!i1.equals(null), "test_equals - 4");
    }

    public void test_hashCode() {
        Integer b1 = new Integer(3439);
        Integer b2 = new Integer(-3439);
        harness.check(b1.hashCode() == 3439 && b2.hashCode() == -3439, "test_hashCode");
    }

    public void test_intValue() {
        Integer b1 = new Integer(Short.MAX_VALUE);
        Integer b2 = new Integer(-32767);
        harness.check(b1 == Short.MAX_VALUE, "test_intValue - 1");
        harness.check(b2 == -32767, "test_intValue - 2");
    }

    public void test_longValue() {
        Integer b1 = new Integer(3767);
        Integer b2 = new Integer(-3767);
        harness.check(b1.longValue() == 3767L, "test_longValue - 1");
        harness.check(b2.longValue() == -3767L, "test_longValue - 2");
    }

    public void test_floatValue() {
        Integer b1 = new Integer(3276);
        Integer b2 = new Integer(-3276);
        harness.check(b1.floatValue() == 3276.0f, "test_floatValue - 1");
        harness.check(b2.floatValue() == -3276.0f, "test_floatValue - 2");
    }

    public void test_doubleValue() {
        Integer b1 = new Integer(0);
        Integer b2 = new Integer(30);
        harness.check(b1.doubleValue() == 0.0, "test_doubleValue - 1");
        harness.check(b2.doubleValue() == 30.0, "test_doubleValue - 2");
    }

    public void test_shortbyteValue() {
        Integer b1 = new Integer(0);
        Integer b2 = new Integer(300);
        harness.check(b1.byteValue() == 0, "test_shortbyteValue - 1");
        harness.check(b2.byteValue() == 44, "test_shortbyteValue - 2");
        harness.check(b1.shortValue() == 0, "test_shortbyteValue - 3");
        harness.check(b2.shortValue() == 300, "test_shortbyteValue - 4");
        harness.check(((Number)b1).shortValue() == 0, "test_shortbyteValue - 5");
        harness.check(((Number)b2).byteValue() == 44, "test_shortbyteValue - 6");
    }

    public void test_toHexString() {
        String str = Integer.toHexString(8375);
        String str1 = Integer.toHexString(-5361);
        harness.check("20b7".equals(str), "test_toHexString - 1");
        harness.check("ffffeb0f".equals(str1), "test_toHexString - 2");
    }

    public void test_toOctalString() {
        String str = Integer.toOctalString(5847);
        String str1 = Integer.toOctalString(-9863);
        harness.check(str.equals("13327"), "test_toOctalString - 1");
        harness.check(str1.equals("37777754571"), "test_toOctalString - 2");
    }

    public void test_toBinaryString() {
        harness.check(Integer.toBinaryString(358).equals("101100110"), "test_toBinaryString - 1");
        harness.check(Integer.toBinaryString(-5478).equals("11111111111111111110101010011010"), "test_toBinaryString - 2");
    }

    public void test_parseInt() {
        harness.check(Integer.parseInt("473") == Integer.parseInt("473", 10), "test_parseInt - 1");
        harness.check(Integer.parseInt("0", 10) == 0, "test_parseInt - 2");
        harness.check(Integer.parseInt("473", 10) == 473, "test_parseInt - 3");
        harness.check(Integer.parseInt("-0", 10) == 0, "test_parseInt - 4");
        harness.check(Integer.parseInt("-FF", 16) == -255, "test_parseInt - 5");
        harness.check(Integer.parseInt("1100110", 2) == 102, "test_parseInt - 6");
        harness.check(Integer.parseInt("2147483647", 10) == Integer.MAX_VALUE, "test_parseInt - 7");
        harness.check(Integer.parseInt("-2147483647", 10) == -2147483647, "test_parseInt - 8");
        try {
            Integer.parseInt("2147483648", 10);
            harness.fail("test_parseInt - 9");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            Integer.parseInt("99", 8);
            harness.fail("test_parseInt - 10");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            Integer.parseInt("kona", 10);
            harness.fail("test_parseInt - 11");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(Integer.parseInt("Kona", 27) == 411787, "test_parseInt - 12");
    }

    public void test_valueOf() {
        harness.check(Integer.valueOf("21234") == Integer.parseInt("21234"), "test_valueOf - 1");
        harness.check(Integer.valueOf("Kona", 27) == Integer.parseInt("Kona", 27), "test_valueOf - 2");
    }

    public void test_getInteger() {
        Properties prop = System.getProperties();
        prop.put("integerkey1", "2345");
        prop.put("integerkey2", "-984");
        prop.put("integerkey3", "-0");
        prop.put("integerkey4", "#1f");
        prop.put("integerkey5", "0x1f");
        prop.put("integerkey6", "017");
        prop.put("integerkey7", "babu");
        System.setProperties(prop);
        harness.check(Integer.getInteger("integerkey1") == 2345 && Integer.getInteger("integerkey2") == -984 && Integer.getInteger("integerkey3") == 0, "test_getInteger - 1");
        harness.check(Integer.getInteger("integerkey4", new Integer(0)) == 31 && Integer.getInteger("integerkey5", new Integer(0)) == 31 && Integer.getInteger("integerkey6", new Integer(0)) == 15, "test_getInteger - 2");
        harness.check(Integer.getInteger("integerkey7", new Integer(0)) == 0, "test_getInteger - 3");
        harness.check(Integer.getInteger("integerkey7", 0) == 0, "test_getInteger - 4");
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
        this.test_parseInt();
        this.test_valueOf();
        this.test_getInteger();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

