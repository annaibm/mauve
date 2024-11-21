/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

public class Filter {
    public static void main(String[] args) throws IOException {
        String which;
        System.out.println("Please specify which tests you want to run based on the JVM version");
        System.out.println("you want to test compatibility with.");
        System.out.println("After you select a file called 'tests' will be written and you then");
        System.out.println("have to type:");
        System.out.println(" export CLASSPATH=alltests.jar:$CLASSPATH");
        System.out.println(" myJava gnu.testlet.runner.Mauve tests");
        System.out.println("");
        final Vector options = new Vector();
        final TreeSet sorted = new TreeSet();
        Filter.readTestList(new LineProcessor(){

            @Override
            public void processLine(StringBuffer buf) {
                if (buf.indexOf("[") == 0 && buf.charAt(buf.length() - 1) == ']') {
                    String token = buf.substring(1, buf.length() - 1);
                    if (token.startsWith("JDK")) {
                        sorted.add(token);
                    } else {
                        options.add(token);
                    }
                }
            }
        });
        System.out.println("Please pick one:");
        StringBuffer buf = new StringBuffer();
        int i = 1;
        Iterator iter2 = sorted.iterator();
        while (iter2.hasNext()) {
            buf.append(String.valueOf(i++));
            buf.append(": ");
            buf.append(iter2.next().toString());
            if (iter2.hasNext()) {
                buf.append(",  ");
                continue;
            }
            buf.append("? ");
        }
        String answer = Filter.ask(buf.toString());
        try {
            int index = Integer.parseInt(answer);
            which = (String)new ArrayList(sorted).get(index - 1);
        }
        catch (NumberFormatException e) {
            System.out.println("No parsable answer found");
            System.exit(-1);
            return;
        }
        catch (Exception e) {
            System.out.println("Sorry; I'm not sure I understand you, bailing out");
            System.exit(-1);
            return;
        }
        Iterator opsIter = new Vector(options).iterator();
        final Vector<String> choosedOptions = new Vector<String>();
        while (opsIter.hasNext()) {
            String option = (String)opsIter.next();
            answer = Filter.ask("Use classes with option: " + option + "? [yN] ");
            if (!"y".equalsIgnoreCase(answer)) continue;
            choosedOptions.add(option);
        }
        System.out.println("Writing all tests for " + which + " to 'tests'");
        final TreeSet tests = new TreeSet();
        Filter.readTestList(new LineProcessor(){
            private boolean valid = true;

            @Override
            public void processLine(StringBuffer buf) {
                if (buf.charAt(0) == '[') {
                    String newVer = buf.substring(1, buf.length() - 1);
                    if (newVer.startsWith("JDK")) {
                        if (which.compareTo(newVer) < 0) {
                            this.valid = false;
                        }
                    } else {
                        this.valid = choosedOptions.contains(newVer);
                    }
                } else if (this.valid && buf.charAt(0) == '-') {
                    tests.remove(buf.substring(1));
                } else if (this.valid) {
                    tests.add(buf.toString());
                } else {
                    tests.remove(buf.toString());
                }
            }
        });
        PrintWriter writer = new PrintWriter(new FileOutputStream(new File("tests")));
        iter2 = tests.iterator();
        while (iter2.hasNext()) {
            writer.println(iter2.next().toString());
        }
        writer.close();
    }

    public static void readTestList(LineProcessor processor) throws IOException {
        int character;
        InputStream in = Filter.class.getResourceAsStream("/testslists");
        StringBuffer buf = new StringBuffer();
        while ((character = in.read()) != -1) {
            if (character == 10) {
                if (buf.length() == 0) continue;
                processor.processLine(buf);
                buf.setLength(0);
                continue;
            }
            buf.append((char)character);
        }
    }

    private static String ask(String question) throws IOException {
        System.out.write(question.getBytes());
        StringBuffer answer = new StringBuffer();
        int ch;
        while ((ch = System.in.read()) >= 0 && ch != 10) {
            if (ch == 13) continue;
            answer.append((char)ch);
        }
        return answer.toString().trim();
    }

    public static interface LineProcessor {
        public void processLine(StringBuffer var1);
    }
}

