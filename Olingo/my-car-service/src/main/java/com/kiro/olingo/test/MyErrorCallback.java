package com.kiro.olingo.test;

import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.exception.ODataApplicationException;
import org.apache.olingo.odata2.api.processor.ODataErrorCallback;
import org.apache.olingo.odata2.api.processor.ODataErrorContext;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyErrorCallback implements ODataErrorCallback {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyErrorCallback.class);

	@Override
	public ODataResponse handleError(ODataErrorContext context) throws ODataApplicationException {
		LOGGER.error(context.getException().getClass().getName() + ":" + context.getMessage(), context.getException());
		return EntityProvider.writeErrorDocument(context);
	}
}
