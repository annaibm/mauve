/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext.BeanContextServicesSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.beans.beancontext.BeanContextServicesSupport.MyBeanContextServicesSupport;
import java.beans.beancontext.BeanContextServicesSupport;

public class getChildBeanContextServicesListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(MyBeanContextServicesSupport.getChildBeanContextServicesListenerX(null), null);
        harness.check(MyBeanContextServicesSupport.getChildBeanContextServicesListenerX("XYZ"), null);
        BeanContextServicesSupport bcss = new BeanContextServicesSupport();
        harness.check(MyBeanContextServicesSupport.getChildBeanContextServicesListenerX(bcss), bcss);
    }
}

