/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.MulticastSocket;

import gnu.testlet.TestHarness;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

class MulticastClient
extends Thread {
    protected static TestHarness harness;
    private int clientPort;
    private MulticastSocket socket;
    private InetAddress address;
    private DatagramPacket packet;

    public MulticastClient() {
        try {
            this.socket = new MulticastSocket(4446);
            this.address = InetAddress.getByName("230.0.0.1");
            this.socket.joinGroup(this.address);
            this.clientPort = this.socket.getLocalPort();
        }
        catch (Exception e) {
            System.out.println("Client constructor failed");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String received;
            do {
                byte[] buf = new byte[256];
                this.packet = new DatagramPacket(buf, buf.length);
                this.socket.receive(this.packet);
            } while (!(received = new String(this.packet.getData())).startsWith("bye"));
            this.socket.leaveGroup(this.address);
            this.socket.close();
        }
        catch (Exception e) {
            System.out.println("Client run failed");
            e.printStackTrace();
        }
    }

    public int getPort() {
        return this.clientPort;
    }
}

