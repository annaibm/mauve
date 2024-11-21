/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.RandomAccessFile;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.Permission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        File dir = new File(harness.getTempDirectory(), "mauve-testdir");
        harness.check(dir.mkdir() || dir.exists(), "temp directory");
        File file = new File(dir, "file");
        String path = file.getPath();
        try {
            new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {
            harness.debug(e);
            harness.check(false, "unexpected exception");
        }
        FilePermission rperm = new FilePermission(path, "read");
        FilePermission wperm = new FilePermission(path, "write");
        RuntimePermission rfdperm = new RuntimePermission("readFileDescriptor");
        RuntimePermission wfdperm = new RuntimePermission("writeFileDescriptor");
        String[] modes = new String[]{"r", "rw", "rws", "rwd"};
        TestSecurityManager sm = new TestSecurityManager(harness);
        try {
            sm.install();
            for (int i = 0; i < modes.length; ++i) {
                RandomAccessFile raf;
                Permission[] mayCheck;
                Permission[] mustCheck;
                String mode = modes[i];
                if (mode.equals("r")) {
                    mustCheck = new Permission[]{rperm};
                    mayCheck = new Permission[]{rfdperm};
                } else {
                    mustCheck = new Permission[]{rperm, wperm};
                    mayCheck = new Permission[]{rfdperm, wfdperm};
                }
                harness.checkPoint("File constructor, mode = \"" + mode + "\"");
                try {
                    sm.prepareChecks(mustCheck, mayCheck);
                    raf = new RandomAccessFile(file, mode);
                    sm.checkAllChecked();
                    if (mode == "r") {
                        this.ensureUnwritable(harness, raf);
                    }
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("String constructor, mode = \"" + mode + "\"");
                try {
                    sm.prepareChecks(mustCheck, mayCheck);
                    raf = new RandomAccessFile(path, mode);
                    sm.checkAllChecked();
                    if (mode != "r") continue;
                    this.ensureUnwritable(harness, raf);
                    continue;
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
            }
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
        finally {
            sm.uninstall();
            file.delete();
            dir.delete();
        }
    }

    private void ensureUnwritable(TestHarness harness, RandomAccessFile file) {
        harness.checkPoint("read-only checks");
        byte[] barry = new byte[]{2, 4, 2};
        try {
            for (int i = 1; i <= 14; ++i) {
                long pointer = file.getFilePointer();
                try {
                    switch (i) {
                        case 1: {
                            file.write(barry);
                            break;
                        }
                        case 2: {
                            file.write(barry, 1, 2);
                            break;
                        }
                        case 3: {
                            file.write(1);
                            break;
                        }
                        case 4: {
                            file.writeBoolean(true);
                            break;
                        }
                        case 5: {
                            file.writeByte(1);
                            break;
                        }
                        case 6: {
                            file.writeBytes("hello mum");
                            break;
                        }
                        case 7: {
                            file.writeChar(1);
                            break;
                        }
                        case 8: {
                            file.writeChars("hello mum");
                            break;
                        }
                        case 9: {
                            file.writeDouble(1.0);
                            break;
                        }
                        case 10: {
                            file.writeFloat(1.0f);
                            break;
                        }
                        case 11: {
                            file.writeInt(1);
                            break;
                        }
                        case 12: {
                            file.writeLong(1L);
                            break;
                        }
                        case 13: {
                            file.writeShort(1);
                            break;
                        }
                        case 14: {
                            file.writeUTF("hello mum");
                        }
                    }
                    harness.check(false);
                    continue;
                }
                catch (IOException e) {
                    harness.check(file.getFilePointer() == pointer);
                }
            }
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false, "unexpected IOException");
        }
    }
}

