/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Short;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class ShortTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        harness.check(true, "test_Basics - 1");
        Short i1 = new Short(100);
        harness.check(i1 == 100, "test_Basics - 2");
        try {
            harness.check(new Short("234") == 234, "test_Basics - 3");
        }
        catch (NumberFormatException e) {
            harness.fail("test_Basics - 3");
        }
        try {
            harness.check(new Short("-FF") == -255, "test_Basics - 4");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            new Short("babu");
            harness.fail("test_Basics - 5");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(Short.decode("123") == 123, "test_Basics - 6");
        harness.check(Short.decode("32767") == Short.MAX_VALUE, "test_Basics - 7");
    }

    public void test_toString() {
        harness.check(new Short(123).toString().equals("123"), "test_toString - 1");
        harness.check(new Short(-44).toString().equals("-44"), "test_toString - 2");
        harness.check(Short.toString((short)234).equals("234"), "test_toString - 3");
        harness.check(Short.toString((short)-34).equals("-34"), "test_toString - 4");
        harness.check(Short.toString((short)-34).equals("-34"), "test_toString - 5");
    }

    public void test_equals() {
        Short i1 = new Short(23);
        Short i2 = new Short(-23);
        harness.check(i1.equals(new Short(23)), "test_equals - 1");
        harness.check(i2.equals(new Short(-23)), "test_equals - 2");
        harness.check(!i1.equals(i2), "test_equals - 3");
        harness.check(!i1.equals(null), "test_equals - 4");
    }

    public void test_hashCode() {
        Short b1 = new Short(3439);
        Short b2 = new Short(-3439);
        harness.check(b1.hashCode() == 3439 && b2.hashCode() == -3439, "test_hashCode");
    }

    public void test_intValue() {
        Short b1 = new Short(Short.MAX_VALUE);
        Short b2 = new Short(-32767);
        harness.check(b1.intValue() == Short.MAX_VALUE, "test_intValue - 1");
        harness.check(b2.intValue() == -32767, "test_intValue - 2");
    }

    public void test_longValue() {
        Short b1 = new Short(3767);
        Short b2 = new Short(-3767);
        harness.check(b1.longValue() == 3767L, "test_longValue - 1");
        harness.check(b2.longValue() == -3767L, "test_longValue - 2");
    }

    public void test_floatValue() {
        Short b1 = new Short(3276);
        Short b2 = new Short(-3276);
        harness.check(b1.floatValue() == 3276.0f, "test_floatValue - 1");
        harness.check(b2.floatValue() == -3276.0f, "test_floatValue - 2");
    }

    public void test_doubleValue() {
        Short b1 = new Short(0);
        Short b2 = new Short(30);
        harness.check(b1.doubleValue() == 0.0, "test_doubleValue - 1");
        harness.check(b2.doubleValue() == 30.0, "test_doubleValue - 2");
    }

    public void test_shortbyteValue() {
        Short b1 = new Short(0);
        Short b2 = new Short(300);
        harness.check(b1.byteValue() == 0, "test_shortbyteValue - 1");
        harness.check(b2.byteValue() == 44, "test_shortbyteValue - 2");
        harness.check(b1 == 0, "test_shortbyteValue - 3");
        harness.check(b2 == 300, "test_shortbyteValue - 4");
        harness.check(b1 == 0, "test_shortbyteValue - 5");
        harness.check(((Number)b2).byteValue() == 44, "test_shortbyteValue - 6");
    }

    public void test_parseShort() {
        harness.check(Short.parseShort("473") == Short.parseShort("473", 10), "test_parseInt - 1");
        harness.check(Short.parseShort("0", 10) == 0, "test_parseInt - 2");
        harness.check(Short.parseShort("473", 10) == 473, "test_parseInt - 3");
        harness.check(Short.parseShort("-0", 10) == 0, "test_parseInt - 4");
        harness.check(Short.parseShort("-FF", 16) == -255, "test_parseInt - 5");
        harness.check(Short.parseShort("1100110", 2) == 102, "test_parseInt - 6");
        try {
            Short.parseShort("99", 8);
            harness.fail("test_parseInt - 10");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            Short.parseShort("kona", 10);
            harness.fail("test_parseInt - 11");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public void test_valueOf() {
        harness.check(Short.valueOf("21234").intValue() == Short.parseShort("21234"), "test_valueOf - 1");
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
        this.test_parseShort();
        this.test_valueOf();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

