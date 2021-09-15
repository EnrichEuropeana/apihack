package eu.transcribathon.europeana.web.serialization;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import eu.transcribathon.europeana.definitions.model.TranscriptionPage;
import eu.transcribathon.europeana.web.AbstractIntegrationTest;
import eu.transcribathon.europeana.web.app.AppConfigConstants;
import eu.transcribathon.europeana.web.app.TranscribathonApp;

@SpringBootTest(classes=TranscribathonApp.class)
public class XmlDeserializationTest extends AbstractIntegrationTest {

//	@Qualifier(AppConfigConstants.BEAN_XML_MAPPER)
//	@Autowired
//	private ObjectMapper objectMapper;
    @Autowired
    @Qualifier(AppConfigConstants.BEAN_JAXB_CONTEXT)
    private JAXBContext jaxbContext;

	@Test
	public void deserializationTest() throws Exception{
		String pageXmlContent = loadFile("/page.xml");
//		TranscriptionPage transcriptionPage = objectMapper.readValue(pageXmlContent, TranscriptionPage.class);
		TranscriptionPage transcriptionPage = (TranscriptionPage) jaxbContext.createUnmarshaller().unmarshal(new StringReader(pageXmlContent));
		assertNotNull(transcriptionPage);
	}
	
}
