/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.event.ComponentEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.event.ComponentEvent;

public class paramString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Button button = new Button();
        ComponentEvent event = new ComponentEvent(button, 100);
        harness.check(!event.paramString().equalsIgnoreCase("COMPONENT_MOVED java.awt.Rectangle[x=0,y=0,width=0,height=0]"));
        harness.check(event.paramString(), (Object)"COMPONENT_MOVED (0,0 0x0)");
        event = new ComponentEvent(button, 1124);
        harness.check(event.paramString(), (Object)"unknown type");
    }
}

