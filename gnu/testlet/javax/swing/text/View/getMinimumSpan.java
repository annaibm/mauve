/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.View;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.View.TestView;

public class getMinimumSpan
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
        harness.check(v.getMinimumSpan(0), 123.0);
    }

    private void testYAxis(TestHarness harness) {
        TestView v = new TestView();
        v.preferred[1] = 123.0f;
        harness.check(v.getMinimumSpan(1), 123.0);
    }

    private void testPositiveResizeWeight(TestHarness harness) {
        PositiveResizeWeightView v = new PositiveResizeWeightView();
        v.resizeWeight = 100;
        v.preferred[0] = 123.0f;
        v.preferred[1] = 123.0f;
        harness.check((int)v.getMinimumSpan(0), 0);
        harness.check((int)v.getMinimumSpan(1), 0);
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

