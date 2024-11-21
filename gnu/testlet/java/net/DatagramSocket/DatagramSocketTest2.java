/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.DatagramSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSocketTest2
implements Testlet {
    static final int INVALID_PORT = -1;
    static final int ECHO_PORT = 7;
    static final int GOOD_PORT = 37777;
    static final int MAX_PORT = 65535;
    protected static TestHarness harness;
    public InetAddress ia;
    public byte[] buf = new byte[10];

    public DatagramSocketTest2() throws Exception {
        this.ia = InetAddress.getLocalHost();
    }

    private void errormsg(String m, int num, boolean flag, String e) {
        if (e != null) {
            if (flag) {
                harness.fail(m + ": test " + num + " - Should throw " + e);
            } else {
                harness.fail(m + ": test " + num + " - Should NOT throw " + e);
            }
        } else {
            harness.fail(m + ": test " + num + " - Should NOT throw any Exception");
        }
    }

    public void invalid_port() {
        DatagramSocket sock;
        harness.checkPoint("invalid_port");
        try {
            sock = new DatagramSocket(-1);
            this.errormsg("invalid_port", 2, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (IOException e) {
            this.errormsg("invalid_port", 2, false, "IOException");
        }
        try {
            sock = new DatagramSocket(65536);
            this.errormsg("invalid_port", 3, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (IOException e) {
            this.errormsg("invalid_port", 3, false, "IOException");
        }
    }

    public void invalid_addr() {
        harness.checkPoint("invalid_addr");
        DatagramSocket sock = null;
        try {
            sock = new DatagramSocket(37777, null);
            harness.check(true);
        }
        catch (NullPointerException e) {
            this.errormsg("invalid_addr", 1, false, "NullPointerException");
        }
        catch (IOException e) {
            this.errormsg("invalid_addr", 1, false, "IOException");
        }
        if (sock != null) {
            sock.close();
        }
    }

    public void invalid_receive_data() {
        DatagramPacket pkt;
        harness.checkPoint("invalid_receive_data");
        DatagramSocket sock = null;
        try {
            sock = new DatagramSocket(37777, this.ia);
            harness.check(true);
        }
        catch (Exception e) {
            this.errormsg("invalid_receive_data", 1, false, "Exception");
            e.printStackTrace();
            return;
        }
        try {
            sock.receive(null);
            this.errormsg("invalid_receive_data", 2, true, "NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        catch (IOException e) {
            this.errormsg("invalid_receive_data", 2, false, "IOException");
        }
        try {
            pkt = new DatagramPacket(this.buf, this.buf.length);
            pkt.setData(null);
            sock.receive(pkt);
            this.errormsg("invalid_send_data", 3, true, "NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        catch (IOException e) {
            this.errormsg("invalid_send_data", 3, false, "IOException");
        }
        try {
            pkt = new DatagramPacket(this.buf, -1);
            this.errormsg("invalid_receive_data", 4, true, "IOException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false, "Expected IllegalArgumentException");
        }
        sock.close();
    }

    public void invalid_send_addr() {
        harness.checkPoint("invalid_send_addr");
        DatagramSocket sock = null;
        try {
            sock = new DatagramSocket(37777, this.ia);
            harness.check(true);
        }
        catch (Exception e) {
            this.errormsg("invalid_send_addr", 1, false, "Exception");
            return;
        }
        try {
            DatagramPacket pkt = new DatagramPacket(this.buf, this.buf.length, null, 7);
            sock.send(pkt);
            this.errormsg("invalid_send_addr", 2, true, "NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        catch (IOException e) {
            this.errormsg("invalid_send_addr", 2, false, "IOException");
        }
        sock.close();
    }

    public void invalid_send_port() {
        harness.checkPoint("invalid_send_port");
        DatagramSocket sock = null;
        try {
            sock = new DatagramSocket(37777, this.ia);
            harness.check(true);
        }
        catch (Exception e) {
            this.errormsg("invalid_send_port", 1, false, "Exception");
            return;
        }
        try {
            DatagramPacket pkt = new DatagramPacket(this.buf, this.buf.length, this.ia, 0);
            sock.send(pkt);
            this.errormsg("invalid_send_port", 2, true, "IOException");
        }
        catch (IOException e) {
            harness.check(true);
        }
        sock.close();
    }

    public void invalid_send_data() {
        DatagramPacket pkt;
        harness.checkPoint("invalid_send_data");
        DatagramSocket sock = null;
        try {
            sock = new DatagramSocket(37777, this.ia);
            harness.check(true);
        }
        catch (Exception e) {
            this.errormsg("invalid_send_data", 1, false, "Exception");
            return;
        }
        try {
            sock.send(null);
            this.errormsg("invalid_send_data", 2, true, "NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        catch (IOException e) {
            this.errormsg("invalid_send_data", 2, false, "IOException");
        }
        try {
            pkt = new DatagramPacket(this.buf, this.buf.length, this.ia, 7);
            pkt.setData(null);
            sock.send(pkt);
            this.errormsg("invalid_send_data", 3, true, "NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        catch (IOException e) {
            this.errormsg("invalid_send_data", 3, false, "IOException");
        }
        try {
            pkt = new DatagramPacket(this.buf, -1, this.ia, 7);
            this.errormsg("invalid_send_data", 4, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            pkt = new DatagramPacket(this.buf, 0, this.ia, 7);
            sock.send(pkt);
            harness.check(true);
        }
        catch (IOException e) {
            this.errormsg("invalid_send_data", 5, false, "IOException");
        }
        sock.close();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }

    public void testall() {
        DatagramSocketTest2 m = null;
        try {
            m = new DatagramSocketTest2();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        m.invalid_port();
        m.invalid_addr();
        m.invalid_receive_data();
        m.invalid_send_addr();
        m.invalid_send_port();
        m.invalid_send_data();
    }
}

