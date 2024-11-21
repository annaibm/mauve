/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Choice;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

public class addHierarchyListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Choice choice = new Choice();
        choice.setBackground(Color.blue);
        HierarchyListener[] hierarchyListeners = choice.getHierarchyListeners();
        harness.check(hierarchyListeners.length, 0);
        choice.addHierarchyListener(new HierarchyListener(){

            @Override
            public void hierarchyChanged(HierarchyEvent e) {
            }

            public String toString() {
                return "myHierarchyListener";
            }
        });
        hierarchyListeners = choice.getHierarchyListeners();
        harness.check(hierarchyListeners.length, 1);
        harness.check(hierarchyListeners[0].toString(), (Object)"myHierarchyListener");
    }
}

