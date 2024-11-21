/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class construct
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new BigDecimal("0.1").toString(), (Object)"0.1");
        harness.check(new BigDecimal(0.1).toString(), (Object)"0.1000000000000000055511151231257827021181583404541015625");
        try {
            harness.check(new BigDecimal("0.01E5").toString(), (Object)"1E+3");
            harness.check(new BigDecimal("1000E-5").toString(), (Object)"0.01000");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }
}

