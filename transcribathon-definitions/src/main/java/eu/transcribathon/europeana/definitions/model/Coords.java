package eu.transcribathon.europeana.definitions.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Coords")
@XmlAccessorType(XmlAccessType.FIELD)
public class Coords {

	@XmlAttribute(name = "points")
	private String points;

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}
}
