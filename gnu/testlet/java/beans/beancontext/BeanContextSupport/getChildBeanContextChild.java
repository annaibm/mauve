/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext.BeanContextSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.beans.beancontext.BeanContextSupport.MyBeanContextSupport;
import java.beans.beancontext.BeanContextChild;
import java.beans.beancontext.BeanContextProxy;
import java.beans.beancontext.BeanContextSupport;

public class getChildBeanContextChild
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBeanContextSupport bcs1 = new MyBeanContextSupport();
        harness.check(MyBeanContextSupport.getChildBeanContextChildX(bcs1), bcs1);
        MyBeanContextSupport bcs2 = new MyBeanContextSupport();
        MyBeanContextProxy proxy = new MyBeanContextProxy(bcs2);
        harness.check(MyBeanContextSupport.getChildBeanContextChildX(proxy), bcs2);
        BadProxy bp = new BadProxy((BeanContextChild)bcs2);
        boolean pass = false;
        try {
            MyBeanContextSupport.getChildBeanContextChildX(bp);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        harness.check(MyBeanContextSupport.getChildBeanContextChildX(null), null);
    }

    static class BadProxy
    extends BeanContextSupport
    implements BeanContextProxy {
        BeanContextChild bcs;

        public BadProxy(BeanContextChild bcs) {
            this.bcs = bcs;
        }

        @Override
        public BeanContextChild getBeanContextProxy() {
            return this.bcs;
        }
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

