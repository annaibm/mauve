/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.AttributeList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.html.parser.AttributeList;
import javax.swing.text.html.parser.DTDConstants;

public class AttributeList_test
implements Testlet,
DTDConstants {
    @Override
    public void test(TestHarness a_harness) {
        for (int i = 0; i < 20; ++i) {
            String type = AttributeList.type2name(i);
            if (type == null) continue;
            a_harness.check(i, AttributeList.name2type(type));
        }
        a_harness.check(AttributeList.type2name(1), (Object)"CDATA");
        a_harness.check(AttributeList.name2type("CDATA"), 1);
        a_harness.check(AttributeList.type2name(2), (Object)"ENTITY");
        a_harness.check(AttributeList.name2type("ENTITY"), 2);
        a_harness.check(AttributeList.type2name(7), (Object)"NAME");
        a_harness.check(AttributeList.name2type("NAME"), 7);
    }
}

