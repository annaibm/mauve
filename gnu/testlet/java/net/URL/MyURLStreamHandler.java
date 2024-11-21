/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URL;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

class MyURLStreamHandler
extends URLStreamHandler {
    public void invoke_parseURL(URL u, String spec, int start, int limit) {
        this.parseURL(u, spec, start, limit);
    }

    public void invoke_setURL(URL u, String protocol, String host, int port, String file, String ref) {
        this.setURL(u, protocol, host, port, file, ref);
    }

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return (URLConnection)new Object();
    }
}

