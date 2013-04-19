/*
 * Created on 27 f�vr. 2005
 * 
 *   Firemox is a turn based strategy simulator
 *   Copyright (C) 2003-2007 Fabrice Daugan
 *
 *   This program is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by the Free 
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 *
 *   This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more 
 * details.
 *
 *   You should have received a copy of the GNU General Public License along  
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package net.sf.firemox.xml.test;

import java.io.IOException;
import java.io.OutputStream;

import net.sf.firemox.test.IdTest;
import net.sf.firemox.xml.XmlParser;
import net.sf.firemox.xml.XmlTest;
import net.sf.firemox.xml.XmlToMDB;
import net.sf.firemox.xml.XmlTools;

/**
 * @author <a href="mailto:fabdouglas@users.sourceforge.net">Fabrice Daugan </a>
 * @since 0.82
 */
public class Hasproperty implements XmlToMDB {

	/**
	 * Write the contained test of the specified node <br>
	 * <ul>
	 * Structure of stream : Data[size]
	 * <li>idTest [1]</li>
	 * <li>used target for test [1]
	 * <li>expression of Property to test [...]</li>
	 * </ul>
	 * 
	 * @param node
	 *          the XML test container structure
	 * @param out
	 *          output stream where the card structure will be saved
	 * @return the amount of written action, so return always ZERO.
	 * @throws IOException
	 */
	public final int buildMdb(XmlParser.Node node, OutputStream out)
			throws IOException {
		boolean notFrom = "true".equals(node.getAttribute("not-created-by-me"));

		if (node.getAttribute("color-mask") != null) {
			XmlTest.buildMdbCard(node, out, IdTest.HAS_PROPERTY_INTERSECTION_COLOR);
			XmlTools.writeTestOn(out, node.getAttribute("color-mask"));
		} else if (node.getAttribute("idcard-mask") != null) {
			XmlTest.buildMdbCard(node, out, IdTest.HAS_PROPERTY_INTERSECTION_IDCARD);
			XmlTools.writeTestOn(out, node.getAttribute("idcard-mask"));
		} else if (node.getAttribute("property-mask") != null) {
			XmlTest
					.buildMdbCard(node, out, IdTest.HAS_PROPERTY_INTERSECTION_PROPERTY);
			XmlTools.writeTestOn(out, node.getAttribute("property-mask"));
		} else {
			// simple property test
			XmlTest.buildMdbCard(node, out, notFrom ? IdTest.HAS_PROPERTY_NOT_FROM
					: IdTest.HAS_PROPERTY);
		}
		XmlTools.writeAttrOptions(node, "property", out);
		return 0;
	}

}