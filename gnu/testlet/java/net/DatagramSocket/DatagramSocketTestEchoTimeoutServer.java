/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.DatagramSocket;

import gnu.testlet.TestHarness;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class DatagramSocketTestEchoTimeoutServer
extends Thread {
    protected static TestHarness harness;

    DatagramSocketTestEchoTimeoutServer() {
    }

    @Override
    public void run() {
        try {
            DatagramSocket sock = new DatagramSocket(8001);
            byte[] inbuf = new byte[10];
            DatagramPacket request = new DatagramPacket(inbuf, inbuf.length);
            try {
                sock.receive(request);
                DatagramPacket pack = new DatagramPacket(inbuf, 10, InetAddress.getLocalHost(), request.getPort());
                sock.send(pack);
            }
            catch (IOException e) {
                System.out.println("Error : run failed with IOException ");
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            System.out.println("Error : run failed with exception ");
            e.printStackTrace();
        }
    }
}

