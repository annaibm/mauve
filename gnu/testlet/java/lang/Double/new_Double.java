/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class new_Double
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new Double("7.79625120912E289").toString(), (Object)"7.79625120912E289");
        harness.check(new Double(3.142857142857143).toString(), (Object)"3.142857142857143");
        harness.check(new Double(Math.PI).toString(), (Object)"3.141592653589793");
        harness.check(Double.valueOf(new Double(Math.PI).toString()), new Double(Math.PI));
        harness.check(Double.valueOf(new Double(-Math.PI).toString()), new Double(-Math.PI));
        harness.check(new Double(Double.MAX_VALUE).toString(), (Object)"1.7976931348623157E308");
        harness.check(new Double(-1.7976931348623157E308).toString(), (Object)"-1.7976931348623157E308");
        harness.check(new Double(Double.POSITIVE_INFINITY).toString(), (Object)"Infinity");
        harness.check(new Double(Double.NEGATIVE_INFINITY).toString(), (Object)"-Infinity");
        harness.check(new Double(Double.NaN).toString(), (Object)"NaN");
    }
}

