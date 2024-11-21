/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.View;

import java.awt.Graphics;
import java.awt.Shape;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.Position;
import javax.swing.text.View;

public class TestView
extends View {
    public float[] preferred = new float[]{100.0f, 100.0f};

    public TestView() {
        super(TestView.createDummyElement());
    }

    static Element createDummyElement() {
        PlainDocument doc = new PlainDocument();
        return doc.getDefaultRootElement();
    }

    @Override
    public void paint(Graphics g, Shape s) {
    }

    @Override
    public float getPreferredSpan(int axis) {
        return this.preferred[axis];
    }

    @Override
    public Shape modelToView(int pos, Shape a, Position.Bias b) throws BadLocationException {
        return null;
    }

    @Override
    public int viewToModel(float x, float y, Shape a, Position.Bias[] b) {
        return 0;
    }
}

