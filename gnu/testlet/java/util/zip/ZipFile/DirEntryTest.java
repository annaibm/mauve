/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.zip.ZipFile;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class DirEntryTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            File temp = File.createTempFile("NoEntryTest", ".zip");
            temp.deleteOnExit();
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(temp));
            ZipEntry ze = new ZipEntry("dir/");
            zout.putNextEntry(ze);
            zout.close();
            ZipFile zf = new ZipFile(temp);
            harness.check(zf.getEntry("dir/").getName(), "dir/", "getEntry(\"dir/\")");
            harness.check(zf.getEntry("dir").getName(), "dir", "getEntry(\"dir\")");
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false);
        }
    }
}

