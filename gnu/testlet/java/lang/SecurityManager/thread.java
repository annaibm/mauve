/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.SecurityManager;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.security.Permission;

public class thread
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("checkAccess");
        Thread thread2 = Thread.currentThread();
        ThreadGroup group = thread2.getThreadGroup();
        harness.check(group != null);
        while (group.getParent() != null) {
            group = group.getParent();
        }
        if (thread2.getThreadGroup() != group) {
            thread2 = new Thread(group, "dummy");
        }
        TestSecurityManager sm = new TestSecurityManager(harness);
        try {
            sm.install();
            sm.prepareChecks(new Permission[]{new RuntimePermission("modifyThread")});
            sm.checkAccess(thread2);
            sm.checkAllChecked();
            sm.prepareChecks(new Permission[]{new RuntimePermission("modifyThreadGroup")});
            sm.checkAccess(group);
            sm.checkAllChecked();
        }
        finally {
            sm.uninstall();
        }
    }
}

