/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class decode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Long.decode("0").equals(new Long(0L)));
        harness.check(Long.decode("-1").equals(new Long(-1L)));
        harness.check(Long.decode("123").equals(new Long(123L)));
        harness.check(Long.decode("1234567").equals(new Long(1234567L)));
        harness.check(Long.decode("1234567890000").equals(new Long(1234567890000L)));
        harness.check(Long.decode("2147483647").equals(new Long(Integer.MAX_VALUE)));
        harness.check(Long.decode("-2147483648").equals(new Long(Integer.MIN_VALUE)));
        harness.check(Long.decode("0x00").equals(new Long(0L)));
        harness.check(Long.decode("-0x01").equals(new Long(-1L)));
        harness.check(Long.decode("0xFF").equals(new Long(255L)));
        harness.check(Long.decode("0XFF").equals(new Long(255L)));
        harness.check(Long.decode("0xff").equals(new Long(255L)));
        harness.check(Long.decode("0XfF").equals(new Long(255L)));
        harness.check(Long.decode("#ff").equals(new Long(255L)));
        harness.check(Long.decode("0Xffff").equals(new Long(65535L)));
        harness.check(Long.decode("00").equals(new Long(0L)));
        harness.check(Long.decode("-070").equals(new Long(-56L)));
        harness.check(Long.decode("072").equals(new Long(58L)));
        boolean pass = false;
        try {
            Long.decode(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Long.decode("XYZ");
        }
        catch (NumberFormatException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Long.decode("078");
        }
        catch (NumberFormatException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Long.decode("1.0");
        }
        catch (NumberFormatException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Long.decode("");
        }
        catch (NumberFormatException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

