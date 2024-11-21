/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.zip.ZipFile;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class NoEntryTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean pass = false;
        try {
            File temp = File.createTempFile("NoEntryTest", ".zip");
            temp.deleteOnExit();
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(temp));
            ZipEntry ze = new ZipEntry("one");
            zout.putNextEntry(ze);
            zout.close();
            ZipFile zf = new ZipFile(temp);
            ze = new ZipEntry("this/does/not/exist");
            InputStream is = zf.getInputStream(ze);
            if (is == null) {
                pass = true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        harness.check(pass, "getInputStream for missing ZipEntry returns null");
    }
}

