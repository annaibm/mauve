/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new Byte(0).toString(), (Object)"0");
        harness.check(new Byte(-1).toString(), (Object)"-1");
        harness.check(new Byte(1).toString(), (Object)"1");
        harness.check(new Byte(127).toString(), (Object)"127");
        harness.check(new Byte(-128).toString(), (Object)"-128");
        harness.check(Byte.toString((byte)0), (Object)"0");
        harness.check(Byte.toString((byte)-1), (Object)"-1");
        harness.check(Byte.toString((byte)1), (Object)"1");
        harness.check(Byte.toString((byte)127), (Object)"127");
        harness.check(Byte.toString((byte)-128), (Object)"-128");
    }
}

