/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Checkbox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

public class addHierarchyListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Checkbox checkbox = new Checkbox("xyzzy");
        checkbox.setBackground(Color.blue);
        HierarchyListener[] hierarchyListeners = checkbox.getHierarchyListeners();
        harness.check(hierarchyListeners.length, 0);
        checkbox.addHierarchyListener(new HierarchyListener(){

            @Override
            public void hierarchyChanged(HierarchyEvent e) {
            }

            public String toString() {
                return "myHierarchyListener";
            }
        });
        hierarchyListeners = checkbox.getHierarchyListeners();
        harness.check(hierarchyListeners.length, 1);
        harness.check(hierarchyListeners[0].toString(), (Object)"myHierarchyListener");
    }
}

