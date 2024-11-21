/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.FeatureDescriptor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.FeatureDescriptor;

public class check
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FeatureDescriptor fd = new FeatureDescriptor();
        harness.checkPoint("initialization");
        harness.check(fd.getName(), null);
        harness.check(fd.getDisplayName(), null);
        harness.check(fd.getShortDescription(), null);
        harness.checkPoint("name set");
        fd.setName("foo");
        harness.check(fd.getName(), (Object)"foo");
        harness.check(fd.getDisplayName(), (Object)"foo");
        harness.check(fd.getShortDescription(), (Object)"foo");
        harness.checkPoint("display name set");
        fd.setDisplayName("baz");
        harness.check(fd.getName(), (Object)"foo");
        harness.check(fd.getDisplayName(), (Object)"baz");
        harness.check(fd.getShortDescription(), (Object)"baz");
        harness.checkPoint("short description set");
        fd.setShortDescription("bar");
        harness.check(fd.getName(), (Object)"foo");
        harness.check(fd.getDisplayName(), (Object)"baz");
        harness.check(fd.getShortDescription(), (Object)"bar");
    }
}

