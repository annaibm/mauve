/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class jdk11
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String tmpfile = harness.getTempDirectory() + File.separator + "mauve-jdk11.tst";
        File f = new File(tmpfile);
        try {
            f.createNewFile();
        }
        catch (IOException ioe) {
            harness.debug(ioe);
        }
        try {
            FileReader fr1 = new FileReader(tmpfile);
            harness.check(true, "FileReader(string)");
        }
        catch (FileNotFoundException e) {
            harness.fail("Can't open file " + tmpfile);
        }
        try {
            File f2 = new File(tmpfile);
            FileReader fr2 = new FileReader(f2);
            harness.check(true, "FileReader(File)");
            FileInputStream fis = new FileInputStream(f2);
            try {
                FileReader fr3 = new FileReader(fis.getFD());
                harness.check(true, "FileReader(FileDescriptor)");
            }
            catch (IOException e) {
                harness.fail("Couldn't get FileDescriptor)");
            }
        }
        catch (FileNotFoundException e) {
            harness.fail("Can't open file " + tmpfile);
        }
        f.delete();
    }
}

