/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.HttpURLConnection;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class requestPropertiesTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test_DefaultProperties(harness);
        this.test_Properties(harness);
        this.test_LowerUpperCaseProperties(harness);
    }

    public void test_DefaultProperties(TestHarness h) {
        h.checkPoint("Default properties");
        URLConnection.setDefaultRequestProperty("Key", "Value");
        h.check(URLConnection.getDefaultRequestProperty("Key"), null);
    }

    public void test_Properties(TestHarness h) {
        try {
            URL url = new URL("http://localhost:8080/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            h.checkPoint("Standard properties tests");
            h.check(conn.getRequestProperty("Key") == null);
            conn.setRequestProperty("Key", "value");
            h.check(conn.getRequestProperty("Key").equals("value"));
            conn.setRequestProperty("Key", "value2");
            h.check(conn.getRequestProperty("Key").equals("value2"));
            conn.addRequestProperty("Anotherkey", "value");
            conn.addRequestProperty("Anotherkey", "value2");
            h.check(conn.getRequestProperty("Anotherkey").equals("value2"));
            h.checkPoint("Map properties tests");
            Map<String, List<String>> props = conn.getRequestProperties();
            h.check(props.size(), 2);
            List<String> obj = props.get("Anotherkey");
            if (obj instanceof List) {
                h.check(true);
                List<String> list2 = obj;
                h.check(list2.size(), 2);
                h.check(list2.get(0), (Object)"value2");
            } else {
                h.check(false);
            }
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
        catch (Exception e) {
            h.debug("Unexpected Exception");
            h.debug(e);
        }
    }

    public void test_LowerUpperCaseProperties(TestHarness h) {
        try {
            URL url = new URL("http://localhost:8080/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            h.checkPoint("LowerUpperCase request properties tests");
            conn.addRequestProperty("Key", "value");
            h.check(conn.getRequestProperty("key").equals("value"));
            conn.setRequestProperty("key", "value2");
            h.check(conn.getRequestProperty("key").equals("value2"));
            conn.addRequestProperty("Anotherkey", "value");
            conn.addRequestProperty("anotherkey", "value2");
            conn.addRequestProperty("anotherkey", "value3");
            h.check(conn.getRequestProperty("Anotherkey").equals("value3"));
            Map<String, List<String>> props = conn.getRequestProperties();
            h.check(props.size(), 3);
            List<String> l = props.get("anotherkey");
            h.check(l.size(), 2);
            h.check(l.get(0).equals("value3"));
            l = props.get("Key");
            h.check(l.size(), 1);
            h.check(l.get(0).equals("value2"));
            conn.setRequestProperty("anotherkey", "XXXX");
            h.check(conn.getRequestProperty("Anotherkey").equals("XXXX"));
            props = conn.getRequestProperties();
            l = props.get("anotherkey");
            h.check(l.get(1).equals("value2"));
        }
        catch (IOException e) {
            h.debug("Unexpected IOException");
            h.debug(e);
        }
        catch (Exception e) {
            h.debug("Unexpected Exception");
            h.debug(e);
        }
    }
}

