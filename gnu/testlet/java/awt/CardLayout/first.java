/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.CardLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Panel;

public class first
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CardLayout layout2 = new CardLayout();
        Frame containerWithLayout = new Frame();
        Panel panel = new Panel();
        containerWithLayout.setLayout(layout2);
        try {
            layout2.first(containerWithLayout);
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false);
        }
        containerWithLayout.add((Component)panel, "Panel");
        try {
            layout2.first(containerWithLayout);
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false);
        }
        try {
            layout2.first(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        Frame container = new Frame();
        container.add(panel);
        try {
            layout2.first(container);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

