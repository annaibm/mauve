/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Logger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class PR35974
implements Testlet {
    private static final boolean DEBUG = false;
    private static Logger parentLogger = Logger.getLogger("new caprica event logger");
    private TestHarness harness = null;
    static volatile boolean fighting = true;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        HarnessHandler handler = new HarnessHandler();
        LoggerThread galactica = new LoggerThread("Galactica", handler);
        LoggerThread cylonBasestar1 = new LoggerThread("Cylon Basestar #1", handler);
        LoggerThread cylonBasestar2 = new LoggerThread("Cylon Basestar #2", handler);
        LoggerThread cylonBasestar3 = new LoggerThread("Cylon Basestar #3", handler);
        galactica.start();
        cylonBasestar1.start();
        cylonBasestar2.start();
        cylonBasestar3.start();
        BattlestarPegasusThread pegasus = new BattlestarPegasusThread();
        pegasus.start();
    }

    private static class LoggerThread
    extends Thread {
        private static Logger brokenLogger = null;
        private HarnessHandler handler = null;

        public LoggerThread(String name2, HarnessHandler handler) {
            super(name2);
            super.setDaemon(true);
            this.handler = handler;
        }

        @Override
        public void run() {
            parentLogger.log(Level.INFO, this.getName() + " did the jump into new caprica orbit ");
            while (fighting) {
                brokenLogger = Logger.getLogger(this.getName());
                brokenLogger.setLevel(Level.OFF);
                brokenLogger.addHandler(this.handler);
                brokenLogger.log(Level.INFO, this.getName() + " fires");
            }
            parentLogger.log(Level.INFO, this.getName() + " jumps");
            this.handler.success();
        }
    }

    private static class BattlestarPegasusThread
    extends Thread {
        private long startTime = System.currentTimeMillis();

        public BattlestarPegasusThread() {
            super("Pegasus to the rescue...");
        }

        @Override
        public void run() {
            parentLogger.log(Level.INFO, this.getName());
            long stopTime = System.currentTimeMillis();
            while (stopTime - this.startTime < 30000L) {
                stopTime = System.currentTimeMillis();
            }
            fighting = false;
            parentLogger.log(Level.INFO, "Pegasus destroyed...");
        }
    }

    private class HarnessHandler
    extends Handler {
        private HarnessHandler() {
        }

        @Override
        public void close() throws SecurityException {
        }

        @Override
        public void flush() {
        }

        public void success() {
            PR35974.this.harness.check(true, Thread.currentThread().getName());
        }

        @Override
        public void publish(LogRecord record) {
        }
    }
}

