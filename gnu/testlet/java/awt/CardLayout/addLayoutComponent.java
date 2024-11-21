/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.CardLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Component;

public class addLayoutComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testButton(harness);
        this.testCanvas(harness);
    }

    private void testButton(TestHarness harness) {
        harness.checkPoint("removeLayoutComponent(Button)");
        CardLayout layout2 = new CardLayout();
        Button component2 = new Button();
        this.checkAllPossibleConstraints(harness, layout2, component2);
    }

    private void testCanvas(TestHarness harness) {
        harness.checkPoint("removeLayoutComponent(Canvas)");
        CardLayout layout2 = new CardLayout();
        Canvas component2 = new Canvas();
        this.checkAllPossibleConstraints(harness, layout2, component2);
    }

    private void checkAllPossibleConstraints(TestHarness harness, CardLayout layout2, Component component2) {
        this.checkAddRemove(harness, layout2, component2, "");
        this.checkAddRemove(harness, layout2, component2, " ");
        this.checkAddRemove(harness, layout2, component2, "xyzzy");
        this.checkAddRemove(harness, layout2, component2, null);
    }

    private void checkAddRemove(TestHarness harness, CardLayout layout2, Component component2, String name2) {
        try {
            layout2.addLayoutComponent(component2, name2);
        }
        catch (IllegalArgumentException e) {
            harness.fail(e.getMessage());
        }
        layout2.removeLayoutComponent(component2);
    }
}

