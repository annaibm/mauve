/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.MBeanServerInvocationHandler;

import gnu.testlet.javax.management.MBeanServerInvocationHandler.TestMBean;

public interface TestXMBean
extends TestMBean {
    public boolean equals(Object var1);

    public int hashCode();

    public String getLastMethodCalled();

    public String toString();
}

