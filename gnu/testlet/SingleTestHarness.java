/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet;

import gnu.testlet.ResourceNotFoundException;
import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class SingleTestHarness
extends TestHarness {
    private int count;
    private String className;
    private boolean verbose = false;
    private String last_check;

    public SingleTestHarness(Testlet t, boolean verbose) {
        this.verbose = verbose;
        this.className = t.getClass().getName();
    }

    @Override
    public void check(boolean result) {
        String message = (result ? "PASS" : "FAIL") + ": " + this.className + (this.last_check == null ? "" : ": " + this.last_check) + " (number " + this.count++ + ")";
        System.out.println(message);
    }

    @Override
    public Reader getResourceReader(String name2) throws ResourceNotFoundException {
        return new BufferedReader(new InputStreamReader(this.getResourceStream(name2)));
    }

    @Override
    public InputStream getResourceStream(String name2) throws ResourceNotFoundException {
        if (File.separator.length() > 1) {
            throw new Error("File.separator length is greater than 1");
        }
        String realName = name2.replace('#', File.separator.charAt(0));
        try {
            return new FileInputStream(this.getSourceDirectory() + File.separator + realName);
        }
        catch (FileNotFoundException ex) {
            throw new ResourceNotFoundException(ex.getLocalizedMessage() + ": " + this.getSourceDirectory() + File.separator + realName);
        }
    }

    @Override
    public File getResourceFile(String name2) throws ResourceNotFoundException {
        if (File.separator.length() > 1) {
            throw new Error("File.separator length is greater than 1");
        }
        String realName = name2.replace('#', File.separator.charAt(0));
        File f = new File(this.getSourceDirectory() + File.separator + realName);
        if (!f.exists()) {
            throw new ResourceNotFoundException("cannot find mauve resource file: " + this.getSourceDirectory() + File.separator + realName);
        }
        return f;
    }

    @Override
    public void checkPoint(String name2) {
        this.last_check = name2;
        this.count = 0;
    }

    @Override
    public void verbose(String message) {
        if (this.verbose) {
            System.out.println(message);
        }
    }

    @Override
    public void debug(String message) {
        this.debug(message, true);
    }

    @Override
    public void debug(String message, boolean newline) {
        if (newline) {
            System.out.println(message);
        } else {
            System.out.print(message);
        }
    }

    @Override
    public void debug(Throwable ex) {
        ex.printStackTrace(System.out);
    }

    @Override
    public void debug(Object[] o, String desc) {
        this.debug("Dumping Object Array: " + desc);
        if (o == null) {
            this.debug("null");
            return;
        }
        for (int i = 0; i < o.length; ++i) {
            if (o[i] instanceof Object[]) {
                this.debug((Object[])o[i], desc + " element " + i);
                continue;
            }
            this.debug("  Element " + i + ": " + o[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            String name2;
            boolean verbose;
            if (args.length > 1 && "-v".equals(args[0])) {
                verbose = true;
                name2 = args[1];
            } else {
                verbose = false;
                name2 = args[0];
            }
            Class<?> k = Thread.currentThread().getContextClassLoader().loadClass(name2);
            Testlet t = (Testlet)k.newInstance();
            SingleTestHarness h = new SingleTestHarness(t, verbose);
            t.test(h);
        } else {
            System.out.println("Usage: mauve-simple [-v] <test-class>");
        }
    }
}

