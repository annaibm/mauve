/*
 * Decompiled with CFR 0.152.
 */
package junit.framework;

import gnu.testlet.TestHarness;
import junit.framework.AssertionFailedError;
import junit.framework.ComparisonFailure;

public class Assert {
    static TestHarness harness;

    protected Assert() {
    }

    public static void assertTrue(String message, boolean value2) {
        if (harness != null) {
            harness.check(value2);
        } else if (!value2) {
            Assert.fail(message);
        }
    }

    public static void assertTrue(boolean value2) {
        Assert.assertTrue(null, value2);
    }

    public static void assertFalse(String message, boolean value2) {
        Assert.assertTrue(message, !value2);
    }

    public static void assertFalse(boolean value2) {
        Assert.assertFalse(null, value2);
    }

    public static void fail(String message) {
        if (harness == null) {
            throw new AssertionFailedError(message);
        }
        harness.check(false);
    }

    public static void fail() {
        Assert.fail(null);
    }

    public static void assertEquals(String message, Object expected, Object value2) {
        if (harness != null) {
            harness.check(expected, value2);
        } else if (!(expected == null && value2 == null || expected != null && expected.equals(value2))) {
            Assert.failNotEquals(message, expected, value2);
        }
    }

    public static void assertEquals(Object expected, Object value2) {
        Assert.assertEquals(null, expected, value2);
    }

    public static void assertEquals(String message, String expected, String value2) {
        if (harness != null) {
            harness.check(expected, (Object)value2);
        } else if (!(expected == null && value2 == null || expected != null && expected.equals(value2))) {
            throw new ComparisonFailure(message, expected, value2);
        }
    }

    public static void assertEquals(String expected, String value2) {
        Assert.assertEquals(null, expected, value2);
    }

    public static void assertEquals(String message, double expected, double value2, double delta) {
        if (harness != null) {
            harness.check(expected, value2, delta);
        } else if (Double.isInfinite(expected)) {
            if (value2 != expected) {
                Assert.failNotEquals(message, new Double(expected), new Double(value2));
            }
        } else if (!(Math.abs(expected - value2) <= delta)) {
            Assert.failNotEquals(message, new Double(expected), new Double(value2));
        }
    }

    public static void assertEquals(double expected, double value2, double delta) {
        Assert.assertEquals(null, expected, value2, delta);
    }

    public static void assertEquals(String message, float expected, float value2, float delta) {
        if (harness != null) {
            harness.check((double)expected, (double)value2, delta);
        } else if (Float.isInfinite(expected)) {
            if (value2 != expected) {
                Assert.failNotEquals(message, new Float(expected), new Float(value2));
            }
        } else if (!(Math.abs(expected - value2) <= delta)) {
            Assert.failNotEquals(message, new Float(expected), new Float(value2));
        }
    }

    public static void assertEquals(float expected, float value2, float delta) {
        Assert.assertEquals(null, expected, value2, delta);
    }

    public static void assertEquals(String message, long expected, long value2) {
        if (harness != null) {
            harness.check(expected, value2);
        } else {
            Assert.failNotEquals(message, new Long(expected), new Long(value2));
        }
    }

    public static void assertEquals(long expected, long value2) {
        Assert.assertEquals(null, expected, value2);
    }

    public static void assertEquals(String message, boolean expected, boolean value2) {
        if (harness != null) {
            harness.check(expected, value2);
        } else {
            Assert.failNotEquals(message, new Boolean(expected), new Boolean(value2));
        }
    }

    public static void assertEquals(boolean expected, boolean value2) {
        Assert.assertEquals(null, expected, value2);
    }

    public static void assertEquals(String message, byte expected, byte value2) {
        if (harness != null) {
            harness.check(expected, value2);
        } else {
            Assert.failNotEquals(message, new Byte(expected), new Byte(value2));
        }
    }

    public static void assertEquals(byte expected, byte value2) {
        Assert.assertEquals(null, expected, value2);
    }

    public static void assertEquals(String message, char expected, char value2) {
        if (harness != null) {
            harness.check(expected, value2);
        } else {
            Assert.failNotEquals(message, new Character(expected), new Character(value2));
        }
    }

    public static void assertEquals(char expected, char value2) {
        Assert.assertEquals(null, expected, value2);
    }

    public static void assertEquals(String message, short expected, short value2) {
        if (harness != null) {
            harness.check(expected, value2);
        } else {
            Assert.failNotEquals(message, new Short(expected), new Short(value2));
        }
    }

    public static void assertEquals(short expected, short value2) {
        Assert.assertEquals(null, expected, value2);
    }

    public static void assertEquals(String message, int expected, int value2) {
        if (harness != null) {
            harness.check(expected, value2);
        } else {
            Assert.failNotEquals(message, new Integer(expected), new Integer(value2));
        }
    }

    public static void assertEquals(int expected, int value2) {
        Assert.assertEquals(null, expected, value2);
    }

    public static void assertNotNull(String message, Object value2) {
        Assert.assertTrue(message, value2 != null);
    }

    public static void assertNotNull(Object value2) {
        Assert.assertNotNull(null, value2);
    }

    public static void assertNull(String message, Object value2) {
        Assert.assertTrue(message, value2 == null);
    }

    public static void assertNull(Object value2) {
        Assert.assertNull(null, value2);
    }

    public static void assertSame(String message, Object expected, Object value2) {
        if (harness != null) {
            harness.check(expected == value2);
        } else if (value2 != expected) {
            StringBuffer str = new StringBuffer();
            if (message != null) {
                str.append(message);
                str.append(' ');
                str.append("expected to be same");
            }
            Assert.fail(Assert.format(str, expected, value2));
        }
    }

    public static void assertSame(Object expected, Object value2) {
        Assert.assertSame(null, expected, value2);
    }

    public static void assertNotSame(String message, Object expected, Object value2) {
        if (harness != null) {
            harness.check(expected != value2);
        } else if (value2 == expected) {
            StringBuffer str = new StringBuffer();
            if (message != null) {
                str.append(message);
                str.append(' ');
                str.append("expected to be not the same");
            }
            Assert.fail(Assert.format(str, expected, value2));
        }
    }

    public static void assertNotSame(Object expected, Object value2) {
        Assert.assertNotSame(null, expected, value2);
    }

    private static void failNotEquals(String message, Object expected, Object value2) {
        StringBuffer str = new StringBuffer();
        if (message != null) {
            str.append(message);
            str.append(' ');
        }
        Assert.fail(Assert.format(str, expected, value2));
    }

    private static String format(StringBuffer str, Object expected, Object value2) {
        str.append(' ');
        str.append(" expected value: ");
        str.append(expected);
        str.append(" actual value: " + value2);
        return str.toString();
    }
}

