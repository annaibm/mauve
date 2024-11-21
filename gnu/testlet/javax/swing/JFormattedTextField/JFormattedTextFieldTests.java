/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFormattedTextField;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class JFormattedTextFieldTests
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFormattedTextField field = new JFormattedTextField();
        harness.checkPoint("defaults");
        harness.check(((AbstractDocument)field.getDocument()).getDocumentFilter() == null);
        harness.check(field.getFormatterFactory() == null);
        harness.check(field.getFormatter() == null);
        harness.checkPoint("implicit creation of formatter and factory");
        field.setValue("aBcDeFg");
        harness.check(((AbstractDocument)field.getDocument()).getDocumentFilter() != null);
        harness.check(field.getFormatterFactory().getClass(), DefaultFormatterFactory.class);
        harness.check(field.getFormatter().getClass(), DefaultFormatter.class);
        harness.checkPoint("setting formatter changes the text");
        MaskFormatter mask = null;
        DefaultFormatter nullFormatter = new DefaultFormatter();
        try {
            mask = new MaskFormatter("UUUUUUU");
        }
        catch (ParseException parseException) {
            // empty catch block
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(mask, null, null, nullFormatter);
        harness.check(field.getText().equals("aBcDeFg"));
        field.setFormatterFactory(factory);
        harness.check(field.getText().equals("ABCDEFG"));
        harness.checkPoint("field value going to null brings in nullFormatter");
        field.setValue(null);
        harness.check(field.getFormatter().getClass(), DefaultFormatter.class);
        harness.checkPoint("removing the DocumentFilter");
        field.getFormatter().uninstall();
        harness.check(((AbstractDocument)field.getDocument()).getDocumentFilter() == null);
    }
}

