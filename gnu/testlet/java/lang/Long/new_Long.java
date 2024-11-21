/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class new_Long
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Long a = new Long(0L);
        Long b = new Long(1L);
        Long c = new Long(-1L);
        Long d = new Long(Long.MAX_VALUE);
        Long e = new Long(Long.MIN_VALUE);
        Long f = new Long("0");
        Long g = new Long("1");
        Long h = new Long("-1");
        Long i = new Long("9223372036854775807");
        Long j = new Long("-9223372036854775808");
        Long k = new Long("-0");
        Long l = new Long("012345");
        Long m = new Long("0012345");
        harness.check(a + " " + b + " " + c + " " + d + " " + e, (Object)"0 1 -1 9223372036854775807 -9223372036854775808");
        harness.check(f + " " + g + " " + h + " " + i + " " + j, (Object)"0 1 -1 9223372036854775807 -9223372036854775808");
        harness.check(k + " " + l + " " + m, (Object)"0 12345 12345");
        harness.check((long)Integer.MAX_VALUE, (long)Integer.MAX_VALUE);
        harness.check((long)Integer.MIN_VALUE, (long)Integer.MIN_VALUE);
        harness.check(Long.MAX_VALUE, Long.MAX_VALUE);
        harness.check(Long.MAX_VALUE, Long.MAX_VALUE);
        harness.check(Long.MIN_VALUE, Long.MIN_VALUE);
        harness.check(-9223372036854775807L, -9223372036854775807L);
        harness.check(Long.MIN_VALUE, Long.MIN_VALUE);
        harness.check(Long.MAX_VALUE, Long.MAX_VALUE);
        harness.check(0x7FFFFFFFFFFFFFFEL, 0x7FFFFFFFFFFFFFFEL);
        harness.check(c.toString(), (Object)"-1");
        harness.check(e.toString(), (Object)"-9223372036854775808");
        harness.check(Long.toString(-1L, 2), (Object)"-1");
        harness.check(Long.toString(-9223372036854775807L, 2), (Object)"-111111111111111111111111111111111111111111111111111111111111111");
        harness.check(Long.toString(Long.MIN_VALUE, 2), (Object)"-1000000000000000000000000000000000000000000000000000000000000000");
        harness.check(Long.toString(Long.MAX_VALUE, 2), (Object)"111111111111111111111111111111111111111111111111111111111111111");
        harness.check(Long.toString(-1L, 16), (Object)"-1");
        harness.check(Long.toString(-9223372036854775807L, 16), (Object)"-7fffffffffffffff");
        harness.check(Long.toString(Long.MIN_VALUE, 16), (Object)"-8000000000000000");
        harness.check(Long.toString(Long.MAX_VALUE, 16), (Object)"7fffffffffffffff");
        harness.check(Long.toString(-1L, 36), (Object)"-1");
        harness.check(Long.toString(-9223372036854775807L, 36), (Object)"-1y2p0ij32e8e7");
        harness.check(Long.toString(Long.MIN_VALUE, 36), (Object)"-1y2p0ij32e8e8");
        harness.check(Long.toString(Long.MAX_VALUE, 36), (Object)"1y2p0ij32e8e7");
        harness.check(Long.toString(12345L, 1), (Object)"12345");
        harness.check(Long.toString(-12345L, 1), (Object)"-12345");
        harness.check(Long.toString(12345L, 37), (Object)"12345");
        harness.check(Long.toString(-12345L, 37), (Object)"-12345");
        harness.check(Long.toString(12345L, 0), (Object)"12345");
        harness.check(Long.toString(-12345L, 0), (Object)"-12345");
        harness.check(Long.toString(12345L, -1), (Object)"12345");
        harness.check(Long.toString(-12345L, -1), (Object)"-12345");
        harness.check(Long.toString(12345L, 1), (Object)"12345");
        harness.check(Long.toString(12345L, 37), (Object)"12345");
        Long bad = null;
        try {
            bad = new Long("9223372036854775808");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(bad, null);
        bad = null;
        try {
            bad = new Long("-9223372036854775809");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(bad, null);
        bad = null;
        try {
            bad = new Long("12345a");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(bad, null);
        bad = null;
        try {
            bad = new Long("-");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(bad, null);
        bad = null;
        try {
            bad = new Long("0x1e");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        harness.check(bad, null);
        harness.check(a.hashCode(), 0);
        harness.check(b.hashCode(), 1);
        harness.check(c.hashCode(), 0);
        harness.check(d.hashCode(), Integer.MIN_VALUE);
        harness.check(e.hashCode(), Integer.MIN_VALUE);
        boolean ok = false;
        try {
            Long.parseLong("");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Long.parseLong(" ");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Long.parseLong("0X1234");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Long.parseLong("0xF0000000");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Long.parseLong("-");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Long.parseLong("#");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Long.parseLong("-0x1234FF");
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        harness.checkPoint("toBinaryString");
        harness.check(Long.toBinaryString(0L), (Object)"0");
        harness.check(Long.toBinaryString(1L), (Object)"1");
        harness.check(Long.toBinaryString(-1L), (Object)"1111111111111111111111111111111111111111111111111111111111111111");
        harness.check(Long.toBinaryString(Long.MIN_VALUE), (Object)"1000000000000000000000000000000000000000000000000000000000000000");
        harness.check(Long.toBinaryString(Long.MAX_VALUE), (Object)"111111111111111111111111111111111111111111111111111111111111111");
        harness.check(Long.toBinaryString(Long.MAX_VALUE), (Object)"111111111111111111111111111111111111111111111111111111111111111");
        harness.check(Long.toBinaryString(Long.MIN_VALUE), (Object)"1000000000000000000000000000000000000000000000000000000000000000");
        harness.checkPoint("toOctalString");
        harness.check(Long.toOctalString(0L), (Object)"0");
        harness.check(Long.toOctalString(1L), (Object)"1");
        harness.check(Long.toOctalString(-1L), (Object)"1777777777777777777777");
        harness.check(Long.toOctalString(Long.MIN_VALUE), (Object)"1000000000000000000000");
        harness.check(Long.toOctalString(Long.MAX_VALUE), (Object)"777777777777777777777");
        harness.check(Long.toOctalString(Long.MAX_VALUE), (Object)"777777777777777777777");
        harness.check(Long.toOctalString(Long.MIN_VALUE), (Object)"1000000000000000000000");
        harness.checkPoint("toHexString");
        harness.check(Long.toHexString(0L), (Object)"0");
        harness.check(Long.toHexString(1L), (Object)"1");
        harness.check(Long.toHexString(-1L), (Object)"ffffffffffffffff");
        harness.check(Long.toHexString(Long.MIN_VALUE), (Object)"8000000000000000");
        harness.check(Long.toHexString(Long.MAX_VALUE), (Object)"7fffffffffffffff");
        harness.check(Long.toHexString(Long.MAX_VALUE), (Object)"7fffffffffffffff");
        harness.check(Long.toHexString(Long.MIN_VALUE), (Object)"8000000000000000");
        harness.checkPoint("parseLong");
        harness.check(Long.parseLong("0012345", 8), 5349L);
        harness.check(Long.parseLong("xyz", 36), 44027L);
        harness.check(Long.parseLong("12345", 6), 1865L);
        harness.check(Long.parseLong("abcdef", 16), 11259375L);
        harness.check(Long.parseLong("-0012345", 8), -5349L);
        harness.check(Long.parseLong("-xyz", 36), -44027L);
        harness.check(Long.parseLong("-12345", 6), -1865L);
        harness.check(Long.parseLong("-abcdef", 16), -11259375L);
        harness.check(Long.parseLong("-8000000000000000", 16), Long.MIN_VALUE);
        harness.check(Long.parseLong("7fffffffffffffff", 16), Long.MAX_VALUE);
        ok = false;
        try {
            Long.parseLong("0", 1);
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Long.parseLong("0", 37);
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Long.parseLong("8000000000000000", 16);
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            Long.parseLong("-8000000000000001", 16);
        }
        catch (NumberFormatException ex) {
            ok = true;
        }
        harness.check(ok);
    }
}

