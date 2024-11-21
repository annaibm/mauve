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

public class Remove
implements Testlet {
    private static TestBeanContextSupport context = new TestBeanContextSupport();
    private static BeanContextChild child = new BeanContextChildSupport();
    private static BeanContextChild brokenChild = new BeanContextChildSupport(){

        @Override
        public void setBeanContext(BeanContext c) throws PropertyVetoException {
            if (c == null) {
                throw new PropertyVetoException("I don't like you.", null);
            }
        }
    };

    @Override
    public void test(TestHarness h) {
        h.check(context.add(child), "Child addition check");
        h.check(!context.isEmpty(), "Non-empty check");
        h.check(context.size() == 1, "Size of 1 check");
        h.check(child.getBeanContext() == context, "Correct context check");
        try {
            context.remove(null);
            h.fail("Failed to catch null child");
        }
        catch (Exception e) {
            h.check(e instanceof IllegalArgumentException, "Caught null child");
        }
        h.check(!context.remove(brokenChild), "Remove non-existant child check");
        h.check(context.add(brokenChild), "Add broken child check");
        try {
            context.remove(brokenChild);
            h.fail("Failed to catch veto by child");
        }
        catch (Exception e) {
            h.check(e instanceof IllegalStateException, "Caught veto from child");
            h.check(context.size() == 2, "Same size after veto check");
        }
        context.removeTest(h);
        h.check(context.size() == 1, "Size of 1 check");
        h.check(context.remove(child), "Remove child check");
        h.check(context.add(child), "Child re-addition check");
        try {
            child.setBeanContext(null);
        }
        catch (PropertyVetoException e) {
            h.debug(e);
        }
        h.check(context.size() == 0, "Empty context check");
    }

    private static class TestBeanContextSupport
    extends BeanContextSupport {
        private TestBeanContextSupport() {
        }

        public void removeTest(TestHarness h) {
            try {
                h.check(this.remove(brokenChild, false), "Correctly avoided notification of child");
            }
            catch (Exception e) {
                if (e instanceof IllegalStateException) {
                    h.fail("Wrongly threw veto when not asked to notify child");
                }
                h.debug(e);
            }
        }
    }
}

