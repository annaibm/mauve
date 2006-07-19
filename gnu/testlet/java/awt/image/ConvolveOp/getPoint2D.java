/* getPoint2D.java -- some checks for the getPoint2D() method in the
       ConvolveOp class.
   Copyright (C) 2006 David Gilbert <david.gilbert@object-refinery.com>
This file is part of Mauve.

Mauve is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

Mauve is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with Mauve; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

*/

// Tags: JD1.4

package gnu.testlet.java.awt.image.ConvolveOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class getPoint2D implements Testlet
{
  public void test(TestHarness harness)
  {
    Kernel k1 = new Kernel(3, 3, new float[] {1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 
            9f});
    ConvolveOp op = new ConvolveOp(k1, ConvolveOp.EDGE_NO_OP, null);

    Point2D p = new Point(7, 8);
    Point2D dest = new Point(0, 0);
    Point2D p1 = op.getPoint2D(p, dest);
    harness.check(p1, p);
    harness.check(p1 == dest);
    
    p1 = op.getPoint2D(p, null);
    harness.check(p1, p);
    harness.check(p1 != dest);
    
    // try null point
    boolean pass = false;
    try
    {
      op.getPoint2D(null, dest);
    }
    catch (NullPointerException e)
    {
      pass = true;
    }
    harness.check(pass);
  }

}
