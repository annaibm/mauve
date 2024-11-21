/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextAttribute;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serialization
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.checkSerial(TextAttribute.BACKGROUND, harness);
        this.checkSerial(TextAttribute.BIDI_EMBEDDING, harness);
        this.checkSerial(TextAttribute.CHAR_REPLACEMENT, harness);
        this.checkSerial(TextAttribute.FAMILY, harness);
        this.checkSerial(TextAttribute.FONT, harness);
        this.checkSerial(TextAttribute.FOREGROUND, harness);
        this.checkSerial(TextAttribute.INPUT_METHOD_HIGHLIGHT, harness);
        this.checkSerial(TextAttribute.JUSTIFICATION, harness);
        this.checkSerial(TextAttribute.NUMERIC_SHAPING, harness);
        this.checkSerial(TextAttribute.POSTURE, harness);
        this.checkSerial(TextAttribute.RUN_DIRECTION, harness);
        this.checkSerial(TextAttribute.SIZE, harness);
        this.checkSerial(TextAttribute.STRIKETHROUGH, harness);
        this.checkSerial(TextAttribute.WEIGHT, harness);
        this.checkSerial(TextAttribute.WIDTH, harness);
    }

    private void checkSerial(TextAttribute ta1, TestHarness harness) {
        TextAttribute ta2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(ta1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            ta2 = (TextAttribute)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(ta1 == ta2);
    }
}

