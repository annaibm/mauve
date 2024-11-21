/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.remote;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.remote.NotificationResult;
import javax.management.remote.TargetedNotification;

public class NotificationResultTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        NotificationResult nr;
        TargetedNotification[] array = new TargetedNotification[]{};
        h.checkPoint("Constructor tests");
        try {
            nr = new NotificationResult(-1L, 0L, array);
            h.fail("Failed to catch negative earliest sequence number");
        }
        catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                h.check(true, "Caught negative earliest sequence number.");
            }
            h.debug(e);
            h.fail("Unknown exception");
        }
        try {
            nr = new NotificationResult(0L, -1L, array);
            h.fail("Failed to catch negative next sequence number");
        }
        catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                h.check(true, "Caught negative next sequence number.");
            }
            h.debug(e);
            h.fail("Unknown exception");
        }
        try {
            nr = new NotificationResult(0L, 1L, null);
            h.fail("Failed to catch null result array");
        }
        catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                h.check(true, "Caught null result array.");
            }
            h.debug(e);
            h.fail("Unknown exception");
        }
        try {
            nr = new NotificationResult(0L, 1L, array);
            h.check(true, "NotificationResult successfully created.");
            h.check(nr.getEarliestSequenceNumber() == 0L, "Retrieved earliest sequence number.");
            h.check(nr.getNextSequenceNumber() == 1L, "Retrieved next sequence number.");
            h.check(nr.getTargetedNotifications() == array, "Retrieved array.");
        }
        catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                h.fail("Wrongly threw IllegalArgumentException.");
            }
            h.debug(e);
            h.fail("Unknown exception");
        }
    }
}

