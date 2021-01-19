package com.analytics.client.view.widgets;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.sencha.gxt.widget.core.client.form.FieldLabel;

public class QueryCard extends HorizontalPanel{
	
	private Image icon;
	private FieldLabel lblName;
	
	public QueryCard(String name) {
		lblName = new FieldLabel();
		icon = new Image();  
		icon.setUrl("images/query.png");
		lblName.setContent(name);
		icon.setSize("100px", "70px");
		lblName.getElement().getStyle().setPaddingTop(20, Unit.PX);
		lblName.setSize("150px", "100%");		
		this.add(icon);
		this.add(lblName);
		this.setSize("280px", "70px");
		this.addStyleName("w3-container w3-panel w3-border w3-round-large w3-border-red w3-hover-border-green");
	}

}
