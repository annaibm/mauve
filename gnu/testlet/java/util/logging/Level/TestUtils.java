/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Level;

import java.util.logging.Level;

class TestUtils {
    public static final Level[] LEVELS = new Level[]{Level.OFF, Level.SEVERE, Level.WARNING, Level.INFO, Level.CONFIG, Level.FINE, Level.FINER, Level.FINEST, Level.ALL};
    public static final String[] NAMES = new String[]{"OFF", "SEVERE", "WARNING", "INFO", "CONFIG", "FINE", "FINER", "FINEST", "ALL"};
    public static final int[] VALUES = new int[]{Integer.MAX_VALUE, 1000, 900, 800, 700, 500, 400, 300, Integer.MIN_VALUE};

    TestUtils() {
    }

    public static class CustomLevel
    extends Level {
        public CustomLevel(String name2, int value2) {
            super(name2, value2);
        }

        public CustomLevel(String name2, int value2, String bundleName) {
            super(name2, value2, bundleName);
        }
    }
}

