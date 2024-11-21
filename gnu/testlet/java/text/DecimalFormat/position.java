/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.util.Locale;

public class position
implements Testlet {
    public String format(DecimalFormat df, double number, FieldPosition pos, StringBuffer buf) {
        buf.setLength(0);
        return df.format(number, buf, pos).toString();
    }

    @Override
    public void test(TestHarness harness) {
        Locale loc = Locale.US;
        Locale.setDefault(loc);
        StringBuffer buf = new StringBuffer();
        DecimalFormat df = new DecimalFormat("0.##");
        FieldPosition intPos = new FieldPosition(0);
        FieldPosition fracPos = new FieldPosition(1);
        harness.check(this.format(df, -1234.56, intPos, buf), (Object)"-1234.56");
        harness.check(intPos.getBeginIndex(), 1);
        harness.check(intPos.getEndIndex(), 5);
        harness.check(this.format(df, -1234.56, fracPos, buf), (Object)"-1234.56");
        harness.check(fracPos.getBeginIndex(), 6);
        harness.check(fracPos.getEndIndex(), 8);
    }
}

