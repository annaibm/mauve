/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class DoubleTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        Double i1;
        double min1 = Double.MIN_VALUE;
        double min2 = Double.MIN_VALUE;
        double max1 = Double.MAX_VALUE;
        double max2 = Double.MAX_VALUE;
        double ninf1 = Double.NEGATIVE_INFINITY;
        double ninf2 = Double.NEGATIVE_INFINITY;
        double pinf1 = Double.POSITIVE_INFINITY;
        double pinf2 = Double.POSITIVE_INFINITY;
        Double nan1 = new Double(Double.NaN);
        Double nan2 = new Double(Double.NaN);
        if (min1 != min2) {
            harness.fail("test_Basics - 1a");
            System.out.println("Expected: " + min1);
            System.out.println("Got: " + min2);
        }
        if (max1 != max2) {
            harness.fail("test_Basics - 1b");
            System.out.println("Expected: " + max1);
            System.out.println("Got: " + max2);
        }
        if (ninf1 != ninf2) {
            harness.fail("test_Basics - 1c");
            System.out.println("Expected: " + ninf1);
            System.out.println("Got: " + ninf2);
        }
        if (pinf1 != pinf2) {
            harness.fail("test_Basics - 1d");
            System.out.println("Expected: " + pinf1);
            System.out.println("Got: " + pinf2);
        }
        if (!nan2.equals(nan1)) {
            harness.fail("test_Basics CYGNUS: NaN.equals - 1e");
            System.out.println("Expected: " + nan1);
            System.out.println("Got: " + nan2);
        }
        harness.check((i1 = new Double(100.5)) == 100.5, "test_Basics - 2");
        try {
            harness.check(new Double("234.34") == 234.34, "test_Basics - 3");
        }
        catch (NumberFormatException e) {
            harness.fail("test_Basics - 3");
        }
        try {
            harness.check(new Double("1.4e-45") == 1.4E-45, "test_Basics - 4");
        }
        catch (NumberFormatException e) {
            harness.fail("test_Basics - 4");
        }
        try {
            new Double("babu");
            harness.fail("test_Basics - 5");
        }
        catch (NumberFormatException e) {
            // empty catch block
        }
        harness.check(new Double(3.4) == 3.4, "test_Basics - 6");
        Double nan = new Double(Double.NaN);
        harness.check(nan.isNaN(), "test_Basics - 7");
        harness.check(!new Double(10.0).isNaN(), "test_Basics - 8");
        harness.check(Double.isNaN(Double.NaN), "test_Basics - 9");
        harness.check(new Double(Double.POSITIVE_INFINITY).isInfinite(), "test_Basics - 10");
        harness.check(new Double(Double.NEGATIVE_INFINITY).isInfinite(), "test_Basics - 11");
        harness.check(Double.isInfinite(Double.NEGATIVE_INFINITY), "test_Basics - 12");
        harness.check(Double.isInfinite(Double.POSITIVE_INFINITY), "test_Basics - 13");
        harness.check(true, "test_Basics - 14");
        harness.check(true, "test_Basics - 15");
        harness.check(true, "test_Basics - 16");
        harness.check(true, "test_Basics - 17");
        harness.check(true, "test_Basics - 18");
        harness.check(true, "test_Basics - 19");
        harness.check(true, "test_Basics - 20");
        harness.check(true, "test_Basics - 21");
        harness.check("0.0".equals("0.0"), "test_Basics - 22");
    }

    public void test_toString() {
        harness.check(new Double(123.0).toString().equals("123.0"), "test_toString - 1");
        harness.check(new Double(-44.5343).toString().equals("-44.5343"), "test_toString - 2");
        harness.check(Double.toString(23.04).equals("23.04"), "test_toString - 3");
        harness.check(Double.toString(Double.NaN).equals("NaN"), "test_toString - 4");
        harness.check(Double.toString(Double.POSITIVE_INFINITY).equals("Infinity"), "test_toString - 5");
        harness.check(Double.toString(Double.NEGATIVE_INFINITY).equals("-Infinity"), "test_toString - 6");
        harness.check(Double.toString(0.0).equals("0.0"), "test_toString - 7");
        String str = Double.toString(-0.0);
        harness.check(str.equals("-0.0"), "test_toString - 8");
        str = Double.toString(-9412128.34);
        harness.check(str.equals("-9412128.34"), "test_toString - 9");
        str = Double.toString(0.001);
        if (!Double.toString(0.001).equals("0.001")) {
            harness.fail("test_toString - 10");
            System.out.println("Expected: 0.001");
            System.out.println("Got: " + Double.toString(0.001));
        }
        str = Double.toString(10000.0);
        if (!Double.toString(10000.0).equals("10000.0")) {
            harness.fail("test_toString - 11");
            System.out.println("Expected: 10000.0");
            System.out.println("Got: " + Double.toString(10000.0));
        }
        if (!new Double(str = Double.toString(3.333333333E7)).equals(new Double(3.333333333E7))) {
            harness.fail("test_toString - 12");
            System.out.println("Expected: " + new Double(3.333333333E7).toString());
            System.out.println("Got: " + new Double(str).toString());
        }
        if (!new Double(str = Double.toString(-1.2323232425332E11)).equals(new Double(-1.2323232425332E11))) {
            harness.fail("test_toString - 13");
            System.out.println("Expected: " + new Double(-1.2323232425332E11).toString());
            System.out.println("Got: " + new Double(str).toString());
        }
        if (!new Double(str = Double.toString(1.243E10)).equals(new Double(1.243E10))) {
            harness.fail("test_toString - 14");
            System.out.println("Expected: " + new Double(1.243E10).toString());
            System.out.println("Got: " + new Double(str).toString());
        }
        if (!(str = Double.toString(Double.MIN_VALUE)).equals("4.9E-324")) {
            harness.fail("test_toString - 15");
            harness.debug("Expected: 4.9E-324");
            harness.debug("Got: " + str);
        }
    }

    public void test_equals() {
        Double i1 = new Double(2.33434E7);
        Double i2 = new Double(-2.33434E7);
        harness.check(i1.equals(new Double(2.33434E7)), "test_equals - 1");
        harness.check(i2.equals(new Double(-2.33434E7)), "test_equals - 2");
        harness.check(!i1.equals(i2), "test_equals - 3");
        harness.check(!i1.equals(null), "test_equals - 4");
        double n1 = Double.NaN;
        double n2 = Double.NaN;
        harness.check(n1 != n2, "test_equals - 5");
        Double flt1 = new Double(Double.NaN);
        Double flt2 = new Double(Double.NaN);
        harness.check(flt1.equals(flt2), "test_equals CYGNUS: NaN.equals - 6");
        harness.check(true, "test_equals - 7");
        Double pzero = new Double(0.0);
        Double nzero = new Double(-0.0);
        harness.check(!pzero.equals(nzero), "test_equals CYGNUS: Double.equals - 8");
    }

    public void test_hashCode() {
        Double flt1 = new Double(3.4028235E38);
        long lng1 = Double.doubleToLongBits(3.4028235E38);
        harness.check(flt1.hashCode() == (int)(lng1 ^ lng1 >>> 32), "test_hashCode - 1");
        Double flt2 = new Double(-2.343323354E9);
        long lng2 = Double.doubleToLongBits(-2.343323354E9);
        harness.check(flt2.hashCode() == (int)(lng2 ^ lng2 >>> 32), "test_hashCode - 2");
    }

    public void test_intValue() {
        Double b1 = new Double(3.4E32);
        Double b2 = new Double(-23.45);
        int i1 = b1.intValue();
        int i2 = b2.intValue();
        harness.check(i1 == Integer.MAX_VALUE, "test_intValue CYGNUS: Float to int conversions - 1");
        harness.check(i2 == -23, "test_intValue - 2");
        Double b3 = new Double(3000.54);
        harness.check(b3.intValue() == 3000, "test_intValue - 3");
        Double b4 = new Double(32735.3249);
        harness.check(b4.intValue() == 32735, "test_intValue - 4");
        Double b5 = new Double(-32735.3249);
        harness.check(b5.intValue() == -32735, "test_intValue - 5");
        Double b6 = new Double(-32735.3249);
        harness.check(b6.intValue() == -32735, "test_intValue - 6");
        Double b7 = new Double(0.0);
        harness.check(b7.intValue() == 0, "test_intValue - 7");
    }

    public void test_longValue() {
        Double b1 = new Double(3.4E32);
        Double b2 = new Double(-23.45);
        harness.check(b1.longValue() == Long.MAX_VALUE, "test_longValue CYGNUS: Float to int conversions - 1");
        harness.check(b2.longValue() == -23L, "test_longValue - 2");
    }

    public void test_DoubleValue() {
        Double b1 = new Double(3276.34);
        Double b2 = new Double(-3276.32);
        harness.check(b1 == 3276.34, "test_DoubleValue - 1");
        harness.check(b2 == -3276.32, "test_DoubleValue - 2");
    }

    public void test_doubleValue() {
        Double b1 = new Double(0.0);
        Double b2 = new Double(30.0);
        harness.check(b1 == 0.0, "test_doubleValue - 1");
        harness.check(b2 == 30.0, "test_doubleValue - 2");
    }

    public void test_floatValue() {
        Double b1 = new Double(0.0);
        Double b2 = new Double(30.0);
        harness.check(b1.floatValue() == 0.0f, "test_floatValue - 1");
        harness.check(b2.floatValue() == 30.0f, "test_floatValue - 2");
    }

    public void test_valueOf() {
        try {
            Double.valueOf(null);
            harness.fail("test_valueOf - 1");
        }
        catch (NumberFormatException nfe) {
            harness.check(false, "test_valueOf null should throw NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true, "test_valueOf null");
        }
        try {
            Double.valueOf("Kona");
            harness.fail("test_valueOf - 2");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(Double.valueOf("3.4e+32") == 3.4E32, "test_valueOf - 3");
        harness.check(Double.valueOf(" -23.45    ") == -23.45, "test_valueOf - 4");
    }

    public void test_parseDouble() {
        try {
            Double.parseDouble(null);
            harness.fail("test_parseDouble - 1");
        }
        catch (NumberFormatException nfe) {
            harness.check(false, "test_parseDouble null should throw NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true, "test_parseDouble null");
        }
        try {
            Double.parseDouble("Kona");
            harness.fail("test_parseDouble - 2");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(Double.parseDouble("3.4e+32") == 3.4E32, "test_parseDouble - 3");
        harness.check(Double.parseDouble(" -23.45    ") == -23.45, "test_parseDouble - 4");
    }

    public void test_doubleToLongBits() {
        harness.check(Double.doubleToLongBits(Double.POSITIVE_INFINITY) == 0x7FF0000000000000L, "test_doubleToLongBits - 1");
        harness.check(Double.doubleToLongBits(Double.NEGATIVE_INFINITY) == -4503599627370496L, "test_doubleToLongBits - 2");
        long nanval = Double.doubleToLongBits(Double.NaN);
        harness.check(nanval == 9221120237041090560L, "test_doubleToLongBits CYGNUS: NaN.doubleToLongBits");
        long i1 = Double.doubleToLongBits(3.4E32f);
        long i2 = Double.doubleToLongBits(-34.56f);
        long sign1 = i1 & Long.MIN_VALUE;
        long sign2 = i2 & Long.MIN_VALUE;
        long exp1 = i1 & 0x7FF0000000000000L;
        long exp2 = i2 & 0x7FF0000000000000L;
        long man1 = i1 & 0xFFFFFFFFFFFFFL;
        long man2 = i2 & 0xFFFFFFFFFFFFFL;
        harness.check(sign1 == 0L, "test_doubleToLongBits - 4");
        harness.check(sign2 == Long.MIN_VALUE, "test_doubleToLongBits - 5");
        harness.check(exp1 == 5093571178556030976L, "test_doubleToLongBits - 6");
        harness.check(exp2 == 0x4040000000000000L, "test_doubleToLongBits - 7");
        harness.check(man1 == 214848222789632L, "test_doubleToLongBits - 8");
        harness.check(man2 == 360288163463168L, "test_doubleToLongBits - 9");
    }

    public void test_longBitsToDouble() {
        harness.check(Double.longBitsToDouble(0x7FF0000000000000L) == Double.POSITIVE_INFINITY, "test_longBitsToDouble - 1");
        harness.check(Double.longBitsToDouble(-4503599627370496L) == Double.NEGATIVE_INFINITY, "test_longBitsToDouble - 2");
        harness.check(Double.isNaN(Double.longBitsToDouble(-2251799813685248L)), "test_longBitsToDouble - 3");
        harness.check(Double.isNaN(Double.longBitsToDouble(0x7FFFFFF000000000L)), "test_longBitsToDouble - 4");
        harness.check(Double.isNaN(Double.longBitsToDouble(-2251799276814335L)), "test_longBitsToDouble - 5");
        harness.check(Double.isNaN(Double.longBitsToDouble(-15L)), "test_longBitsToDouble - 6");
        double fl1 = Double.longBitsToDouble(0x34343F33L);
        if (Double.doubleToLongBits(fl1) != 0x34343F33L) {
            harness.fail("test_longBitsToDouble - 7");
            System.out.println("Expected: " + Long.toHexString(0x34343F33L));
            System.out.println("Got: " + Long.toHexString(Double.doubleToLongBits(fl1)));
        }
        harness.check(Double.doubleToLongBits(Double.longBitsToDouble(0x33439943L)) == 0x33439943L, "test_longBitsToDouble - 8");
    }

    public void check_remainder(double val, double val1, double ret, int errno) {
        double res = val % val1;
        harness.check(!(res < ret - 0.001) && !(res > ret + 0.001), "test_remainder " + errno);
    }

    public void check_remainder_NaN(double val, double val1, int errno) {
        double res = val % val1;
        if (!Double.isNaN(res)) {
            harness.fail("test_remainder " + errno);
        }
    }

    public void test_remainder() {
        this.check_remainder(15.2, 1.0, 0.2, 1);
        this.check_remainder(2345.2432, 1.2, 0.44319999999997, 2);
        this.check_remainder(20.56, 1.87, 1.86, 3);
        this.check_remainder(0.0, 1.2, 0.0, 4);
        this.check_remainder(1000.0, 10.0, 0.0, 5);
        this.check_remainder(234.332, 134.34, 99.992, 6);
        this.check_remainder(1.0, 1.0, 0.0, 7);
        this.check_remainder(45.0, 5.0, 0.0, 8);
        this.check_remainder(1.25, 0.5, 0.25, 9);
        this.check_remainder(12345.678, 1234.5678, 1234.5678, 10);
        if (!System.getProperty("os.name").equals("VxWorks")) {
            this.check_remainder(Double.MAX_VALUE, Double.MIN_VALUE, 0.0, 11);
        }
        this.check_remainder(0.0, 999.99, 0.0, 12);
        this.check_remainder(123.0, 25.0, 23.0, 13);
        this.check_remainder(15.0, 1.5, 0.0, 14);
        this.check_remainder_NaN(Double.NaN, 1.5, 15);
        this.check_remainder_NaN(1.5, Double.NaN, 16);
        this.check_remainder_NaN(Double.NaN, 0.0, 17);
        this.check_remainder_NaN(0.0, Double.NaN, 18);
        this.check_remainder_NaN(Double.POSITIVE_INFINITY, 1.5, 19);
        this.check_remainder_NaN(Double.NEGATIVE_INFINITY, 1.5, 20);
        this.check_remainder_NaN(1.5, 0.0, 21);
        this.check_remainder_NaN(Double.POSITIVE_INFINITY, 0.0, 22);
        this.check_remainder_NaN(Double.NEGATIVE_INFINITY, 0.0, 23);
        this.check_remainder(15.0, Double.POSITIVE_INFINITY, 15.0, 24);
        this.check_remainder(-15.0, Double.POSITIVE_INFINITY, -15.0, 25);
        this.check_remainder(0.0, Double.POSITIVE_INFINITY, 0.0, 26);
        this.check_remainder(-0.0, Double.POSITIVE_INFINITY, -0.0, 27);
        this.check_remainder(0.1, Double.POSITIVE_INFINITY, 0.1, 28);
        this.check_remainder(-0.1, Double.POSITIVE_INFINITY, -0.1, 29);
        this.check_remainder(15.0, Double.NEGATIVE_INFINITY, 15.0, 30);
        this.check_remainder(-15.0, Double.NEGATIVE_INFINITY, -15.0, 31);
        this.check_remainder(0.0, Double.NEGATIVE_INFINITY, 0.0, 32);
        this.check_remainder(-0.0, Double.NEGATIVE_INFINITY, -0.0, 33);
        this.check_remainder(0.1, Double.NEGATIVE_INFINITY, 0.1, 34);
        this.check_remainder(-0.1, Double.NEGATIVE_INFINITY, -0.1, 35);
    }

    public void test_shortbyteValue() {
        Double d1 = new Double(123.35);
        Double d2 = new Double(400.35);
        Double d3 = new Double(0.0);
        harness.check(d1.shortValue() == 123, "test_shortbyteValue - 1");
        harness.check(d2.shortValue() == 400, "test_shortbyteValue - 2");
        harness.check(d3.shortValue() == 0, "test_shortbyteValue - 3");
        harness.check(d1.byteValue() == 123, "test_shortbyteValue - 4");
        harness.check(d2.byteValue() == -112, "test_shortbyteValue - 5");
        harness.check(d3.byteValue() == 0, "test_shortbyteValue - 6");
    }

    public void test_neg() {
        String nonzero3;
        String nonzero2;
        double nonzero;
        String nonzero1;
        String zero3;
        String zero2;
        double zero = 0.0;
        String zero1 = String.valueOf(zero);
        if (!zero1.equals("0.0")) {
            harness.fail("test_neg - 1");
        }
        if (!(zero2 = String.valueOf(zero = -zero)).equals("-0.0")) {
            harness.fail("test_neg - 2");
            System.out.println("Expected -0.0, got: " + zero2);
        }
        if (!(zero3 = String.valueOf(zero = -zero)).equals("0.0")) {
            harness.fail("test_neg - 3");
        }
        if (!(nonzero1 = String.valueOf(nonzero = -21.23)).equals("-21.23")) {
            harness.fail("test_neg - 4");
        }
        if (!(nonzero2 = String.valueOf(nonzero = -nonzero)).equals("21.23")) {
            harness.fail("test_neg - 5");
        }
        if (!(nonzero3 = String.valueOf(nonzero = -nonzero)).equals("-21.23")) {
            harness.fail("test_neg - 6");
        }
    }

    public void testall() {
        this.test_Basics();
        this.test_remainder();
        this.test_toString();
        this.test_equals();
        this.test_hashCode();
        this.test_intValue();
        this.test_longValue();
        this.test_DoubleValue();
        this.test_doubleValue();
        this.test_floatValue();
        this.test_shortbyteValue();
        this.test_valueOf();
        this.test_parseDouble();
        this.test_doubleToLongBits();
        this.test_longBitsToDouble();
        this.test_neg();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

