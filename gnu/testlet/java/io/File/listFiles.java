/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.File;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class listFiles
implements Testlet {
    File tmpdir;
    File tmpfile;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            String tmp = harness.getTempDirectory();
            this.tmpdir = new File(tmp + File.separator + "mauve-testdir");
            harness.check(this.tmpdir.mkdir() || this.tmpdir.exists(), "temp directory");
            File[] list2 = this.tmpdir.listFiles();
            harness.check(list2.length, 0, "empty directory");
            harness.debug("list.length: " + list2.length);
            if (list2.length > 0) {
                harness.debug("Unexpected: " + list2[0]);
            }
            list2 = this.tmpdir.listFiles((FileFilter)null);
            harness.check(list2.length, 0, "empty directory, null filter");
            harness.debug("list.length: " + list2.length);
            if (list2.length > 0) {
                harness.debug("Unexpected: " + list2[0]);
            }
            this.tmpfile = new File(this.tmpdir, "testfile");
            harness.check(this.tmpfile.delete() || !this.tmpfile.exists(), "no temp file");
            list2 = this.tmpdir.listFiles();
            harness.check(list2.length, 0, "no real file in dir");
            harness.debug("list.length: " + list2.length);
            if (list2.length > 0) {
                harness.debug("Unexpected: " + list2[0]);
            }
            list2 = this.tmpdir.listFiles((FileFilter)null);
            harness.check(list2.length, 0, "no real file in dir, null filter");
            harness.debug("list.length: " + list2.length);
            if (list2.length > 0) {
                harness.debug("Unexpected: " + list2[0]);
            }
            list2 = this.tmpfile.listFiles();
            harness.check(list2, null, "non-existing-file");
            list2 = this.tmpfile.listFiles((FileFilter)null);
            harness.check(list2, null, "non-existing-file, null filter");
            this.tmpfile.createNewFile();
            list2 = this.tmpfile.listFiles();
            harness.check(list2, null, "not-a-directory");
            list2 = this.tmpfile.listFiles((FileFilter)null);
            harness.check(list2, null, "not-a-directory, null filter");
            list2 = this.tmpdir.listFiles();
            harness.check(list2 != null && list2.length == 1 && list2[0].equals(this.tmpfile), "one file in directory");
            list2 = this.tmpdir.listFiles((FileFilter)null);
            harness.check(list2 != null && list2.length == 1 && list2[0].equals(this.tmpfile), "one file in directory, null filter");
            File[] roots = File.listRoots();
            for (int i = 0; i < roots.length; ++i) {
                harness.check(roots[i].listFiles() != null, "root " + i);
                harness.check(roots[i].listFiles((FileFilter)null) != null, "root " + i + ", null filter");
            }
        }
        catch (IOException ioe) {
            harness.fail("Unexpected exception: " + ioe);
            harness.debug(ioe);
        }
        finally {
            if (this.tmpdir != null && this.tmpdir.exists()) {
                if (this.tmpfile != null && this.tmpfile.exists()) {
                    this.tmpfile.delete();
                }
                this.tmpdir.delete();
            }
        }
    }
}

