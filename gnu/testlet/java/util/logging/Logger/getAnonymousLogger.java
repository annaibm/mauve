/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Logger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Logger.TestFilter;
import gnu.testlet.java.util.logging.Logger.TestResourceBundle;
import gnu.testlet.java.util.logging.Logger.TestSecurityManager;
import java.util.MissingResourceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class getAnonymousLogger
implements Testlet {
    TestSecurityManager sec = new TestSecurityManager();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness th) {
        TestFilter filter2 = new TestFilter();
        SimpleFormatter formatter = new SimpleFormatter();
        try {
            this.sec.install();
            this.sec.setGrantLoggingControl(true);
            Logger al = Logger.getAnonymousLogger();
            th.check(al != null);
            th.check(al != Logger.getAnonymousLogger());
            al = Logger.getAnonymousLogger();
            th.check(al.getName(), null);
            th.check(al.getResourceBundle(), null);
            th.check(al.getResourceBundleName(), null);
            th.check(al.getParent(), Logger.getLogger(""));
            al.setFilter(filter2);
            al.setUseParentHandlers(false);
            al.setLevel(Level.FINEST);
            al.entering("Class", "method", "txt");
            th.check(formatter.formatMessage(filter2.getLastRecord()), (Object)"ENTRY txt");
            al = Logger.getAnonymousLogger(TestResourceBundle.class.getName());
            th.check(al.getResourceBundle() instanceof TestResourceBundle);
            al.setFilter(filter2);
            al.setUseParentHandlers(false);
            al.setLevel(Level.FINEST);
            al.entering("Class", "method", "txt");
            th.check(formatter.formatMessage(filter2.getLastRecord()), (Object)"BETRETEN txt");
            try {
                Logger.getAnonymousLogger("garbageClassName");
                th.check(false);
            }
            catch (MissingResourceException ex) {
                th.check(true);
            }
            catch (Exception ex) {
                th.check(false);
                th.debug(ex);
            }
        }
        finally {
            this.sec.uninstall();
        }
    }
}

