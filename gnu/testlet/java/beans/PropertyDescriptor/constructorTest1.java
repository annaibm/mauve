/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.PropertyDescriptor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

public class constructorTest1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean ok = true;
        try {
            new PropertyDescriptor("name", Component.class);
        }
        catch (IntrospectionException e) {
            harness.debug(e);
            ok = false;
        }
        harness.check(ok);
        ok = true;
        try {
            new PropertyDescriptor("visible", Component.class);
        }
        catch (IntrospectionException e) {
            harness.debug(e);
            ok = false;
        }
        harness.check(ok);
        ok = false;
        try {
            new PropertyDescriptor("class", Object.class);
        }
        catch (IntrospectionException e) {
            ok = true;
        }
        harness.check(ok);
    }
}

