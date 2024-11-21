/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLConnection;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

class MyURLConnection
extends URLConnection {
    public MyURLConnection(URL u) {
        super(u);
    }

    @Override
    public void connect() throws IOException {
    }
}

