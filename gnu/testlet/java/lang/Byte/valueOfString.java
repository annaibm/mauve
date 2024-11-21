/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class valueOfString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new Byte(0).equals(Byte.valueOf("0")));
        harness.check(new Byte(-1).equals(Byte.valueOf("-1")));
        harness.check(new Byte(1).equals(Byte.valueOf("1")));
        harness.check(new Byte(127).equals(Byte.valueOf("127")));
        harness.check(new Byte(-128).equals(Byte.valueOf("-128")));
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

