package com.vladimir.nextstep.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.vladimir.nextstep.client.service.ExampleServiceClientImpl;

public class NextStepGWT implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
	 
		ExampleServiceClientImpl serviceImpl = new ExampleServiceClientImpl(GWT.getModuleBaseURL()+"exampleservice");
		RootPanel.get().add(serviceImpl.getMainGui());
   }
}