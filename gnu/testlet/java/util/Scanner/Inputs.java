/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.util.Random;
import java.util.Scanner;

public class Inputs
extends Base {
    private static final int AMOUNT = 20000;

    public Inputs() {
        this.fileName = this.getClass().getName() + ".txt";
        this.isEnabled = false;
    }

    @Override
    protected void doTest() {
        long tmp;
        int i;
        long[] numbers = new long[20000];
        Random r = new Random(System.currentTimeMillis());
        long max2 = 20000000000000L;
        long mean = 10000000000000L;
        StringBuffer tmpBuff = new StringBuffer(10000);
        FileOutputStream fos = null;
        Scanner s = null;
        String[] charSets = new String[]{"windows-1252"};
        for (i = 0; i < numbers.length; ++i) {
            numbers[i] = tmp = (long)(r.nextFloat() * 2.0E13f) - 10000000000000L;
        }
        tmpBuff.insert(0, "" + numbers[0]);
        for (i = 1; i < numbers.length; ++i) {
            tmpBuff.append(" " + numbers[i]);
        }
        try {
            fos = new FileOutputStream(this.aktFile);
            fos.write(tmpBuff.toString().getBytes());
            fos.flush();
            fos.close();
            this.myHarness.debug("Testing Readable input...");
            int errors = 0;
            s = new Scanner(new FileReader(this.aktFile));
            i = 0;
            while (s.hasNextLong()) {
                tmp = s.nextLong();
                if (tmp != numbers[i]) {
                    ++errors;
                    this.myHarness.fail("Readable : nextLong() -> " + tmp + " != " + numbers[i]);
                }
                ++i;
            }
            if (errors == 0) {
                this.myHarness.debug("all OK");
            } else {
                this.myHarness.fail(errors + " errors..");
            }
            this.myHarness.debug("Testing ReadableByteChanel input...");
            errors = 0;
            s = new Scanner(new FileInputStream(this.aktFile).getChannel());
            i = 0;
            while (s.hasNextLong()) {
                tmp = s.nextLong();
                if (tmp != numbers[i]) {
                    ++errors;
                    this.myHarness.fail("ReadableByteChanel : nextLong() -> " + tmp + " != " + numbers[i]);
                }
                ++i;
            }
            if (errors == 0) {
                this.myHarness.debug("all OK");
            } else {
                this.myHarness.fail(errors + " errors..");
            }
            for (int aktCS = 0; aktCS < charSets.length; ++aktCS) {
                String aktName = "Testing File + CharSet \"" + charSets[aktCS] + "\"";
                this.myHarness.debug(aktName);
                errors = 0;
                s = new Scanner(this.aktFile, charSets[aktCS]);
                i = 0;
                while (s.hasNextLong()) {
                    tmp = s.nextLong();
                    if (tmp != numbers[i]) {
                        ++errors;
                        this.myHarness.fail(aktName + " : nextLong() -> " + tmp + " != " + numbers[i]);
                    }
                    ++i;
                }
                if (errors == 0) {
                    this.myHarness.debug("all OK");
                } else {
                    this.myHarness.fail(errors + " errors..");
                }
                aktName = "Testing InputStream + CharSet \"" + charSets[aktCS] + "\"";
                this.myHarness.debug(aktName);
                errors = 0;
                s = new Scanner((InputStream)new ByteArrayInputStream(tmpBuff.toString().getBytes()), charSets[aktCS]);
                i = 0;
                while (s.hasNextLong()) {
                    tmp = s.nextLong();
                    if (tmp != numbers[i]) {
                        ++errors;
                        this.myHarness.fail(aktName + " : nextLong() -> " + tmp + " != " + numbers[i]);
                    }
                    ++i;
                }
                if (errors == 0) {
                    this.myHarness.debug("all OK");
                } else {
                    this.myHarness.fail(errors + " errors..");
                }
                aktName = "Testing ReadableByteChanel + CharSet \"" + charSets[aktCS] + "\"";
                this.myHarness.debug(aktName);
                errors = 0;
                s = new Scanner((ReadableByteChannel)new FileInputStream(this.aktFile).getChannel(), charSets[aktCS]);
                i = 0;
                while (s.hasNextLong()) {
                    tmp = s.nextLong();
                    if (tmp != numbers[i]) {
                        ++errors;
                        this.myHarness.fail(aktName + " : nextLong() -> " + tmp + " != " + numbers[i]);
                    }
                    ++i;
                }
                if (errors == 0) {
                    this.myHarness.debug("all OK");
                    continue;
                }
                this.myHarness.fail(errors + " errors..");
            }
            this.myHarness.check(i, numbers.length, "Incomplete read... (" + i + " / " + numbers.length + ")");
            s.close();
        }
        catch (FileNotFoundException e) {
            this.myHarness.fail("Could not create file");
        }
        catch (IOException e) {
            this.myHarness.fail("Could not write to File \"" + this.aktFile.getName() + "\"");
        }
    }
}

