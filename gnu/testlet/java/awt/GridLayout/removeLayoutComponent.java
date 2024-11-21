/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GridLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.GridLayout;

public class removeLayoutComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testButton(harness);
        this.testCanvas(harness);
    }

    private void testButton(TestHarness harness) {
        harness.checkPoint("removeLayoutComponent(Button)");
        GridLayout layout2 = new GridLayout();
        Button component2 = new Button();
        this.checkAllPossibleConstraints(harness, layout2, component2);
    }

    private void testCanvas(TestHarness harness) {
        harness.checkPoint("removeLayoutComponent(Canvas)");
        GridLayout layout2 = new GridLayout();
        Canvas component2 = new Canvas();
        this.checkAllPossibleConstraints(harness, layout2, component2);
    }

    private void checkAllPossibleConstraints(TestHarness harness, GridLayout layout2, Component component2) {
        this.checkAddRemove(harness, layout2, component2, "");
        this.checkAddRemove(harness, layout2, component2, " ");
        this.checkAddRemove(harness, layout2, component2, "xyzzy");
        this.checkAddRemove(harness, layout2, component2, null);
    }

    private void checkAddRemove(TestHarness harness, GridLayout layout2, Component component2, String name2) {
        try {
            layout2.addLayoutComponent(name2, component2);
        }
        catch (IllegalArgumentException e) {
            harness.fail(e.getMessage());
        }
        layout2.removeLayoutComponent(component2);
    }
}

