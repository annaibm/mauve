/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new Integer(0).toString(), (Object)"0");
        harness.check(new Integer(-1).toString(), (Object)"-1");
        harness.check(new Integer(1).toString(), (Object)"1");
        harness.check(new Integer(127).toString(), (Object)"127");
        harness.check(new Integer(-128).toString(), (Object)"-128");
        harness.check(new Integer(Integer.MAX_VALUE).toString(), (Object)"2147483647");
        harness.check(new Integer(Integer.MIN_VALUE).toString(), (Object)"-2147483648");
        harness.check(Integer.toString(0), (Object)"0");
        harness.check(Integer.toString(-1), (Object)"-1");
        harness.check(Integer.toString(1), (Object)"1");
        harness.check(Integer.toString(127), (Object)"127");
        harness.check(Integer.toString(-128), (Object)"-128");
        harness.check(Integer.toString(Integer.MAX_VALUE), (Object)"2147483647");
        harness.check(Integer.toString(Integer.MIN_VALUE), (Object)"-2147483648");
    }
}

