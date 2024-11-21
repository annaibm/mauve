/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.runner;

class Tags {
    boolean gui = false;
    String fromJDK = "1.0";
    String toJDK = "99.0";
    String fromJDBC = "1.0";
    String toJDBC = "99.0";

    public Tags(String line) {
        int start = 0;
        for (int i = 0; i <= line.length(); ++i) {
            if (i != line.length() && line.charAt(i) != ' ') continue;
            if (start < i) {
                this.process(line.substring(start, i));
            }
            start = i + 1;
        }
    }

    public void process(String token) {
        boolean end2 = token.startsWith("!");
        if (end2) {
            token = token.substring(1);
        }
        if (token.startsWith("jls") || token.startsWith("jdk")) {
            String value2 = token.substring(3);
            if (end2) {
                this.toJDK = value2;
            } else {
                this.fromJDK = value2;
            }
        } else if (token.startsWith("jdbc")) {
            String value3 = token.substring(4);
            if (end2) {
                this.toJDBC = value3;
            } else {
                this.fromJDBC = value3;
            }
        } else if (token.startsWith("gui")) {
            this.gui = true;
        }
    }

    public boolean isValid(double javaVersion, double JDBCVersion) throws NumberFormatException {
        double end2;
        double from;
        if (javaVersion != 0.0) {
            from = Double.parseDouble(this.fromJDK);
            if (from > javaVersion) {
                return false;
            }
            end2 = Double.parseDouble(this.toJDK);
            if (end2 < javaVersion) {
                return false;
            }
        }
        if (JDBCVersion != 0.0) {
            from = Double.parseDouble(this.fromJDBC);
            if (from < JDBCVersion) {
                return false;
            }
            end2 = Double.parseDouble(this.toJDBC);
            if (end2 > JDBCVersion) {
                return false;
            }
        }
        return true;
    }
}

