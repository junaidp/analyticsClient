package com.analytics.client.view.menus.queries;

import com.analytics.client.view.menus.queries.PanelTabItemConfig.TabItemId;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.ShowEvent;

//JUST A TEST CLASS, We can use this approach if ever we need a different view in step1 depending on diff scenario
public class QueriesSecondaryView extends TabViewImpl {

	@Override
	public Widget getStep1() {
		
		return new HTML("Another View for step1");
	}

	
	@Override
	protected void onTabStep1(SelectionEvent<Widget> event, TabItemId tabItemId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onHide(HideEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onShow(ShowEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onBeforeSelection(BeforeSelectionEvent<Widget> event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected Widget getStep2() {
		return new HTML("Another View for step2");
	}




}
