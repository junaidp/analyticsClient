package com.analytics.client.view.menus.queries.steps;


import com.analytics.client.view.widgets.WizardFieldLabel;
import com.google.gwt.user.client.ui.HTML;
import com.sencha.gxt.widget.core.client.form.TextField;

public class DefaultStep1 extends TabImpl implements Tab{
	TextField text = new TextField();
	public DefaultStep1() {
		add(new HTML("DefaultStep 1"));
		
		
		add(new WizardFieldLabel(text, "First Field"));
	}
	
	@Override
	public void loadModel() {
		text.setText(quesriesDTO.getFirstField());
		
	}

	@Override
	public void saveModel() {
		quesriesDTO.setFirstField(text.getText());
		
		
	}


}
