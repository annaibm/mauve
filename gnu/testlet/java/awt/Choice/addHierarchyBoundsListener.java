/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Choice;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;

public class addHierarchyBoundsListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Choice choice = new Choice();
        choice.setBackground(Color.blue);
        HierarchyBoundsListener[] hierarchyBoundsListeners = choice.getHierarchyBoundsListeners();
        harness.check(hierarchyBoundsListeners.length, 0);
        choice.addHierarchyBoundsListener(new HierarchyBoundsListener(){

            @Override
            public void ancestorMoved(HierarchyEvent e) {
            }

            @Override
            public void ancestorResized(HierarchyEvent e) {
            }

            public String toString() {
                return "myHierarchyBoundsListener";
            }
        });
        hierarchyBoundsListeners = choice.getHierarchyBoundsListeners();
        harness.check(hierarchyBoundsListeners.length, 1);
        harness.check(hierarchyBoundsListeners[0].toString(), (Object)"myHierarchyBoundsListener");
    }
}

