/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class new_Integer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Integer a = new Integer(0);
        Integer b = new Integer(1);
        Integer c = new Integer(-1);
        Integer d = new Integer(Integer.MAX_VALUE);
        Integer e = new Integer(Integer.MIN_VALUE);
        Integer f = new Integer("0");
        Integer g = new Integer("1");
        Integer h = new Integer("-1");
        Integer i = new Integer("2147483647");
        Integer j = new Integer("-2147483648");
        Integer k = new Integer("-0");
        Integer l = new Integer("012345");
        Integer m = new Integer("0012345");
        harness.checkPoint("toString");
        harness.check(a + " " + b + " " + c + " " + d + " " + e, (Object)"0 1 -1 2147483647 -2147483648");
        harness.check(f + " " + g + " " + h + " " + i + " " + j, (Object)"0 1 -1 2147483647 -2147483648");
        harness.check(k + " " + l + " " + m, (Object)"0 12345 12345");
        harness.check(Integer.MAX_VALUE, Integer.MAX_VALUE);
        harness.check(Integer.MIN_VALUE, Integer.MIN_VALUE);
        harness.check(-2147483647, -2147483647);
        harness.check(Integer.MIN_VALUE, Integer.MIN_VALUE);
        harness.check(Integer.MAX_VALUE, Integer.MAX_VALUE);
        harness.check(0x7FFFFFFE, 0x7FFFFFFE);
        harness.check(c.toString(), (Object)"-1");
        harness.check(e.toString(), (Object)"-2147483648");
        harness.check(Integer.toString(-1, 2), (Object)"-1");
        harness.check(Integer.toString(-2147483647, 2), (Object)"-1111111111111111111111111111111");
        harness.check(Integer.toString(Integer.MIN_VALUE, 2), (Object)"-10000000000000000000000000000000");
        harness.check(Integer.toString(Integer.MAX_VALUE, 2), (Object)"1111111111111111111111111111111");
        harness.check(Integer.toString(-1, 16), (Object)"-1");
        harness.check(Integer.toString(-2147483647, 16), (Object)"-7fffffff");
        harness.check(Integer.toString(Integer.MIN_VALUE, 16), (Object)"-80000000");
        harness.check(Integer.toString(Integer.MAX_VALUE, 16), (Object)"7fffffff");
        harness.check(Integer.toString(-1, 36), (Object)"-1");
        harness.check(Integer.toString(-2147483647, 36), (Object)"-zik0zj");
        harness.check(Integer.toString(Integer.MIN_VALUE, 36), (Object)"-zik0zk");
        harness.check(Integer.toString(Integer.MAX_VALUE, 36), (Object)"zik0zj");
        harness.check(Integer.toString(12345, 1), (Object)"12345");
        harness.check(Integer.toString(-12345, 1), (Object)"-12345");
        harness.check(Integer.toString(12345, 37), (Object)"12345");
        harness.check(Integer.toString(-12345, 37), (Object)"-12345");
        harness.check(Integer.toString(12345, 0), (Object)"12345");
        harness.check(Integer.toString(-12345, 0), (Object)"-12345");
        harness.check(Integer.toString(12345, -1), (Object)"12345");
        harness.check(Integer.toString(-12345, -1), (Object)"-12345");
        harness.check(Integer.toString(12345, 1), (Object)"12345");
        harness.check(Integer.toString(12345, 37), (Object)"12345");
        harness.checkPoint("exceptions");
        Integer bad = null;
        try {
            bad = new Integer("2147483648");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(bad, null);
        bad = null;
        try {
            bad = new Integer("-2147483649");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(bad, null);
        bad = null;
        try {
            bad = new Integer("12345a");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(bad, null);
        bad = null;
        try {
            bad = new Integer("-");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(bad, null);
        bad = null;
        try {
            bad = new Integer("0x1e");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(bad, null);
        bad = null;
        try {
            bad = new Integer(null);
        }
        catch (NullPointerException npe) {
            harness.fail("wrong exception");
        }
        catch (NumberFormatException npe) {
            // empty catch block
        }
        harness.check(bad, null);
        bad = null;
        try {
            bad = new Integer(" ");
        }
        catch (NumberFormatException npe) {
            // empty catch block
        }
        harness.check(bad, null);
        harness.checkPoint("hashCode");
        harness.check(a.hashCode(), 0);
        harness.check(b.hashCode(), 1);
        harness.check(c.hashCode(), -1);
        harness.check(d.hashCode(), Integer.MAX_VALUE);
        harness.check(e.hashCode(), Integer.MIN_VALUE);
        harness.checkPoint("decode");
        harness.check(Integer.decode("123456789"), new Integer(123456789));
        harness.check(Integer.decode("01234567"), new Integer(342391));
        harness.check(Integer.decode("0x1234FF"), new Integer(1193215));
        harness.check(Integer.decode("#1234FF"), new Integer(1193215));
        harness.check(Integer.decode("-123456789"), new Integer(-123456789));
        harness.check(Integer.decode("-01234567"), new Integer(-342391));
        harness.check(Integer.decode("-0"), new Integer(0));
        harness.check(Integer.decode("0"), new Integer(0));
        harness.check(Integer.decode(Integer.toString(Integer.MIN_VALUE)), new Integer(Integer.MIN_VALUE));
        harness.check(Integer.decode("-01"), new Integer(-1));
        harness.check(Integer.decode("-0x1"), new Integer(-1));
        harness.check(Integer.decode("-#1"), new Integer(-1));
        harness.check(Integer.decode("\u06609"), new Integer(9));
        harness.checkPoint("decode exceptions");
        boolean ok = false;
        try {
            Integer.decode("");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.decode(" ");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.decode(null);
        }
        catch (NullPointerException npe) {
            ok = true;
        }
        catch (NumberFormatException npe) {
            // empty catch block
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.decode("X1234");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.decode("0xF0000000");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.decode("0x");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.decode("-");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.decode("#");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        harness.checkPoint("toBinaryString");
        harness.check(Integer.toBinaryString(0), (Object)"0");
        harness.check(Integer.toBinaryString(1), (Object)"1");
        harness.check(Integer.toBinaryString(-1), (Object)"11111111111111111111111111111111");
        harness.check(Integer.toBinaryString(Integer.MIN_VALUE), (Object)"10000000000000000000000000000000");
        harness.check(Integer.toBinaryString(Integer.MAX_VALUE), (Object)"1111111111111111111111111111111");
        harness.check(Integer.toBinaryString(Integer.MAX_VALUE), (Object)"1111111111111111111111111111111");
        harness.check(Integer.toBinaryString(Integer.MIN_VALUE), (Object)"10000000000000000000000000000000");
        harness.checkPoint("toOctalString");
        harness.check(Integer.toOctalString(0), (Object)"0");
        harness.check(Integer.toOctalString(1), (Object)"1");
        harness.check(Integer.toOctalString(-1), (Object)"37777777777");
        harness.check(Integer.toOctalString(Integer.MIN_VALUE), (Object)"20000000000");
        harness.check(Integer.toOctalString(Integer.MAX_VALUE), (Object)"17777777777");
        harness.check(Integer.toOctalString(Integer.MAX_VALUE), (Object)"17777777777");
        harness.check(Integer.toOctalString(Integer.MIN_VALUE), (Object)"20000000000");
        harness.checkPoint("toHexString");
        harness.check(Integer.toHexString(0), (Object)"0");
        harness.check(Integer.toHexString(1), (Object)"1");
        harness.check(Integer.toHexString(-1), (Object)"ffffffff");
        harness.check(Integer.toHexString(Integer.MIN_VALUE), (Object)"80000000");
        harness.check(Integer.toHexString(Integer.MAX_VALUE), (Object)"7fffffff");
        harness.check(Integer.toHexString(Integer.MAX_VALUE), (Object)"7fffffff");
        harness.check(Integer.toHexString(Integer.MIN_VALUE), (Object)"80000000");
        harness.checkPoint("parseInt");
        harness.check(Integer.parseInt("0012345", 8), 5349);
        harness.check(Integer.parseInt("xyz", 36), 44027);
        harness.check(Integer.parseInt("12345", 6), 1865);
        harness.check(Integer.parseInt("abcdef", 16), 11259375);
        harness.check(Integer.parseInt("-0012345", 8), -5349);
        harness.check(Integer.parseInt("-xyz", 36), -44027);
        harness.check(Integer.parseInt("-12345", 6), -1865);
        harness.check(Integer.parseInt("-abcdef", 16), -11259375);
        harness.check(Integer.parseInt("0", 25), 0);
        ok = false;
        try {
            Integer.parseInt("0", 1);
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.parseInt("0", 37);
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.parseInt("-80000001", 16);
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.parseInt("4294967309", 10);
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Integer.parseInt("800000001", 16);
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
    }
}

