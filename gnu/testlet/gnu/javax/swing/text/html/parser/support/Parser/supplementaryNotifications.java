// Tags: JDK1.2 
/* supplementaryNotifications.java --
   Copyright (C) 2005 Free Software Foundation, Inc.

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
02111-1307 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version. */


package gnu.testlet.gnu.javax.swing.text.html.parser.support.Parser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;

import gnu.testlet.gnu.javax.swing.text.html.parser.*;

import gnu.testlet.gnu.javax.swing.text.html.support.Parser.*;

/**
 * @author Audrius Meskauskas (AudriusA@Bioinformatics.org)
 */
public class supplementaryNotifications
  extends TestCase
  implements Testlet
{
  String eoln = null;
  int flushed = 0;

  public void test(TestHarness harness)
  {
    try
      {
        h = harness;
        testHTMLParsing();
      }
    catch (Exception ex)
      {
        ex.printStackTrace();
        harness.fail("Exception: " + ex);
      }
  }

  public void testHTMLParsing()
                       throws Exception
  {
    Parser_Test v =
      new Parser_Test()
      {
        public void handleEndOfLineString(String end_of_line)
        {
          eoln = end_of_line;
        }

        public void flush()
        {
          flushed++;
        }
      };

    v.hideImplied = true;

    v.verify("a \n b", "<html><head></head><body>'a b'</body></html>");

    assertEquals(eoln, "\n");

    v.verify("a \r b", "<html><head></head><body>'a b'</body></html>");

    assertEquals(eoln, "\r");

    v.verify("a \r\n b", "<html><head></head><body>'a b'</body></html>");

    assertEquals(eoln, "\r\n");

    assertEquals(flushed, 3);
  }
}