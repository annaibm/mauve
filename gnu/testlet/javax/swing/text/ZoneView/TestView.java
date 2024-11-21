/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import javax.swing.text.BoxView;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;

public class TestView
extends BoxView {
    private static final Element DEFAULT_ELEMENT;
    boolean removeAllCalled;

    TestView() {
        this(0);
    }

    TestView(int axis) {
        this(DEFAULT_ELEMENT, axis);
    }

    TestView(Element el, int axis) {
        super(el, axis);
    }

    @Override
    public void removeAll() {
        super.removeAll();
        this.removeAllCalled = true;
    }

    static {
        Element el;
        PlainDocument doc = new PlainDocument();
        DEFAULT_ELEMENT = el = doc.getDefaultRootElement();
    }
}

