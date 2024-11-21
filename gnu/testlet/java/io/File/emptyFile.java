/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.File;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class emptyFile
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            String srcdirstr = harness.getBuildDirectory();
            String pathseperator = File.separator;
            File testfile = new File("");
            harness.check(testfile.getName(), "", "getName()");
            harness.check(testfile.getParent(), null, "getParent()");
            harness.check(testfile.getParentFile(), null, "getParentFile()");
            harness.check(testfile.getPath(), "", "getPath()");
            harness.check(testfile.isAbsolute(), false, "isAbsolute");
            harness.check(testfile.getAbsolutePath(), srcdirstr, "getAbsolutePath");
            harness.check(testfile.getAbsoluteFile(), new File(testfile.getAbsolutePath()), "getAbsoluteFile()");
            harness.check(testfile.getCanonicalPath(), srcdirstr, "getCanonicalPath");
            harness.check(testfile.getCanonicalFile(), new File(testfile.getCanonicalPath()), "getCanonicalFile");
            harness.checkPoint("toURL");
            harness.check(testfile.toURL().toString(), (Object)("file:" + srcdirstr));
            harness.check(testfile.toURL(), new URL("file:" + srcdirstr));
            harness.check(testfile.toURL().sameFile(new URL("file", "", srcdirstr)), true);
            harness.check(testfile.toURL().getPath(), (Object)new URL("file", "", srcdirstr).getPath());
            harness.checkPoint("toURI");
            harness.check(testfile.toURI().toString(), (Object)("file:" + srcdirstr + pathseperator));
            harness.check(new File(testfile.toURI()).equals(testfile.getAbsoluteFile()));
            harness.check(testfile.canRead(), false, "canRead()");
            harness.check(testfile.canWrite(), false, "canWrite()");
            harness.check(testfile.exists(), false, "exists()");
            harness.check(testfile.isDirectory(), false, "isDirectory()");
            harness.check(testfile.isFile(), false, "isFile()");
            harness.check(testfile.length(), 0L, "length()");
            harness.check(testfile.lastModified(), 0L, "lastModified()");
            try {
                testfile.createNewFile();
                harness.check(false, "createNewFile()");
            }
            catch (IOException e) {
                harness.check(true, "createNewFile()");
            }
            harness.check(testfile.delete(), false, "delete()");
            harness.check(testfile.list(), null, "list()");
            harness.check(testfile.mkdir(), false, "mkdir()");
            harness.check(testfile.setReadOnly(), false, "setReadOnly()");
            harness.check(testfile.setLastModified(1000L), false, "setLastModified()");
            harness.checkPoint("compareTo()");
            harness.check(testfile.compareTo(new File("")), 0);
            harness.check(testfile.compareTo(new File(".")), -1);
            harness.checkPoint("equals()");
            harness.check(testfile.equals(new File("")), true);
            harness.check(testfile.equals(new File(".")), false);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

