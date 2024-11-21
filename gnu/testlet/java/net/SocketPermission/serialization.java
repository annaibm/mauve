/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.SocketPermission;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketPermission;

public class serialization
implements Testlet {
    private String[] hosts = new String[]{"", "localhost", "example.com", "*.com", "209.132.177.50", "[FEDC:BA98:7654:3210:FEDC:BA98:7654:3210]", "[3ffe:2a00:100:7031::1]", "[::192.9.5.5]"};
    private String[] ports = new String[]{"", ":", ":80", ":-80", ":80-", ":70-90", ":800000", ":700000-900000"};
    private static String[] actions = new String[]{"accept", "connect", "listen", "resolve"};

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("serialization checking");
        for (int i = 0; i < this.hosts.length; ++i) {
            for (int j = 0; j < this.ports.length; ++j) {
                for (int k = 1; k < 1 << actions.length; ++k) {
                    SocketPermission p1 = new SocketPermission(this.hosts[i] + this.ports[j], serialization.makeActions(k));
                    SocketPermission p2 = null;
                    try {
                        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                        ObjectOutputStream out = new ObjectOutputStream(buffer);
                        out.writeObject(p1);
                        out.close();
                        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
                        p2 = (SocketPermission)in.readObject();
                        in.close();
                    }
                    catch (Exception e) {
                        harness.debug(e);
                    }
                    harness.check(p1.equals(p2));
                }
            }
        }
    }

    private static String makeActions(int mask) {
        String result = "";
        for (int i = 0; i < actions.length; ++i) {
            if ((mask & 1 << i) == 0) continue;
            if (result.length() > 0) {
                result = result + ",";
            }
            result = result + actions[i];
        }
        return result;
    }
}

