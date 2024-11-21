/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLClassLoader;

import gnu.testlet.TestHarness;
import gnu.testlet.java.net.URLClassLoader.getResourceBase;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class getResourceRemote
extends getResourceBase {
    @Override
    public void test(TestHarness h) {
        this.harness = h;
        try {
            URL[] urls = new URL[]{new URL("http://sources.redhat.com/mauve/testarea/"), new URL("http://sources.redhat.com/mauve/testarea/remotejar.jar")};
            this.ucl = URLClassLoader.newInstance(urls);
            this.check("testresource", "/mauve/testarea", true);
            this.check("testdir/resourceindir", "/mauve/testarea", true);
            this.check("remote-jresource", "/mauve/testarea/remotejar.jar", false);
            this.check("path/in/remote-jar/resourcefile", "/mauve/testarea/remotejar.jar", false);
        }
        catch (IOException ioe) {
            this.harness.fail("Unexpected exception: " + ioe);
            this.harness.debug(ioe);
        }
    }
}

