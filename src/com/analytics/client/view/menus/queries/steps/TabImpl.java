package com.analytics.client.view.menus.queries.steps;


import com.analytics.shared.dtos.QueriesDTO;
import com.google.gwt.user.client.Window;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public abstract class TabImpl extends VerticalLayoutContainer implements Tab{
	
	
	protected QueriesDTO quesriesDTO = new QueriesDTO();
	
	public TabImpl() {
		//TODO: NEED TO FIND A BETTER WAY, may be BorderLayoutContianer can help
		setHeight(Window.getClientHeight()+2100);
	}

	@Override
	public void saveModel() {
		Window.alert("on save1");
	}
}
