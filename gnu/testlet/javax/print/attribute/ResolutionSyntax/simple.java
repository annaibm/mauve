/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.attribute.ResolutionSyntax;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.print.attribute.ResolutionSyntax;

public class simple
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestResolutionSyntax test = new TestResolutionSyntax(400, 600, 100);
        harness.checkPoint("toString");
        harness.check(test.toString(), (Object)"40000x60000 dphi");
        harness.check(test.toString(100, "dpi"), (Object)"400x600 dpi");
        harness.check(test.toString(254, "dpcm"), (Object)"157x236 dpcm");
        harness.check(test.toString(254, null), (Object)"157x236");
        harness.checkPoint("getFeedResolution");
        harness.check(test.getFeedResolution(254), 236);
        harness.check(test.getFeedResolution(100), 600);
        TestResolutionSyntax test22 = new TestResolutionSyntax(400, 600, 100);
        TestResolutionSyntax test32 = new TestResolutionSyntax(401, 610, 100);
        TestResolutionSyntax test42 = new TestResolutionSyntax(389, 589, 100);
        harness.checkPoint("lessThanOrEqual");
        harness.check(test.lessThanOrEquals(test22), true);
        harness.check(test.lessThanOrEquals(test32), true);
        harness.check(test.lessThanOrEquals(test42), false);
        TestResolutionSyntax test52 = new TestResolutionSyntax(40000, 60000, 1);
        harness.checkPoint("equals");
        harness.check(test.equals(test22), true);
        harness.check(test.equals(test52), true);
        harness.check(test32.equals(test52), false);
    }

    public class TestResolutionSyntax
    extends ResolutionSyntax {
        public TestResolutionSyntax(int crossFeedResolution, int feedResolution, int units) {
            super(crossFeedResolution, feedResolution, units);
        }
    }
}

