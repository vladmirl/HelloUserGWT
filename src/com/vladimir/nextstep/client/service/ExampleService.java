package com.vladimir.nextstep.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.vladimir.nextstep.shared.InfoPerson;

@RemoteServiceRelativePath("exampleservice")
public interface ExampleService extends RemoteService {
	
	 InfoPerson personInfo(String login, String password);

}
