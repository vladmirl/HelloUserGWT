package com.vladimir.nextstep.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import com.vladimir.nextstep.client.service.ExampleServiceClientImpl;
import com.vladimir.nextstep.shared.InfoPerson;

public class BindingUI extends Composite {
	
	public static final Localisation CONSTANTS = GWT.create(Localisation.class);
	private static BindingUIUiBinder uiBinder = GWT.create(BindingUIUiBinder.class);
	
	private ExampleServiceClientImpl serviceImpl;
	

	@UiField
   TextBox loginBox;
    @UiField
    PasswordTextBox passwordBox;
    @UiField
    Button enterButton;
    @UiField
    Label loginLabel;
    @UiField
    Label passwordLabel;
    @UiField
    Label greetingLabel;
    @UiField
    Anchor closeAnchor;
    @UiField
    VerticalPanel startPanel;
    @UiField
    VerticalPanel userPanel;
    
    
	interface BindingUIUiBinder extends UiBinder<Widget, BindingUI> {
	}
	public BindingUI(){}

	public BindingUI(ExampleServiceClientImpl serviceImpl) {
		
		
		initWidget(uiBinder.createAndBindUi(this));
		
	   userPanel.setVisible(false);
	   this.serviceImpl = serviceImpl;
		
	}
	
public void greetingUser(InfoPerson personInfo){
	
	String greeting;
	
	switch(personInfo.getMassege()){
	case "moninig":
		greeting = CONSTANTS.morning();
		break;
	case "day":
		greeting = CONSTANTS.day();
	break;
	case "evening":
		greeting = CONSTANTS.evening();
		break;
	case "night":
		greeting = CONSTANTS.night();
		break;
		default:
			greeting = "error";
	}
		
	greetingLabel.setText(greeting+" "+personInfo.getUserName());
	
	}

	  @UiHandler("enterButton")
   public void enterBtnClick(ClickEvent event) {
       if (loginBox.getValue() == ""&&passwordBox.getValue()!="") {
        loginLabel.setText(CONSTANTS.loginError());
        passwordLabel.setText(CONSTANTS.passwordLabelField_text());
        
       } else if(passwordBox.getValue() == ""&&loginBox.getValue()!=""){
          passwordLabel.setText(CONSTANTS.passwordError());
          loginLabel.setText(CONSTANTS.loginLabelField_text());
       }
       else if(passwordBox.getValue() == ""&&loginBox.getValue()==""){
    	   loginLabel.setText(CONSTANTS.loginError());
    	   passwordLabel.setText(CONSTANTS.passwordError());
    	   
       }else if(passwordBox.getValue() != ""&&loginBox.getValue()!=""){
    	   
    	   serviceImpl.personInfo(loginBox.getText(), passwordBox.getText());
    	   userPanel.setVisible(true);
    	   startPanel.setVisible(false); 
       }
    }

	  @UiHandler("closeAnchor")
   public void closeAnchorClick(ClickEvent event) {
		  userPanel.setVisible(false);
   	   startPanel.setVisible(true);
	  }
}
