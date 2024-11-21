/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.FlowView.FlowStrategy;

import java.awt.Graphics;
import java.awt.Shape;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.View;

public class TestView
extends View {
    public int preferred = 100;
    public int breakWeight = 0;
    public TestView break1;
    public TestView break2;

    public TestView(Element el) {
        super(el);
    }

    @Override
    public void paint(Graphics g, Shape s) {
    }

    @Override
    public float getMinimumSpan(int axis) {
        return this.getPreferredSpan(axis);
    }

    @Override
    public float getPreferredSpan(int axis) {
        return this.preferred;
    }

    @Override
    public Shape modelToView(int pos, Shape a, Position.Bias b) throws BadLocationException {
        return null;
    }

    @Override
    public int viewToModel(float x, float y, Shape a, Position.Bias[] b) {
        return 0;
    }

    @Override
    public int getBreakWeight(int axis, float pos, float len) {
        if (pos + len > (float)this.preferred) {
            return this.breakWeight;
        }
        return 0;
    }

    @Override
    public View breakView(int axis, int offset2, float pos, float len) {
        this.break1 = new TestView(this.getElement());
        this.break1.preferred = this.preferred / 2;
        this.break2 = new TestView(this.getElement());
        this.break2.preferred = this.preferred / 2;
        if (offset2 < this.preferred / 2) {
            return this.break1;
        }
        return this.break2;
    }
}

