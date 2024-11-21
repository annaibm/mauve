/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.JarURLConnection;
import java.net.URL;

public class Jar
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("jar: URL with missing entry");
        try {
            File jarfile = harness.getResourceFile("gnu#testlet#java#util#jar#JarFile#jartest.jar");
            String filename = jarfile.toString();
            URL url = new URL("jar:file:" + filename + "!/nosuchfile.txt");
            JarURLConnection connection = null;
            try {
                connection = (JarURLConnection)url.openConnection();
                connection.connect();
                harness.check(false);
            }
            catch (FileNotFoundException e) {
                harness.check(true);
            }
            catch (Exception e) {
                harness.check(false);
            }
            try {
                url.openStream();
                harness.check(false);
            }
            catch (FileNotFoundException e) {
                harness.check(true);
            }
            catch (Exception e) {
                harness.check(false);
            }
        }
        catch (Throwable e) {
            harness.debug("Unexpected exception in testcase.");
            harness.debug(e);
        }
    }
}

