/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JScrollBar;
import javax.swing.plaf.metal.MetalScrollBarUI;

public class MyMetalScrollBarUI
extends MetalScrollBarUI {
    @Override
    public void installDefaults() {
        super.installDefaults();
    }

    public void setScrollbar(JScrollBar sb) {
        this.scrollbar = sb;
    }

    public int getScrollBarWidthField() {
        return this.scrollBarWidth;
    }

    @Override
    public Dimension getMinimumThumbSize() {
        return super.getMinimumThumbSize();
    }

    @Override
    public Rectangle getTrackBounds() {
        return super.getTrackBounds();
    }

    @Override
    public Rectangle getThumbBounds() {
        return super.getThumbBounds();
    }
}

