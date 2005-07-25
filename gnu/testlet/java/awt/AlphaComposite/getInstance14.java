// Tags: JDK1.4

// Copyright (C) 2005 David Gilbert <david.gilbert@object-refinery.com>

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
// Boston, MA 02111-1307, USA.  */

package gnu.testlet.java.awt.AlphaComposite;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.awt.AlphaComposite;

/**
 * Some checks for the getInstance() method in the {@link AlphaComposite} class
 * using constants available since 1.4.  
 */
public class getInstance14 implements Testlet 
{

  /**
   * Runs the test using the specified harness.
   * 
   * @param harness  the test harness (<code>null</code> not permitted).
   */
  public void test(TestHarness harness)  
  {
    // SRC_ATOP
    AlphaComposite a = AlphaComposite.getInstance(AlphaComposite.SRC_ATOP);
    harness.check(a.getRule(), AlphaComposite.SRC_ATOP);
    harness.check(a.getAlpha(), 1.0f);

    // DST_ATOP
    a = AlphaComposite.getInstance(AlphaComposite.DST_ATOP);
    harness.check(a.getRule(), AlphaComposite.DST_ATOP);
    harness.check(a.getAlpha(), 1.0f);  

    // XOR
    a = AlphaComposite.getInstance(AlphaComposite.XOR);
    harness.check(a.getRule(), AlphaComposite.XOR);
    harness.check(a.getAlpha(), 1.0f);
  }

}