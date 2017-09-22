package com.kiro.olingo.test;

import org.apache.olingo.odata2.api.ODataDebugResponseWrapperCallback;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataRequest;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.uri.UriInfo;

public class DebugWrapperCallback implements ODataDebugResponseWrapperCallback {

	@Override
	public ODataResponse handle(ODataContext context, ODataRequest request, ODataResponse response, UriInfo uriInfo,
			Exception exception) {
		return response;
	}

}
