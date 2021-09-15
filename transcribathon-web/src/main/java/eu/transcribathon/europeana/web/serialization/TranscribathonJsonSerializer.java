package eu.transcribathon.europeana.web.serialization;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import eu.transcribathon.europeana.definitions.model.TranscriptionPage;
import eu.transcribathon.europeana.web.app.AppConfigConstants;

@Component(AppConfigConstants.BEAN_JSON_SERIALIZER)
public class TranscribathonJsonSerializer {

	@Resource(name = AppConfigConstants.BEAN_JSON_MAPPER)
	ObjectMapper objectMapper;
	
//	public TranscribathonJsonSerializer(@Qualifier(AppConfigConstants.BEAN_JSON_MAPPER) ObjectMapper objectMapper){
//		this.objectMapper = objectMapper;
//	}
	
    public TranscribathonJsonSerializer(){
//		mapper = objectMapper.copy();
//		SimpleModule module = new SimpleModule();
//		mapper.registerModule(module);
//		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
//		mapper.setDateFormat(df);
//		
//		/*
//		 * necessary because of the @JsonFilter annotations if we want to include all fields,
//		 * otherwise the fields we want to exclude can be specified in the given FilerProvider
//		 */
//		
//		SimpleFilterProvider dummy = new SimpleFilterProvider();
//	    dummy.setFailOnUnknownId(false);
//	    mapper.setFilterProvider(dummy);
    }
    
    
    public String serialize(TranscriptionPage page) throws Exception {
    	return objectMapper.writeValueAsString(page);
    }

  
}