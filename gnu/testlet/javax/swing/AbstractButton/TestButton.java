/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractButton;

import javax.swing.JButton;
import javax.swing.event.ChangeListener;

class TestButton
extends JButton {
    boolean repaintCalled;
    boolean revalidateCalled;

    TestButton() {
    }

    @Override
    public void repaint() {
        this.repaintCalled = true;
        super.repaint();
    }

    @Override
    public void revalidate() {
        this.revalidateCalled = true;
        super.revalidate();
    }

    @Override
    public ChangeListener createChangeListener() {
        return super.createChangeListener();
    }
}

