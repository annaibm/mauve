/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class new_Float
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new Float(3.142857142857143).toString(), (Object)"3.142857");
        harness.check(new Float(Math.PI).toString(), (Object)"3.1415927");
        harness.check(Float.valueOf(new Float(Math.PI).toString()), new Float(Math.PI));
        harness.check(Float.valueOf(new Float(-Math.PI).toString()), new Float(-Math.PI));
        harness.check(new Float(Float.MAX_VALUE).toString(), (Object)"3.4028235E38");
        harness.check(new Float(-3.4028235E38f).toString(), (Object)"-3.4028235E38");
        harness.check(new Float(Float.POSITIVE_INFINITY).toString(), (Object)"Infinity");
        harness.check(new Float(Float.NEGATIVE_INFINITY).toString(), (Object)"-Infinity");
        harness.check(new Float(Float.NaN).toString(), (Object)"NaN");
    }
}

