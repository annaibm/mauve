/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Short;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new Short(0).toString(), (Object)"0");
        harness.check(new Short(-1).toString(), (Object)"-1");
        harness.check(new Short(1).toString(), (Object)"1");
        harness.check(new Short(127).toString(), (Object)"127");
        harness.check(new Short(-128).toString(), (Object)"-128");
        harness.check(new Short(Short.MIN_VALUE).toString(), (Object)"-32768");
        harness.check(new Short(Short.MAX_VALUE).toString(), (Object)"32767");
        harness.check(Short.toString((short)0), (Object)"0");
        harness.check(Short.toString((short)-1), (Object)"-1");
        harness.check(Short.toString((short)1), (Object)"1");
        harness.check(Short.toString((short)127), (Object)"127");
        harness.check(Short.toString((short)-128), (Object)"-128");
        harness.check(Short.toString((short)Short.MIN_VALUE), (Object)"-32768");
        harness.check(Short.toString((short)Short.MAX_VALUE), (Object)"32767");
    }
}

