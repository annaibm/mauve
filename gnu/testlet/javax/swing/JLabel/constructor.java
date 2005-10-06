// Tags: JDK1.2

// Copyright (C) 2005 Roman Kennke <kennke@aicas.com>

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

package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.Testlet;
import gnu.testlet.TestHarness;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Tests if the constructor sets the default values for the JLabel's properties
 * correctly.
 *
 * @author Roman Kennke (kennke@aicas.com)
 */
public class constructor implements Testlet
{
  public void test(TestHarness harness)
  {
    JLabel l = new JLabel();
    harness.check(l.getAlignmentX(), 0.0F, "alignmentX");
    harness.check(l.getAlignmentY(), 0.5F, "alignmentY");
    harness.check(l.getHorizontalAlignment(), SwingConstants.LEADING,
                  "horizontalAlignment");
    harness.check(l.getVerticalAlignment(), SwingConstants.CENTER,
                  "verticalAlignment");
    
  }
}
