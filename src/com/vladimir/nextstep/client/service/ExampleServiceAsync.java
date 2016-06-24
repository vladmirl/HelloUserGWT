package com.vladimir.nextstep.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExampleServiceAsync {

	 
	 void personInfo(String login, String password, AsyncCallback callback);
	
}
