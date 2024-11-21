/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AbstractDocument;

import javax.swing.text.AbstractDocument;
import javax.swing.text.Element;
import javax.swing.text.GapContent;

public class TestAbstractDocument
extends AbstractDocument {
    public TestAbstractDocument() {
        super(new GapContent());
    }

    @Override
    public Element getParagraphElement(int pos) {
        return null;
    }

    @Override
    public Element getDefaultRootElement() {
        return null;
    }
}

