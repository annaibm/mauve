/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.DatagramPacket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class DatagramPacketTest2
implements Testlet {
    static final int INVALID_PORT = -1;
    static final int PORT = 7;
    static final int MAX_PORT = 65535;
    protected static TestHarness harness;
    public InetAddress ia;
    public byte[] buf = new byte[10];

    public DatagramPacketTest2() throws Exception {
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

    public void invalid_buf() {
        DatagramPacket reply;
        DatagramPacket request;
        try {
            request = new DatagramPacket(null, 10, this.ia, 7);
            this.errormsg("invalid_buf", 1, true, "NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            request = new DatagramPacket(this.buf, this.buf.length, this.ia, 7);
            request.setData(null);
            this.errormsg("invalid_buf", 2, true, "NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            reply = new DatagramPacket(null, 10);
            this.errormsg("invalid_buf", 3, true, "NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            reply = new DatagramPacket(this.buf, this.buf.length);
            reply.setData(null);
            this.errormsg("invalid_buf", 4, true, "NullPointerException");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    public void invalid_buflen() {
        DatagramPacket reply;
        DatagramPacket request;
        try {
            request = new DatagramPacket(this.buf, -1, this.ia, 7);
            this.errormsg("invalid_buflen", 1, false, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            request = new DatagramPacket(this.buf, 0, this.ia, 7);
            harness.check(true);
        }
        catch (Exception e) {
            this.errormsg("invalid_buflen", 2, true, null);
            e.printStackTrace();
        }
        try {
            reply = new DatagramPacket(this.buf, -1);
            this.errormsg("invalid_buflen", 3, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            reply = new DatagramPacket(this.buf, 0);
            harness.check(true);
        }
        catch (Exception e) {
            this.errormsg("invalid_buflen", 4, true, null);
            e.printStackTrace();
        }
        try {
            request = new DatagramPacket(this.buf, this.buf.length + 1, this.ia, 7);
            this.errormsg("invalid_buflen", 5, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            reply = new DatagramPacket(this.buf, this.buf.length + 1);
            this.errormsg("invalid_buflen", 6, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            reply = new DatagramPacket(this.buf, this.buf.length);
            reply.setLength(this.buf.length + 1);
            this.errormsg("invalid_buflen", 7, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    public void invalid_port() {
        DatagramPacket reply;
        DatagramPacket request;
        try {
            request = new DatagramPacket(this.buf, 10, this.ia, -1);
            this.errormsg("invalid_port", 1, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            request = new DatagramPacket(this.buf, 10, this.ia, 7);
            request.setPort(-1);
            this.errormsg("invalid_port", 2, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            DatagramPacket request2 = new DatagramPacket(this.buf, 10, this.ia, 65536);
            this.errormsg("invalid_port", 3, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            reply = new DatagramPacket(this.buf, 10);
            reply.setPort(-1);
            this.errormsg("invalid_port", 4, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            reply = new DatagramPacket(this.buf, 10);
            reply.setPort(65536);
            this.errormsg("invalid_port", 5, true, "IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }

    public void testall() {
        DatagramPacketTest2 m = null;
        try {
            m = new DatagramPacketTest2();
            harness.check(true);
        }
        catch (Exception e) {
            harness.fail("DatagramPacketTest2 constructor");
            e.printStackTrace();
            System.exit(1);
        }
        m.invalid_buf();
        m.invalid_buflen();
        m.invalid_port();
    }
}

