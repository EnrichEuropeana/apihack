package eu.transcribathon.europeana.web.serialization;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.transcribathon.europeana.definitions.model.TranscriptionPage;
import eu.transcribathon.europeana.web.app.AppConfigConstants;

@Component(AppConfigConstants.BEAN_XML_SERIALIZER)
public class TranscribathonXmlSerializer {
    
	@Resource(name = AppConfigConstants.BEAN_XML_MAPPER)
	ObjectMapper objectMapper;
//	private final JAXBContext jaxbContext;
	
	public TranscribathonXmlSerializer() {
//		xmlModule = new JacksonXmlModule();
//		xmlModule.setDefaultUseWrapper(true);
//		objectMapper = new XmlMapper(xmlModule);
//		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

	}
    	/**
	 * This method serializes Entity object to xml formats.
	 * @param page The Entity object
	 * @return The serialized entity in xml string format
	 * @throws JsonProcessingException, UnsupportedEntityTypeException
	 */
	public String serializeXml(TranscriptionPage page) throws Exception {
		
		return objectMapper.writeValueAsString(page);
		
	}
}
