/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.IconUIResource;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.IconUIResource;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean pass = false;
        try {
            IconUIResource iconUIResource = new IconUIResource(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

