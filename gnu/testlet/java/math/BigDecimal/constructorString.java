/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.MathContext;

public class constructorString
implements Testlet {
    private static final String STRING_LITERAL_0 = "0.0";
    private static final String STRING_LITERAL_1 = "0.1";
    private static final String STRING_LITERAL_2 = "0.01";
    private static final String STRING_LITERAL_3 = "0.001";
    private static final String STRING_LITERAL_4 = "0.0001";
    private static final String STRING_LITERAL_5 = "0.00001";
    private static final String STRING_LITERAL_6 = "0.000001";
    private static final String STRING_LITERAL_7 = "0.0000001";
    private static final String STRING_LITERAL_8 = "0.01E5";
    private static final String STRING_LITERAL_9 = "1000E-5";
    private static final String NEG_STRING_LITERAL_0 = "obviously not-a-number";
    private static final String NEG_STRING_LITERAL_1 = "--0";
    private static final String NEG_STRING_LITERAL_2 = "123qwe";
    private static final String NEG_STRING_LITERAL_3 = "qwe123";
    private static final String NEG_STRING_LITERAL_4 = "0.0.0";
    private static final String NEG_STRING_LITERAL_5 = "-0.0.0";

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.test4(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(String)");
        try {
            harness.check(new BigDecimal(STRING_LITERAL_0).toString(), (Object)STRING_LITERAL_0);
            harness.check(new BigDecimal(STRING_LITERAL_1).toString(), (Object)STRING_LITERAL_1);
            harness.check(new BigDecimal(STRING_LITERAL_2).toString(), (Object)STRING_LITERAL_2);
            harness.check(new BigDecimal(STRING_LITERAL_3).toString(), (Object)STRING_LITERAL_3);
            harness.check(new BigDecimal(STRING_LITERAL_4).toString(), (Object)STRING_LITERAL_4);
            harness.check(new BigDecimal(STRING_LITERAL_5).toString(), (Object)STRING_LITERAL_5);
            harness.check(new BigDecimal(STRING_LITERAL_6).toString(), (Object)STRING_LITERAL_6);
            harness.check(new BigDecimal(STRING_LITERAL_7).toString(), (Object)"1E-7");
            harness.check(new BigDecimal(STRING_LITERAL_8).toString(), (Object)"1E+3");
            harness.check(new BigDecimal(STRING_LITERAL_9).toString(), (Object)"0.01000");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(String, MathContext)");
        try {
            harness.check(new BigDecimal(STRING_LITERAL_0, MathContext.UNLIMITED).toString(), (Object)STRING_LITERAL_0);
            harness.check(new BigDecimal(STRING_LITERAL_1, MathContext.UNLIMITED).toString(), (Object)STRING_LITERAL_1);
            harness.check(new BigDecimal(STRING_LITERAL_2, MathContext.UNLIMITED).toString(), (Object)STRING_LITERAL_2);
            harness.check(new BigDecimal(STRING_LITERAL_3, MathContext.UNLIMITED).toString(), (Object)STRING_LITERAL_3);
            harness.check(new BigDecimal(STRING_LITERAL_4, MathContext.UNLIMITED).toString(), (Object)STRING_LITERAL_4);
            harness.check(new BigDecimal(STRING_LITERAL_5, MathContext.UNLIMITED).toString(), (Object)STRING_LITERAL_5);
            harness.check(new BigDecimal(STRING_LITERAL_6, MathContext.UNLIMITED).toString(), (Object)STRING_LITERAL_6);
            harness.check(new BigDecimal(STRING_LITERAL_7, MathContext.UNLIMITED).toString(), (Object)"1E-7");
            harness.check(new BigDecimal(STRING_LITERAL_8, MathContext.UNLIMITED).toString(), (Object)"1E+3");
            harness.check(new BigDecimal(STRING_LITERAL_9, MathContext.UNLIMITED).toString(), (Object)"0.01000");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }

    public void test3(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(String) - negative tests");
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_0).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_1).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_2).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_3).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_4).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_5).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public void test4(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(String, MathContext) - negative tests");
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_0, MathContext.UNLIMITED).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_1, MathContext.UNLIMITED).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_2, MathContext.UNLIMITED).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_3, MathContext.UNLIMITED).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_4, MathContext.UNLIMITED).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            harness.check(new BigDecimal(NEG_STRING_LITERAL_5, MathContext.UNLIMITED).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }
}

