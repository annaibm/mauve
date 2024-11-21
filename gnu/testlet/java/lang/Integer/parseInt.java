/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class parseInt
implements Testlet {
    private static boolean conformToJDK17() {
        String[] javaVersion = System.getProperty("java.version").split("\\.");
        String vendorID = System.getProperty("java.vendor");
        if ("Sun Microsystems Inc.".equals(vendorID)) {
            return Integer.parseInt(javaVersion[1]) >= 7;
        }
        return true;
    }

    @Override
    public void test(TestHarness harness) {
        int i = Integer.parseInt("0");
        harness.check(i, 0);
        i = Integer.parseInt("1");
        harness.check(i, 1);
        i = Integer.parseInt("000");
        harness.check(i, 0);
        i = Integer.parseInt("007");
        harness.check(i, 7);
        i = Integer.parseInt("-0");
        harness.check(i, 0);
        i = Integer.parseInt("-1");
        harness.check(i, -1);
        i = Integer.parseInt("-2147483648");
        harness.check(i, Integer.MIN_VALUE);
        i = Integer.parseInt("2147483647");
        harness.check(i, Integer.MAX_VALUE);
        try {
            i = Integer.parseInt("-2147483649");
            harness.fail("-2147483649 is to small for an int");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            i = Integer.parseInt("2147483648");
            harness.fail("2147483648 is to big for an int");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            i = Integer.parseInt("abc");
            harness.fail("Illegal input (abc) must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            i = Integer.parseInt("-");
            harness.fail("Single '-' must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            i = Integer.parseInt("+");
            harness.fail("Single '+' must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        if (parseInt.conformToJDK17()) {
            try {
                i = Integer.parseInt("+10");
                harness.check(true);
                harness.check(i, 10);
            }
            catch (NumberFormatException nfe) {
                harness.fail("'+10' string is not parsed correctly as expected in JDK1.7");
            }
        } else {
            try {
                i = Integer.parseInt("+10");
                harness.fail("'+10' must throw NumberFormatException");
            }
            catch (NumberFormatException nfe) {
                harness.check(true);
            }
        }
        try {
            i = Integer.parseInt(null);
            harness.fail("null input must throw NumberFormatException");
        }
        catch (NullPointerException npe) {
            harness.fail("null input must throw NumberFormatException, not NullPointerException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            i = Integer.parseInt("");
            harness.fail("empty input must throw NumberFormatException");
        }
        catch (IndexOutOfBoundsException ioobe) {
            harness.fail("empty input must throw NumberFormatException, not IndexOutOfBoundsException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
    }
}

