package com.analytics.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface AnalyticServiceAsync {
	void readExcel(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
}
