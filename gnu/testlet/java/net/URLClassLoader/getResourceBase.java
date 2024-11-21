/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLClassLoader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public abstract class getResourceBase
implements Testlet {
    protected TestHarness harness;
    protected URLClassLoader ucl;

    protected void check(String resource, String base, boolean noncanonical) {
        String r;
        URL u = this.ucl.getResource(resource);
        this.harness.debug(u != null ? u.toString() : null);
        String sep = base.endsWith(".jar") ? "!/" : "/";
        String fullpath = base + sep + resource;
        if (u != null) {
            int i;
            String f = u.getFile();
            File file = new File(u.getFile());
            if (file.isDirectory() && fullpath.length() > 1 && fullpath.charAt(fullpath.length() - 1) != File.separator.charAt(0)) {
                fullpath = fullpath + File.separator;
            }
            if (file.isDirectory() && f.length() > 1 && f.charAt(f.length() - 1) != File.separator.charAt(0)) {
                f = f + File.separator;
            }
            r = (i = f.indexOf(fullpath)) != -1 ? f.substring(f.length() - fullpath.length()) : f;
        } else {
            r = null;
        }
        this.harness.check(r, fullpath, "URL file path ends with " + fullpath);
        u = this.ucl.getResource("no-" + resource);
        this.harness.debug(u != null ? u.toString() : null);
        this.harness.check(u == null, "no-" + resource);
        if (noncanonical) {
            String dir;
            String path;
            String name2;
            int index = resource.lastIndexOf(47);
            if (index != -1) {
                name2 = resource.substring(index + 1);
                path = resource.substring(0, index);
                index = path.lastIndexOf(47);
                path = path + '/';
                dir = index != -1 ? path.substring(index) : '/' + path;
            } else {
                path = "";
                name2 = resource;
                dir = "";
            }
            this.harness.debug(" == resource='" + resource + "'; name='" + name2 + "'; dir='" + dir + "'; path='" + path + "'");
            u = this.ucl.getResource(path + '/' + "no-" + name2);
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u == null, path + '/' + "no-" + name2);
            u = this.ucl.getResource("./" + resource);
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u != null, "./" + resource);
            u = this.ucl.getResource(path + "./" + name2);
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u != null, path + "./" + name2);
            u = this.ucl.getResource(".\\" + resource);
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u == null, "no .\\" + resource);
            if (!dir.equals("")) {
                u = this.ucl.getResource(path + ".." + dir + name2);
                this.harness.debug(u != null ? u.toString() : null);
                this.harness.check(u != null, path + ".." + dir + name2);
            }
            if (!path.equals("")) {
                u = this.ucl.getResource(path + "//" + name2);
                this.harness.debug(u != null ? u.toString() : null);
                this.harness.check(u != null, path + "//" + name2);
            }
            this.harness.debug((u = this.ucl.getResource("\\" + resource)) != null ? u.toString() : null);
            this.harness.check(u == null, "no \\" + resource);
            u = this.ucl.getResource(":" + resource);
            this.harness.debug(u != null ? u.toString() : null);
            this.harness.check(u == null, "no :" + resource);
        }
    }
}

