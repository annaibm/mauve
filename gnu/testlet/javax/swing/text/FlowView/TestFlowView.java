/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.FlowView;

import javax.swing.text.BoxView;
import javax.swing.text.Element;
import javax.swing.text.FlowView;
import javax.swing.text.View;

public class TestFlowView
extends FlowView {
    public TestFlowView(Element element, int axis) {
        super(element, axis);
        this.strategy = new TestFlowStrategy();
    }

    @Override
    public View createRow() {
        return new TestRow(this.getElement());
    }

    public TestFlowStrategy getFlowStragy() {
        return (TestFlowStrategy)this.strategy;
    }

    public class TestRow
    extends BoxView {
        public int preferred;
        public TestRow break1;
        public TestRow break2;
        public int breakWeight;

        public TestRow(Element el) {
            super(el, 0);
            this.preferred = 200;
            this.breakWeight = 0;
        }

        @Override
        public float getPreferredSpan(int axis) {
            System.err.println("preferredSpan called");
            return this.preferred;
        }

        @Override
        public float getMinimumSpan(int axis) {
            System.err.println("minimumSpan called");
            return this.preferred;
        }

        @Override
        public int getBreakWeight(int axis, float pos, float len) {
            System.err.println("getBreakWeight called");
            if (pos + len > (float)this.preferred) {
                return this.breakWeight;
            }
            return 0;
        }

        @Override
        public View breakView(int axis, int offset2, float pos, float len) {
            System.err.println("breakView called");
            this.break1 = new TestRow(this.getElement());
            this.break1.preferred = this.preferred / 2;
            this.break2 = new TestRow(this.getElement());
            this.break2.preferred = this.preferred / 2;
            if (offset2 < this.preferred / 2) {
                return this.break1;
            }
            return this.break2;
        }
    }

    public class TestFlowStrategy
    extends FlowView.FlowStrategy {
        @Override
        public void adjustRow(FlowView fv, int rowIndex, int desiredSpan, int x) {
            super.adjustRow(fv, rowIndex, desiredSpan, x);
        }
    }
}

