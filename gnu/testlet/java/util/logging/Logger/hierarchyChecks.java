/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Logger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Logger.TestFilter;
import gnu.testlet.java.util.logging.Logger.TestResourceBundle;
import gnu.testlet.java.util.logging.Logger.TestSecurityManager;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class hierarchyChecks
implements Testlet {
    private final TestSecurityManager sec = new TestSecurityManager();
    private static final String PARENT_NAME = "gnu.testlet.java.util.logging.Logger.hierarchyChecks";
    private static final String CHILD_NAME = "gnu.testlet.java.util.logging.Logger.hierarchyChecks.child";

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        try {
            this.sec.install();
            TestFilter parentFilter = new TestFilter();
            TestFilter childFilter = new TestFilter();
            SimpleFormatter formatter = new SimpleFormatter();
            this.sec.setGrantLoggingControl(true);
            Logger parent = Logger.getLogger(PARENT_NAME, TestResourceBundle.class.getName());
            parent.setLevel(Level.ALL);
            parent.setFilter(parentFilter);
            parent.setUseParentHandlers(false);
            Logger child = Logger.getLogger(CHILD_NAME);
            child.setFilter(childFilter);
            child.setLevel(Level.ALL);
            this.sec.setGrantLoggingControl(false);
            h.check(parent.getResourceBundle() instanceof TestResourceBundle);
            h.check(child.getResourceBundle() == null);
            h.check(parent.getResourceBundleName(), (Object)TestResourceBundle.class.getName());
            h.check(child.getResourceBundleName(), null);
            h.check(child.getParent() == parent);
            h.check(!parent.getUseParentHandlers());
            h.check(child.getUseParentHandlers());
            child.warning("Boo!");
            h.check(childFilter.getLastRecord().getResourceBundle() == parent.getResourceBundle());
            h.check(parentFilter.getLastRecord() == null);
            child.entering("fakedClass", "fakedMethod", "SingleParam");
            LogRecord rec = childFilter.getLastRecord();
            h.check(rec.getMessage(), (Object)"ENTRY {0}");
            h.check(formatter.formatMessage(rec), (Object)"BETRETEN SingleParam");
        }
        finally {
            this.sec.uninstall();
        }
    }
}

