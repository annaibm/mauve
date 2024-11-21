/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.jar.JarFile;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class TestOfManifest
implements Testlet {
    private static final String FILENAME = "jfaceSmall.jar";
    private static final String FILEPATH = "gnu#testlet#java#util#jar#JarFile#jfaceSmall.jar";
    private static final String ENTRYNAME = "org/eclipse/jface/viewers/TreeViewer$TreeColorAndFontCollector.class";

    @Override
    public void test(TestHarness harness) {
        this.checkManifestEntries(harness);
        this.checkCertificates(harness);
    }

    private void checkManifestEntries(TestHarness harness) {
        harness.checkPoint("checkManifestEntries");
        try {
            File file = harness.getResourceFile(FILEPATH);
            JarFile jarFile = new JarFile(file);
            TestOfManifest.readEntries(jarFile);
            boolean ok = this.readCertificates(harness, jarFile);
            harness.check(ok, "Jar entry MUST be signed");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("checkManifestEntries: " + x);
        }
    }

    private void checkCertificates(TestHarness harness) {
        harness.checkPoint("checkCertificates");
        try {
            File file = harness.getResourceFile(FILEPATH);
            JarFile jarFile = new JarFile(file, true);
            JarEntry je = jarFile.getJarEntry(ENTRYNAME);
            Certificate[] certsBefore = je.getCertificates();
            int certsBeforeCount = certsBefore == null ? 0 : certsBefore.length;
            harness.verbose("***       before: " + certsBeforeCount);
            harness.check(certsBeforeCount == 0, "Certificate count MUST be 0");
            TestOfManifest.read1Entry(jarFile, je);
            Certificate[] certsAfter = je.getCertificates();
            int certsAfterCount = certsAfter == null ? 0 : certsAfter.length;
            harness.verbose("***        after: " + certsAfterCount);
            harness.check(certsAfterCount == 1, "Certificate count MUST be 1");
            harness.check(certsBeforeCount != certsAfterCount, "Certificate counts MUST NOT be the same");
            JarEntry je_ = jarFile.getJarEntry(ENTRYNAME);
            Certificate[] sameCerts = je_.getCertificates();
            int sameCertsCount = sameCerts == null ? 0 : sameCerts.length;
            harness.verbose("*** w/ new entry: " + sameCertsCount);
            harness.check(sameCertsCount == 1, "Certificate count (w/ new entry) MUST be 1");
            harness.check(certsAfterCount == sameCertsCount, "Certificate counts (w/ new entry) MUST be the same");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("checkCertificates: " + x);
        }
    }

    private static void readEntries(JarFile jarFile) throws Exception {
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            TestOfManifest.read1Entry(jarFile, entries.nextElement());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void read1Entry(JarFile jar, JarEntry entry) throws Exception {
        InputStream stream = null;
        try {
            int n;
            stream = jar.getInputStream(entry);
            byte[] ba = new byte[8192];
            while ((n = stream.read(ba)) >= 0) {
            }
        }
        finally {
            if (stream != null) {
                try {
                    stream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    private boolean readCertificates(TestHarness harness, JarFile jarFile) {
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            Certificate[] certs;
            JarEntry entry = entries.nextElement();
            if (entry.isDirectory() || (certs = entry.getCertificates()) != null && certs.length != 0 || entry.getName().startsWith("META-INF")) continue;
            harness.verbose("Entry " + entry.getName() + " in jar file " + FILENAME + " does not have a certificate");
            return false;
        }
        return true;
    }
}

