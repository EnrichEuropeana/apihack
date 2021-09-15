package eu.transcribathon.europeana.definitions.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class Metadata {

	@XmlElement(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "Creator")
    private String creator;
	@XmlElement(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "Created")
    private Date created;
	@XmlElement(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "LastChange")
    private Date lastChange;
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastChange() {
		return lastChange;
	}
	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

}
