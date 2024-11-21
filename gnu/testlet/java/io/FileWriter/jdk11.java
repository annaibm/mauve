/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileWriter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class jdk11
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            FileWriter fr1 = new FileWriter("tmpfile");
            harness.check(true, "FileWriter(string)");
            FileWriter fr1a = new FileWriter("tmpfile", true);
            harness.check(true, "FileWriter(string, boolean)");
            File f2 = new File("tmpfile");
            FileWriter fr2 = new FileWriter(f2);
            harness.check(true, "FileWriter(File)");
            FileOutputStream fis = new FileOutputStream(f2);
            FileWriter fr3 = new FileWriter(fis.getFD());
            harness.check(true, "FileWriter(FileDescriptor)");
        }
        catch (IOException e) {
            harness.fail("Can't open file 'choices'");
        }
    }
}

