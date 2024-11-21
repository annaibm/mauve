/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.MessageFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Locale;

public class format
implements Testlet {
    private final String myformat(MessageFormat mf, Object[] args, StringBuffer buf) {
        try {
            buf.setLength(0);
            mf.format(args, buf, (FieldPosition)null);
            return buf.toString();
        }
        catch (IllegalArgumentException x) {
            return "caught IllegalArgumentException";
        }
    }

    @Override
    public void test(TestHarness harness) {
        Locale loc = Locale.US;
        Locale.setDefault(loc);
        MessageFormat mf = new MessageFormat("no variables");
        mf.setLocale(loc);
        Object[] args = new Object[]{};
        StringBuffer buf = new StringBuffer();
        harness.checkPoint("no variable format");
        harness.check(mf.format(args, buf, (FieldPosition)null) == buf);
        harness.check(buf.toString(), (Object)"no variables");
        buf.setLength(0);
        harness.check(mf.format(null, buf, null) == buf);
        harness.check(buf.toString(), (Object)"no variables");
        harness.check(MessageFormat.format("no variables", args), (Object)"no variables");
        harness.checkPoint("quoted brace");
        mf.applyPattern("no '{' variables");
        harness.check(this.myformat(mf, args, buf), (Object)"no { variables");
        harness.check(mf.toPattern(), (Object)"no '{' variables");
        harness.checkPoint("one variable");
        mf.applyPattern("the disk contains {0} files");
        args = new Object[]{new Long(23L)};
        harness.check(this.myformat(mf, args, buf), (Object)"the disk contains 23 files");
        args = new Object[10];
        args[0] = new Long(27L);
        harness.check(this.myformat(mf, args, buf), (Object)"the disk contains 27 files");
        mf.applyPattern("the disk contains {0,number} files");
        harness.check(this.myformat(mf, args, buf), (Object)"the disk contains 27 files");
        args[0] = "zap";
        harness.check(this.myformat(mf, args, buf), (Object)"caught IllegalArgumentException");
        args[0] = new Double(0.99);
        mf.applyPattern("the disk is {0,number,percent} full");
        harness.check(this.myformat(mf, args, buf), (Object)"the disk is 99% full");
        harness.checkPoint("two variables");
        args = new Object[]{"files", new Long(29L)};
        mf.applyPattern("the disk contains {1} {0}");
        harness.check(this.myformat(mf, args, buf), (Object)"the disk contains 29 files");
        args = new Object[]{"files"};
        mf.applyPattern("the disk contains {1} {0}");
        harness.check(this.myformat(mf, args, buf), (Object)"the disk contains {1} files");
        args = null;
        harness.check(this.myformat(mf, args, buf), (Object)"the disk contains {1} {0}");
        args = new Object[1];
        harness.checkPoint("choice format");
        args[0] = new Long(5L);
        mf.applyPattern("There {0,choice,0#are no files|1#is one file|1<are {0, number, integer} files}.");
        harness.check(this.myformat(mf, args, buf), (Object)"There are 5 files.");
        args[0] = new Double(10.23);
        mf.applyPattern("Got {0,number,'#'.##}");
        harness.check(this.myformat(mf, args, buf), (Object)"Got #10.23");
        harness.checkPoint("array argument");
        mf.applyPattern("test Message = {0}");
        args = new Object[]{"a jolly string"};
        harness.check(mf.format(args), (Object)"test Message = a jolly string");
        harness.checkPoint("choice format in message format");
        mf.applyPattern("{0,choice,0#0 tasks|1#{0,number,integer} task|1<{0,number,integer} tasks}, {1,choice,0#0 errors|1#{1,number,integer} error|1<{1,number,integer} errors}");
        args = new Object[]{new Integer(0), new Integer(1)};
        buf = new StringBuffer();
        mf.format(args, buf, (FieldPosition)null);
        harness.check(buf.toString(), (Object)"0 tasks, 1 error");
    }
}

