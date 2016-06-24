package com.vladimir.nextstep.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.vladimir.nextstep.client.BindingUI;
import com.vladimir.nextstep.shared.InfoPerson;



public class ExampleServiceClientImpl extends Composite implements ExampleServiceClientInterface {
	
	private ExampleServiceAsync service;
	private BindingUI mainGui;
	private VerticalPanel vPanel = new VerticalPanel();
	 
	public ExampleServiceClientImpl(String url){ 
		
		System.out.println(url);
		this.service = GWT.create(ExampleService.class);
		ServiceDefTarget endpoin = (ServiceDefTarget)this.service;
		endpoin.setServiceEntryPoint(url);
		
		this.mainGui = new BindingUI(this);
		 Image img1 = new Image("/myImages/Logo-ARDAS.png");
		 Image img2 = new Image("/myImages/futer.png");
		 
		 img1.setPixelSize(750, 200);
			img2.setPixelSize(750, 70);
			this.vPanel.setPixelSize(750, 550);
		this.vPanel.add(img1);
		this.vPanel.add(mainGui);
		this.vPanel.add(img2);
		
		
	}
	
	@Override
	public void personInfo(String name, String password) {
		this.service.personInfo(name, password, new DefaultCallback());
		
	}
	
	
	public VerticalPanel getMainGui(){
		return this.vPanel;
	}
	
	private class DefaultCallback implements AsyncCallback{

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An Error has occured");
			
		}

		@Override
		public void onSuccess(Object result) {
				
			if(result instanceof InfoPerson){
				InfoPerson personInfo = (InfoPerson)result;
				mainGui.greetingUser(personInfo);
			}	
		}
	}
}
