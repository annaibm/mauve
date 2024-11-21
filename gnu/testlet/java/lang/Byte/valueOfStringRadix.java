/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class valueOfStringRadix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Byte.valueOf("0", 2).equals(new Byte(0)));
        harness.check(Byte.valueOf("0", 10).equals(new Byte(0)));
        harness.check(Byte.valueOf("0", 16).equals(new Byte(0)));
        harness.check(Byte.valueOf("0", 36).equals(new Byte(0)));
        harness.check(Byte.valueOf("10", 2).equals(new Byte(2)));
        harness.check(Byte.valueOf("10", 10).equals(new Byte(10)));
        harness.check(Byte.valueOf("10", 16).equals(new Byte(16)));
        harness.check(Byte.valueOf("10", 36).equals(new Byte(36)));
        harness.check(Byte.valueOf("z", 36).equals(new Byte(35)));
        try {
            Byte.valueOf("10", 1);
            harness.fail("too small radix");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            Byte.valueOf("10", 37);
            harness.fail("too small radix");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            Byte.valueOf("-129");
            harness.fail("-129 is to small for a byte");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            Byte.valueOf("128");
            harness.fail("128 is to big for a byte");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            Byte.valueOf("abc");
            harness.fail("Illegal input (abc) must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            Byte.valueOf("-");
            harness.fail("Single '-' must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            Byte.valueOf("+");
            harness.fail("Single '+' must throw NumberFormatException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            Byte.valueOf(null, 10);
            harness.fail("null input must throw NumberFormatException");
        }
        catch (NullPointerException npe) {
            harness.fail("null input must throw NumberFormatException, not NullPointerException");
        }
        catch (NumberFormatException nfe) {
            harness.check(true);
        }
        try {
            Byte.valueOf("", 10);
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

