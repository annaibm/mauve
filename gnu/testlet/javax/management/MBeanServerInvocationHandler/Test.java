/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.MBeanServerInvocationHandler;

import gnu.testlet.javax.management.MBeanServerInvocationHandler.TestMBean;

public class Test
implements TestMBean {
    private String name;

    public Test(String name2) {
        this.setName(name2);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name2) {
        this.name = name2;
    }

    @Override
    public boolean isEdible() {
        return false;
    }
}

