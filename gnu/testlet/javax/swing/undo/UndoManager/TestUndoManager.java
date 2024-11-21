/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.undo.UndoManager;

import java.util.Vector;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

public class TestUndoManager
extends UndoManager {
    public int numTrimForLimitCalls;

    @Override
    protected void trimForLimit() {
        ++this.numTrimForLimitCalls;
        super.trimForLimit();
    }

    public Vector getEdits() {
        return this.edits;
    }

    public void invokeTrimEdits(int from, int to2) {
        this.trimEdits(from, to2);
    }

    public void invokeRedoTo(UndoableEdit edit) {
        this.redoTo(edit);
    }

    public void invokeUndoTo(UndoableEdit edit) {
        this.undoTo(edit);
    }

    public UndoableEdit getEditToBeRedone() {
        return this.editToBeRedone();
    }

    public UndoableEdit getEditToBeUndone() {
        return this.editToBeUndone();
    }

    public TestEdit[] addTestEdits(int firstID, int count) {
        TestEdit[] result = new TestEdit[count];
        for (int i = 0; i < count; ++i) {
            result[i] = new TestEdit(firstID + i);
            this.addEdit(result[i]);
        }
        return result;
    }

    public boolean checkIDs(int[] expected) {
        if (expected.length != this.edits.size()) {
            return false;
        }
        for (int i = 0; i < expected.length; ++i) {
            if (expected[i] == ((TestEdit)this.edits.get((int)i)).id) continue;
            return false;
        }
        return true;
    }

    public static class TestEdit
    extends AbstractUndoableEdit {
        public final int id;
        private boolean significant = true;
        private boolean inhibitCanRedo = false;
        private boolean inhibitCanUndo = false;

        public TestEdit(int id) {
            this.id = id;
        }

        public boolean isAlive() {
            return this.canRedo() || this.canUndo();
        }

        @Override
        public boolean isSignificant() {
            return this.significant;
        }

        public void setSignificant(boolean significant) {
            this.significant = significant;
        }

        public void inhibitCanUndo() {
            this.inhibitCanUndo = true;
        }

        public void inhibitCanRedo() {
            this.inhibitCanRedo = true;
        }

        @Override
        public String toString() {
            return super.toString() + " id: " + this.id;
        }

        @Override
        public boolean canRedo() {
            if (this.inhibitCanRedo) {
                return false;
            }
            return super.canRedo();
        }

        @Override
        public boolean canUndo() {
            if (this.inhibitCanUndo) {
                return false;
            }
            return super.canUndo();
        }

        @Override
        public String getUndoPresentationName() {
            return "UndoPres" + this.id;
        }

        @Override
        public String getRedoPresentationName() {
            return "RedoPres" + this.id;
        }
    }
}

