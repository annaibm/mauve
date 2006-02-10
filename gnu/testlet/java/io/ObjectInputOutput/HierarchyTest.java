/* HierarchyTest.java -- Tests which checks the deserialization of a hierarchy
 of class including an abstract but useful constructor 
 Copyright (C) 2006 Olivier Jolly <olivier.jolly@pcedev.com>
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

// Tags: JDK1.2


package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Tests which ensures that abstract constructors are replayed during
 * deserialization.
 * @author Olivier Jolly <olivier.jolly@pcedev.com>
 */
public class HierarchyTest implements Testlet
{

  public void test(TestHarness harness)
  {

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream objectOutputStream = null;
    try
      {
        objectOutputStream = new ObjectOutputStream(baos);
        objectOutputStream.writeObject(new Derived());
      }
    catch (IOException e)
      {
        harness.debug(e);
        harness.fail("Serialiazing a simple class deriving from a non serializable class");
      }

    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

    try
      {
        ObjectInputStream objectInputStream = new ObjectInputStream(bais);
        Derived serialized = (Derived) objectInputStream.readObject();
        harness.check(serialized.getA(), new Integer(-1),
                      "Checking value from non serializable super class");

      }
    catch (Exception e)
      {
        // If the deserializating failed
        harness.debug(e);
        harness.fail("Deserialiazing a simple class");
      }

  }

  /**
   * Base class for test. It is abstract but set a field to something else than
   * the default value. Checking that this value is not null will prove that we
   * used this class constructor
   */
  private static abstract class Base
  {
    private Integer a = new Integer(-1);

    Integer getA()
    {
      return a;
    }

  }

  /**
   * Derived class, which only exists to be instanciated.
   */
  private static class Derived extends Base implements Serializable
  {

    private static final long serialVersionUID = 7027787387780503451L;

  }

}
