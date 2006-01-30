// Copyright (C) 2006 Red Hat, Inc.
// Written by Gary Benson <gbenson@redhat.com>

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

package gnu.testlet.java.lang.ClassLoader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Permission;

import gnu.testlet.Testlet;
import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager2;

public class security implements Testlet
{
  public void test(TestHarness harness)
  {
    try {
      harness.checkPoint("setup");

      // we need a different classloader for some of the checks to occur.
      Class testClass = new URLClassLoader(new URL[] {
	new File(harness.getSourceDirectory()).toURL()}, null).loadClass(
	  getClass().getName());

      ClassLoader ourLoader = getClass().getClassLoader();
      harness.check(ourLoader != testClass.getClassLoader());

      Method getSystemClassLoaderTest = testClass.getMethod(
	"testGetSystemClassLoader", new Class[] {});

      Method getParentTest = testClass.getMethod(
	"testGetParent", new Class[] {ClassLoader.class});
      
      // Make sure everything's fully resolved, or we'll be loading
      // classes during tests and the extra checks will make us fail.
      new TestClassLoader();

      Permission[] createClassLoader = new Permission[] {
	new RuntimePermission("createClassLoader")};

      Permission[] getClassLoader = new Permission[] {
	new RuntimePermission("getClassLoader")};

      Permission[] noPerms = new Permission[] {};

      TestSecurityManager2 sm = new TestSecurityManager2(harness);
      try {
	sm.install();

	// security: java.lang.ClassLoader-ClassLoader()
	harness.checkPoint("Constructor (no-args)");
	try {
	  sm.prepareChecks(createClassLoader, noPerms);
	  new TestClassLoader();
	  sm.checkAllChecked(harness);
	}
	catch (SecurityException ex) {
	  harness.debug(ex);
	  harness.check(false, "unexpected check");
	}

	// security: java.lang.ClassLoader-ClassLoader(ClassLoader)
	harness.checkPoint("Constructor (one-arg)");
	try {
	  sm.prepareChecks(createClassLoader, noPerms);
	  new TestClassLoader(ourLoader);
	  sm.checkAllChecked(harness);
	}
	catch (SecurityException ex) {
	  harness.debug(ex);
	  harness.check(false, "unexpected check");
	}

	// security: java.lang.ClassLoader-getSystemClassLoader
	harness.checkPoint("getSystemClassLoader");
	try {
	  sm.prepareChecks(getClassLoader, noPerms);
	  getSystemClassLoaderTest.invoke(null, new Object[] {});
	  sm.checkAllChecked(harness);
	}
	catch (SecurityException ex) {
	  harness.debug(ex);
	  harness.check(false, "unexpected check");
	}

	// security: java.lang.ClassLoader-getParent
	harness.checkPoint("getParent");
	try {
	  sm.prepareChecks(getClassLoader, noPerms);
	  getParentTest.invoke(null, new Object[] {ourLoader});
	  sm.checkAllChecked(harness);
	}
	catch (SecurityException ex) {
	  harness.debug(ex);
	  harness.check(false, "unexpected check");
	}
      }
      finally {
	sm.uninstall();
      }
    }
    catch (Throwable ex) {
      harness.debug(ex);
      harness.check(false, "Unexpected exception");
    }
  }

  // Stuff for the createClassLoader tests
  private static class TestClassLoader extends ClassLoader
  {
    public TestClassLoader()
    {
      super();
    }

    public TestClassLoader(ClassLoader parent)
    {
      super(parent);
    }
  }

  // Stuff for the getClassLoader tests
  public static void testGetSystemClassLoader()
  {
    ClassLoader.getSystemClassLoader();
  }

  public static void testGetParent(ClassLoader loader)
  {
    loader.getParent();
  }
}