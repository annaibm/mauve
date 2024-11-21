/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.MathContext;

public class constructorCharacterSequence
implements Testlet {
    private static final char[] CHAR_SEQUENCE_0 = "0.0".toCharArray();
    private static final char[] CHAR_SEQUENCE_1 = "0.1".toCharArray();
    private static final char[] CHAR_SEQUENCE_2 = "0.01".toCharArray();
    private static final char[] CHAR_SEQUENCE_3 = "0.001".toCharArray();
    private static final char[] CHAR_SEQUENCE_4 = "0.0001".toCharArray();
    private static final char[] CHAR_SEQUENCE_5 = "0.00001".toCharArray();
    private static final char[] CHAR_SEQUENCE_6 = "0.000001".toCharArray();
    private static final char[] CHAR_SEQUENCE_7 = "0.0000001".toCharArray();
    private static final char[] CHAR_SEQUENCE_8 = "0.01E5".toCharArray();
    private static final char[] CHAR_SEQUENCE_9 = "1000E-5".toCharArray();
    private static final char[] CHAR_SEQUENCE_10 = "123456".toCharArray();

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.test4(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(char[])");
        try {
            harness.check(new BigDecimal(CHAR_SEQUENCE_0).toString(), (Object)"0.0");
            harness.check(new BigDecimal(CHAR_SEQUENCE_1).toString(), (Object)"0.1");
            harness.check(new BigDecimal(CHAR_SEQUENCE_2).toString(), (Object)"0.01");
            harness.check(new BigDecimal(CHAR_SEQUENCE_3).toString(), (Object)"0.001");
            harness.check(new BigDecimal(CHAR_SEQUENCE_4).toString(), (Object)"0.0001");
            harness.check(new BigDecimal(CHAR_SEQUENCE_5).toString(), (Object)"0.00001");
            harness.check(new BigDecimal(CHAR_SEQUENCE_6).toString(), (Object)"0.000001");
            harness.check(new BigDecimal(CHAR_SEQUENCE_7).toString(), (Object)"1E-7");
            harness.check(new BigDecimal(CHAR_SEQUENCE_8).toString(), (Object)"1E+3");
            harness.check(new BigDecimal(CHAR_SEQUENCE_9).toString(), (Object)"0.01000");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(char[], offset, length)");
        harness.check(new BigDecimal(CHAR_SEQUENCE_10, 0, 1).toString(), (Object)"1");
        harness.check(new BigDecimal(CHAR_SEQUENCE_10, 0, 2).toString(), (Object)"12");
        harness.check(new BigDecimal(CHAR_SEQUENCE_10, 1, 1).toString(), (Object)"2");
        harness.check(new BigDecimal(CHAR_SEQUENCE_10, 1, 2).toString(), (Object)"23");
        try {
            System.out.println(new BigDecimal(CHAR_SEQUENCE_10, 1, 10).toString());
            harness.fail("Exception don't thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            System.out.println(new BigDecimal(CHAR_SEQUENCE_10, -1, 2).toString());
            harness.fail("Exception don't thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public void test3(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(char[], MathContext)");
        try {
            harness.check(new BigDecimal(CHAR_SEQUENCE_0, MathContext.UNLIMITED).toString(), (Object)"0.0");
            harness.check(new BigDecimal(CHAR_SEQUENCE_1, MathContext.UNLIMITED).toString(), (Object)"0.1");
            harness.check(new BigDecimal(CHAR_SEQUENCE_2, MathContext.UNLIMITED).toString(), (Object)"0.01");
            harness.check(new BigDecimal(CHAR_SEQUENCE_3, MathContext.UNLIMITED).toString(), (Object)"0.001");
            harness.check(new BigDecimal(CHAR_SEQUENCE_4, MathContext.UNLIMITED).toString(), (Object)"0.0001");
            harness.check(new BigDecimal(CHAR_SEQUENCE_5, MathContext.UNLIMITED).toString(), (Object)"0.00001");
            harness.check(new BigDecimal(CHAR_SEQUENCE_6, MathContext.UNLIMITED).toString(), (Object)"0.000001");
            harness.check(new BigDecimal(CHAR_SEQUENCE_7, MathContext.UNLIMITED).toString(), (Object)"1E-7");
            harness.check(new BigDecimal(CHAR_SEQUENCE_8, MathContext.UNLIMITED).toString(), (Object)"1E+3");
            harness.check(new BigDecimal(CHAR_SEQUENCE_9, MathContext.UNLIMITED).toString(), (Object)"0.01000");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }

    public void test4(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(char[], offset, length, MathContext)");
        harness.check(new BigDecimal(CHAR_SEQUENCE_10, 0, 1, MathContext.UNLIMITED).toString(), (Object)"1");
        harness.check(new BigDecimal(CHAR_SEQUENCE_10, 0, 2, MathContext.UNLIMITED).toString(), (Object)"12");
        harness.check(new BigDecimal(CHAR_SEQUENCE_10, 1, 1, MathContext.UNLIMITED).toString(), (Object)"2");
        harness.check(new BigDecimal(CHAR_SEQUENCE_10, 1, 2, MathContext.UNLIMITED).toString(), (Object)"23");
        try {
            System.out.println(new BigDecimal(CHAR_SEQUENCE_10, 1, 10).toString());
            harness.fail("Exception don't thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            System.out.println(new BigDecimal(CHAR_SEQUENCE_10, -1, 2).toString());
            harness.fail("Exception don't thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }
}

