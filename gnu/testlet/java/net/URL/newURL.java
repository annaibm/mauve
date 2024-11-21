/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URL;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.MalformedURLException;
import java.net.URL;

public class newURL
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.check(null, "jar:http://www.kaffe.org/foo/bar.jar!/float/boat", "jar:http://www.kaffe.org/foo/bar.jar!/float/boat");
        this.check(null, "http://www.kaffe.org", "http://www.kaffe.org");
        this.check(null, "http://www.kaffe.org:8080#ref", "http://www.kaffe.org:8080#ref");
        this.check("http://www.kaffe.org", "foo/bar", "http://www.kaffe.org/foo/bar");
        this.check("http://www.kaffe.org/foo/bar#baz", "jan/far", "http://www.kaffe.org/foo/jan/far");
        this.check("http://www.kaffe.org/foo/bar", "/jan/far", "http://www.kaffe.org/jan/far");
        this.check("http://www.kaffe.org/foo/bar", "", "http://www.kaffe.org/foo/bar");
        this.check(null, "foo/bar", null);
        this.check("file:/foo/bar", "barf#jow", "file:/foo/barf#jow");
        this.check("file:/foo/bar#fly", "jabawaba", "file:/foo/jabawaba");
        this.check(null, "jar:file:/usr/local/share/kaffe/Klasses.jar!/kaffe/lang/unicode.tbl", "jar:file:/usr/local/share/kaffe/Klasses.jar!/kaffe/lang/unicode.tbl");
        this.check(null, "jar:http://www.kaffe.org/foo/bar.jar", null);
        this.check("jar:http://www.kaffe.org/foo/bar.jar!/path/name", "float/boat", "jar:http://www.kaffe.org/foo/bar.jar!/path/float/boat");
        this.check("jar:http://www.kaffe.org/foo/bar.jar!/", "float/boat", "jar:http://www.kaffe.org/foo/bar.jar!/float/boat");
        this.check("jar:http://www.kaffe.org/foo/bar.jar!/path/name", "/float/boat", "jar:http://www.kaffe.org/foo/bar.jar!/float/boat");
        this.check("jar:http://www.kaffe.org/foo/bar.jar!/", "/float/boat", "jar:http://www.kaffe.org/foo/bar.jar!/float/boat");
        this.check("jar:http://www.kaffe.org/foo/bar.jar!/float", "#boat", "jar:http://www.kaffe.org/foo/bar.jar!/float#boat");
        this.check(null, "http://www.kaffe.org:99999/foo/bar", "http://www.kaffe.org:99999/foo/bar");
        this.check(null, "jar:abc!/eat/me", null);
        URL u = this.check(null, "http://anonymous:anonymous@host/", "http://anonymous:anonymous@host/");
        harness.check(u.getHost(), (Object)"host");
        harness.check(u.getUserInfo(), (Object)"anonymous:anonymous");
    }

    private URL check(String context, String url, String string) {
        URL c;
        this.harness.checkPoint(context + " + " + url + " = " + string);
        if (context != null) {
            try {
                c = new URL(context);
            }
            catch (MalformedURLException mue) {
                this.harness.debug(mue);
                this.harness.check(false);
                return null;
            }
        } else {
            c = null;
        }
        try {
            URL u = new URL(c, url);
            this.harness.check(u.toString(), (Object)string);
            return u;
        }
        catch (MalformedURLException mue) {
            boolean expected;
            boolean bl = expected = string == null;
            if (!expected) {
                this.harness.debug(mue);
            }
            this.harness.check(expected);
            return null;
        }
    }
}

