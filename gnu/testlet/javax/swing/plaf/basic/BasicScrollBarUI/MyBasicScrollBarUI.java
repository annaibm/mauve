/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MyBasicScrollBarUI
extends BasicScrollBarUI {
    @Override
    public Dimension getMinimumThumbSize() {
        return super.getMinimumThumbSize();
    }

    @Override
    public Dimension getMaximumThumbSize() {
        return super.getMaximumThumbSize();
    }

    @Override
    public Rectangle getTrackBounds() {
        return super.getTrackBounds();
    }

    @Override
    public Rectangle getThumbBounds() {
        return super.getThumbBounds();
    }

    @Override
    public JButton createIncreaseButton(int o) {
        return super.createIncreaseButton(o);
    }

    @Override
    public JButton createDecreaseButton(int o) {
        return super.createDecreaseButton(o);
    }

    @Override
    public void installDefaults() {
        super.installDefaults();
    }

    @Override
    public void installComponents() {
        super.installComponents();
    }

    public JButton getIncrButton() {
        return this.incrButton;
    }

    public void setIncrButton(JButton b) {
        this.incrButton = b;
    }

    public JButton getDecrButton() {
        return this.decrButton;
    }

    public void setDecrButton(JButton b) {
        this.decrButton = b;
    }

    public void setScrollbar(JScrollBar sb) {
        this.scrollbar = sb;
    }
}

