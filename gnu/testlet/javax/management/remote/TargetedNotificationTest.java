/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.remote;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.Notification;
import javax.management.remote.TargetedNotification;

public class TargetedNotificationTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TargetedNotification tn;
        Notification n = new Notification("", this, 1L);
        h.checkPoint("Constructor tests");
        try {
            tn = new TargetedNotification(null, 3);
            h.fail("Failed to catch null notification");
        }
        catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                h.check(true, "Caught null notification.");
            }
            h.debug(e);
            h.fail("Unknown exception");
        }
        try {
            tn = new TargetedNotification(n, null);
            h.fail("Failed to catch null identifier");
        }
        catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                h.check(true, "Caught null identifier.");
            }
            h.debug(e);
            h.fail("Unknown exception");
        }
        try {
            tn = new TargetedNotification(n, 3);
            h.check(true, "Successfully created notification");
            h.check(n == tn.getNotification(), "Check notification retrieval");
            h.check(3 == tn.getListenerID(), "Check ID retrieval");
        }
        catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                h.debug(e);
                h.check(false, "Wrongly threw IllegalArgumentException.");
            }
            h.debug(e);
            h.fail("Unknown exception");
        }
    }
}

