/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext.BeanContextSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.beans.beancontext.BeanContextSupport.MyBeanContextSupport;
import java.beans.beancontext.BeanContextChild;
import java.beans.beancontext.BeanContextMembershipEvent;
import java.beans.beancontext.BeanContextMembershipListener;
import java.beans.beancontext.BeanContextProxy;

public class getChildBeanContextMembershipListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBeanContextSupport bcs1 = new MyBeanContextSupport();
        harness.check(MyBeanContextSupport.getChildBeanContextMembershipListenerX(bcs1), null);
        MyBeanContextSupport bcs2 = new MyBeanContextSupport();
        MyBeanContextProxy proxy = new MyBeanContextProxy(bcs2);
        harness.check(MyBeanContextSupport.getChildBeanContextMembershipListenerX(proxy), proxy);
        harness.check(MyBeanContextSupport.getChildBeanContextMembershipListenerX(null), null);
    }

    static class MyBeanContextProxy
    implements BeanContextProxy,
    BeanContextMembershipListener {
        BeanContextChild bcs;

        @Override
        public void childrenAdded(BeanContextMembershipEvent bcme) {
        }

        @Override
        public void childrenRemoved(BeanContextMembershipEvent bcme) {
        }

        public MyBeanContextProxy(BeanContextChild bcs) {
            this.bcs = bcs;
        }

        @Override
        public BeanContextChild getBeanContextProxy() {
            return this.bcs;
        }
    }
}

