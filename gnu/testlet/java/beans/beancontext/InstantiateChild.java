/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.beancontext.BeanContextSupport;

public class InstantiateChild
implements Testlet {
    private static BeanContextSupport context = new BeanContextSupport();

    @Override
    public void test(TestHarness h) {
        try {
            h.check(context.isEmpty(), "Empty check");
            h.check(context.size() == 0, "Size of 0 check");
            context.instantiateChild("java.beans.beancontext.BeanContextChildSupport");
            h.check(!context.isEmpty(), "Non-empty check");
            h.check(context.size() == 1, "Size of 1 check");
        }
        catch (Exception e) {
            h.debug(e);
        }
    }
}

