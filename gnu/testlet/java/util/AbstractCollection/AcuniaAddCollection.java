/* Copyright (C) 2001 ACUNIA

   This file is part of Mauve.

   Mauve is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2, or (at your option)
   any later version.

   Mauve is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with Mauve; see the file COPYING.  If not, write to
   the Free Software Foundation, 59 Temple Place - Suite 330,
   Boston, MA 02111-1307, USA.
*/

// Tags: JLS1.2

package gnu.testlet.java.util.AbstractCollection;
import java.util.*;

/*
*  Written by ACUNIA
*
*  this class extends AbstractCollection and is used to test java.uitl.AbstractCollection
*  used by AcuniaAbstractCollectionTest
*/
public class AcuniaAddCollection extends AbstractCollection
{
	public Vector v;
	private boolean retadd=true;
	

	public AcuniaAddCollection(){
		super();
		v=new Vector();
	}
	
	public int size() {
		return v.size();
	}
		
	
	public boolean add(Object o) {
		if (retadd)v.add(o);
		return retadd;
	}

	
	public Iterator iterator() {
		return v.iterator();
	}
	
	public void setRA(boolean b) {
		retadd=b;
	}

}	