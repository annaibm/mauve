/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class decode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Integer.decode("0").equals(new Integer(0)));
        harness.check(Integer.decode("-1").equals(new Integer(-1)));
        harness.check(Integer.decode("123").equals(new Integer(123)));
        harness.check(Integer.decode("1234567").equals(new Integer(1234567)));
        harness.check(Integer.decode("2147483647").equals(new Integer(Integer.MAX_VALUE)));
        harness.check(Integer.decode("-2147483648").equals(new Integer(Integer.MIN_VALUE)));
        harness.check(Integer.decode("0x00").equals(new Integer(0)));
        harness.check(Integer.decode("-0x01").equals(new Integer(-1)));
        harness.check(Integer.decode("0xFF").equals(new Integer(255)));
        harness.check(Integer.decode("0XFF").equals(new Integer(255)));
        harness.check(Integer.decode("0xff").equals(new Integer(255)));
        harness.check(Integer.decode("0XfF").equals(new Integer(255)));
        harness.check(Integer.decode("#ff").equals(new Integer(255)));
        harness.check(Integer.decode("00").equals(new Integer(0)));
        harness.check(Integer.decode("-070").equals(new Integer(-56)));
        harness.check(Integer.decode("072").equals(new Integer(58)));
        boolean pass = false;
        try {
            Integer.decode(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Integer.decode("XYZ");
        }
        catch (NumberFormatException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Integer.decode("078");
        }
        catch (NumberFormatException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Integer.decode("1.0");
        }
        catch (NumberFormatException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Integer.decode("");
        }
        catch (NumberFormatException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

