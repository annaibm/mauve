/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.FileNameMap;
import java.net.URLConnection;

public class getFileNameMap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FileNameMap fnm = URLConnection.getFileNameMap();
        harness.check(fnm != null);
        harness.check(fnm.getContentTypeFor("foo.ps"), (Object)"application/postscript");
    }
}

