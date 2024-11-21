/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.StyleConstants;

public class constants
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check("component".equals("component"));
        harness.check("icon".equals("icon"));
        harness.check(StyleConstants.ModelAttribute.toString(), (Object)"model");
        harness.check(StyleConstants.NameAttribute.toString(), (Object)"name");
        harness.check(StyleConstants.ResolveAttribute.toString(), (Object)"resolver");
        harness.check(StyleConstants.Background.equals(StyleConstants.CharacterConstants.Background));
        harness.check(StyleConstants.BidiLevel.equals(StyleConstants.CharacterConstants.BidiLevel));
        harness.check(StyleConstants.Bold.equals(StyleConstants.CharacterConstants.Bold));
        harness.check(StyleConstants.ComponentAttribute.equals(StyleConstants.CharacterConstants.ComponentAttribute));
        harness.check(StyleConstants.Family.equals(StyleConstants.CharacterConstants.Family));
        harness.check(StyleConstants.Foreground.equals(StyleConstants.CharacterConstants.Foreground));
        harness.check(StyleConstants.IconAttribute.equals(StyleConstants.CharacterConstants.IconAttribute));
        harness.check(StyleConstants.Italic.equals(StyleConstants.CharacterConstants.Italic));
        harness.check(StyleConstants.Size.equals(StyleConstants.CharacterConstants.Size));
        harness.check(StyleConstants.StrikeThrough.equals(StyleConstants.CharacterConstants.StrikeThrough));
        harness.check(StyleConstants.Subscript.equals(StyleConstants.CharacterConstants.Subscript));
        harness.check(StyleConstants.Superscript.equals(StyleConstants.CharacterConstants.Superscript));
        harness.check(StyleConstants.Underline.equals(StyleConstants.CharacterConstants.Underline));
        harness.check(StyleConstants.Background.equals(StyleConstants.ColorConstants.Background));
        harness.check(StyleConstants.Foreground.equals(StyleConstants.ColorConstants.Foreground));
        harness.check(StyleConstants.Bold.equals(StyleConstants.FontConstants.Bold));
        harness.check(StyleConstants.Family.equals(StyleConstants.FontConstants.Family));
        harness.check(StyleConstants.Italic.equals(StyleConstants.FontConstants.Italic));
        harness.check(StyleConstants.Size.equals(StyleConstants.FontConstants.Size));
        harness.check(StyleConstants.Alignment.equals(StyleConstants.ParagraphConstants.Alignment));
        harness.check(StyleConstants.FirstLineIndent.equals(StyleConstants.ParagraphConstants.FirstLineIndent));
        harness.check(StyleConstants.LeftIndent.equals(StyleConstants.ParagraphConstants.LeftIndent));
        harness.check(StyleConstants.LineSpacing.equals(StyleConstants.ParagraphConstants.LineSpacing));
        harness.check(StyleConstants.Orientation.equals(StyleConstants.ParagraphConstants.Orientation));
        harness.check(StyleConstants.RightIndent.equals(StyleConstants.ParagraphConstants.RightIndent));
        harness.check(StyleConstants.SpaceAbove.equals(StyleConstants.ParagraphConstants.SpaceAbove));
        harness.check(StyleConstants.SpaceBelow.equals(StyleConstants.ParagraphConstants.SpaceBelow));
        harness.check(StyleConstants.TabSet.equals(StyleConstants.ParagraphConstants.TabSet));
    }
}

