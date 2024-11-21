/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLConnection;

import java.net.HttpURLConnection;
import java.net.URL;

class MyHttpURLConnection
extends HttpURLConnection {
    MyHttpURLConnection(URL u) {
        super(u);
    }

    @Override
    public void connect() {
    }

    @Override
    public void disconnect() {
    }

    @Override
    public boolean usingProxy() {
        return false;
    }
}

