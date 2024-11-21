/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.MenuShortcut;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.MenuShortcut;

public class testToString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MenuShortcut m = new MenuShortcut(10);
        harness.check(m.toString(), (Object)"Ctrl+Enter");
        harness.check(m.usesShiftModifier(), false);
        m = new MenuShortcut(8, true);
        harness.check(m.toString(), (Object)"Ctrl+Shift+Backspace");
        harness.check(m.usesShiftModifier(), true);
        m = new MenuShortcut(9);
        harness.check(m.toString(), (Object)"Ctrl+Tab");
        m = new MenuShortcut(3);
        harness.check(m.toString(), (Object)"Ctrl+Cancel");
        m = new MenuShortcut(12);
        harness.check(m.toString(), (Object)"Ctrl+Clear");
        m = new MenuShortcut(16);
        harness.check(m.toString(), (Object)"Ctrl+Shift");
        m = new MenuShortcut(17);
        harness.check(m.toString(), (Object)"Ctrl+Ctrl");
        m = new MenuShortcut(18);
        harness.check(m.toString(), (Object)"Ctrl+Alt");
        m = new MenuShortcut(19);
        harness.check(m.toString(), (Object)"Ctrl+Pause");
        m = new MenuShortcut(20);
        harness.check(m.toString(), (Object)"Ctrl+Caps Lock");
        m = new MenuShortcut(27);
        harness.check(m.toString(), (Object)"Ctrl+Escape");
        m = new MenuShortcut(32);
        harness.check(m.toString(), (Object)"Ctrl+Space");
        m = new MenuShortcut(33);
        harness.check(m.toString(), (Object)"Ctrl+Page Up");
        m = new MenuShortcut(34);
        harness.check(m.toString(), (Object)"Ctrl+Page Down");
        m = new MenuShortcut(35);
        harness.check(m.toString(), (Object)"Ctrl+End");
        m = new MenuShortcut(36);
        harness.check(m.toString(), (Object)"Ctrl+Home");
        m = new MenuShortcut(37);
        harness.check(m.toString(), (Object)"Ctrl+Left");
        m = new MenuShortcut(38);
        harness.check(m.toString(), (Object)"Ctrl+Up");
        m = new MenuShortcut(39);
        harness.check(m.toString(), (Object)"Ctrl+Right");
        m = new MenuShortcut(40);
        harness.check(m.toString(), (Object)"Ctrl+Down");
        m = new MenuShortcut(44);
        harness.check(m.toString(), (Object)"Ctrl+Comma");
        m = new MenuShortcut(46);
        harness.check(m.toString(), (Object)"Ctrl+Period");
        m = new MenuShortcut(47);
        harness.check(m.toString(), (Object)"Ctrl+Slash");
        m = new MenuShortcut(59);
        harness.check(m.toString(), (Object)"Ctrl+Semicolon");
        m = new MenuShortcut(61);
        harness.check(m.toString(), (Object)"Ctrl+Equals");
        m = new MenuShortcut(92);
        harness.check(m.toString(), (Object)"Ctrl+Back Slash");
        m = new MenuShortcut(48);
        harness.check(m.toString(), (Object)"Ctrl+0");
        m = new MenuShortcut(49);
        harness.check(m.toString(), (Object)"Ctrl+1");
        m = new MenuShortcut(50);
        harness.check(m.toString(), (Object)"Ctrl+2");
        m = new MenuShortcut(51);
        harness.check(m.toString(), (Object)"Ctrl+3");
        m = new MenuShortcut(52);
        harness.check(m.toString(), (Object)"Ctrl+4");
        m = new MenuShortcut(53);
        harness.check(m.toString(), (Object)"Ctrl+5");
        m = new MenuShortcut(54);
        harness.check(m.toString(), (Object)"Ctrl+6");
        m = new MenuShortcut(55);
        harness.check(m.toString(), (Object)"Ctrl+7");
        m = new MenuShortcut(56);
        harness.check(m.toString(), (Object)"Ctrl+8");
        m = new MenuShortcut(57);
        harness.check(m.toString(), (Object)"Ctrl+9");
        m = new MenuShortcut(96);
        harness.check(m.toString(), (Object)"Ctrl+NumPad-0");
        m = new MenuShortcut(97);
        harness.check(m.toString(), (Object)"Ctrl+NumPad-1");
        m = new MenuShortcut(98);
        harness.check(m.toString(), (Object)"Ctrl+NumPad-2");
        m = new MenuShortcut(99);
        harness.check(m.toString(), (Object)"Ctrl+NumPad-3");
        m = new MenuShortcut(100);
        harness.check(m.toString(), (Object)"Ctrl+NumPad-4");
        m = new MenuShortcut(101);
        harness.check(m.toString(), (Object)"Ctrl+NumPad-5");
        m = new MenuShortcut(102);
        harness.check(m.toString(), (Object)"Ctrl+NumPad-6");
        m = new MenuShortcut(103);
        harness.check(m.toString(), (Object)"Ctrl+NumPad-7");
        m = new MenuShortcut(104);
        harness.check(m.toString(), (Object)"Ctrl+NumPad-8");
        m = new MenuShortcut(105);
        harness.check(m.toString(), (Object)"Ctrl+NumPad-9");
        m = new MenuShortcut(106);
        harness.check(m.toString(), (Object)"Ctrl+NumPad *");
        m = new MenuShortcut(107);
        harness.check(m.toString(), (Object)"Ctrl+NumPad +");
        m = new MenuShortcut(108);
        harness.check(m.toString(), (Object)"Ctrl+NumPad ,");
        m = new MenuShortcut(109);
        harness.check(m.toString(), (Object)"Ctrl+NumPad -");
        m = new MenuShortcut(110);
        harness.check(m.toString(), (Object)"Ctrl+NumPad .");
        m = new MenuShortcut(111);
        harness.check(m.toString(), (Object)"Ctrl+NumPad /");
        m = new MenuShortcut(65);
        harness.check(m.toString(), (Object)"Ctrl+A");
        m = new MenuShortcut(66);
        harness.check(m.toString(), (Object)"Ctrl+B");
        m = new MenuShortcut(67);
        harness.check(m.toString(), (Object)"Ctrl+C");
        m = new MenuShortcut(68);
        harness.check(m.toString(), (Object)"Ctrl+D");
        m = new MenuShortcut(69);
        harness.check(m.toString(), (Object)"Ctrl+E");
        m = new MenuShortcut(70);
        harness.check(m.toString(), (Object)"Ctrl+F");
        m = new MenuShortcut(71);
        harness.check(m.toString(), (Object)"Ctrl+G");
        m = new MenuShortcut(72);
        harness.check(m.toString(), (Object)"Ctrl+H");
        m = new MenuShortcut(73);
        harness.check(m.toString(), (Object)"Ctrl+I");
        m = new MenuShortcut(74);
        harness.check(m.toString(), (Object)"Ctrl+J");
        m = new MenuShortcut(76);
        harness.check(m.toString(), (Object)"Ctrl+L");
        m = new MenuShortcut(77);
        harness.check(m.toString(), (Object)"Ctrl+M");
        m = new MenuShortcut(78);
        harness.check(m.toString(), (Object)"Ctrl+N");
        m = new MenuShortcut(79);
        harness.check(m.toString(), (Object)"Ctrl+O");
        m = new MenuShortcut(80);
        harness.check(m.toString(), (Object)"Ctrl+P");
        m = new MenuShortcut(81);
        harness.check(m.toString(), (Object)"Ctrl+Q");
        m = new MenuShortcut(82);
        harness.check(m.toString(), (Object)"Ctrl+R");
        m = new MenuShortcut(83);
        harness.check(m.toString(), (Object)"Ctrl+S");
        m = new MenuShortcut(84);
        harness.check(m.toString(), (Object)"Ctrl+T");
        m = new MenuShortcut(85);
        harness.check(m.toString(), (Object)"Ctrl+U");
        m = new MenuShortcut(86);
        harness.check(m.toString(), (Object)"Ctrl+V");
        m = new MenuShortcut(87);
        harness.check(m.toString(), (Object)"Ctrl+W");
        m = new MenuShortcut(88);
        harness.check(m.toString(), (Object)"Ctrl+X");
        m = new MenuShortcut(89);
        harness.check(m.toString(), (Object)"Ctrl+Y");
        m = new MenuShortcut(90);
        harness.check(m.toString(), (Object)"Ctrl+Z");
        m = new MenuShortcut(112);
        harness.check(m.toString(), (Object)"Ctrl+F1");
        m = new MenuShortcut(113);
        harness.check(m.toString(), (Object)"Ctrl+F2");
        m = new MenuShortcut(114);
        harness.check(m.toString(), (Object)"Ctrl+F3");
        m = new MenuShortcut(115);
        harness.check(m.toString(), (Object)"Ctrl+F4");
        m = new MenuShortcut(116);
        harness.check(m.toString(), (Object)"Ctrl+F5");
        m = new MenuShortcut(117);
        harness.check(m.toString(), (Object)"Ctrl+F6");
        m = new MenuShortcut(118);
        harness.check(m.toString(), (Object)"Ctrl+F7");
        m = new MenuShortcut(119);
        harness.check(m.toString(), (Object)"Ctrl+F8");
        m = new MenuShortcut(120);
        harness.check(m.toString(), (Object)"Ctrl+F9");
        m = new MenuShortcut(121);
        harness.check(m.toString(), (Object)"Ctrl+F10");
        m = new MenuShortcut(122);
        harness.check(m.toString(), (Object)"Ctrl+F11");
        m = new MenuShortcut(123);
        harness.check(m.toString(), (Object)"Ctrl+F12");
        m = new MenuShortcut(127);
        harness.check(m.toString(), (Object)"Ctrl+Delete");
        m = new MenuShortcut(144);
        harness.check(m.toString(), (Object)"Ctrl+Num Lock");
        m = new MenuShortcut(145);
        harness.check(m.toString(), (Object)"Ctrl+Scroll Lock");
        m = new MenuShortcut(154);
        harness.check(m.toString(), (Object)"Ctrl+Print Screen");
        m = new MenuShortcut(155);
        harness.check(m.toString(), (Object)"Ctrl+Insert");
        m = new MenuShortcut(156);
        harness.check(m.toString(), (Object)"Ctrl+Help");
        m = new MenuShortcut(157);
        harness.check(m.toString(), (Object)"Ctrl+Meta");
        m = new MenuShortcut(192);
        harness.check(m.toString(), (Object)"Ctrl+Back Quote");
        m = new MenuShortcut(222);
        harness.check(m.toString(), (Object)"Ctrl+Quote");
        m = new MenuShortcut(91);
        harness.check(m.toString(), (Object)"Ctrl+Open Bracket");
        m = new MenuShortcut(93);
        harness.check(m.toString(), (Object)"Ctrl+Close Bracket");
        m = new MenuShortcut(30);
        harness.check(m.toString(), (Object)"Ctrl+Accept");
        m = new MenuShortcut(28);
        harness.check(m.toString(), (Object)"Ctrl+Convert");
        m = new MenuShortcut(24);
        harness.check(m.toString(), (Object)"Ctrl+Final");
        m = new MenuShortcut(21);
        harness.check(m.toString(), (Object)"Ctrl+Kana");
        m = new MenuShortcut(25);
        harness.check(m.toString(), (Object)"Ctrl+Kanji");
        m = new MenuShortcut(31);
        harness.check(m.toString(), (Object)"Ctrl+Mode Change");
        m = new MenuShortcut(29);
        harness.check(m.toString(), (Object)"Ctrl+No Convert");
    }
}

