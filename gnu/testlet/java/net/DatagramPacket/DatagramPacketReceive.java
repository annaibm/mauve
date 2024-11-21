/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.DatagramPacket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class DatagramPacketReceive
implements Testlet {
    protected static TestHarness harness;

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        new UDPTest1();
    }

    class UDPTest1 {
        static final String TESTNAME = "DatagramPacket receive Test A";
        DatagramSocket localUdpSock;
        DatagramSocket localUdpSock2;
        protected DatagramPacket receivePacket;
        protected byte[] receiveBuf = new byte[1000];

        public UDPTest1() {
            try {
                this.start();
            }
            catch (Exception ex) {
                harness.fail("DatagramPacket receive Test A " + ex);
            }
        }

        void start() throws Exception {
            this.localUdpSock = new DatagramSocket(4567);
            this.localUdpSock2 = new DatagramSocket(4568);
            Thread sendThread = new Thread(new Runnable(){

                @Override
                public void run() {
                    try {
                        UDPTest1.this.sendLoop();
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
            InetSocketAddress toSocketAddr = new InetSocketAddress("127.0.0.1", 4567);
            for (int count = 0; count < 10; ++count) {
                String s1 = "Hello World 1234567890 ++++++++++++++";
                byte[] ba1 = s1.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(ba1, ba1.length, toSocketAddr);
                this.localUdpSock2.send(sendPacket);
                String s2 = "World Hello 0987654321";
                byte[] ba2 = s2.getBytes();
                sendPacket = new DatagramPacket(ba2, ba2.length, toSocketAddr);
                this.localUdpSock2.send(sendPacket);
                Thread.sleep(10L);
            }
        }

        void receiveLoop() throws Exception {
            this.receivePacket = new DatagramPacket(this.receiveBuf, this.receiveBuf.length);
            int errorCount = 0;
            for (int count = 0; count < 10; ++count) {
                try {
                    this.localUdpSock.receive(this.receivePacket);
                    Thread.sleep(5L);
                    int reportedLength = this.receivePacket.getLength();
                    String s = new String(this.receiveBuf, 0, reportedLength);
                    String message = "packet#" + count + " got packet '" + s + "' length=" + this.receivePacket.getLength();
                    harness.debug(message);
                    if (s.startsWith("World Hello") && reportedLength == 22 || s.startsWith("Hello World") && reportedLength == 37) continue;
                    ++errorCount;
                    continue;
                }
                catch (Exception ex) {
                    harness.fail("DatagramPacket receive Test A receiveloop exception:" + ex);
                }
            }
            harness.check(errorCount == 0, "DatagramPacket receive Test A errorCount=" + errorCount);
        }
    }
}

