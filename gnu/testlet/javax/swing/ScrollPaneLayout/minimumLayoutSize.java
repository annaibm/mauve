/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ScrollPaneLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

public class minimumLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testHorizontalScrollbarAlways(harness);
        this.testHorizontalScrollbarAsNeeded(harness);
        this.testHorizontalScrollbarNever(harness);
        this.testVerticalScrollbarAlways(harness);
        this.testVerticalScrollbarAsNeeded(harness);
        this.testVerticalScrollbarNever(harness);
    }

    private void testHorizontalScrollbarAlways(TestHarness h) {
        JScrollPane sp = new JScrollPane();
        ScrollPaneLayout l = (ScrollPaneLayout)sp.getLayout();
        sp.setHorizontalScrollBarPolicy(32);
        sp.setVerticalScrollBarPolicy(21);
        JPanel view = new JPanel();
        view.setMinimumSize(new Dimension(100, 100));
        sp.getViewport().add(view);
        Insets i = sp.getInsets();
        Component[] c = sp.getComponents();
        sp.setSize(50, 50);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height + c[2].getMinimumSize().height));
        sp.setSize(150, 150);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height + c[2].getMinimumSize().height));
    }

    private void testHorizontalScrollbarAsNeeded(TestHarness h) {
        JScrollPane sp = new JScrollPane();
        ScrollPaneLayout l = (ScrollPaneLayout)sp.getLayout();
        sp.setHorizontalScrollBarPolicy(30);
        sp.setVerticalScrollBarPolicy(21);
        JPanel view = new JPanel();
        view.setMinimumSize(new Dimension(100, 100));
        sp.getViewport().add(view);
        Insets i = sp.getInsets();
        Component[] c = sp.getComponents();
        sp.setSize(50, 50);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height + c[2].getMinimumSize().height));
        sp.setSize(150, 150);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height + c[2].getMinimumSize().height));
    }

    private void testHorizontalScrollbarNever(TestHarness h) {
        JScrollPane sp = new JScrollPane();
        ScrollPaneLayout l = (ScrollPaneLayout)sp.getLayout();
        sp.setHorizontalScrollBarPolicy(31);
        sp.setVerticalScrollBarPolicy(21);
        JPanel view = new JPanel();
        view.setMinimumSize(new Dimension(100, 100));
        sp.getViewport().add(view);
        Insets i = sp.getInsets();
        Component[] c = sp.getComponents();
        sp.setSize(50, 50);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height));
        sp.setSize(150, 150);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height));
    }

    private void testVerticalScrollbarAlways(TestHarness h) {
        JScrollPane sp = new JScrollPane();
        ScrollPaneLayout l = (ScrollPaneLayout)sp.getLayout();
        sp.setHorizontalScrollBarPolicy(31);
        sp.setVerticalScrollBarPolicy(22);
        JPanel view = new JPanel();
        view.setMinimumSize(new Dimension(100, 100));
        sp.getViewport().add(view);
        Insets i = sp.getInsets();
        Component[] c = sp.getComponents();
        sp.setSize(50, 50);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width + c[1].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height));
        sp.setSize(150, 150);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width + c[1].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height));
    }

    private void testVerticalScrollbarAsNeeded(TestHarness h) {
        JScrollPane sp = new JScrollPane();
        ScrollPaneLayout l = (ScrollPaneLayout)sp.getLayout();
        sp.setHorizontalScrollBarPolicy(31);
        sp.setVerticalScrollBarPolicy(20);
        JPanel view = new JPanel();
        view.setMinimumSize(new Dimension(100, 100));
        sp.getViewport().add(view);
        Insets i = sp.getInsets();
        Component[] c = sp.getComponents();
        sp.setSize(50, 50);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width + c[1].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height));
        sp.setSize(150, 150);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width + c[1].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height));
    }

    private void testVerticalScrollbarNever(TestHarness h) {
        JScrollPane sp = new JScrollPane();
        ScrollPaneLayout l = (ScrollPaneLayout)sp.getLayout();
        sp.setHorizontalScrollBarPolicy(31);
        sp.setVerticalScrollBarPolicy(21);
        JPanel view = new JPanel();
        sp.getViewport().add(view);
        view.setMinimumSize(new Dimension(100, 100));
        Insets i = sp.getInsets();
        Component[] c = sp.getComponents();
        sp.setSize(50, 50);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height));
        sp.setSize(150, 150);
        h.check(l.minimumLayoutSize(sp), new Dimension(i.left + i.right + c[0].getMinimumSize().width, i.top + i.bottom + c[0].getMinimumSize().height));
    }
}

