/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.ChoiceFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.ChoiceFormat;
import java.text.ParsePosition;

public class parse
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ChoiceFormat cf = new ChoiceFormat("1.0#Sun|2.0#Mon|3.0#Tue|4.0#Wed|5.0#Thu|6.0#Fri|7.0#Sat");
        ParsePosition pp = new ParsePosition(0);
        Number n = cf.parse("Wed", pp);
        harness.check(n instanceof Double);
        harness.check(n.doubleValue(), 4.0);
        harness.check(pp.getIndex(), 3);
        pp.setIndex(3);
        n = cf.parse("ZooMon", pp);
        harness.check(n.doubleValue(), 2.0);
        harness.check(pp.getIndex(), 6);
        pp.setIndex(0);
        n = cf.parse("Saturday", pp);
        harness.check(n.doubleValue(), 7.0);
        harness.check(pp.getIndex(), 3);
        n = cf.parse("Saturday", pp);
        harness.check(Double.isNaN(n.doubleValue()));
        harness.check(pp.getIndex(), 3);
    }
}

