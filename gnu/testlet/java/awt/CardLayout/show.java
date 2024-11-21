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

public class show
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CardLayout layout2 = new CardLayout();
        Frame containerWithLayout = new Frame();
        Panel panel = new Panel();
        containerWithLayout.setLayout(layout2);
        containerWithLayout.add((Component)panel, "Panel");
        try {
            layout2.show(containerWithLayout, "Panel");
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false);
        }
        try {
            layout2.show(containerWithLayout, null);
            harness.check(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            harness.check(false);
        }
        try {
            layout2.show(containerWithLayout, "XXXXX");
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false);
        }
        try {
            layout2.show(containerWithLayout, "");
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false);
        }
        Frame container = new Frame();
        container.add(panel);
        try {
            layout2.show(container, "Panel");
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        CardLayout layout22 = new CardLayout();
        container.setLayout(layout22);
        try {
            layout2.show(container, "Panel");
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            layout2.show(null, "Panel");
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

