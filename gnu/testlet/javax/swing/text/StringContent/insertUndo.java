/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Locale;
import javax.swing.text.BadLocationException;
import javax.swing.text.StringContent;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

public class insertUndo
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("StringContent -- InsertUndo");
        StringContent sc = new StringContent();
        UndoableEdit ue = null;
        UndoableEdit ue2 = null;
        UndoableEdit ue3 = null;
        try {
            h.checkPoint("StringContent -- insertString()");
            ue = sc.insertString(0, "path");
            h.check("path\n", sc.getString(0, sc.length()), "StringContent.insertString(): insert 'path' at 0");
            Locale.setDefault(Locale.US);
            String presentationName = ue.getPresentationName();
            h.check("", presentationName, "PresentationName should be '' and is: " + presentationName);
            String redoPresentationName = ue.getRedoPresentationName();
            h.check("Redo", redoPresentationName, "RedoPresentationName should be Redo and is: " + redoPresentationName);
            String undoPresentationName = ue.getUndoPresentationName();
            h.check("Undo", undoPresentationName, "UndoPresentationName should be Undo and is: " + undoPresentationName);
            h.check(false, ue.canRedo(), "canRedo? () (" + ue.canRedo() + ")");
            h.check(true, ue.canUndo(), "canUndo? () (" + ue.canUndo() + ")");
            ue.undo();
            h.check("\n", sc.getString(0, sc.length()), "Undo: should be '\\n' and is: " + sc.getString(0, sc.length()));
            h.check(true, ue.canRedo(), "canRedo? () (" + ue.canRedo() + ")");
            h.check(false, ue.canUndo(), "canUndo? () (" + ue.canUndo() + ")");
            ue.redo();
            h.check("path\n", sc.getString(0, sc.length()), "Redo: should be '\\n' and is: " + sc.getString(0, sc.length()));
            ue.die();
            h.debug("UndoableEdit.die() no more undo/redo");
            h.check(false, ue.canUndo(), "die, no more undo");
            h.check(false, ue.canRedo(), "die, no more redo");
            sc = new StringContent();
            ue = sc.insertString(0, "path");
            ue2 = sc.insertString(0, "class");
            h.check("classpath\n", sc.getString(0, sc.length()), "should be classpath and is: " + sc.getString(0, sc.length()));
            h.check(true, ue.canUndo(), "double undo can undo?");
            ue.undo();
            h.check("spath\n", sc.getString(0, sc.length()), "double undo: should be 'spath\\n' and is: " + sc.getString(0, sc.length()));
            ue2.undo();
            h.check("\n", sc.getString(0, sc.length()), "double undo: should be '\\n' and is: " + sc.getString(0, sc.length()));
            ue.redo();
            h.check("clas\n", sc.getString(0, sc.length()), "double undo: should be 'clas\\n' and is: " + sc.getString(0, sc.length()));
            ue2.redo();
            h.check("spathclas\n", sc.getString(0, sc.length()), "double undo: should be 'spathclas\\n' and is: " + sc.getString(0, sc.length()));
            ue3 = sc.insertString(9, "X");
            h.check("spathclasX\n", sc.getString(0, sc.length()), "add an X: should be 'spathclasX\\n' and is: " + sc.getString(0, sc.length()));
            ue.undo();
            h.check("hclasX\n", sc.getString(0, sc.length()), "undo first position: should be 'hclasX\\n' and is: " + sc.getString(0, sc.length()));
        }
        catch (BadLocationException ble) {
            h.fail("BadLocation! " + ble.getMessage());
        }
        try {
            ue3.undo();
            h.fail("should not be able to undo!");
        }
        catch (CannotUndoException cannot) {
            h.checkPoint("cannot undo");
        }
        try {
            sc = new StringContent();
            ue = sc.insertString(0, "class");
            ue2 = sc.insertString(0, "super ");
            ue3 = sc.insertString(11, "path");
            h.check("super classpath\n", sc.getString(0, sc.length()), "insert 'super classpath': " + sc.getString(0, sc.length()));
            ue.undo();
            h.check(" classpath\n", sc.getString(0, sc.length()), "undo ' classpath': " + sc.getString(0, sc.length()));
            ue.undo();
            h.fail("should not be able to undo two times");
        }
        catch (BadLocationException ble) {
            h.fail("BadLocation! " + ble.getMessage());
        }
        catch (CannotUndoException cannot) {
            h.checkPoint("cannot undo several times");
        }
    }
}

