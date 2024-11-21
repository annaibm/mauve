/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.MulticastSocket;

import gnu.testlet.TestHarness;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

class MulticastServer
extends Thread {
    protected static TestHarness harness;
    private int serverPort;
    private MulticastSocket socket;
    private InetAddress address;
    private DatagramPacket packet;

    public MulticastServer(int nPort) {
        try {
            this.serverPort = nPort;
            this.socket = new MulticastSocket();
            this.address = InetAddress.getByName("230.0.0.1");
        }
        catch (Exception e) {
            System.out.println("Server constructor");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String[] cmd = new String[]{"hello", "there", "this is", "multicast", "bye"};
            for (int i = 0; i < 5; ++i) {
                this.packet = new DatagramPacket(cmd[i].getBytes(), cmd[i].length(), this.address, this.serverPort);
                this.socket.send(this.packet);
            }
            this.socket.close();
        }
        catch (Exception e) {
            System.out.println("Server run failed");
            e.printStackTrace();
        }
    }
}

