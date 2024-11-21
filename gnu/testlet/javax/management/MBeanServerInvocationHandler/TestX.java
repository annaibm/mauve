/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.MBeanServerInvocationHandler;

import gnu.testlet.javax.management.MBeanServerInvocationHandler.Test;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.TestXMBean;

public class TestX
extends Test
implements TestXMBean {
    private String lastMethodCalled;

    public TestX(String name2) {
        super(name2);
    }

    @Override
    public boolean equals(Object obj) {
        this.lastMethodCalled = "equals";
        return false;
    }

    @Override
    public int hashCode() {
        this.lastMethodCalled = "hashCode";
        return 42;
    }

    @Override
    public String getLastMethodCalled() {
        return this.lastMethodCalled;
    }

    @Override
    public String toString() {
        this.lastMethodCalled = "toString";
        return this.getClass().getName() + "[name=" + this.getName() + ",isEdible=" + this.isEdible() + ",lastMethodCalled=" + this.lastMethodCalled + "]";
    }
}

