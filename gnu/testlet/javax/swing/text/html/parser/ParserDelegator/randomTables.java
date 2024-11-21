/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.ParserDelegator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.html.parser.ParserDelegator.parsingTester;
import java.util.Random;

public class randomTables
extends parsingTester
implements Testlet {
    static int TABLES_TO_TEST = 101;
    Random r = new Random();

    public String s() {
        if (this.r.nextBoolean()) {
            return "";
        }
        StringBuffer b = new StringBuffer();
        int spc = this.r.nextInt(4);
        for (int i = 0; i < spc; ++i) {
            b.append(' ');
        }
        return b.toString();
    }

    @Override
    public void test(TestHarness a_harness) {
        this.harness = a_harness;
        this.hideImplied = true;
        for (int i = 0; i < TABLES_TO_TEST; ++i) {
            try {
                new table().test();
                continue;
            }
            catch (Exception ex) {
                this.harness.fail(ex.toString());
            }
        }
    }

    class table {
        final String[][] rows;
        final boolean caption;

        table() {
            this.caption = randomTables.this.r.nextBoolean();
            int nrows = randomTables.this.r.nextInt(5) + 1;
            this.rows = new String[nrows][];
            for (int i = 0; i < this.rows.length; ++i) {
                int ncol = randomTables.this.r.nextInt(5) + 1;
                this.rows[i] = new String[ncol];
                for (int j = 0; j < this.rows[i].length; ++j) {
                    this.rows[i][j] = "C_" + i + "_" + j;
                }
            }
        }

        public String getHtml() {
            StringBuffer b = new StringBuffer("<html><head></head><body><table>");
            if (this.caption) {
                b.append("<caption>capt</caption>");
            }
            for (int row = 0; row < this.rows.length; ++row) {
                b.append("<tr" + randomTables.this.s() + ">");
                for (int col = 0; col < this.rows[row].length; ++col) {
                    b.append("<td" + randomTables.this.s() + ">");
                    b.append(this.rows[row][col]);
                    if (!randomTables.this.r.nextBoolean()) continue;
                    b.append("</td" + randomTables.this.s() + ">");
                }
                if (!randomTables.this.r.nextBoolean()) continue;
                b.append("</tr" + randomTables.this.s() + ">");
            }
            b.append("</table></body></html>");
            return b.toString();
        }

        public String getTrace() {
            StringBuffer b = new StringBuffer("<html><head></head><body><table>");
            if (this.caption) {
                b.append("<caption>'capt'</caption>");
            }
            for (int row = 0; row < this.rows.length; ++row) {
                b.append("<tr>");
                for (int col = 0; col < this.rows[row].length; ++col) {
                    b.append("<td>'" + this.rows[row][col] + "'</td>");
                }
                b.append("</tr>");
            }
            b.append("</table></body></html>");
            return b.toString();
        }

        void test() throws Exception {
            String trace = this.getTrace();
            String html = this.getHtml();
            randomTables.this.verify(html, trace, html + ":" + trace);
        }
    }
}

