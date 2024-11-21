/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.TimeZone;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Locale;
import java.util.TimeZone;

public class GetDisplayName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TimeZone zone = TimeZone.getTimeZone("Europe/London");
        harness.check(zone.getDisplayName(false, 1, Locale.UK), (Object)"Greenwich Mean Time");
        harness.check(zone.getDisplayName(false, 0, Locale.UK), (Object)"GMT");
        harness.check(zone.getDisplayName(true, 1, Locale.UK), (Object)"British Summer Time");
        harness.check(zone.getDisplayName(true, 0, Locale.UK), (Object)"BST");
    }
}

