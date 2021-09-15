package eu.transcribathon.europeana.definitions.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TextEquiv")
@XmlAccessorType(XmlAccessType.FIELD)
public class Text {

	@XmlElement(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "Unicode")
	private String unicode;

	public String getUnicode() {
		return unicode;
	}

	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}
}
