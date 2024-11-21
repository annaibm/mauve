/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

import gnu.testlet.runner.Tags;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CreateTags {
    private File base;
    private File output;
    private List classes = new ArrayList();

    public CreateTags(File base, File output) {
        if (!base.exists()) {
            throw new IllegalArgumentException("base dir does not exist");
        }
        if (!base.isDirectory()) {
            throw new IllegalArgumentException("base dir is not a directory");
        }
        if (output.exists()) {
            output.delete();
        }
        this.base = base;
        this.output = output;
    }

    public void create() throws IOException {
        boolean first2;
        this.append(this.base);
        FileWriter writer = new FileWriter(this.output);
        String start = "1.0";
        do {
            first2 = true;
            String next2 = "9.9";
            for (TestCase testCase : this.classes) {
                int from = testCase.tags.fromJDK.compareTo(start);
                if (from < 0) {
                    if (testCase.tags.toJDK.compareTo(start) != 0) continue;
                    if (first2) {
                        writer.write("[JDK" + start + "]\n");
                        first2 = false;
                    }
                    writer.write("-");
                    writer.write(testCase.className);
                    writer.write("\n");
                    continue;
                }
                if (from == 0) {
                    if (first2) {
                        writer.write("[JDK" + start + "]\n");
                        first2 = false;
                    }
                    writer.write(testCase.className);
                    writer.write("\n");
                    continue;
                }
                if (from <= 0 || testCase.tags.fromJDK.compareTo(next2) >= 0) continue;
                next2 = testCase.tags.fromJDK;
            }
            start = next2;
            writer.write("\n");
        } while (!first2);
        first2 = true;
        for (TestCase testCase : this.classes) {
            if (!testCase.tags.gui) continue;
            if (first2) {
                writer.write("\n[GUI]\n");
                first2 = false;
            }
            writer.write(testCase.className);
            writer.write("\n");
        }
        writer.close();
    }

    private void append(File dir) {
        File[] children2 = dir.listFiles();
        block2: for (int i = 0; i < children2.length; ++i) {
            File file = children2[i];
            if (file.isDirectory()) {
                this.append(file);
                continue;
            }
            if (!file.getName().endsWith(".java")) continue;
            String tags = null;
            String pckage = null;
            try {
                int character;
                FileReader reader = new FileReader(file);
                StringBuffer buf = new StringBuffer();
                int maxLines = 30;
                while (maxLines > 0 && (tags == null || pckage == null) && (character = ((Reader)reader).read()) != -1) {
                    if (character == 10) {
                        int index = buf.indexOf("Tags:") + 5;
                        if (index > 5 && buf.length() > index) {
                            String line = buf.substring(index).trim().toLowerCase();
                            if ("not-a-test".equals(line)) continue block2;
                            tags = tags != null ? tags + " " + line : line;
                        } else if (buf.indexOf("package ") == 0) {
                            int idx = buf.lastIndexOf(";");
                            pckage = buf.substring(8, idx);
                        }
                        buf = new StringBuffer();
                        --maxLines;
                        continue;
                    }
                    buf.append((char)character);
                }
                if (pckage == null || tags == null) continue;
                String className = pckage + "." + file.getName().substring(0, file.getName().length() - 5);
                this.classes.add(new TestCase(className, tags));
                continue;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new CreateTags(new File(args[0]), new File(args[1])).create();
    }

    private static class TestCase {
        public final String className;
        public final Tags tags;

        public TestCase(String className, String tags) {
            this.className = className;
            this.tags = new Tags(tags);
        }
    }
}

