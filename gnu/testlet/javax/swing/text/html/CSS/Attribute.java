/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.CSS;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.html.CSS;

public class Attribute
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testAttribute(harness, CSS.Attribute.BACKGROUND, "background", false, null);
        this.testAttribute(harness, CSS.Attribute.BACKGROUND_ATTACHMENT, "background-attachment", false, "scroll");
        this.testAttribute(harness, CSS.Attribute.BACKGROUND_COLOR, "background-color", false, "transparent");
        this.testAttribute(harness, CSS.Attribute.BACKGROUND_IMAGE, "background-image", false, "none");
        this.testAttribute(harness, CSS.Attribute.BACKGROUND_POSITION, "background-position", false, null);
        this.testAttribute(harness, CSS.Attribute.BACKGROUND_REPEAT, "background-repeat", false, "repeat");
        this.testAttribute(harness, CSS.Attribute.BORDER, "border", false, null);
        this.testAttribute(harness, CSS.Attribute.BORDER_BOTTOM, "border-bottom", false, null);
        this.testAttribute(harness, CSS.Attribute.BORDER_BOTTOM_WIDTH, "border-bottom-width", false, "medium");
        this.testAttribute(harness, CSS.Attribute.BORDER_COLOR, "border-color", false, "black");
        this.testAttribute(harness, CSS.Attribute.BORDER_LEFT, "border-left", false, null);
        this.testAttribute(harness, CSS.Attribute.BORDER_LEFT_WIDTH, "border-left-width", false, "medium");
        this.testAttribute(harness, CSS.Attribute.BORDER_RIGHT, "border-right", false, null);
        this.testAttribute(harness, CSS.Attribute.BORDER_RIGHT_WIDTH, "border-right-width", false, "medium");
        this.testAttribute(harness, CSS.Attribute.BORDER_STYLE, "border-style", false, "none");
        this.testAttribute(harness, CSS.Attribute.BORDER_TOP, "border-top", false, null);
        this.testAttribute(harness, CSS.Attribute.BORDER_TOP_WIDTH, "border-top-width", false, "medium");
        this.testAttribute(harness, CSS.Attribute.BORDER_WIDTH, "border-width", false, "medium");
        this.testAttribute(harness, CSS.Attribute.CLEAR, "clear", false, "none");
        this.testAttribute(harness, CSS.Attribute.COLOR, "color", true, "black");
        this.testAttribute(harness, CSS.Attribute.DISPLAY, "display", false, "block");
        this.testAttribute(harness, CSS.Attribute.FLOAT, "float", false, "none");
        this.testAttribute(harness, CSS.Attribute.FONT, "font", true, null);
        this.testAttribute(harness, CSS.Attribute.FONT_FAMILY, "font-family", true, null);
        this.testAttribute(harness, CSS.Attribute.FONT_SIZE, "font-size", true, "medium");
        this.testAttribute(harness, CSS.Attribute.FONT_STYLE, "font-style", true, "normal");
        this.testAttribute(harness, CSS.Attribute.FONT_VARIANT, "font-variant", true, "normal");
        this.testAttribute(harness, CSS.Attribute.FONT_WEIGHT, "font-weight", true, "normal");
        this.testAttribute(harness, CSS.Attribute.HEIGHT, "height", false, "auto");
        this.testAttribute(harness, CSS.Attribute.LETTER_SPACING, "letter-spacing", true, "normal");
        this.testAttribute(harness, CSS.Attribute.LINE_HEIGHT, "line-height", true, "normal");
        this.testAttribute(harness, CSS.Attribute.LIST_STYLE, "list-style", true, null);
        this.testAttribute(harness, CSS.Attribute.LIST_STYLE_IMAGE, "list-style-image", true, "none");
        this.testAttribute(harness, CSS.Attribute.LIST_STYLE_POSITION, "list-style-position", true, "outside");
        this.testAttribute(harness, CSS.Attribute.LIST_STYLE_TYPE, "list-style-type", true, "disc");
        this.testAttribute(harness, CSS.Attribute.MARGIN, "margin", false, null);
        this.testAttribute(harness, CSS.Attribute.MARGIN_BOTTOM, "margin-bottom", false, "0");
        this.testAttribute(harness, CSS.Attribute.MARGIN_LEFT, "margin-left", false, "0");
        this.testAttribute(harness, CSS.Attribute.MARGIN_RIGHT, "margin-right", false, "0");
        this.testAttribute(harness, CSS.Attribute.MARGIN_TOP, "margin-top", false, "0");
        this.testAttribute(harness, CSS.Attribute.PADDING, "padding", false, null);
        this.testAttribute(harness, CSS.Attribute.PADDING_BOTTOM, "padding-bottom", false, "0");
        this.testAttribute(harness, CSS.Attribute.PADDING_LEFT, "padding-left", false, "0");
        this.testAttribute(harness, CSS.Attribute.PADDING_RIGHT, "padding-right", false, "0");
        this.testAttribute(harness, CSS.Attribute.PADDING_TOP, "padding-top", false, "0");
        this.testAttribute(harness, CSS.Attribute.TEXT_ALIGN, "text-align", true, null);
        this.testAttribute(harness, CSS.Attribute.TEXT_DECORATION, "text-decoration", true, "none");
        this.testAttribute(harness, CSS.Attribute.TEXT_INDENT, "text-indent", true, "0");
        this.testAttribute(harness, CSS.Attribute.TEXT_TRANSFORM, "text-transform", true, "none");
        this.testAttribute(harness, CSS.Attribute.VERTICAL_ALIGN, "vertical-align", false, "baseline");
        this.testAttribute(harness, CSS.Attribute.WHITE_SPACE, "white-space", true, "normal");
        this.testAttribute(harness, CSS.Attribute.WIDTH, "width", false, "auto");
        this.testAttribute(harness, CSS.Attribute.WORD_SPACING, "word-spacing", true, "normal");
    }

    void testAttribute(TestHarness harness, CSS.Attribute att, String attStr, boolean inherited, String defaultValue) {
        harness.check(att.toString(), (Object)attStr);
        harness.check(att.isInherited(), inherited);
        harness.check(att.getDefaultValue(), (Object)defaultValue);
    }
}

