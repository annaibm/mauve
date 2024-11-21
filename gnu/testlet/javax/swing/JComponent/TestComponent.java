/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

class TestComponent
extends JComponent {
    boolean repaintCalled;
    boolean revalidateCalled;

    TestComponent() {
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
    public void setUI(ComponentUI ui) {
        super.setUI(ui);
    }
}

