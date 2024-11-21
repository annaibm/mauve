/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class parseByteRadix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        byte b = Byte.parseByte("0", 2);
        harness.check(b, 0);
        b = Byte.parseByte("0", 10);
        harness.check(b, 0);
        b = Byte.parseByte("0", 16);
        harness.check(b, 0);
        b = Byte.parseByte("0", 36);
        harness.check(b, 0);
        b = Byte.parseByte("10", 8);
        harness.check(b, 8);
        b = Byte.parseByte("10", 10);
        harness.check(b, 10);
        b = Byte.parseByte("10", 16);
        harness.check(b, 16);
        b = Byte.parseByte("z", 36);
        harness.check(b, 35);
        b = Byte.parseByte("-80", 16);
        harness.check(b, -128);
        b = Byte.parseByte("7f", 16);
        harness.check(b, 127);
        try {
            b = Byte.parseByte("10", 1);
            harness.fail("too small radix");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            b = Byte.parseByte("10", 37);
            harness.fail("too small radix");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            b = Byte.parseByte("-129");
            harness.fail("-129 is to small for a byte");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            b = Byte.parseByte("128");
            harness.fail("128 is to big for a byte");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            b = Byte.parseByte("abc");
            harness.fail("Illegal input (abc) must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            b = Byte.parseByte("-");
            harness.fail("Single '-' must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            b = Byte.parseByte("+");
            harness.fail("Single '+' must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        if (parseByteRadix.conformToJDK17()) {
            try {
                b = Byte.parseByte("+10", 10);
                harness.check(true);
                harness.check(b, 10);
            }
            catch (NumberFormatException nfe) {
                harness.fail("'+10' string is not parsed correctly as expected in JDK1.7");
            }
        } else {
            try {
                b = Byte.parseByte("+10", 10);
                harness.fail("'+10' must throw NumberFormatException");
            }
            catch (NumberFormatException nfe) {
                harness.check(true);
            }
        }
        try {
            b = Byte.parseByte(null, 10);
            harness.fail("null input must throw NumberFormatException");
        }
        catch (NullPointerException npe) {
            harness.fail("null input must throw NumberFormatException, not NullPointerException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            b = Byte.parseByte("", 10);
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

