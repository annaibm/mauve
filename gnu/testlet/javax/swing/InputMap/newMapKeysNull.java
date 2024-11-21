/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.InputMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.InputMap;

public class newMapKeysNull
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InputMap map2 = new InputMap();
        if (map2.keys() != null) {
            harness.fail("New InputMap should return null for keys()");
        }
        if (map2.allKeys() != null) {
            harness.fail("New ActionMap should return null for allKeys()");
        }
    }
}

