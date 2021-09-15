package eu.transcribathon.europeana.web.controller;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.europeana.api.commons.definitions.config.i18n.I18nConstants;
import eu.europeana.api.commons.web.controller.BaseRestController;
import eu.europeana.api.commons.web.exception.ParamValidationException;
import eu.transcribathon.europeana.definitions.exception.UnsupportedFormatTypeException;
import eu.transcribathon.europeana.definitions.formats.FormatTypes;
import eu.transcribathon.europeana.definitions.model.TranscriptionPage;
import eu.transcribathon.europeana.web.app.AppConfigConstants;
import eu.transcribathon.europeana.web.config.BuildInfo;
import eu.transcribathon.europeana.web.config.TranscribathonConfigProps;
import eu.transcribathon.europeana.web.serialization.TranscribathonJsonSerializer;
import eu.transcribathon.europeana.web.serialization.TranscribathonXmlSerializer;

public abstract class BaseRest extends BaseRestController {

//    @Resource(name = AppConfigConstants.BEAN_TRANSCRIBATHON_SERVICE)
//    private EntityService entityService;

	@Resource(name = AppConfigConstants.BEAN_CONFIG_PROPS)
	TranscribathonConfigProps webConfig;

	@Resource(name = AppConfigConstants.BEAN_BUILD_INFO)
	BuildInfo buildInfo;

	@Resource(name = AppConfigConstants.BEAN_XML_SERIALIZER)
	TranscribathonXmlSerializer transcribathonXmlSerializer;

	@Resource(name = AppConfigConstants.BEAN_JSON_SERIALIZER)
	TranscribathonJsonSerializer transcribathonJsonSerializer;

	Logger logger = LogManager.getLogger(getClass());

	Pattern pattern = null;

	public BaseRest() {
		super();
	}

	public Logger getLogger() {
		return logger;
	}

	public String getApiVersion() {
		return buildInfo.getAppVersion();
	}

	protected TranscribathonConfigProps getConfig() {
		return webConfig;
	}

	/**
	 * This method verifies if the provided format parameter is a valid one
	 * 
	 * @param The format string
	 * @return The format type
	 * @throws ParamValidationException
	 */
	protected FormatTypes getFormatType(String extension) throws ParamValidationException {

		// default format, when none provided
		if (extension == null)
			return FormatTypes.json;

		try {
			return FormatTypes.getByExtention(extension);
		} catch (UnsupportedFormatTypeException e) {
			throw new ParamValidationException(I18nConstants.INVALID_PARAM_VALUE, null, null);
		}
	}

	protected String serialize(TranscriptionPage page, FormatTypes format) throws Exception {

		String responseBody = null;

		if (FormatTypes.json.equals(format)) {
			responseBody = transcribathonJsonSerializer.serialize(page);
		} else if (FormatTypes.xml.equals(format)) {
			responseBody = transcribathonXmlSerializer.serializeXml(page);
		}
		return responseBody;
	}
}
