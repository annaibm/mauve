/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ScrollPaneAdjustable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.ScrollPane;
import java.awt.ScrollPaneAdjustable;

public class paramString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ScrollPane sp = new ScrollPane();
        ScrollPaneAdjustable vspa = (ScrollPaneAdjustable)sp.getVAdjustable();
        ScrollPaneAdjustable hspa = (ScrollPaneAdjustable)sp.getHAdjustable();
        harness.check(vspa.paramString(), (Object)"vertical,[0..0],val=0,vis=0,unit=1,block=1,isAdjusting=false");
        harness.check(hspa.paramString(), (Object)"horizontal,[0..0],val=0,vis=0,unit=1,block=1,isAdjusting=false");
    }
}

