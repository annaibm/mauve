/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LogManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.LogManager.TestHandler;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class readConfiguration
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Logger logger;
        LogManager manager = LogManager.getLogManager();
        harness.checkPoint("read user logging properties");
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("gnu/testlet/java/util/logging/LogManager/logging.properties");
            manager.readConfiguration(is);
            harness.check(true);
            is.close();
        }
        catch (IOException e) {
            harness.check(false);
            harness.debug(e);
        }
        Logger logger2 = logger = Logger.getLogger("TestLogger");
        logger2.setLevel(Level.FINE);
        while (logger.getParent() != null) {
            logger = logger.getParent();
        }
        Handler[] handlers = logger.getHandlers();
        harness.checkPoint("handlers is not null");
        harness.check(handlers != null);
        if (handlers != null) {
            harness.checkPoint("handlers length");
            harness.check(handlers.length, 1);
            harness.check(handlers[0].getClass() == TestHandler.class);
            TestHandler handler = (TestHandler)handlers[0];
            harness.checkPoint("state reset");
            harness.check(logger2.getLevel() == Level.FINE);
            try {
                manager.readConfiguration();
                harness.check(true);
            }
            catch (Exception e) {
                harness.check(false);
                harness.debug(e);
            }
            harness.check(logger2.getLevel() == null);
            harness.check(handler.isClosed);
        }
    }
}

