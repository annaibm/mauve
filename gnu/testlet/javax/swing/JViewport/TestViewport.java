/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JViewport;

import javax.swing.JViewport;

class TestViewport
extends JViewport {
    boolean repaintCalled;
    boolean revalidateCalled;

    TestViewport() {
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

