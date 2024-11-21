/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.EventSetDescriptor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;

public class constructorTest1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean ok = true;
        try {
            new EventSetDescriptor(Button.class, "action", ActionListener.class, "actionPerformed");
        }
        catch (IntrospectionException e) {
            harness.debug(e);
            ok = false;
        }
        harness.check(ok);
    }
}

