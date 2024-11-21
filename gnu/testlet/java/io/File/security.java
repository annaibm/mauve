/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.File;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileFilter;
import java.io.FilePermission;
import java.io.FilenameFilter;
import java.security.Permission;
import java.util.Date;
import java.util.PropertyPermission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        String tmp = harness.getTempDirectory();
        File tmpdir = new File(tmp + File.separator + "mauve-testdir");
        harness.check(tmpdir.mkdir() || tmpdir.exists(), "temp directory");
        File tmpdir2 = new File(tmpdir, "nested-dir");
        harness.check(tmpdir2.mkdir() || tmpdir2.exists(), "temp directory 2");
        File tmpdir3 = new File(tmpdir2, "nested-nested-dir");
        File tmpfile = new File(tmpdir, "testfile");
        harness.check(tmpfile.delete() || !tmpfile.exists(), "no temp file");
        File tmpfile2 = new File(tmpdir, "testfile2");
        harness.check(tmpfile2.delete() || !tmpfile2.exists());
        FilePermission tmpdirReadPerm = new FilePermission(tmpdir.toString(), "read");
        FilePermission tmpdirWritePerm = new FilePermission(tmpdir.toString(), "write");
        FilePermission tmpdirDeletePerm = new FilePermission(tmpdir.toString(), "delete");
        FilePermission tmpdir2ReadPerm = new FilePermission(tmpdir2.toString(), "read");
        FilePermission tmpdir2WritePerm = new FilePermission(tmpdir2.toString(), "write");
        FilePermission tmpdir2DeletePerm = new FilePermission(tmpdir2.toString(), "delete");
        FilePermission tmpdir3ReadPerm = new FilePermission(tmpdir3.toString(), "read");
        FilePermission tmpdir3WritePerm = new FilePermission(tmpdir3.toString(), "write");
        FilePermission tmpfileReadPerm = new FilePermission(tmpfile.toString(), "read");
        FilePermission tmpfileWritePerm = new FilePermission(tmpfile.toString(), "write");
        FilePermission tmpfileDeletePerm = new FilePermission(tmpfile.toString(), "delete");
        FilePermission tmpallWritePerm = new FilePermission(tmp + File.separator + "*", "write");
        FilePermission tmpdirallWritePerm = new FilePermission(tmpdir.toString() + File.separator + "*", "write");
        FilePermission tmpfile2WritePerm = new FilePermission(tmpfile2.toString(), "write");
        FilePermission rootReadPerm = new FilePermission(File.separator, "read");
        PropertyPermission tmpdirPropPerm = new PropertyPermission("java.io.tmpdir", "read");
        RuntimePermission modifyThreadGroup = new RuntimePermission("modifyThreadGroup");
        RuntimePermission shutdownHooks = new RuntimePermission("shutdownHooks");
        File tf1 = null;
        File tf2 = null;
        TestSecurityManager sm = new TestSecurityManager(harness);
        try {
            sm.install();
            harness.checkPoint("dir.canWrite");
            try {
                sm.prepareChecks(new Permission[]{tmpdirWritePerm});
                tmpdir.canWrite();
                sm.checkAllChecked();
            }
            catch (SecurityException ex) {
                harness.debug(ex);
                harness.check(false, "dir.canWrite - unexpected exception");
            }
            harness.checkPoint("dir.canRead");
            try {
                sm.prepareChecks(new Permission[]{tmpdirReadPerm});
                tmpdir.canRead();
                sm.checkAllChecked();
            }
            catch (SecurityException ex) {
                harness.debug(ex);
                harness.check(false, "dir.canRead - unexpected exception");
            }
            harness.checkPoint("file.createNewFile");
            try {
                sm.prepareChecks(new Permission[]{tmpfileWritePerm});
                tmpfile.createNewFile();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.createNewFile - unexpected exception");
            }
            harness.checkPoint("file.delete");
            try {
                sm.prepareChecks(new Permission[]{tmpfileDeletePerm});
                tmpfile.delete();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.delete - unexpected exception");
            }
            harness.checkPoint("dir.list(null)");
            try {
                sm.prepareChecks(new Permission[]{tmpdirReadPerm});
                tmpdir.list(null);
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.list(null) - unexpected exception");
            }
            harness.checkPoint("dir.list()");
            try {
                sm.prepareChecks(new Permission[]{tmpdirReadPerm});
                tmpdir.list();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.list() - unexpected exception");
            }
            harness.checkPoint("dir.listFiles()");
            try {
                sm.prepareChecks(new Permission[]{tmpdirReadPerm});
                tmpdir.listFiles();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.listFiles() - unexpected exception");
            }
            harness.checkPoint("dir.listFiles(FilenameFilter)");
            try {
                sm.prepareChecks(new Permission[]{tmpdirReadPerm});
                tmpdir.listFiles((FilenameFilter)null);
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.listFiles(FilenameFilter) - unexpected exception");
            }
            harness.checkPoint("dir.listFiles(FileFilter)");
            try {
                sm.prepareChecks(new Permission[]{tmpdirReadPerm});
                tmpdir.listFiles((FileFilter)null);
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.listFiles(FileFilter) - unexpected exception");
            }
            harness.checkPoint("createTempFile(2-args)");
            try {
                sm.prepareChecks(new Permission[]{tmpallWritePerm}, new Permission[]{tmpdirPropPerm});
                sm.setComparisonStyle(2);
                tf1 = File.createTempFile("pfx", "sfx");
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "createTempFile(2-args) - unexpected exception");
            }
            harness.checkPoint("createTempFile(3-args)");
            try {
                sm.prepareChecks(new Permission[]{tmpdirallWritePerm});
                sm.setComparisonStyle(2);
                tf2 = File.createTempFile("pfx", "sfx", tmpdir);
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "createTempFile(3-args) - unexpected exception");
            }
            harness.checkPoint("dir.setReadOnly");
            try {
                sm.prepareChecks(new Permission[]{tmpdir2WritePerm});
                tmpdir2.setReadOnly();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.setReadOnly - unexpected exception");
            }
            harness.checkPoint("dir.delete");
            try {
                sm.prepareChecks(new Permission[]{tmpdir2DeletePerm});
                tmpdir2.delete();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.delete - unexpected exception");
            }
            harness.checkPoint("listRoots()");
            try {
                sm.prepareChecks(new Permission[]{rootReadPerm});
                File[] roots = File.listRoots();
                harness.check(roots.length >= 1, "File.listRoots()");
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "listRoots() - unexpected exception");
            }
            harness.checkPoint("file.renameTo");
            try {
                sm.prepareChecks(new Permission[]{tmpfileWritePerm, tmpfile2WritePerm});
                tmpfile.renameTo(tmpfile2);
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.renameTo - unexpected exception");
            }
            harness.checkPoint("dir.setLastModified()");
            try {
                sm.prepareChecks(new Permission[]{tmpdirWritePerm});
                tmpdir.setLastModified(0L);
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.setLastModified() - unexpected exception");
            }
            harness.checkPoint("dir.deleteOnExit()");
            try {
                sm.prepareChecks(new Permission[]{tmpdirDeletePerm}, new Permission[]{modifyThreadGroup, shutdownHooks});
                tmpdir.deleteOnExit();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.deleteOnExit() - unexpected exception");
            }
            harness.checkPoint("file.deleteOnExit()");
            try {
                sm.prepareChecks(new Permission[]{tmpfileDeletePerm}, new Permission[]{modifyThreadGroup, shutdownHooks});
                tmpfile.deleteOnExit();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.deleteOnExit() - unexpected exception");
            }
            harness.checkPoint("file.exists");
            try {
                sm.prepareChecks(new Permission[]{tmpdirReadPerm});
                tmpdir.exists();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.exists - unexpected exception");
            }
            harness.checkPoint("file.exists");
            try {
                sm.prepareChecks(new Permission[]{tmpfileReadPerm});
                tmpfile.exists();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.exists - unexpected exception");
            }
            harness.checkPoint("file.canRead");
            try {
                sm.prepareChecks(new Permission[]{tmpfileReadPerm});
                tmpfile.canRead();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.canRead - unexpected exception");
            }
            harness.checkPoint("file.isFile");
            try {
                sm.prepareChecks(new Permission[]{tmpfileReadPerm});
                tmpfile.isFile();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.isFile - unexpected exception");
            }
            harness.checkPoint("dir.isFile");
            try {
                sm.prepareChecks(new Permission[]{tmpdirReadPerm});
                tmpdir.isFile();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.isFile - unexpected exception");
            }
            harness.checkPoint("file.isDirectory");
            try {
                sm.prepareChecks(new Permission[]{tmpfileReadPerm});
                tmpfile.isDirectory();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.isDirectory - unexpected exception");
            }
            harness.checkPoint("dir.isDirectory");
            try {
                sm.prepareChecks(new Permission[]{tmpdirReadPerm});
                tmpdir.isDirectory();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.isDirectory - unexpected exception");
            }
            harness.checkPoint("file.isHidden");
            try {
                sm.prepareChecks(new Permission[]{tmpfileReadPerm});
                tmpfile.isHidden();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.isHidden - unexpected exception");
            }
            harness.checkPoint("dir.isHidden");
            try {
                sm.prepareChecks(new Permission[]{tmpdirReadPerm});
                tmpdir.isHidden();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.isHidden - unexpected exception");
            }
            harness.checkPoint("file.lastModified");
            try {
                sm.prepareChecks(new Permission[]{tmpfileReadPerm});
                tmpfile.lastModified();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.lastModified - unexpected exception");
            }
            harness.checkPoint("file.length");
            try {
                sm.prepareChecks(new Permission[]{tmpfileReadPerm});
                tmpfile.length();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.length - unexpected exception");
            }
            harness.checkPoint("file.canWrite");
            try {
                sm.prepareChecks(new Permission[]{tmpfileWritePerm});
                tmpfile.canWrite();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.canWrite - unexpected exception");
            }
            harness.checkPoint("dir.mkdir");
            try {
                sm.prepareChecks(new Permission[]{tmpdirWritePerm});
                tmpdir.mkdir();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.mkdir - unexpected exception");
            }
            harness.checkPoint("dir.mkdirs");
            try {
                sm.prepareChecks(new Permission[]{tmpdir2WritePerm, tmpdir2ReadPerm, tmpdir3ReadPerm, tmpdir3WritePerm});
                tmpdir3.mkdirs();
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "dir.mkdirs - unexpected exception");
            }
            harness.checkPoint("file.setLastModified");
            try {
                sm.prepareChecks(new Permission[]{tmpfileWritePerm});
                tmpfile.setLastModified(new Date().getTime());
                sm.checkAllChecked();
            }
            catch (Exception ex) {
                harness.debug(ex);
                harness.check(false, "file.setLastModified - unexpected exception");
            }
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "outer handler - unexpected exception");
        }
        finally {
            sm.uninstall();
            if (tmpfile != null) {
                tmpfile.delete();
            }
            if (tmpfile2 != null) {
                tmpfile2.delete();
            }
            if (tf1 != null) {
                tf1.delete();
            }
            if (tf2 != null) {
                tf2.delete();
            }
            if (tmpdir3 != null) {
                tmpdir3.delete();
            }
            if (tmpdir2 != null) {
                tmpdir2.delete();
            }
            if (tmpdir != null) {
                tmpdir.delete();
            }
        }
    }
}

