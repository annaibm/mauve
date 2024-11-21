/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ProcessBuilder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ProcessBuilder object1 = new ProcessBuilder(new ArrayList<String>());
        harness.check(object1 != null);
        ProcessBuilder object2 = new ProcessBuilder("nothing happens");
        harness.check(object2 != null);
        ProcessBuilder object3 = new ProcessBuilder(new String[]{null});
        harness.check(object3 != null);
        ProcessBuilder object4 = new ProcessBuilder("ls", "/");
        harness.check(object4 != null);
        ProcessBuilder object5 = new ProcessBuilder("unknown", "command");
        harness.check(object5 != null);
    }
}

