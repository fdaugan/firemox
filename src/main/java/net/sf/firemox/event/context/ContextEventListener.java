/*
 * MContextEventListener.java
 * Created on 19 f�vr. 2004
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
package net.sf.firemox.event.context;

import net.sf.firemox.clickable.target.card.MCard;

/**
 * @author <a href="mailto:fabdouglas@users.sourceforge.net">Fabrice Daugan </a>
 * @since 0.54
 */
public interface ContextEventListener {

	/**
	 * Verify the timestamp of the specified card
	 * 
	 * @param card
	 *          the concerned object.
	 * @return true if the timestamp is correct.
	 */
	boolean checkTimeStamp(MCard card);

	/**
	 * Decrement the reference counter for the current timestamp of this card.
	 */
	void removeTimestamp();

	/**
	 * Return the card source of the event attached to this context.
	 * 
	 * @return the card source of the event attached to this context.
	 */
	MCard getEventSource();

	/**
	 * The zone attched to this context.
	 * 
	 * @return zone attched to this context.
	 */
	int getZoneContext();

}