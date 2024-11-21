/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import javax.swing.JLabel;

class TestLabel
extends JLabel {
    boolean repaintCalled;
    boolean revalidateCalled;

    TestLabel() {
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
}

