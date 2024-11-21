/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FilePermission;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FilePermission;
import java.util.LinkedList;

public class traversal
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("setup");
            String[] items_to_access = new String[]{"file", "rlink", "alink"};
            String[] ways_to_access = new String[]{"dir", "rlink", "alink"};
            String[] item_states = new String[]{"present", "absent"};
            LinkedList<File> cleanup = new LinkedList<File>();
            try {
                File file;
                int i;
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
                File[] dirs = new File[]{testdir, tempdir};
                for (i = 0; i < dirs.length; ++i) {
                    file = new File(dirs[i], "file-present");
                    harness.check(file.isFile() || file.createNewFile());
                    cleanup.add(file);
                    file = new File(dirs[i], "file-absent");
                    harness.check(!file.exists());
                }
                for (i = 0; i < item_states.length; ++i) {
                    file = new File(tempdir, "file-" + item_states[i]);
                    link = new File(testdir, "rlink-" + item_states[i]);
                    harness.check(Runtime.getRuntime().exec(new String[]{"ln", "-s", new File("..", file.getName()).getPath(), link.getPath()}).waitFor() == 0);
                    cleanup.add(link);
                    link = new File(testdir, "alink-" + item_states[i]);
                    harness.check(Runtime.getRuntime().exec(new String[]{"ln", "-s", file.getPath(), link.getPath()}).waitFor() == 0);
                    cleanup.add(link);
                }
                harness.checkPoint("test");
                for (i = 0; i < items_to_access.length; ++i) {
                    String item_to_access = items_to_access[i];
                    for (int j = 0; j < ways_to_access.length; ++j) {
                        String how_to_access = ways_to_access[j];
                        for (int k = 0; k < ways_to_access.length; ++k) {
                            String how_permitted = ways_to_access[k];
                            for (int l = 0; l < item_states.length; ++l) {
                                String item_state = item_states[l];
                                String item = item_to_access + "-" + item_state;
                                FilePermission a = new FilePermission(new File(new File(tempdir, how_permitted), item).getPath(), "read");
                                FilePermission b = new FilePermission(new File(new File(tempdir, how_to_access), item).getPath(), "read");
                                harness.debug("\na = " + a);
                                harness.debug("b = " + b);
                                harness.check(a.implies(b));
                            }
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

