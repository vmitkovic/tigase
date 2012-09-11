/*
 * Tigase XMPP Client Library
 * Copyright (C) 2006-2012 "Bartosz Małkowski" <bartosz.malkowski@tigase.org>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://www.gnu.org/licenses/.
 */
package tigase.jaxmpp.core.client.xmpp.forms;

import java.util.List;

import tigase.jaxmpp.core.client.xml.DefaultElement;
import tigase.jaxmpp.core.client.xml.Element;
import tigase.jaxmpp.core.client.xml.XMLException;

public class ListSingleField extends AbstractField<String> {

	ListSingleField(Element element) throws XMLException {
		super("list-single", element);
	}

	public void addOption(String label, String value) throws XMLException {
		DefaultElement o = new DefaultElement("option");
		if (label != null)
			o.setAttribute("label", label);
		o.addChild(new DefaultElement("value", value, null));
		addChild(o);
	}

	public void clearOptions() throws XMLException {
		List<Element> lls = getChildren("option");
		if (lls != null)
			for (Element element : lls) {
				removeChild(element);
			}
	}

	@Override
	public String getFieldValue() throws XMLException {
		return getChildElementValue("value");
	}

	@Override
	public void setFieldValue(String value) throws XMLException {
		setChildElementValue("value", value);
	}

}