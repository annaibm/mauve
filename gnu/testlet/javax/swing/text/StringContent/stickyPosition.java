// Tags: JDK1.2

// Copyright (C) 2004 Arnaud Vandyck <avdyk@gnu.org>

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

package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.Testlet;
import gnu.testlet.TestHarness;

import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.StringContent;

public class stickyPosition implements Testlet
{
  public void test(TestHarness h)
  {
    h.checkPoint("StringContent");

    StringContent sc = new StringContent();
    try
      {
        sc.insertString(0, "classpath");
        Position position = sc.createPosition(1);
        Position position2 = sc.createPosition(4);
        h.check(1, position.getOffset(), "createPosition(1): Position.getOffset() should be 1 and is: " + position.getOffset());
        sc.insertString(2, "-");
        h.check(1, position.getOffset(), "Position.getOffset() should be 1 and is: " + position.getOffset());
        sc.insertString(1, "-");
        h.check(2, position.getOffset(), "Position.getOffset() should be 2 and is: " + position.getOffset());
        sc.remove(0, 2);
        h.check(0, position.getOffset(), "Position.getOffset() should be 0 and is: " + position.getOffset());
        sc.remove(0, 5);
        h.check(0, position.getOffset(), "Position.getOffset() should be 0 and is: " + position.getOffset());
        h.check("path\n", sc.getString(0, sc.length()), "getString(0, length()) should be 'path' and is: " + sc.getString(0, sc.length()));
        h.check(0, position2.getOffset(), "Position.getOffset() should be 0 and is: " + position2.getOffset());
      }
    catch (BadLocationException ble)
      {
        h.fail("BadLocation! " + ble.getMessage());
      }
  }

}

