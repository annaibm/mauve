// Tags: JDK1.2

// Copyright (C) 2004 Sascha Brawer <brawer@dandelis.ch>

// This file is part of Mauve.

// Mauve is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2, or (at your option)
// any later version.

// Mauve is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with Mauve; see the file COPYING.  If not, write to
// the Free Software Foundation, 59 Temple Place - Suite 330,
// Boston, MA 02111-1307, USA.

package gnu.testlet.javax.swing.undo.UndoableEditSupport;

import gnu.testlet.Testlet;
import gnu.testlet.TestHarness;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoableEditSupport;


/**
 * @author <a href="mailto:brawer@dandelis.ch">Sascha Brawer</a>
 */
public class createCompoundEdit
  implements Testlet
{
  public void test(TestHarness harness)
  {
    MyUES ues;
    CompoundEdit c1, c2;

    ues = new MyUES();
    c1 = ues.cce();
    c2 = ues.cce();

    // Check #1.
    harness.check(c1 != null);

    // Check #1.
    harness.check(c2 != null);

    // Check #3: Is it a shared instance? No.
    harness.check(c1 != c2);
  }

  private static class MyUES
    extends UndoableEditSupport
  {
    public CompoundEdit cce()
    {
      return createCompoundEdit();
    }
  }
}
