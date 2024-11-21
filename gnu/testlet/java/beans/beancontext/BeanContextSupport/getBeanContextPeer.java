/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext.BeanContextSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.beancontext.BeanContextChildSupport;
import java.beans.beancontext.BeanContextSupport;

public class getBeanContextPeer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BeanContextSupport bcs1 = new BeanContextSupport();
        BeanContextSupport bcs2 = new BeanContextSupport(bcs1);
        harness.check(bcs1.getBeanContextPeer(), bcs1);
        harness.check(bcs2.getBeanContextPeer(), bcs1);
        boolean pass = true;
        bcs2.beanContextChildPeer = new BeanContextChildSupport();
        try {
            bcs2.getBeanContextPeer();
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

