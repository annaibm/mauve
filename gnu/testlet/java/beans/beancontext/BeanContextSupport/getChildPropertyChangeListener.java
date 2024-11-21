/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext.BeanContextSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.beans.beancontext.BeanContextSupport.MyBeanContextSupport;
import java.beans.beancontext.BeanContextChild;
import java.beans.beancontext.BeanContextProxy;

public class getChildPropertyChangeListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBeanContextSupport bcs1 = new MyBeanContextSupport();
        harness.check(MyBeanContextSupport.getChildPropertyChangeListenerX(bcs1), bcs1);
        MyBeanContextSupport bcs2 = new MyBeanContextSupport();
        MyBeanContextProxy proxy = new MyBeanContextProxy(bcs2);
        harness.check(MyBeanContextSupport.getChildPropertyChangeListenerX(proxy), null);
        harness.check(MyBeanContextSupport.getChildPropertyChangeListenerX(null), null);
    }

    static class MyBeanContextProxy
    implements BeanContextProxy {
        BeanContextChild bcs;

        public MyBeanContextProxy(BeanContextChild bcs) {
            this.bcs = bcs;
        }

        @Override
        public BeanContextChild getBeanContextProxy() {
            return this.bcs;
        }
    }
}

