/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;
import java.util.Locale;

public class PR23996
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Locale orig = Locale.getDefault();
        Locale.setDefault(Locale.US);
        harness.checkPoint("PR23996");
        DecimalFormat df = new DecimalFormat("S#.12345");
        harness.check(df.format(3.4028234663852886E38), (Object)"S340282346638528860000000000000000000000.12345");
        DecimalFormat df1 = new DecimalFormat("S#.00");
        harness.check(df1.format(3.4028234663852886E38), (Object)"S340282346638528860000000000000000000000.00");
        DecimalFormat df2 = new DecimalFormat("0.7547895");
        harness.check(df2.format(3.4028234663852886E38), (Object)"340282346638528860000000000000000000000.7547895");
        Locale.setDefault(orig);
    }
}

