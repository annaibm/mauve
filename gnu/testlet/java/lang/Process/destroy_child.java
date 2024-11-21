/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Process;

public class destroy_child {
    public static void main(String[] args) {
        try {
            System.out.println("UP");
            while (true) {
                Thread.sleep(1000L);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
    }
}

