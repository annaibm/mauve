/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.channels.FileChannel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.NonReadableChannelException;
import java.nio.channels.NonWritableChannelException;

public class lock
implements Testlet,
Runnable {
    DataInputStream dis;
    DataOutputStream dos;
    BufferedReader br;
    TestHarness harness;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        String filename = harness.getTempDirectory() + File.separator + "mauvelock";
        File file = new File(filename);
        FileOutputStream fos = null;
        FileInputStream fis = null;
        RandomAccessFile raf = null;
        try {
            int i;
            file.delete();
            file.createNewFile();
            fos = new FileOutputStream(file);
            byte[] bs = new byte[256];
            for (i = 0; i < 256; ++i) {
                bs[i] = (byte)i;
            }
            for (i = 0; i < 20; ++i) {
                fos.write(bs);
            }
            fos.close();
            fos = null;
        }
        catch (IOException ioe) {
            harness.check(false, ioe.toString());
            harness.debug(ioe);
            return;
        }
        Process p = null;
        try {
            String execvm = System.getProperty("mauve.vmexec");
            if (execvm == null || execvm.equals("")) {
                harness.check(false, "mauve.vmexec system property NOT SET!");
            } else {
                String cmd = execvm + " " + this.getClass().getName();
                p = Runtime.getRuntime().exec(cmd);
                this.dis = new DataInputStream(p.getInputStream());
                this.dos = new DataOutputStream(p.getOutputStream());
                this.br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                Thread t = new Thread(this);
                t.setDaemon(true);
                t.start();
                this.dos.writeUTF(filename);
                this.dos.flush();
                harness.debug(this.dis.readUTF());
            }
        }
        catch (IOException ioe) {
            p = null;
            harness.check(false, ioe.toString());
            harness.debug(ioe);
        }
        try {
            fos = new FileOutputStream(file);
            FileChannel channel = fos.getChannel();
            this.testChannelLock("FileOutputStream", channel, false, true);
            fos.close();
            fos = null;
            fis = new FileInputStream(file);
            channel = fis.getChannel();
            this.testChannelLock("FileInputStream", channel, true, false);
            fis.close();
            fis = null;
            raf = new RandomAccessFile(file, "r");
            channel = raf.getChannel();
            this.testChannelLock("RandomAccessFile(r)", channel, true, false);
            raf.close();
            raf = null;
            raf = new RandomAccessFile(file, "rw");
            channel = raf.getChannel();
            this.testChannelLock("RandomAccessFile(rw)", channel, true, true);
            raf.close();
            raf = null;
        }
        catch (IOException ioe) {
            harness.debug(ioe);
            harness.check(false, ioe.toString());
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException ioe) {
                    harness.debug(ioe);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                }
                catch (IOException ioe) {
                    harness.debug(ioe);
                }
            }
            if (raf != null) {
                try {
                    raf.close();
                }
                catch (IOException ioe) {
                    harness.debug(ioe);
                }
            }
            try {
                if (p != null) {
                    this.dos.writeUTF("quit");
                    this.dos.flush();
                    p.destroy();
                    p.waitFor();
                }
            }
            catch (IOException ioe) {
                harness.debug(ioe);
            }
            catch (InterruptedException ie) {
                harness.debug(ie);
            }
            harness.check(file.delete(), "cleanup " + file);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void testChannelLock(String what, FileChannel channel, boolean read2, boolean write2) {
        block42: {
            FileLock lock2 = null;
            try {
                boolean illegal;
                this.harness.checkPoint(what + " lock()");
                try {
                    lock2 = channel.lock();
                    illegal = false;
                }
                catch (NonWritableChannelException nrca) {
                    illegal = true;
                }
                this.harness.check(illegal, !write2);
                this.harness.check(illegal || lock2 != null);
                if (lock2 != null) {
                    try {
                        this.testLock(what, channel, lock2, 0L, Long.MAX_VALUE, false);
                    }
                    finally {
                        lock2.release();
                        this.harness.check(lock2.isValid(), false);
                        lock2 = null;
                    }
                }
                this.harness.checkPoint(what + " tryLock()");
                try {
                    lock2 = channel.tryLock();
                    illegal = false;
                }
                catch (NonWritableChannelException nwce) {
                    illegal = true;
                }
                this.harness.check(illegal, !write2);
                this.harness.check(illegal || lock2 != null);
                if (lock2 != null) {
                    try {
                        this.testLock(what, channel, lock2, 0L, Long.MAX_VALUE, false);
                    }
                    finally {
                        lock2.release();
                        this.harness.check(lock2.isValid(), false);
                        lock2 = null;
                    }
                }
                this.harness.checkPoint(what + " lock(129, 2050, false)");
                try {
                    lock2 = channel.lock(129L, 2050L, false);
                    illegal = false;
                }
                catch (NonWritableChannelException nwce) {
                    illegal = true;
                }
                this.harness.check(illegal, !write2);
                this.harness.check(illegal || lock2 != null);
                if (lock2 != null) {
                    try {
                        this.testLock(what, channel, lock2, 129L, 2050L, false);
                    }
                    finally {
                        lock2.release();
                        this.harness.check(lock2.isValid(), false);
                        lock2 = null;
                    }
                }
                this.harness.checkPoint(what + " tryLock(129, 2050, false)");
                try {
                    lock2 = channel.tryLock(129L, 2050L, false);
                    illegal = false;
                }
                catch (NonWritableChannelException nwce) {
                    illegal = true;
                }
                this.harness.check(illegal, !write2);
                this.harness.check(illegal || lock2 != null);
                if (lock2 != null) {
                    try {
                        this.testLock(what, channel, lock2, 129L, 2050L, false);
                    }
                    finally {
                        lock2.release();
                        this.harness.check(lock2.isValid(), false);
                        lock2 = null;
                    }
                }
                this.harness.checkPoint(what + " lock(129, 2050, true)");
                try {
                    lock2 = channel.lock(129L, 2050L, true);
                    illegal = false;
                }
                catch (NonReadableChannelException nrce) {
                    illegal = true;
                }
                this.harness.check(illegal, !read2);
                this.harness.check(illegal || lock2 != null);
                if (lock2 != null) {
                    try {
                        this.testLock(what, channel, lock2, 129L, 2050L, true);
                    }
                    finally {
                        lock2.release();
                        this.harness.check(lock2.isValid(), false);
                        lock2 = null;
                    }
                }
                this.harness.checkPoint(what + " tryLock(129, 2050, true)");
                try {
                    lock2 = channel.tryLock(129L, 2050L, true);
                    illegal = false;
                }
                catch (NonReadableChannelException nrce) {
                    illegal = true;
                }
                this.harness.check(illegal, !read2);
                this.harness.check(illegal || lock2 != null);
                if (lock2 == null) break block42;
                try {
                    this.testLock(what, channel, lock2, 129L, 2050L, true);
                }
                finally {
                    lock2.release();
                    this.harness.check(lock2.isValid(), false);
                    lock2 = null;
                }
            }
            catch (IOException ioe) {
                this.harness.debug(ioe);
                this.harness.check(false);
            }
        }
    }

    private void testLock(String what, FileChannel channel, FileLock lock2, long position2, long size2, boolean shared) throws IOException {
        this.harness.checkPoint(what + ": " + lock2);
        this.harness.check(lock2.channel(), channel);
        this.harness.check(lock2.position(), position2);
        this.harness.check(lock2.size(), size2);
        this.harness.check(lock2.isShared(), shared);
        this.harness.check(lock2.isValid(), true);
        this.harness.check(lock2.overlaps(0L, Long.MAX_VALUE), true);
        this.harness.check(lock2.overlaps(position2, size2), true);
        if (position2 < Long.MAX_VALUE) {
            this.harness.check(lock2.overlaps(0L, position2 + 1L), true);
        }
        if (position2 > 0L) {
            this.harness.check(lock2.overlaps(0L, 1L), false);
            this.harness.check(lock2.overlaps(0L, position2 - 1L), false);
        }
        if (size2 < Long.MAX_VALUE && position2 > 0L) {
            this.harness.check(lock2.overlaps(position2 - 1L, size2 + 1L), true);
        }
        if (size2 > 1L) {
            this.harness.check(lock2.overlaps(position2, size2 - 1L), true);
        }
        if (this.dos != null) {
            this.dos.writeUTF("lock");
            this.harness.debug("Sending: " + position2 + ", " + size2 + " (" + shared + ")");
            this.harness.debug("lock: " + lock2);
            this.dos.writeLong(position2);
            this.dos.writeLong(size2);
            this.dos.writeBoolean(shared);
            this.dos.flush();
            this.harness.debug("EXTERNAL: " + this.dis.readUTF());
            this.harness.check(this.dis.readBoolean(), what + " external " + lock2);
        }
    }

    @Override
    public void run() {
        try {
            String line = this.br.readLine();
            while (line != null) {
                this.harness.debug(" ex: " + line);
                line = this.br.readLine();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] args) throws Exception {
        DataInputStream dis = new DataInputStream(System.in);
        DataOutputStream dos = new DataOutputStream(System.out);
        String file = dis.readUTF();
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        FileChannel channel = raf.getChannel();
        dos.writeUTF("Opened file: " + file);
        dos.flush();
        try {
            String command = dis.readUTF();
            while (command != null && !command.equals("quit")) {
                long position2 = dis.readLong();
                long size2 = dis.readLong();
                boolean shared = dis.readBoolean();
                System.err.println("Recv: " + position2 + ", " + size2 + " (" + shared + ")");
                String what = "lock[" + position2 + "," + size2 + "," + shared + "]";
                String message = "X";
                boolean result = true;
                FileLock lock2 = null;
                try {
                    lock2 = channel.tryLock(position2, size2, false);
                    if (lock2 != null) {
                        result = false;
                        message = "Got lock: " + lock2;
                    }
                }
                finally {
                    try {
                        lock2.release();
                        lock2 = null;
                    }
                    catch (Throwable throwable) {}
                }
                if (result && shared) {
                    try {
                        lock2 = channel.tryLock(position2, size2, true);
                        if (lock2 == null) {
                            result = false;
                            message = "Couldn't get shared lock";
                        }
                    }
                    finally {
                        try {
                            lock2.release();
                            lock2 = null;
                        }
                        catch (Throwable throwable) {}
                    }
                }
                if (result) {
                    dos.writeUTF("OK: " + what);
                } else {
                    dos.writeUTF("Failed: " + what + ": " + message);
                }
                dos.writeBoolean(result);
                dos.flush();
                command = dis.readUTF();
            }
        }
        catch (Throwable t) {
            dos.writeUTF("External error: " + t.toString());
            t.printStackTrace();
            System.err.flush();
        }
    }
}

