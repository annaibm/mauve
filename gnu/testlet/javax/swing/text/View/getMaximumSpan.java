/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.View;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.View.TestView;

public class getMaximumSpan
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testXAxis(harness);
        this.testYAxis(harness);
        this.testPositiveResizeWeight(harness);
    }

    private void testXAxis(TestHarness harness) {
        TestView v = new TestView();
        v.preferred[0] = 123.0f;
        harness.check(v.getMaximumSpan(0), 123.0);
    }

    private void testYAxis(TestHarness harness) {
        TestView v = new TestView();
        v.preferred[1] = 123.0f;
        harness.check(v.getMaximumSpan(1), 123.0);
    }

    private void testPositiveResizeWeight(TestHarness harness) {
        PositiveResizeWeightView v = new PositiveResizeWeightView();
        v.resizeWeight = 100;
        v.preferred[0] = 123.0f;
        v.preferred[1] = 123.0f;
        harness.check((int)v.getMaximumSpan(0), Integer.MAX_VALUE);
        harness.check((int)v.getMaximumSpan(1), Integer.MAX_VALUE);
    }

    private class PositiveResizeWeightView
    extends TestView {
        int resizeWeight = 0;

        private PositiveResizeWeightView() {
        }

        @Override
        public int getResizeWeight(int axis) {
            return this.resizeWeight;
        }
    }
}

