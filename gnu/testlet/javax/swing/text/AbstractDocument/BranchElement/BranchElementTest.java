/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AbstractDocument.BranchElement;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Element;
import javax.swing.text.GapContent;

public class BranchElementTest
extends AbstractDocument
implements Testlet {
    public BranchElementTest() {
        super(new GapContent());
    }

    @Override
    public Element getDefaultRootElement() {
        return null;
    }

    @Override
    public Element getParagraphElement(int pos) {
        return null;
    }

    @Override
    public void test(TestHarness h) {
        AbstractDocument.BranchElement root = new AbstractDocument.BranchElement(this, null, null);
        Element[] array1 = new Element[1];
        Element[] array2 = new Element[2];
        h.check(root.getElementCount(), 0, "number of children");
        AbstractDocument.BranchElement leaf1 = new AbstractDocument.BranchElement(this, root, null);
        array1[0] = leaf1;
        root.replace(0, 0, array1);
        h.check(root.getElementCount(), 1, "number of children");
        AbstractDocument.BranchElement leaf2 = new AbstractDocument.BranchElement(this, root, null);
        array2[0] = leaf1;
        array2[1] = leaf2;
        root.replace(0, 1, array2);
        h.check(root.getElementCount(), 2, "number of children");
        AbstractDocument.BranchElement leaf3 = new AbstractDocument.BranchElement(this, leaf1, null);
        array1[0] = leaf3;
        leaf1.replace(0, 0, array1);
        h.check(root.getElementCount(), 2, "number of children");
    }
}

