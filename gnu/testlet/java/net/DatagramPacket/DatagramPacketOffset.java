/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.DatagramPacket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class DatagramPacketOffset
implements Testlet {
    protected static TestHarness harness;

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        new OffsetTest();
    }

    class OffsetTest {
        static final String TESTNAME = "DatagramPacket Offset Test";
        DatagramSocket localUdpSock;
        DatagramSocket localUdpSock2;
        protected DatagramPacket receivePacket;
        protected byte[] receiveBuf = new byte[37];
        Exception sendTextEx1;
        Exception sendTextEx2;

        public OffsetTest() {
            try {
                this.start();
            }
            catch (Exception ex) {
                harness.fail("DatagramPacket Offset Test " + ex);
            }
            this.sendBadOffset();
        }

        void sendBadOffset() {
            DatagramPacket sendPacket;
            byte[] ba1;
            InetSocketAddress toSocketAddr = new InetSocketAddress("127.0.0.1", 4580);
            String s1 = "xyz Hello World 1234567890 ++++++++++++++";
            try {
                ba1 = s1.getBytes();
                sendPacket = new DatagramPacket(ba1, 4, ba1.length, toSocketAddr);
                this.localUdpSock2.send(sendPacket);
                harness.check(false, "Invalid send offset/length (4/37) test (no Exception)");
            }
            catch (Exception ex) {
                harness.check(ex instanceof IllegalArgumentException, "Invalid send offset/length (4/37) test: Exception= " + ex);
            }
            try {
                ba1 = s1.getBytes();
                sendPacket = new DatagramPacket(ba1, 40, 2, toSocketAddr);
                this.localUdpSock2.send(sendPacket);
                harness.check(false, "Invalid send offset/length (40/2) test (no Exception)");
            }
            catch (Exception ex) {
                harness.check(ex instanceof IllegalArgumentException, "Invalid send offset/length (40/2) test: Exception= " + ex);
            }
        }

        void start() throws Exception {
            this.localUdpSock = new DatagramSocket(4580);
            this.localUdpSock2 = new DatagramSocket(4581);
            Thread sendThread = new Thread(new Runnable(){

                @Override
                public void run() {
                    try {
                        OffsetTest.this.sendLoop();
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            sendThread.start();
            this.receiveLoop();
        }

        void sendLoop() throws Exception {
            InetSocketAddress toSocketAddr = new InetSocketAddress("127.0.0.1", 4580);
            for (int count = 0; count < 10; ++count) {
                String s1 = "xyz Hello World 1234567890 ++++++++++++++";
                byte[] ba1 = s1.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(ba1, 4, ba1.length - 4, toSocketAddr);
                this.localUdpSock2.send(sendPacket);
                Thread.sleep(10L);
            }
        }

        void receiveLoop() throws Exception {
            DatagramPacket packet;
            for (int i = 0; i < this.receiveBuf.length; ++i) {
                this.receiveBuf[i] = 46;
            }
            try {
                packet = this.receivePacket = new DatagramPacket(this.receiveBuf, 40, 3);
                this.localUdpSock.receive(this.receivePacket);
                harness.check(false, "Invalid receive offset/length (40/3) test failed (no Exception)");
            }
            catch (Exception ex) {
                harness.check(ex instanceof IllegalArgumentException, "Invalid receive offset/length (40/3) test: Exception= " + ex);
            }
            try {
                packet = this.receivePacket = new DatagramPacket(this.receiveBuf, 20, 20);
                this.localUdpSock.receive(this.receivePacket);
                harness.check(false, "Invalid receive offset/length (20/20) test failed (no Exception)");
            }
            catch (Exception ex) {
                harness.check(ex instanceof IllegalArgumentException, "Invalid receive offset/length (20/20) test: Exception= " + ex);
            }
            packet = this.receivePacket = new DatagramPacket(this.receiveBuf, 36, 0);
            this.localUdpSock.receive(this.receivePacket);
            harness.debug("after receive 0: byte[]='" + new String(this.receiveBuf) + "'");
            packet = this.receivePacket = new DatagramPacket(this.receiveBuf, 0, 10);
            this.localUdpSock.receive(this.receivePacket);
            harness.debug("after receive 1: byte[]='" + new String(this.receiveBuf) + "'");
            packet = this.receivePacket = new DatagramPacket(this.receiveBuf, 10, 10);
            this.localUdpSock.receive(this.receivePacket);
            harness.debug("after receive 2: byte[]='" + new String(this.receiveBuf) + "'");
            packet = this.receivePacket = new DatagramPacket(this.receiveBuf, 20, 17);
            this.localUdpSock.receive(this.receivePacket);
            harness.debug("after receive 3: byte[]='" + new String(this.receiveBuf) + "'");
            String result = new String(this.receiveBuf);
            String shouldBe = "Hello WorlHello WorlHello World 12345";
            harness.check(result.equals(shouldBe), "DatagramPacket Offset Test byte[]='" + result + "' should be='" + shouldBe + "'");
        }
    }
}

