/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FilePermission;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FilePermission;
import java.util.LinkedList;

public class traversal2
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("setup");
            String[] ways_to_access = new String[]{"dir", "rlink", "alink"};
            String[] ways_to_escape = new String[]{"..", "rlink", "alink"};
            String[] item_states = new String[]{"present", "absent"};
            LinkedList<File> cleanup = new LinkedList<File>();
            try {
                File tempdir = new File(harness.getTempDirectory(), "mauve-testdir");
                harness.check(tempdir.isDirectory() || tempdir.mkdir());
                cleanup.add(tempdir);
                File testdir = new File(tempdir, "dir");
                harness.check(testdir.isDirectory() || testdir.mkdir());
                cleanup.add(testdir);
                File link = new File(tempdir, "rlink");
                harness.check(Runtime.getRuntime().exec(new String[]{"ln", "-s", testdir.getName(), link.getPath()}).waitFor() == 0);
                cleanup.add(link);
                link = new File(tempdir, "alink");
                harness.check(Runtime.getRuntime().exec(new String[]{"ln", "-s", testdir.getPath(), link.getPath()}).waitFor() == 0);
                cleanup.add(link);
                File file = new File(tempdir, "file-present");
                harness.check(file.isFile() || file.createNewFile());
                cleanup.add(file);
                file = new File(tempdir, "file-absent");
                harness.check(!file.exists());
                link = new File(testdir, "rlink");
                harness.check(Runtime.getRuntime().exec(new String[]{"ln", "-s", "..", link.getPath()}).waitFor() == 0);
                cleanup.add(link);
                link = new File(testdir, "alink");
                harness.check(Runtime.getRuntime().exec(new String[]{"ln", "-s", tempdir.getPath(), link.getPath()}).waitFor() == 0);
                cleanup.add(link);
                harness.checkPoint("test");
                for (int i = 0; i < ways_to_access.length; ++i) {
                    String how_to_access = ways_to_access[i];
                    FilePermission a = new FilePermission(new File(new File(tempdir, how_to_access), "-").getPath(), "read");
                    for (int j = 0; j < ways_to_escape.length; ++j) {
                        String how_to_escape = ways_to_escape[j];
                        for (int k = 0; k < item_states.length; ++k) {
                            String item = "file-" + item_states[k];
                            FilePermission b = new FilePermission(new File(new File(testdir, how_to_escape), item).getPath(), "read");
                            harness.debug("\na = " + a);
                            harness.debug("b = " + b);
                            harness.check(!a.implies(b));
                        }
                    }
                }
            }
            finally {
                for (int i = cleanup.size() - 1; i >= 0; --i) {
                    ((File)cleanup.get(i)).delete();
                }
            }
        }
        catch (Throwable ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
    }
}

