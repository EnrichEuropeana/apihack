package eu.transcribathon.europeana.web.config;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import eu.europeana.api.commons.web.http.HttpHeaders;

/**
 * Setup CORS for all requests and setup default Content-type
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
    Map<String, MediaType> mediaTypesMaping = new HashMap<String, MediaType>(); 
    
    /**
     * Setup CORS for all GET, HEAD and OPTIONS, requests.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api-docs")
                .allowedOrigins("*")
                .allowCredentials(false)
                .exposedHeaders(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS)
                .maxAge(600L); // in seconds
        
        registry.addMapping("/api-docs/**")
        .allowedOrigins("*")
        .allowCredentials(false)
        .exposedHeaders(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS)
        .maxAge(600L); // in seconds
        
        registry.addMapping("/transcribathon/**")
        .allowedOrigins("*")
        .allowedMethods("GET,POST,PUT,DELETE")
        .exposedHeaders("Location,Allow")
        .allowCredentials(false)
        .exposedHeaders(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS)
        .maxAge(600L); // in seconds
        
    }

    /*
     * Enable content negotiation via path extension (as long as Spring supports it) and set default content type in
     * case we receive a request without an extension or Accept header
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // Enable content negotiation via path extension. Note that this is deprecated with Spring 5.2.4,
        // (see also https://github.com/spring-projects/spring-framework/issues/24179), so it may not work in future
        // releases
        configurer.favorPathExtension(true);

        // use application/ld+json if no Content-Type is specified
        configurer.defaultContentType(MediaType.valueOf(HttpHeaders.CONTENT_TYPE_JSONLD));
        
        configurer.mediaTypes(getMediaTypesMapping());
    }
    
    private Map<String, MediaType> getMediaTypesMapping() {
        if(mediaTypesMaping.isEmpty()) {
            for (MediaType mediaType : supportedMediaTypes) {
                    mediaTypesMaping.put(mediaType.getSubtype(), mediaType);
            }    
        }
        
        return mediaTypesMaping;
    }

    @Bean
    public HttpMessageConverter<String> getStringHttpMessageConverter() {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        stringConverter.setWriteAcceptCharset(false);
        stringConverter.setSupportedMediaTypes(getSupportedMediaTypes());
        return stringConverter;
    }

    private List<MediaType> getSupportedMediaTypes() {
        if(supportedMediaTypes.isEmpty()) {
            supportedMediaTypes.add(MediaType.APPLICATION_JSON);
            supportedMediaTypes.add(MediaType.APPLICATION_XML);
        }
        return supportedMediaTypes;
    }
    
   
}
