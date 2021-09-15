package eu.transcribathon.europeana.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import eu.transcribathon.europeana.web.app.AppConfigConstants;

@Configuration(AppConfigConstants.BEAN_CONFIG_PROPS)
@PropertySources({ @PropertySource(value = "classpath:transcribathon.properties", ignoreResourceNotFound = true),
@PropertySource(value = "classpath:transcribathon.user.properties", ignoreResourceNotFound = true) })
public class TranscribathonConfigProps{

    @Value("${authorization.api.name:transcribathon}")
    String authorizationApiName;
    
    public String getAuthorizationApiName() {
        return authorizationApiName;
    }

}
