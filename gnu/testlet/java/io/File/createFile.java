/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.File;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

public class createFile
implements Testlet {
    static int N_FILES = 100;
    static int N_THREADS = 10;
    String[][] returned;
    TestHarness harness;
    int completed;
    File tempDir;

    @Override
    public void test(TestHarness a_harness) {
        try {
            this.harness = a_harness;
            this.tempDir = new File(this.harness.getTempDirectory());
            this.returned = new String[N_THREADS][];
            this.completed = 0;
            for (int thread2 = 0; thread2 < N_THREADS; ++thread2) {
                new tester(thread2).start();
            }
            int n = 0;
            while (this.completed < N_THREADS && n++ < 600) {
                try {
                    Thread.sleep(100L);
                }
                catch (InterruptedException interruptedException) {}
            }
            if (this.completed < N_THREADS) {
                this.harness.fail("Failed in 60 seconds. Probably hangs.");
            }
            TreeSet<String> allReturned = new TreeSet<String>();
            for (int thread3 = 0; thread3 < N_THREADS; ++thread3) {
                for (int file = 0; file < N_FILES; ++file) {
                    String x = this.returned[thread3][file];
                    if (allReturned.contains(x)) {
                        this.harness.fail("Multiple occurence of " + x);
                        return;
                    }
                    allReturned.add(x);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    class tester
    extends Thread {
        int thread_number;

        tester(int a_thread_number) {
            this.thread_number = a_thread_number;
            createFile.this.returned[this.thread_number] = new String[N_FILES];
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            try {
                for (int file = 0; file < N_FILES; ++file) {
                    try {
                        String s;
                        File tempFile = File.createTempFile("mauve", "cft", createFile.this.tempDir);
                        createFile.this.returned[this.thread_number][file] = s = tempFile.getAbsolutePath();
                        tempFile.delete();
                        continue;
                    }
                    catch (IOException ioex) {
                        createFile.this.harness.fail("IOException " + ioex);
                        createFile.this.completed = N_THREADS + 1;
                    }
                }
            }
            finally {
                ++createFile.this.completed;
            }
        }
    }
}

