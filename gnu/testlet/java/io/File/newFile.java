/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.File;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;

public class newFile
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
            File samedir = new File(tmp + File.separator + "mauve-testdir" + File.separator);
            File againdir = new File(tmp + File.separator + "mauve-testdir" + File.separator + File.separator);
            File dirdir = new File(tmp, "mauve-testdir");
            harness.check(this.tmpdir.isDirectory(), "isDirectory() without separator");
            harness.check(samedir.isDirectory(), "isDirectory() with separator");
            harness.check(againdir.isDirectory(), "isDirectory() with double separators");
            harness.check(dirdir.isDirectory(), "isDirectory() with dir in dir");
            harness.check(this.tmpdir.getPath(), samedir.getPath(), "dir getPath() with/without trailing separator");
            harness.check(samedir.getPath(), againdir.getPath(), "dir getPath() with (double) trailing separator");
            harness.check(againdir.getPath(), dirdir.getPath(), "dir getPath() with double separator and dir in dir");
            harness.check(this.tmpdir.getName(), samedir.getName(), "dir getName() with/without trailing separator");
            harness.check(samedir.getName(), againdir.getName(), "dir getName() with (double) separator");
            harness.check(againdir.getName(), dirdir.getName(), "dir getName() with double separator and dir in dir");
            harness.check(this.tmpdir.getParent(), samedir.getParent(), "same parent with/without separator");
            harness.check(samedir.getParent(), againdir.getParent(), "same parent with (double) separator");
            harness.check(againdir.getParent(), dirdir.getParent(), "same parent with double separator and dir in dir");
            harness.checkPoint("getname returns the argument");
            harness.check(new File("dir").getName(), (Object)"dir");
            harness.check(new File("dir" + File.separator).getName(), (Object)"dir");
            if (File.separatorChar != '\\') {
                harness.check(new File("dir\\").getName(), (Object)"dir\\");
            }
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

