/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.Size2DSyntax;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.print.attribute.Size2DSyntax;

public class simple
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestSize2DSyntax floatInch = new TestSize2DSyntax(55.6f, 232.1f, 25400);
        TestSize2DSyntax intInch = new TestSize2DSyntax(8, 12, 25400);
        TestSize2DSyntax floatMM = new TestSize2DSyntax(55.6f, 232.1f, 1000);
        TestSize2DSyntax intMM = new TestSize2DSyntax(210, 297, 1000);
        harness.checkPoint("units conversions/toString");
        harness.check(floatInch.toString(), (Object)"1412240x5895340 um");
        harness.check(intInch.toString(), (Object)"203200x304800 um");
        harness.check(floatMM.toString(), (Object)"55600x232100 um");
        harness.check(intMM.toString(), (Object)"210000x297000 um");
        harness.check(floatInch.toString(25400, null), (Object)"55.6x232.1");
        harness.check(intInch.toString(25400, null), (Object)"8.0x12.0");
        harness.check(floatMM.toString(25400, null), (Object)"2.1889763x9.137795");
        harness.check(intMM.toString(25400, null), (Object)"8.267716x11.692913");
        harness.check(floatInch.toString(1000, "mm"), (Object)"1412.24x5895.34 mm");
        harness.check(intInch.toString(1000, "mm"), (Object)"203.2x304.8 mm");
        harness.check(floatMM.toString(1000, "mm"), (Object)"55.6x232.1 mm");
        harness.check(intMM.toString(1000, "mm"), (Object)"210.0x297.0 mm");
    }

    public class TestSize2DSyntax
    extends Size2DSyntax {
        public TestSize2DSyntax(float x, float y, int units) {
            super(x, y, units);
        }

        public TestSize2DSyntax(int x, int y, int units) {
            super(x, y, units);
        }
    }
}

