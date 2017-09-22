package com.kiro.olingo.test;

import org.apache.olingo.odata2.api.ODataCallback;
import org.apache.olingo.odata2.api.ODataDebugResponseWrapperCallback;
import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;

public class MyServiceFactory extends ODataServiceFactory {

	@Override
	public ODataService createService(ODataContext ctx) throws ODataException {
		EdmProvider edmProvider = new MyEdmProvider();
		ODataSingleProcessor odataProcessor = new MyODataSingleProcessor();
		return createODataSingleProcessorService(edmProvider, odataProcessor);
	}

	@Override
	public <T extends ODataCallback> T getCallback(final Class<T> callbackInterface) {
		T callback;

		if (callbackInterface.isAssignableFrom(MyDebugCallback.class)) {
			callback = (T) new MyDebugCallback();
		} else if (callbackInterface.isAssignableFrom(ODataDebugResponseWrapperCallback.class)) {
			callback = (T) new DebugWrapperCallback();
		} else if (callbackInterface.isAssignableFrom(MyErrorCallback.class)) {
			callback = (T) new MyErrorCallback();
		} else {
			callback = super.getCallback(callbackInterface);
		}

		return callback;
	}
}