package eu.transcribathon.europeana.web.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;

import eu.transcribathon.europeana.web.app.AppConfigConstants;


@Configuration
public class TranscribathonAppConfig extends AppConfigConstants {

    @Resource(name = AppConfigConstants.BEAN_CONFIG_PROPS)
    private TranscribathonConfigProps entityWebConfig;
    
}
