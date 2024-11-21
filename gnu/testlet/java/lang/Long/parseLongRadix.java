/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class parseLongRadix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        long l = Long.parseLong("0", 2);
        harness.check(l, 0L);
        l = Long.parseLong("0", 10);
        harness.check(l, 0L);
        l = Long.parseLong("0", 16);
        harness.check(l, 0L);
        l = Long.parseLong("0", 36);
        harness.check(l, 0L);
        l = Long.parseLong("10", 8);
        harness.check(l, 8L);
        l = Long.parseLong("10", 10);
        harness.check(l, 10L);
        l = Long.parseLong("10", 16);
        harness.check(l, 16L);
        l = Long.parseLong("z", 36);
        harness.check(l, 35L);
        l = Long.parseLong("-80", 16);
        harness.check(l, -128L);
        l = Long.parseLong("7f", 16);
        harness.check(l, 127L);
        try {
            l = Long.parseLong("10", 1);
            harness.fail("too small radix");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            l = Long.parseLong("10", 37);
            harness.fail("too small radix");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            l = Long.parseLong("-9223372036854775809");
            harness.fail("-9223372036854775809 is to small for a Long");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            l = Long.parseLong("9223372036854775808");
            harness.fail("9223372036854775808 is to big for a Long");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            l = Long.parseLong("abc");
            harness.fail("Illegal input (abc) must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            l = Long.parseLong("-");
            harness.fail("Single '-' must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            l = Long.parseLong("+");
            harness.fail("Single '+' must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        if (parseLongRadix.conformToJDK17()) {
            try {
                l = Long.parseLong("+10", 10);
                harness.check(true);
                harness.check(l, 10L);
            }
            catch (NumberFormatException nfe) {
                harness.fail("'+10' string is not parsed correctly as expected in JDK1.7");
            }
        } else {
            try {
                l = Long.parseLong("+10", 10);
                harness.fail("'+10' must throw NumberFormatException");
            }
            catch (NumberFormatException nfe) {
                harness.check(true);
            }
        }
        try {
            l = Long.parseLong(null, 10);
            harness.fail("null input must throw NumberFormatException");
        }
        catch (NullPointerException npe) {
            harness.fail("null input must throw NumberFormatException, not NullPointerException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            l = Long.parseLong("", 10);
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
            return Long.parseLong(javaVersion[1]) >= 7L;
        }
        return true;
    }
}

