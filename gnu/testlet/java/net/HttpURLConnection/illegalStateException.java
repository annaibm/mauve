/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.HttpURLConnection;
import java.net.URL;

public class illegalStateException
implements Testlet {
    @Override
    public void test(TestHarness h) {
        try {
            URL url = new URL("http://sources.redhat.com/mauve/testarea/index.html");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            try {
                conn.getRequestProperties();
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            try {
                conn.getRequestProperty("accept");
                h.check(true);
            }
            catch (IllegalStateException e) {
                h.check(false);
            }
            try {
                conn.setDoInput(true);
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            try {
                conn.setDoOutput(true);
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            try {
                conn.setAllowUserInteraction(true);
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            try {
                conn.setUseCaches(true);
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            try {
                conn.setIfModifiedSince(100000L);
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            try {
                conn.setRequestProperty("ssss", "dddd");
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            try {
                conn.setRequestProperty(null, "dddd");
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            catch (NullPointerException e) {
                h.check(false);
            }
            try {
                conn.addRequestProperty("ssss", "dddd");
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            try {
                conn.addRequestProperty(null, "dddd");
                h.check(false);
            }
            catch (IllegalStateException e) {
                h.check(true);
            }
            catch (NullPointerException e) {
                h.check(false);
            }
        }
        catch (Exception e) {
            h.debug(e);
            h.fail("Unexpected error: " + e.getMessage());
        }
    }
}

