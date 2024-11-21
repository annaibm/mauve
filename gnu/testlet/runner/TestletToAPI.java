/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TestletToAPI {
    private static final String TESTLET_SERIALIZATION = "serialization";
    private static final String TESTLET_CONSTRUCTORS = "constructors";
    private static final String TESTLET_CONSTANTS = "constants";
    private static final String TESTLET_CLASS_SUFFIX = "Class!";

    public static void main(String[] args) throws IOException {
        if (args.length < 4) {
            TestletToAPI.usage();
            return;
        }
        String inTestletsFile = args[0];
        String inTestedFile = args[1];
        String outTestletsFile = args[2];
        String outTestedFile = args[3];
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (j == i || !args[i].equals(args[j])) continue;
                throw new IllegalArgumentException("argument #" + i + " and argument #" + j + " are the same");
            }
        }
        FileReader inTestlets = new FileReader(inTestletsFile);
        FileReader inTested = new FileReader(inTestedFile);
        FileWriter outTestlets = new FileWriter(outTestletsFile);
        FileWriter outTested = new FileWriter(outTestedFile);
        TestletToAPI.convert(inTestlets, inTested, outTestlets, outTested);
    }

    public static void usage() {
        System.out.println("usage: TestletToAPI inTestlets.japi inTested.japi outTestlets.japi outTested.japi");
        System.out.println("  inTestlets.japi: the output of japize on mauve testlets");
        System.out.println("  inTested.japi: the output of japize on tested api (Classpath, jdk, ...)");
        System.out.println("  outTestlets.japi, outTested.japi: 2 japi files to be used as input of japicompat");
    }

    public static void convert(Reader inTestlets, Reader inTested, Writer outTestlets, Writer outTested) throws IOException {
        Stats stats = new Stats();
        Map methodToFullLine = TestletToAPI.processTestedAPI(inTested, outTested, stats);
        TestletToAPI.processMauveAPI(inTestlets, outTestlets, methodToFullLine, stats);
        System.out.println("=== Statistics ===");
        System.out.println("NbTestlets:" + stats.getNbTestlets());
        System.out.println("NbMethods:" + stats.getNbMethods());
        System.out.println("NbMethodsNotFound:" + stats.getNbMethodsNotFound());
        if (stats.getNbMethods() == 0) {
            System.out.println("Estimated coverage : #ERROR#");
        } else {
            double ratio = (double)stats.getNbTestlets() / (double)stats.getNbMethods();
            double percent = (double)((int)(10000.0 * ratio)) / 100.0;
            System.out.println("Estimated coverage : " + percent + " %");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void processMauveAPI(Reader in, Writer out, Map methodToFullLine, Stats stats) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            String l;
            reader = new BufferedReader(in);
            writer = new BufferedWriter(out);
            StringBuffer line = new StringBuffer(128);
            HashSet<String> testedMethods = new HashSet<String>();
            boolean firstLine = true;
            while ((l = reader.readLine()) != null) {
                Line mauveAPI;
                String methodName;
                line.setLength(0);
                line.append(l);
                if (firstLine) {
                    writer.write(l);
                    writer.write(10);
                    firstLine = false;
                    continue;
                }
                if (!TestletToAPI.acceptAPILine(line.toString()) || testedMethods.contains(methodName = (mauveAPI = TestletToAPI.parseMauveAPILine(line)).getMethodName())) continue;
                testedMethods.add(methodName);
                Line testedAPI = (Line)methodToFullLine.get(methodName);
                if (testedAPI == null || testedAPI == Line.NULL) {
                    System.err.println("method not found in API : " + methodName);
                    stats.incNbMethodsNotFound();
                    continue;
                }
                String className = testedAPI.getClassName();
                if (!testedMethods.contains(className)) {
                    testedMethods.add(className);
                    Line classDecl = (Line)methodToFullLine.get(className);
                    if (classDecl == null || classDecl == Line.NULL) {
                        throw new IllegalStateException(className + " has no declaration");
                    }
                    writer.write(classDecl.getContent());
                    writer.write(10);
                }
                writer.write(testedAPI.getContent());
                writer.write(10);
                stats.inNbTestlets();
            }
        }
        finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
            in.close();
            out.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Map processTestedAPI(Reader inTested, Writer outTested, Stats stats) throws IOException {
        HashMap<String, Line> methodToFullLine = new HashMap<String, Line>();
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            String l;
            reader = new BufferedReader(inTested);
            writer = new BufferedWriter(outTested);
            StringBuffer line = new StringBuffer(128);
            boolean firstLine = true;
            while ((l = reader.readLine()) != null) {
                line.setLength(0);
                line.append(l);
                if (firstLine) {
                    firstLine = false;
                } else if (TestletToAPI.acceptAPILine(l)) {
                    Line parsedLine = TestletToAPI.parseTestedAPILine(line);
                    String methodName = parsedLine.getMethodName();
                    switch (parsedLine.getType()) {
                        case 1: 
                        case 2: {
                            Line constLine = (Line)methodToFullLine.get(methodName);
                            if (constLine == Line.NULL || constLine == null) {
                                methodToFullLine.put(methodName, parsedLine);
                                break;
                            }
                            constLine.append(parsedLine.getContent());
                            break;
                        }
                        case 4: {
                            if (methodToFullLine.containsKey(methodName)) break;
                            methodToFullLine.put(parsedLine.getClassName(), parsedLine);
                            if (!parsedLine.isSerializable()) break;
                            String serialMethod = parsedLine.getClassName() + '!' + TESTLET_SERIALIZATION;
                            String serialLine = serialMethod + "() Pcifu V";
                            Line sl = new Line(3, serialMethod, serialLine, true);
                            methodToFullLine.put(serialMethod, sl);
                            l = l + "\n";
                            if (l.charAt(0) == '+') {
                                l = l.charAt(1) == '+' ? l + "++" : l + "+";
                            }
                            l = l + serialLine;
                            stats.incNbMethods();
                            break;
                        }
                        case 3: {
                            throw new IllegalStateException("type SERIALIZATION unexpected here");
                        }
                        case 0: {
                            if (methodToFullLine.containsKey(methodName)) break;
                            methodToFullLine.put(methodName, parsedLine);
                            break;
                        }
                        default: {
                            if (parsedLine == Line.NULL) break;
                            throw new IllegalStateException("unknown type of line");
                        }
                    }
                }
                writer.write(l);
                writer.write(10);
                stats.incNbMethods();
            }
        }
        finally {
            if (reader != null) {
                reader.close();
            }
            inTested.close();
            if (writer != null) {
                writer.close();
            }
            outTested.close();
        }
        return methodToFullLine;
    }

    public static Line parseTestedAPILine(StringBuffer japizeLine) {
        boolean isConstructor;
        int idx;
        String line = japizeLine.toString();
        boolean isClassDecl = TestletToAPI.preprocessAPILine(japizeLine);
        boolean isSerialClassDecl = false;
        if (!isClassDecl && japizeLine.indexOf("(") < 0) {
            isSerialClassDecl = japizeLine.indexOf("class#") >= 0 && japizeLine.lastIndexOf("java.io.Serializable") >= 0;
            boolean isNonSerialClassDecl = japizeLine.indexOf("class:") >= 0;
            boolean isInterfaceDecl = japizeLine.indexOf("interface") >= 0;
            boolean bl = isClassDecl = isNonSerialClassDecl || isSerialClassDecl || isInterfaceDecl;
        }
        if (isClassDecl) {
            idx = japizeLine.indexOf("!");
            if (idx < 0) {
                return Line.NULL;
            }
            japizeLine.setLength(idx + 1);
            return new Line(4, japizeLine.toString(), line, isSerialClassDecl);
        }
        idx = japizeLine.indexOf("(");
        if (idx < 0) {
            idx = japizeLine.indexOf("!#");
            if (idx < 0) {
                return Line.NULL;
            }
            japizeLine.setLength(idx + 1);
            japizeLine.append(TESTLET_CONSTANTS);
            return new Line(2, japizeLine.toString(), line);
        }
        boolean bl = isConstructor = japizeLine.indexOf("constructor") >= 0;
        if (isConstructor) {
            japizeLine.setLength(idx);
            japizeLine.append(TESTLET_CONSTRUCTORS);
            return new Line(1, japizeLine.toString(), line);
        }
        if (idx >= 0) {
            japizeLine.setLength(idx);
            return new Line(0, japizeLine.toString(), line);
        }
        return Line.NULL;
    }

    public static Line parseMauveAPILine(StringBuffer japizeLine) {
        String line = japizeLine.toString();
        TestletToAPI.preprocessAPILine(japizeLine);
        japizeLine.delete(0, "gnu.testlet.".length());
        int idx = japizeLine.indexOf("!");
        if (idx < 0) {
            return Line.NULL;
        }
        japizeLine.setLength(idx);
        idx = japizeLine.indexOf(",");
        if (idx < 0) {
            return Line.NULL;
        }
        japizeLine.setCharAt(idx, '!');
        idx = japizeLine.lastIndexOf(".");
        if (idx < 0) {
            return Line.NULL;
        }
        japizeLine.setCharAt(idx, ',');
        idx = japizeLine.indexOf(TESTLET_CLASS_SUFFIX);
        if (idx >= 0) {
            japizeLine.delete(idx, idx + TESTLET_CLASS_SUFFIX.length() - 1);
        }
        int type = japizeLine.indexOf(TESTLET_CONSTANTS) >= 0 ? 2 : (japizeLine.indexOf(TESTLET_CONSTRUCTORS) >= 0 ? 1 : (japizeLine.indexOf(TESTLET_SERIALIZATION) >= 0 ? 3 : 0));
        return new Line(type, japizeLine.toString(), line);
    }

    public static boolean acceptAPILine(String line) {
        boolean isMauveFramework = line.toString().startsWith("gnu.testlet,");
        return !isMauveFramework;
    }

    public static boolean preprocessAPILine(StringBuffer japizeLine) {
        boolean isClassDecl = false;
        if (japizeLine.charAt(0) == '+') {
            if (japizeLine.charAt(1) == '+') {
                japizeLine.delete(0, 2);
                isClassDecl = japizeLine.toString().endsWith("class");
            } else {
                japizeLine.delete(0, 1);
            }
        }
        return isClassDecl;
    }

    public static class Line {
        public static final Line NULL = new Line();
        private static final int METHOD = 0;
        private static final int CONSTRUCTORS = 1;
        private static final int CONSTANTS = 2;
        private static final int SERIALIZATION = 3;
        private static final int CLASS_DECL = 4;
        private final int type;
        private final String className;
        private final String methodName;
        private final StringBuffer lines;
        private final boolean serializable;

        public Line(int type, String methodName, String line) {
            this(type, methodName, line, false);
        }

        public Line(int type, String methodName, String line, boolean serializable) {
            this.type = type;
            this.methodName = methodName;
            this.lines = new StringBuffer(line);
            this.serializable = serializable;
            int idx = methodName.indexOf(33);
            if (idx < 0) {
                throw new IllegalArgumentException("methodName must contains the '!' character");
            }
            this.className = methodName.substring(0, idx);
        }

        public int getType() {
            return this.type;
        }

        public boolean isSerializable() {
            return this.serializable;
        }

        public String getContent() {
            return this.lines.toString();
        }

        private Line() {
            this.type = -1;
            this.className = "";
            this.methodName = "";
            this.lines = null;
            this.serializable = false;
        }

        public void append(String nextLine) {
            if (!this.isConstructor() && !this.isConstant()) {
                throw new UnsupportedOperationException("reserved to constructor and constant lines");
            }
            this.lines.append('\n');
            this.lines.append(nextLine);
        }

        public boolean isConstructor() {
            return this.type == 1;
        }

        public boolean isConstant() {
            return this.type == 2;
        }

        public final String getMethodName() {
            return this.methodName;
        }

        public String getClassName() {
            return this.className;
        }

        public String toString() {
            return "[" + this.methodName + "]->" + this.lines.toString();
        }
    }

    public static class Stats {
        private int nbTestlets = 0;
        private int nbMethods = 0;
        private int nbMethodsNotFound = 0;

        final int getNbMethods() {
            return this.nbMethods;
        }

        final void incNbMethods() {
            ++this.nbMethods;
        }

        final int getNbTestlets() {
            return this.nbTestlets;
        }

        final void inNbTestlets() {
            ++this.nbTestlets;
        }

        final int getNbMethodsNotFound() {
            return this.nbMethodsNotFound;
        }

        final void incNbMethodsNotFound() {
            ++this.nbMethodsNotFound;
        }
    }
}

