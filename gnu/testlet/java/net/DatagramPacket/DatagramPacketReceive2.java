/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.DatagramPacket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class DatagramPacketReceive2
implements Testlet {
    protected static TestHarness harness;

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        new UDPTest2();
    }

    class UDPTest2 {
        static final String TESTNAME = "DatagramPacket receive Test B";
        DatagramSocket localUdpSock;
        DatagramSocket localUdpSock2;
        protected DatagramPacket receivePacket;
        protected byte[] receiveBuf = new byte[1000];

        public UDPTest2() {
            try {
                this.start();
            }
            catch (Exception ex) {
                harness.fail("DatagramPacket receive Test B " + ex);
            }
        }

        void start() throws Exception {
            this.localUdpSock = new DatagramSocket(4569);
            this.localUdpSock2 = new DatagramSocket(4570);
            Thread sendThread = new Thread(new Runnable(){

                @Override
                public void run() {
                    try {
                        UDPTest2.this.sendLoop();
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
            InetSocketAddress toSocketAddr = new InetSocketAddress("127.0.0.1", 4569);
            for (int count = 0; count < 40; ++count) {
                String s1 = "Hello World 1234567890 ++++++++++++++";
                byte[] ba1 = s1.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(ba1, ba1.length, toSocketAddr);
                this.localUdpSock2.send(sendPacket);
                String s2 = "World Hello 0987654321";
                byte[] ba2 = s2.getBytes();
                sendPacket = new DatagramPacket(ba2, ba2.length, toSocketAddr);
                this.localUdpSock2.send(sendPacket);
                Thread.sleep(3L);
            }
        }

        void receiveLoop() throws Exception {
            int errorCount = 0;
            this.receivePacket = new DatagramPacket(this.receiveBuf, this.receiveBuf.length);
            for (int i = 0; i < 3; ++i) {
                harness.debug("DatagramPacket receive Test B switch=" + i);
                for (int j = 0; j < 10; ++j) {
                    try {
                        switch (i) {
                            case 0: {
                                break;
                            }
                            case 1: {
                                this.receivePacket.setLength(30);
                                break;
                            }
                            case 2: {
                                this.receivePacket.setLength(0);
                            }
                        }
                        this.localUdpSock.receive(this.receivePacket);
                        Thread.sleep(50L);
                        int reportedLength = this.receivePacket.getLength();
                        String s = new String(this.receiveBuf, 0, reportedLength);
                        String message = "got packet:" + s + " length=" + this.receivePacket.getLength();
                        switch (i) {
                            case 0: {
                                if (reportedLength == 37 || reportedLength == 22) break;
                                harness.debug(message + " bad getLength=" + reportedLength + " - should be 22 or 37.");
                                ++errorCount;
                                break;
                            }
                            case 1: {
                                if (reportedLength == 30 || reportedLength == 22) break;
                                harness.debug(message + " bad getLength=" + reportedLength + " - should be 22 or 30.");
                                ++errorCount;
                                break;
                            }
                            case 2: {
                                if (reportedLength == 0) break;
                                harness.debug(message + " bad getLength=" + reportedLength + " - should be 0.");
                                ++errorCount;
                            }
                        }
                        continue;
                    }
                    catch (Exception ex) {
                        harness.fail("DatagramPacket receive Test BException in read Loop " + ex);
                    }
                }
            }
            harness.check(errorCount == 0, "DatagramPacket receive Test B errorCount=" + errorCount);
        }
    }
}

