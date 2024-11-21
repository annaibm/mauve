/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class fileoutputstream
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String tmpfile = ".";
        try {
            new FileOutputStream(tmpfile);
            harness.check(false, "Failed to throw FileNotFoundException");
        }
        catch (FileNotFoundException e) {
            harness.check(true, "thrown FileNotFoundException for directory parameter");
        }
        catch (Throwable t) {
            harness.fail("Unknown Throwable caught");
            harness.debug(t);
        }
        File f = new File(tmpfile);
        try {
            new FileOutputStream(f);
            harness.check(false, "Failed to throw FileNotFoundException");
        }
        catch (FileNotFoundException e) {
            harness.check(true, "thrown FileNotFoundException for directory parameter");
        }
        catch (Throwable t) {
            harness.fail("Unknown Throwable caught");
            harness.debug(t);
        }
    }
}

