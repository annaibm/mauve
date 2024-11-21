/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

public class addHierarchyListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Label label = new Label("xyzzy");
        label.setBackground(Color.blue);
        HierarchyListener[] hierarchyListeners = label.getHierarchyListeners();
        harness.check(hierarchyListeners.length, 0);
        label.addHierarchyListener(new HierarchyListener(){

            @Override
            public void hierarchyChanged(HierarchyEvent e) {
            }

            public String toString() {
                return "myHierarchyListener";
            }
        });
        hierarchyListeners = label.getHierarchyListeners();
        harness.check(hierarchyListeners.length, 1);
        harness.check(hierarchyListeners[0].toString(), (Object)"myHierarchyListener");
    }
}

