/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.File;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

public class jdk11
implements Testlet,
FilenameFilter {
    @Override
    public void test(TestHarness harness) {
        String srcdirstr = harness.getSourceDirectory();
        String tmpdirstr = harness.getTempDirectory();
        File srcdir = new File(srcdirstr);
        File tmpdir = new File(tmpdirstr);
        String THIS_FILE = new String("gnu" + File.separator + "testlet" + File.separator + "java" + File.separator + "io" + File.separator + "File" + File.separator + "tmp");
        File cons = new File(srcdir, THIS_FILE);
        File cons2 = new File(srcdirstr, THIS_FILE);
        harness.check(cons.mkdir(), "mkdir ()");
        harness.check(cons.canRead(), "canRead ()");
        harness.check(cons.equals(cons2), "equals ()");
        harness.check(srcdir.isDirectory(), "isDirectory ()");
        harness.check(tmpdir.isDirectory(), "isDirectory ()");
        String TMP_FILENAME = "File.tst";
        String TMP_FILENAME2 = "Good.doc";
        String TMP_FILENAME3 = "File.doc";
        File tmp = new File(cons, TMP_FILENAME);
        try {
            FileOutputStream fos = new FileOutputStream(tmp);
            fos.close();
        }
        catch (FileNotFoundException fos) {
        }
        catch (IOException fos) {
            // empty catch block
        }
        File tmp2 = new File(cons, TMP_FILENAME2);
        try {
            FileOutputStream fos = new FileOutputStream(tmp2);
            fos.close();
        }
        catch (FileNotFoundException fos) {
        }
        catch (IOException fos) {
            // empty catch block
        }
        File tmp3 = new File(cons, TMP_FILENAME3);
        harness.check(tmp.canWrite(), "canWrite()");
        harness.check(tmp.exists(), "exists ()");
        harness.check(tmp.isFile(), "isFile ()");
        harness.check(tmp.length(), 0L, "length ()");
        byte[] b = new byte[2001];
        try {
            FileOutputStream fos = new FileOutputStream(tmp);
            fos.write(b);
            fos.close();
        }
        catch (FileNotFoundException fos) {
        }
        catch (IOException fos) {
            // empty catch block
        }
        harness.check(tmp.length(), (long)b.length, "length ()");
        String tmpstr = new String(srcdirstr + File.separator + THIS_FILE + File.separator + TMP_FILENAME);
        harness.debug(tmp.toString() + " =? " + tmpstr);
        harness.check(tmp.toString().equals(tmpstr), "toString ()");
        String[] tmpdirlist = cons.list();
        String[] expectedlist = new String[]{TMP_FILENAME, TMP_FILENAME2};
        harness.check(this.compareStringArray(tmpdirlist, expectedlist), "list ()");
        tmpdirlist = cons.list(this);
        expectedlist = new String[]{TMP_FILENAME2};
        harness.check(this.compareStringArray(tmpdirlist, expectedlist), "list (FilenameFilter)");
        if (tmp3.exists()) {
            tmp3.delete();
        }
        harness.check(tmp.renameTo(tmp3), "renameTo (File)");
        harness.check(tmp3.exists(), "renameTo (File)");
        if (tmp.exists()) {
            harness.check(tmp.delete(), "delete ()");
        }
        if (tmp2.exists()) {
            harness.check(tmp2.delete(), "delete ()");
        }
        if (tmp3.exists()) {
            harness.check(tmp3.delete(), "delete ()");
        }
        harness.check(!tmp.exists(), "delete ()");
        harness.check(!tmp2.exists(), "delete ()");
        harness.check(!tmp3.exists(), "delete ()");
        harness.check(tmp.mkdir(), "mkdir ()");
        harness.check(tmp.exists() && tmp.isDirectory(), "mkdir ()");
        File mkdirstest = new File(tmpdirstr, new String("one" + File.separator + "two" + File.separator + "three"));
        harness.check(mkdirstest.mkdirs(), "mkdirs ()");
        harness.check(mkdirstest.exists() && mkdirstest.isDirectory(), "mkdirs ()");
        File mkdirstest2 = new File(tmpdirstr, new String("one" + File.separator + "two"));
        harness.check(mkdirstest2.exists() && mkdirstest2.isDirectory(), "mkdirs ()");
        File mkdirstest1 = new File(tmpdirstr, new String("one"));
        harness.check(mkdirstest1.exists() && mkdirstest1.isDirectory(), "mkdirs ()");
        harness.check(mkdirstest.delete(), "delete () of a directory");
        harness.check(!mkdirstest.exists(), "delete () of a directory");
        harness.check(!mkdirstest1.delete(), "delete () of a directory");
        harness.check(mkdirstest2.delete(), "delete () of a directory");
        harness.check(!mkdirstest2.exists(), "delete () of a directory");
        harness.check(mkdirstest1.delete(), "delete () of a directory");
        harness.check(!mkdirstest1.exists(), "delete () of a directory");
        harness.check(tmp.delete(), "delete () of a directory");
        harness.check(!tmp.exists(), "delete () of a directory");
        harness.check(cons.delete(), "delete () of a directory");
        harness.check(!cons.exists(), "delete () of a directory");
        harness.check(File.pathSeparator.equals("@CHECK_PATH_SEPARATOR@"), "pathSeparator");
        harness.check(new Character(File.pathSeparatorChar).toString().equals("@CHECK_PATH_SEPARATOR@"), "pathSeparatorChar");
        harness.check(File.separator.equals("@CHECK_FILE_SEPARATOR@"), "separator");
        harness.check(new Character(File.separatorChar).toString().equals("@CHECK_FILE_SEPARATOR@"), "separatorChar");
        harness.debug("tmp3.getAbsolutePath () = " + tmp3.getAbsolutePath());
        harness.debug("equals? " + srcdirstr + File.separator + THIS_FILE + File.separator + TMP_FILENAME3);
        harness.check(tmp3.getAbsolutePath().equals(srcdirstr + File.separator + THIS_FILE + File.separator + TMP_FILENAME3), "getAbsolutePath ()");
        try {
            cons.mkdir();
            FileOutputStream fos = new FileOutputStream(tmp3);
            fos.write(1);
            fos.close();
            harness.debug("tmp3.getCanonicalPath () = " + tmp3.getCanonicalPath());
            harness.debug("equals? " + srcdirstr + File.separator + THIS_FILE + File.separator + TMP_FILENAME3);
            harness.check(tmp3.getCanonicalPath().equals(srcdirstr + File.separator + THIS_FILE + File.separator + TMP_FILENAME3), "getCanonicalPath ()");
            tmp3.delete();
            cons.delete();
        }
        catch (IOException ioe) {
            harness.check(false, "getCanonicalPath () " + ioe);
        }
        boolean ok = false;
        try {
            File x1 = new File("").getCanonicalFile();
            File x2 = new File(".").getCanonicalFile();
            ok = x1.equals(x2);
        }
        catch (IOException x1) {
            // empty catch block
        }
        harness.check(ok, "getCanonicalFile with empty path");
        harness.debug("tmp3.getName () = " + tmp3.getName());
        harness.check(tmp3.getName().equals(TMP_FILENAME3), "getName ()");
        harness.check(tmp3.getParent().equals(srcdirstr + File.separator + THIS_FILE), "getParent ()");
        harness.debug("tmp3.getPath () = " + tmp.getPath());
        harness.check(tmp3.getPath().equals(srcdirstr + File.separator + THIS_FILE + File.separator + TMP_FILENAME3), "getPath ()");
        int hc1 = tmp3.hashCode();
        int hc2 = tmp3.hashCode();
        harness.check(hc1, hc2, "hashCode()");
        harness.check(tmp3.isAbsolute(), "isAbsolute ()");
        harness.check(!new File("").isAbsolute());
        File lastmod = new File(tmpdir, "lastmod");
        if (lastmod.exists()) {
            lastmod.delete();
        }
        Date now = new Date();
        long time2 = now.getTime();
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        try {
            FileOutputStream fos = new FileOutputStream(lastmod);
            fos.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        harness.debug(lastmod.lastModified() + " >= " + time2);
        if (lastmod.lastModified() >= time2) {
            harness.check(true, "lastModified ()");
        } else {
            harness.check(false, "lastModified ()");
        }
        if (lastmod.exists()) {
            lastmod.delete();
        }
    }

    private boolean compareStringArray(String[] x, String[] y) {
        int i;
        if (x.length != y.length) {
            return false;
        }
        boolean[] test = new boolean[y.length];
        for (i = 0; i < test.length; ++i) {
            test[i] = true;
        }
        for (i = 0; i < x.length; ++i) {
            boolean nomatch = true;
            for (int j = 0; j < y.length; ++j) {
                if (!test[j] || !x[i].equals(y[j])) continue;
                test[j] = false;
                nomatch = false;
                break;
            }
            if (!nomatch) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean accept(File dir, String name2) {
        return name2.endsWith(".doc");
    }
}

