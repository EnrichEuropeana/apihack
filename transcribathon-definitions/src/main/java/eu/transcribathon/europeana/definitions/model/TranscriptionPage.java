package eu.transcribathon.europeana.definitions.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "PcGts")
@XmlAccessorType(XmlAccessType.FIELD)
public class TranscriptionPage {

	
	
	private String itemId;
	private String storyId;
	@XmlElement(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "Page")
	private Page page;
	@XmlElement(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "Metadata")
	private Metadata metadata; 
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getStoryId() {
		return storyId;
	}
	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	
	
	
	
	
}
