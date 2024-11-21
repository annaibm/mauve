/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class jdk12
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String tmpfile = "./asdfghj/mauve-fileout.tst";
        try {
            new FileOutputStream(tmpfile);
            harness.fail("No exception thrown");
        }
        catch (FileNotFoundException t) {
            harness.check(true, "new(string) Threw correct exception");
        }
        try {
            new FileOutputStream(tmpfile, true);
            harness.fail("No exception thrown");
        }
        catch (FileNotFoundException t) {
            harness.check(true, "new(string, boolean) Threw correct exception");
        }
    }
}

