/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.ChoiceFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.ChoiceFormat;
import java.text.FieldPosition;

public class format
implements Testlet {
    public final String doformat(ChoiceFormat cf, double d, StringBuffer buf) {
        buf.setLength(0);
        cf.format(d, buf, (FieldPosition)null);
        return buf.toString();
    }

    @Override
    public void test(TestHarness harness) {
        StringBuffer buf = new StringBuffer();
        ChoiceFormat cf = new ChoiceFormat("1.0#Sun|2.0#Mon|3.0#Tue|4.0#Wed|5.0#Thu|6.0#Fri|7.0#Sat");
        harness.check(cf.getFormats().length, 7);
        harness.check(cf.getLimits().length, 7);
        harness.check(this.doformat(cf, -9.0, buf), (Object)"Sun");
        harness.check(this.doformat(cf, 1.5, buf), (Object)"Sun");
        harness.check(this.doformat(cf, 5.5, buf), (Object)"Thu");
        harness.check(this.doformat(cf, 7.0, buf), (Object)"Sat");
        harness.check(this.doformat(cf, 99.5, buf), (Object)"Sat");
        cf.applyPattern("-1.0#Less than one|1.0#One|1.0<One to two, exclusive|2.0#Two to three, inclusive|3.0<Over three, up to four|4.0<Four to five, exclusive|5.0#Five and above");
        harness.check(this.doformat(cf, -23.0, buf), (Object)"Less than one");
        harness.check(this.doformat(cf, -0.5, buf), (Object)"Less than one");
        harness.check(this.doformat(cf, ChoiceFormat.previousDouble(1.0), buf), (Object)"Less than one");
        harness.check(this.doformat(cf, 1.0, buf), (Object)"One");
        harness.check(this.doformat(cf, ChoiceFormat.nextDouble(1.0), buf), (Object)"One to two, exclusive");
        harness.check(this.doformat(cf, 1.5, buf), (Object)"One to two, exclusive");
        harness.check(this.doformat(cf, 2.0, buf), (Object)"Two to three, inclusive");
        harness.check(this.doformat(cf, 3.5, buf), (Object)"Over three, up to four");
        harness.check(this.doformat(cf, 4.0, buf), (Object)"Over three, up to four");
        harness.check(this.doformat(cf, 5.0, buf), (Object)"Five and above");
        harness.check(this.doformat(cf, Double.POSITIVE_INFINITY, buf), (Object)"Five and above");
        harness.check(this.doformat(cf, Double.NaN, buf), (Object)"Less than one");
    }
}

