/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.LineNumberReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

public class Test2
implements Testlet {
    static LineReaderTest[] tests = new LineReaderTest[]{new LineTest1(), new LineTest2(), new LineTest3(), new LineTest4(), new LineTest5(), new LineTest6(), new LineTest7(), new LineTest8(), new LineTest9(), new LineTest10(), new LineTest11()};

    @Override
    public void test(TestHarness harness) {
        for (int i = 0; i < tests.length; ++i) {
            String name2 = tests[i].getClass().getName();
            name2 = name2.substring(name2.indexOf(36) + 1);
            harness.checkPoint("LineNumberReader stress test (" + name2 + ")");
            try {
                tests[i].test(harness);
                continue;
            }
            catch (Exception e) {
                harness.check(false);
                harness.debug(e);
            }
        }
    }

    static class LineTest11
    extends LineReaderTest {
        LineTest11() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("X");
            LineNumberReader lnr = new LineNumberReader(sr);
            int old_linenumber = lnr.getLineNumber();
            lnr.mark(5);
            lnr.setLineNumber(10);
            lnr.reset();
            harness.check(lnr.getLineNumber(), old_linenumber);
        }
    }

    static class LineTest10
    extends LineReaderTest {
        LineTest10() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("X");
            LineNumberReader lnr = new LineNumberReader(sr);
            try {
                lnr.reset();
                harness.check(false);
            }
            catch (IOException e) {
                harness.check(true);
            }
        }
    }

    static class LineTest9
    extends LineReaderTest {
        LineTest9() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("\r\n\r");
            LineNumberReader lnr = new LineNumberReader(sr);
            char[] ch = new char[1];
            lnr.read();
            lnr.mark(5);
            harness.check(lnr.read(ch, 0, 1), 1);
            harness.check(ch[0], 10);
            harness.check(lnr.read(), 10);
            lnr.reset();
            harness.check(lnr.read(ch, 0, 1), 1);
            harness.check(ch[0], 10);
            harness.check(lnr.read(), 10);
            harness.check(lnr.getLineNumber(), 2);
        }
    }

    static class LineTest8
    extends LineReaderTest {
        LineTest8() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("\r\n\r");
            LineNumberReader lnr = new LineNumberReader(sr);
            char[] ch = new char[1];
            harness.check(lnr.read(ch, 0, 1), 1);
            harness.check(ch[0], 13);
            harness.check(lnr.read(), 10);
            harness.check(lnr.read(ch, 0, 1), -1);
            harness.check(ch[0], 13);
            harness.check(lnr.getLineNumber(), 2);
        }
    }

    static class LineTest7
    extends LineReaderTest {
        LineTest7() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("\r\n\r");
            LineNumberReader lnr = new LineNumberReader(sr);
            char[] ch = new char[1];
            harness.check(lnr.read(), 10);
            harness.check(lnr.read(ch, 0, 1), 1);
            harness.check(ch[0], 10);
            harness.check(lnr.read(), 10);
            harness.check(lnr.getLineNumber(), 2);
        }
    }

    static class LineTest6
    extends LineReaderTest {
        LineTest6() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("\r\r\n");
            LineNumberReader lnr = new LineNumberReader(sr);
            harness.check(lnr.read(), 10);
            harness.check(lnr.read(), 10);
            harness.check(lnr.getLineNumber(), 2);
        }
    }

    static class LineTest5
    extends LineReaderTest {
        LineTest5() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("\r\n\r");
            LineNumberReader lnr = new LineNumberReader(sr);
            harness.check(lnr.read(), 10);
            harness.check(lnr.read(), 10);
            harness.check(lnr.getLineNumber(), 2);
        }
    }

    static class LineTest4
    extends LineReaderTest {
        LineTest4() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("\r\n");
            LineNumberReader lnr = new LineNumberReader(sr);
            char[] ch = new char[2];
            int r = lnr.read(ch, 0, 2);
            harness.check(ch[0] == '\r' && ch[1] == '\n');
            harness.check(lnr.getLineNumber(), 1);
        }
    }

    static class LineTest3
    extends LineReaderTest {
        LineTest3() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("X");
            LineNumberReader lnr = new LineNumberReader(sr);
            lnr.setLineNumber(-5);
            harness.check(lnr.getLineNumber(), -5);
        }
    }

    static class LineTest2
    extends LineReaderTest {
        LineTest2() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("X");
            LineNumberReader lnr = new LineNumberReader(sr);
            try {
                lnr.read(null, 0, 0);
                harness.check(false);
            }
            catch (NullPointerException e) {
                harness.check(true);
            }
            try {
                lnr.read(new char[1], 0, 2);
                harness.check(false);
            }
            catch (IndexOutOfBoundsException e) {
                harness.check(true);
            }
            try {
                lnr.read(new char[1], -5, 0);
                harness.check(false);
            }
            catch (IndexOutOfBoundsException e) {
                harness.check(true);
            }
            try {
                lnr.read(new char[1], 0, -5);
                harness.check(false);
            }
            catch (IndexOutOfBoundsException e) {
                harness.check(true);
            }
        }
    }

    static class LineTest1
    extends LineReaderTest {
        LineTest1() {
        }

        @Override
        void test(TestHarness harness) throws Exception {
            StringReader sr = new StringReader("X");
            LineNumberReader lnr = new LineNumberReader(sr);
            try {
                lnr.mark(-5);
                harness.check(false);
            }
            catch (IllegalArgumentException e) {
                harness.check(true);
            }
        }
    }

    static abstract class LineReaderTest {
        LineReaderTest() {
        }

        abstract void test(TestHarness var1) throws Exception;
    }
}

