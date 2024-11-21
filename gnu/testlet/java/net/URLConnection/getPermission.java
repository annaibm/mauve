/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.net.SocketPermission;
import java.net.URL;
import java.net.URLConnection;
import java.security.AllPermission;
import java.security.Permission;

public class getPermission
extends URLConnection
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String host;
        Permission p;
        URLConnection uc;
        URL u;
        String file;
        try {
            Permission p2 = this.getPermission();
            harness.check(p2, new AllPermission());
        }
        catch (IOException ioe) {
            harness.debug(ioe);
            harness.check(false);
        }
        try {
            file = "dummy";
            URL u2 = new URL("file:" + file);
            URLConnection uc2 = u2.openConnection();
            Permission p3 = uc2.getPermission();
            harness.check(p3, new FilePermission(file, "read"));
        }
        catch (IOException ioe) {
            harness.check(false);
        }
        try {
            file = "file";
            File f = new File(file);
            u = f.toURL();
            uc = u.openConnection();
            p = uc.getPermission();
            harness.check(p, new FilePermission(f.getAbsolutePath(), "read"));
        }
        catch (IOException ioe) {
            harness.debug(ioe);
            harness.check(false);
        }
        try {
            host = "dummy";
            int port = 80;
            u = new URL("http://" + host + "/");
            uc = u.openConnection();
            p = uc.getPermission();
            harness.check(p, new SocketPermission(host + ":" + port, "connect"));
        }
        catch (IOException ioe) {
            harness.debug(ioe);
            harness.check(false);
        }
        try {
            host = "dummy";
            int port = 667;
            u = new URL("http://" + host + ":" + port + "/");
            uc = u.openConnection();
            p = uc.getPermission();
            harness.check(p, new SocketPermission(host + ":" + port, "connect"));
        }
        catch (IOException ioe) {
            harness.debug(ioe);
            harness.check(false);
        }
    }

    public getPermission() throws IOException {
        super(new URL("file:dummy"));
    }

    @Override
    public void connect() {
        this.connected = true;
    }
}

