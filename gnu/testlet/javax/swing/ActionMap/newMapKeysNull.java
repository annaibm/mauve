/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ActionMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ActionMap;

public class newMapKeysNull
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ActionMap map2 = new ActionMap();
        if (map2.keys() != null) {
            harness.fail("New ActionMap should return null for keys()");
        }
        if (map2.allKeys() != null) {
            harness.fail("New ActionMap should return null for allKeys()");
        }
    }
}

