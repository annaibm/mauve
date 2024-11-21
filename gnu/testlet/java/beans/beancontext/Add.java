/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyVetoException;
import java.beans.beancontext.BeanContext;
import java.beans.beancontext.BeanContextChild;
import java.beans.beancontext.BeanContextChildSupport;
import java.beans.beancontext.BeanContextSupport;

public class Add
implements Testlet {
    private static BeanContextSupport context = new BeanContextSupport();
    private static BeanContextChild child = new BeanContextChildSupport();
    private static BeanContextChild brokenChild = new BeanContextChildSupport(){

        @Override
        public void setBeanContext(BeanContext c) throws PropertyVetoException {
            throw new PropertyVetoException("I don't like you.", null);
        }
    };

    @Override
    public void test(TestHarness h) {
        h.check(child.getBeanContext() == null, "Contextless check");
        h.check(context.isEmpty(), "Empty check");
        h.check(context.size() == 0, "Size of 0 check");
        h.check(context.add(child), "Child addition check");
        h.check(!context.isEmpty(), "Non-empty check");
        h.check(context.size() == 1, "Size of 1 check");
        h.check(child.getBeanContext() == context, "Correct context check");
        h.check(!context.add(child), "Set check");
        h.check(context.size() == 1, "Same size after failed addition check");
        try {
            context.add((Object)null);
            h.fail("Failed to catch null child");
        }
        catch (Exception e) {
            h.check(e instanceof IllegalArgumentException, "Caught null child");
        }
        try {
            context.add(brokenChild);
            h.fail("Failed to catch veto by child");
        }
        catch (Exception e) {
            h.check(e instanceof IllegalStateException, "Caught veto from child");
            h.check(context.size() == 1, "Same size after veto check");
        }
    }
}

