/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Component;

public class removeLayoutComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testButton(harness);
        this.testCanvas(harness);
    }

    private void testButton(TestHarness harness) {
        harness.checkPoint("removeLayoutComponent(Button)");
        BorderLayout layout2 = new BorderLayout();
        Button component2 = new Button();
        this.checkAllPossibleConstraints(harness, layout2, component2);
    }

    private void testCanvas(TestHarness harness) {
        harness.checkPoint("removeLayoutComponent(Canvas)");
        BorderLayout layout2 = new BorderLayout();
        Canvas component2 = new Canvas();
        this.checkAllPossibleConstraints(harness, layout2, component2);
    }

    private void checkAllPossibleConstraints(TestHarness harness, BorderLayout layout2, Component component2) {
        this.checkAddRemove(harness, layout2, component2, "North");
        this.checkAddRemove(harness, layout2, component2, "West");
        this.checkAddRemove(harness, layout2, component2, "South");
        this.checkAddRemove(harness, layout2, component2, "East");
        this.checkAddRemove(harness, layout2, component2, "Last");
        this.checkAddRemove(harness, layout2, component2, "First");
        this.checkAddRemove(harness, layout2, component2, "After");
        this.checkAddRemove(harness, layout2, component2, "Before");
        this.checkAddRemove(harness, layout2, component2, "Last");
        this.checkAddRemove(harness, layout2, component2, "After");
        this.checkAddRemove(harness, layout2, component2, "First");
        this.checkAddRemove(harness, layout2, component2, "Before");
    }

    private void checkAddRemove(TestHarness harness, BorderLayout layout2, Component component2, String constraints) {
        try {
            layout2.addLayoutComponent(component2, constraints);
        }
        catch (IllegalArgumentException e) {
            harness.fail(e.getMessage());
        }
        layout2.removeLayoutComponent(component2);
    }
}

