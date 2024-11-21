/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.MethodDescriptor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.beans.MethodDescriptor;

public class constructorTest1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean ok = true;
        try {
            new MethodDescriptor(Component.class.getMethod("getLocation", new Class[0]));
        }
        catch (NoSuchMethodException e) {
            harness.debug(e);
            ok = false;
        }
        harness.check(ok);
    }
}

