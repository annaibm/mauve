/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Process;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class destroy
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            Process p = Runtime.getRuntime().exec(harness.getTestJava() + " gnu.testlet.java.lang.Process.destroy_child");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = in.readLine();
            if (line.equals("UP")) {
                harness.check(true);
                p.destroy();
            } else {
                harness.check(false);
            }
            try {
                p.waitFor();
                harness.check(true);
            }
            catch (InterruptedException e) {
                harness.debug(e);
                harness.check(false);
            }
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

