/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class parseIntRadix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int i = Integer.parseInt("0", 2);
        harness.check(i, 0);
        i = Integer.parseInt("0", 10);
        harness.check(i, 0);
        i = Integer.parseInt("0", 16);
        harness.check(i, 0);
        i = Integer.parseInt("0", 36);
        harness.check(i, 0);
        i = Integer.parseInt("10", 8);
        harness.check(i, 8);
        i = Integer.parseInt("10", 10);
        harness.check(i, 10);
        i = Integer.parseInt("10", 16);
        harness.check(i, 16);
        i = Integer.parseInt("z", 36);
        harness.check(i, 35);
        i = Integer.parseInt("-80", 16);
        harness.check(i, -128);
        i = Integer.parseInt("7f", 16);
        harness.check(i, 127);
        try {
            i = Integer.parseInt("10", 1);
            harness.fail("too small radix");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            i = Integer.parseInt("10", 37);
            harness.fail("too small radix");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            i = Integer.parseInt("-2147483649");
            harness.fail("-2147483649 is to small for a Integer");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            i = Integer.parseInt("2147483648");
            harness.fail("2147483648 is to big for a Integer");
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
        if (parseIntRadix.conformToJDK17()) {
            try {
                i = Integer.parseInt("+10", 10);
                harness.check(true);
                harness.check(i, 10);
            }
            catch (NumberFormatException nfe) {
                harness.fail("'+10' string is not parsed correctly as expected in JDK1.7");
            }
        } else {
            try {
                i = Integer.parseInt("+10", 10);
                harness.fail("'+10' must throw NumberFormatException");
            }
            catch (NumberFormatException nfe) {
                harness.check(true);
            }
        }
        try {
            i = Integer.parseInt(null, 10);
            harness.fail("null input must throw NumberFormatException");
        }
        catch (NullPointerException npe) {
            harness.fail("null input must throw NumberFormatException, not NullPointerException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            i = Integer.parseInt("", 10);
            harness.fail("empty input must throw NumberFormatException");
        }
        catch (IndexOutOfBoundsException ioobe) {
            harness.fail("empty input must throw NumberFormatException, not IndexOutOfBoundsException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
    }

    private static boolean conformToJDK17() {
        String[] javaVersion = System.getProperty("java.version").split("\\.");
        String vendorID = System.getProperty("java.vendor");
        if ("Sun Microsystems Inc.".equals(vendorID)) {
            return Integer.parseInt(javaVersion[1]) >= 7;
        }
        return true;
    }
}

