/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

public class addHierarchyListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        HierarchyListener[] hierarchyListeners = canvas.getHierarchyListeners();
        harness.check(hierarchyListeners.length, 0);
        canvas.addHierarchyListener(new HierarchyListener(){

            @Override
            public void hierarchyChanged(HierarchyEvent e) {
            }

            public String toString() {
                return "myHierarchyListener";
            }
        });
        hierarchyListeners = canvas.getHierarchyListeners();
        harness.check(hierarchyListeners.length, 1);
        harness.check(hierarchyListeners[0].toString(), (Object)"myHierarchyListener");
    }
}

