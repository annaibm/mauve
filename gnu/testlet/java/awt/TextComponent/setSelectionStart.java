/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.TextComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.TextComponent;
import java.awt.TextField;

public class setSelectionStart
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TextField textComp = new TextField();
        harness.check(textComp.getSelectionStart(), 0);
        harness.check(textComp.getSelectionEnd(), 0);
        ((TextComponent)textComp).setText("This is some text.");
        harness.check(textComp.getSelectionStart(), 0);
        harness.check(textComp.getSelectionEnd(), 0);
        textComp.setSelectionStart(-6);
        harness.check(textComp.getSelectionStart(), 0);
        harness.check(textComp.getSelectionEnd(), 0);
        textComp.setSelectionStart(0);
        harness.check(textComp.getSelectionStart(), 0);
        harness.check(textComp.getSelectionEnd(), 0);
        textComp.setSelectionStart(13);
        harness.check(textComp.getSelectionStart(), 13);
        harness.check(textComp.getSelectionEnd(), 13);
        textComp.setSelectionStart(9);
        harness.check(textComp.getSelectionStart(), 9);
        harness.check(textComp.getSelectionEnd(), 13);
    }
}

