package eu.transcribathon.europeana.definitions.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TextRegion")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextRegion {

	@XmlAttribute(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "id")
	private String id;
	@XmlAttribute(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "type")
	private String type;
	@XmlElement(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "Coords")
    private Coords coords;
	@XmlElement(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "TextEquiv")
    private Text textEquiv;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Coords getCoords() {
		return coords;
	}
	public void setCoords(Coords coords) {
		this.coords = coords;
	}
	public Text getTextEquiv() {
		return textEquiv;
	}
	public void setTextEquiv(Text textEquiv) {
		this.textEquiv = textEquiv;
	}
}
