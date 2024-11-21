/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;

public class TestLayout
implements LayoutManager2 {
    float alignmentX = 0.0f;
    float alignmentY = 0.0f;

    @Override
    public void addLayoutComponent(Component component2, Object constraints) {
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return null;
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return this.alignmentX;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return this.alignmentY;
    }

    @Override
    public void invalidateLayout(Container target) {
    }

    @Override
    public void addLayoutComponent(String name2, Component component2) {
    }

    @Override
    public void removeLayoutComponent(Component component2) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
    }
}

