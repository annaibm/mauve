/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLClassLoader;

import gnu.testlet.TestHarness;
import gnu.testlet.java.net.URLClassLoader.getResourceBase;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

public class getResource
extends getResourceBase {
    private File tmpdir;
    private File tmpfile;
    private File subtmpdir;
    private File subtmpfile;
    private String jarPath;

    private void setup() throws IOException {
        String tmp = this.harness.getTempDirectory();
        this.tmpdir = new File(tmp + File.separator + "mauve-testdir");
        if (!this.tmpdir.mkdir() && !this.tmpdir.exists()) {
            throw new IOException("Could not create: " + this.tmpdir);
        }
        this.tmpfile = new File(this.tmpdir, "testfile");
        if (!this.tmpfile.delete() && this.tmpfile.exists()) {
            throw new IOException("Could not remove (old): " + this.tmpfile);
        }
        this.tmpfile.createNewFile();
        this.subtmpdir = new File(this.tmpdir, "testdir");
        if (!this.subtmpdir.mkdir() && !this.subtmpdir.exists()) {
            throw new IOException("Could not create: " + this.subtmpdir);
        }
        this.subtmpfile = new File(this.subtmpdir, "test");
        if (!this.subtmpfile.delete() && this.subtmpfile.exists()) {
            throw new IOException("Could not remove (old): " + this.subtmpfile);
        }
        this.subtmpfile.createNewFile();
        this.jarPath = tmp + File.separator + "m.jar";
        FileOutputStream fos = new FileOutputStream(this.jarPath);
        JarOutputStream jos = new JarOutputStream(fos);
        JarEntry je = new JarEntry("jresource");
        jos.putNextEntry(je);
        jos.write(new byte[256]);
        je = new JarEntry("path/in/jar/");
        jos.putNextEntry(je);
        je = new JarEntry("path/in/jar/file");
        jos.putNextEntry(je);
        jos.write(new byte[256]);
        jos.close();
        fos.close();
    }

    private void tearDown() {
        if (this.tmpdir != null && this.tmpdir.exists()) {
            if (this.tmpfile != null && this.tmpfile.exists()) {
                this.tmpfile.delete();
            }
            if (this.subtmpdir != null && this.subtmpdir.exists()) {
                if (this.subtmpfile != null && this.subtmpfile.exists()) {
                    this.subtmpfile.delete();
                }
                this.subtmpdir.delete();
            }
            this.tmpdir.delete();
        }
        if (this.jarPath != null) {
            new File(this.jarPath).delete();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        this.harness = h;
        try {
            this.setup();
            URL[] urls = new URL[]{this.tmpdir.toURL(), new URL("file://" + this.jarPath)};
            this.ucl = URLClassLoader.newInstance(urls);
            URL u = this.ucl.getResource(".");
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u != null, "Checking .");
            u = this.ucl.getResource("..");
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u == null, "Checking ..");
            u = this.ucl.getResource("../mauve-testdir");
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u == null, "Checking ../mauve-testdir");
            u = this.ucl.getResource("mauve-testdir/..");
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u == null, "Checking mauve-testdir/..");
            u = this.ucl.getResource("mauve-testdir/../");
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u == null, "Checking mauve-testdir/../");
            u = this.ucl.getResource("testdir/..");
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u != null, "Checking testdir/..");
            u = this.ucl.getResource("testdir/../");
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u != null, "Checking testdir/../");
            u = this.ucl.getResource("mauve-testdir/../testdir");
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u == null, "Checking mauve-testdir/../testdir");
            u = this.ucl.getResource("testdir/../testdir");
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u != null, "Checking testdir/../testdir");
            this.check("testfile", "mauve-testdir", true);
            this.check("testdir", "mauve-testdir", true);
            this.check("testdir/test", "mauve-testdir", true);
            this.check("jresource", "m.jar", false);
            this.check("path/in/jar/file", "m.jar", false);
            this.check("path/in/jar", "m.jar", false);
        }
        catch (IOException ioe) {
            this.harness.fail("Unexpected exception: " + ioe);
            this.harness.debug(ioe);
        }
        finally {
            this.tearDown();
        }
    }
}

