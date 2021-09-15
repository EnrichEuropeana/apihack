package eu.transcribathon.europeana.definitions.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page {

	@XmlAttribute(name = "imageFilename")
    private String imageFilename;
	@XmlAttribute(name = "imageWidth")
    private String imageWidth;
	@XmlAttribute(name = "imageHeight")
    private String imageHeight;
	@XmlElement(namespace = XmlConstants.NAMESPACE_PAGE_XML, name = "TextRegion")
    List<TextRegion> textRegions;
	
	public String getImageFilename() {
		return imageFilename;
	}
	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}
	public String getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(String imageWidth) {
		this.imageWidth = imageWidth;
	}
	public String getImageimageHeight() {
		return imageHeight;
	}
	public void setImageimageHeight(String imageHeight) {
		this.imageHeight = imageHeight;
	}
	public List<TextRegion> getTextRegions() {
		return textRegions;
	}
	public void setTextRegions(List<TextRegion> textRegions) {
		this.textRegions = textRegions;
	}
	
	
	
}
