/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Button;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

public class addHierarchyListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Button button = new Button("xyzzy");
        button.setBackground(Color.blue);
        HierarchyListener[] hierarchyListeners = button.getHierarchyListeners();
        harness.check(hierarchyListeners.length, 0);
        button.addHierarchyListener(new HierarchyListener(){

            @Override
            public void hierarchyChanged(HierarchyEvent e) {
            }

            public String toString() {
                return "myHierarchyListener";
            }
        });
        hierarchyListeners = button.getHierarchyListeners();
        harness.check(hierarchyListeners.length, 1);
        harness.check(hierarchyListeners[0].toString(), (Object)"myHierarchyListener");
    }
}

