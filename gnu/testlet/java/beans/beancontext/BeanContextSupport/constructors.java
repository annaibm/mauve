/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext.BeanContextSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.beancontext.BeanContextSupport;
import java.util.Locale;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        BeanContextSupport bcs = new BeanContextSupport();
        harness.check(bcs.getBeanContext(), null);
        harness.check(bcs.getBeanContextPeer(), bcs);
        harness.check(bcs.beanContextChildPeer, bcs);
        harness.check(!bcs.needsGui());
        harness.check(!bcs.isDesignTime());
        harness.check(!bcs.avoidingGui());
        harness.check(bcs.getLocale(), Locale.getDefault());
        harness.check(bcs.size(), 0);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(BeanContext)");
        BeanContextSupport bc = new BeanContextSupport();
        BeanContextSupport bcs = new BeanContextSupport(bc);
        harness.check(bcs.getBeanContext(), null);
        harness.check(bcs.getBeanContextPeer(), bc);
        harness.check(bcs.beanContextChildPeer, bc);
        harness.check(!bcs.needsGui());
        harness.check(!bcs.isDesignTime());
        harness.check(!bcs.avoidingGui());
        harness.check(bcs.getLocale(), Locale.getDefault());
        harness.check(bcs.size(), 0);
        bcs = new BeanContextSupport(null);
        harness.check(bcs.getBeanContext(), null);
        harness.check(bcs.getBeanContextPeer(), bcs);
        harness.check(bcs.beanContextChildPeer, bcs);
        harness.check(!bcs.needsGui());
        harness.check(!bcs.isDesignTime());
        harness.check(!bcs.avoidingGui());
        harness.check(bcs.getLocale(), Locale.getDefault());
        harness.check(bcs.size(), 0);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(BeanContext, Locale)");
        BeanContextSupport bc = new BeanContextSupport();
        BeanContextSupport bcs = new BeanContextSupport(bc, Locale.FRANCE);
        harness.check(bcs.getBeanContext(), null);
        harness.check(bcs.getBeanContextPeer(), bc);
        harness.check(bcs.beanContextChildPeer, bc);
        harness.check(!bcs.needsGui());
        harness.check(!bcs.isDesignTime());
        harness.check(!bcs.avoidingGui());
        harness.check(bcs.getLocale(), Locale.FRANCE);
        harness.check(bcs.size(), 0);
        bcs = new BeanContextSupport(null, null);
        harness.check(bcs.getBeanContext(), null);
        harness.check(bcs.getBeanContextPeer(), bcs);
        harness.check(!bcs.needsGui());
        harness.check(!bcs.isDesignTime());
        harness.check(!bcs.avoidingGui());
        harness.check(bcs.getLocale(), Locale.getDefault());
        harness.check(bcs.size(), 0);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(BeanContext, Locale, boolean)");
        BeanContextSupport bc = new BeanContextSupport();
        BeanContextSupport bcs = new BeanContextSupport(bc, Locale.FRANCE, true);
        harness.check(bcs.getBeanContext(), null);
        harness.check(bcs.getBeanContextPeer(), bc);
        harness.check(bcs.beanContextChildPeer, bc);
        harness.check(!bcs.needsGui());
        harness.check(bcs.isDesignTime());
        harness.check(!bcs.avoidingGui());
        harness.check(bcs.getLocale(), Locale.FRANCE);
        bcs = new BeanContextSupport(null, null, true);
        harness.check(bcs.getBeanContext(), null);
        harness.check(bcs.getBeanContextPeer(), bcs);
        harness.check(bcs.beanContextChildPeer, bcs);
        harness.check(!bcs.needsGui());
        harness.check(bcs.isDesignTime());
        harness.check(!bcs.avoidingGui());
        harness.check(bcs.getLocale(), Locale.getDefault());
        harness.check(bcs.size(), 0);
    }

    public void testConstructor5(TestHarness harness) {
        harness.checkPoint("()");
        harness.checkPoint("(BeanContext, Locale, boolean, boolean)");
        BeanContextSupport bc = new BeanContextSupport();
        BeanContextSupport bcs = new BeanContextSupport(bc, Locale.FRANCE, true, true);
        harness.check(bcs.getBeanContext(), null);
        harness.check(bcs.getBeanContextPeer(), bc);
        harness.check(bcs.beanContextChildPeer, bc);
        harness.check(!bcs.needsGui());
        harness.check(bcs.isDesignTime());
        harness.check(!bcs.avoidingGui());
        harness.check(bcs.getLocale(), Locale.FRANCE);
        bcs = new BeanContextSupport(null, null, true, true);
        harness.check(bcs.getBeanContext(), null);
        harness.check(bcs.getBeanContextPeer(), bcs);
        harness.check(bcs.beanContextChildPeer, bcs);
        harness.check(!bcs.needsGui());
        harness.check(bcs.isDesignTime());
        harness.check(!bcs.avoidingGui());
        harness.check(bcs.getLocale(), Locale.getDefault());
        harness.check(bcs.size(), 0);
    }
}

