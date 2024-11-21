/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSliderUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class MyBasicSliderUI
extends BasicSliderUI {
    public MyBasicSliderUI(JSlider slider) {
        super(slider);
    }

    public JSlider getSlider() {
        return this.slider;
    }

    @Override
    public Color getFocusColor() {
        return super.getFocusColor();
    }

    @Override
    public Color getHighlightColor() {
        return super.getHighlightColor();
    }

    @Override
    public Color getShadowColor() {
        return super.getShadowColor();
    }

    public int getTrackBuffer() {
        return this.trackBuffer;
    }

    @Override
    public int getTickLength() {
        return super.getTickLength();
    }

    @Override
    public Dimension getThumbSize() {
        return super.getThumbSize();
    }

    public Rectangle getFocusRect() {
        return this.focusRect;
    }

    public Rectangle getContentRect() {
        return this.contentRect;
    }

    public Rectangle getTrackRect() {
        return this.trackRect;
    }

    public Rectangle getThumbRect() {
        return this.thumbRect;
    }

    public Rectangle getTickRect() {
        return this.tickRect;
    }

    @Override
    public void calculateGeometry() {
        super.calculateGeometry();
    }

    @Override
    public int xPositionForValue(int v) {
        return super.xPositionForValue(v);
    }

    @Override
    public int yPositionForValue(int v) {
        return super.yPositionForValue(v);
    }
}

