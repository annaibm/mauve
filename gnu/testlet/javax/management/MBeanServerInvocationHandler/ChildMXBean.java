/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.MBeanServerInvocationHandler;

import gnu.testlet.javax.management.MBeanServerInvocationHandler.TestCMXBean;

public interface ChildMXBean {
    public TestCMXBean getParent();

    public void setParent(TestCMXBean var1);
}

