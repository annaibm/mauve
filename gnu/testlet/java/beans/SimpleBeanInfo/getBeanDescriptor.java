/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.SimpleBeanInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.SimpleBeanInfo;

public class getBeanDescriptor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleBeanInfo i = new SimpleBeanInfo();
        harness.check(i.getBeanDescriptor(), null);
    }
}

